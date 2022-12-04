package fr.uge.projet.bike.sell;

import fr.uge.projet.user.IUser;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.UUID;

public interface IBikeManager extends Remote {

  IBike[] getAll() throws RemoteException;

  String[] lookComment(UUID id) throws RemoteException;

  IBike buyBike(IUser user, UUID idBike, long amount) throws RemoteException;

}
