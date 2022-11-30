package fr.uge.projet.user;

import fr.uge.projet.bike.location.IBike;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class EiffelBikeCorp extends UnicastRemoteObject implements IUser {

  protected EiffelBikeCorp() throws RemoteException {
    super();
  }

  @Override
  public void notifyAvailability(IBike bike) throws RemoteException {
    throw new AssertionError("EiffelBikeCorp shouldn't register on waiting list of any bike");
  }
}
