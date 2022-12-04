package fr.uge.projet.bike;

import fr.uge.projet.user.IUser;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/*
 * Thread safe class to manage bikes
 * */
public class BikeManager extends UnicastRemoteObject implements IBikeManager {

  private final HashMap<UUID, IBike> bikeById = new HashMap<>();

  protected BikeManager() throws RemoteException {
    super();
  }

  @Override
  public UUID addBike(IUser owner, State state, long price) throws RemoteException {
    Objects.requireNonNull(owner);
    Objects.requireNonNull(state);
    var id = UUID.randomUUID();
    synchronized (bikeById) {
      while (bikeById.containsKey(id)) {
        id = UUID.randomUUID();
      }
      bikeById.put(id, new Bike(id, owner, state, price));
    }
    return id;
  }

  @Override
  public boolean registerOnWaitingList(IUser user, UUID idBike) throws RemoteException {
    Objects.requireNonNull(user);
    Objects.requireNonNull(idBike);
    synchronized (bikeById) {
      if (!bikeById.containsKey(idBike)) {
        return false;
      }
      var bike = bikeById.get(idBike);
      var res = bike.registerOnWaitingList(user);
      if (bike.isAvailable()) {
        bike.tryToNotifyClient();
      }
      return res;
    }
  }

  @Override
  public void returnToService(IUser user, UUID idBike, State state, String comment)
      throws RemoteException {
    Objects.requireNonNull(user);
    Objects.requireNonNull(idBike);
    Objects.requireNonNull(state);
    Objects.requireNonNull(comment);
    synchronized (bikeById) {
      if (!bikeById.containsKey(idBike)) {
        return;
      }
      var bike = bikeById.get(idBike);
      bike.returnToService(user, state, comment);
      bike.tryToNotifyClient();
    }
  }

  @Override
  public IBike[] getAll() throws RemoteException {
    synchronized (bikeById) {
      List<IBike> lst = bikeById.values().stream().toList();
      IBike[] res = new IBike[lst.size()];
      for (int i = 0; i < lst.size(); i++) {
        res[i] = lst.get(i);
      }
      return res;
    }
  }

  @Override
  public String[] lookComment(UUID id) throws RemoteException {
    Objects.requireNonNull(id);
    synchronized (bikeById) {
      if (!bikeById.containsKey(id)) {
        return null;
      }
      return bikeById.get(id).getComment();
    }
  }

  @Override
  public IBike buyBike(IUser user, UUID idBike, long amount) throws RemoteException {
    Objects.requireNonNull(user);
    Objects.requireNonNull(idBike);

    synchronized (bikeById) {
      var bike = bikeById.get(idBike);

      if (null == bike || !bike.isAvailable() || bike.getPrice() != amount)
        return null;

      return bikeById.remove(idBike);
    }
  }
}
