package fr.uge.projet.bike;

import fr.uge.projet.user.IUser;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Bike extends UnicastRemoteObject implements IBike {

  private final static int WAITING_LIST_LENGTH = 100;

  private final UUID id;
  private final IUser owner;
  private State state;
  private boolean available = true;

  private final BlockingQueue<IUser> waitingList = new ArrayBlockingQueue<>(WAITING_LIST_LENGTH);
  private final HashMap<IUser, List<String>> commentsByUser = new HashMap<>();

  public Bike(UUID id, IUser owner, State state) throws RemoteException {
    super();
    Objects.requireNonNull(this.id = id);
    Objects.requireNonNull(this.owner = owner);
    Objects.requireNonNull(this.state = state);
  }

  @Override
  public UUID getId() throws RemoteException {
    return id;
  }

  @Override
  public boolean isAvailable() throws RemoteException {
    return available;
  }

  public boolean registerOnWaitingList(IUser user) throws RemoteException {
    Objects.requireNonNull(user);
    return waitingList.offer(user);
  }

  public void returnToService(IUser user, State state, String comment) throws RemoteException {
    Objects.requireNonNull(user);
    Objects.requireNonNull(state);
    Objects.requireNonNull(comment);

    this.available = true;
    this.state = state;
    if (!commentsByUser.containsKey(user)) {
      commentsByUser.put(user, new ArrayList<>());
    }
    commentsByUser.computeIfPresent(user, (_user, lst) -> {
      lst.add(comment);
      return lst;
    });
  }

  @Override
  public void tryToNotifyClient() throws RemoteException {
    var client = waitingList.poll();
    if (client != null) {
      client.notifyAvailability(this);
      this.available = false;
    }
  }

  @Override
  public String[] getComment() throws RemoteException {

    var s = commentsByUser
        .entrySet()
        .stream()
        .flatMap(e -> e.getValue().stream())
        .toList();
    var res = new String[s.size()];
    for (int i = 0; i < s.size(); i++) {
      res[i] = s.get(i);
    }
    return res;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    Bike bike = (Bike) o;
    return available == bike.available && Objects.equals(id, bike.id)
        && Objects.equals(owner, bike.owner) && state == bike.state
        && Objects.equals(waitingList, bike.waitingList) && Objects.equals(
        commentsByUser, bike.commentsByUser);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), id, owner, state, available, waitingList, commentsByUser);
  }

  @Override
  public String toString() {
    return "Bike{" +
        " owner=" + owner +
        ", state=" + state +
        ", available=" + available +
        " }";
  }
}
