package fr.uge.projet.bike.lease;

import fr.uge.projet.bike.State;
import fr.uge.projet.user.IUser;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.UUID;

public interface IBikeManager extends Remote {

  UUID addBike(IUser user, State state, long price) throws RemoteException;

  boolean registerOnWaitingList(IUser user, UUID idBike) throws RemoteException;

  void returnToService(IUser user, UUID idBike, State state, String comment) throws RemoteException;

  IBike[] getAll() throws RemoteException;

  String[] lookComment(UUID id) throws RemoteException;

}
