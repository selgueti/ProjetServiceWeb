package fr.uge.projet.bike.lease;

import fr.uge.projet.bike.State;
import fr.uge.projet.user.IUser;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.UUID;

public interface IBike extends Remote {

  UUID getId() throws RemoteException;

  boolean isAvailable() throws RemoteException;

  boolean registerOnWaitingList(IUser user) throws RemoteException;

  void returnToService(IUser user, State state, String comment) throws RemoteException;

  void tryToNotifyClient() throws RemoteException;

  String[] getComment() throws RemoteException;
}
