package fr.uge.projet.bike;

import fr.uge.projet.user.IUser;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.UUID;

public interface IBikeManager extends Remote {

  UUID addBike(IUser user, State state) throws RemoteException;

  boolean registerOnWaitingList(IUser user, UUID idBike) throws RemoteException;

  void returnToService(IUser user, UUID idBike, State state, String comment) throws RemoteException;

  fr.uge.projet.bike.IBike[] getAll() throws RemoteException;

  String[] lookComment(UUID id) throws RemoteException;

}
