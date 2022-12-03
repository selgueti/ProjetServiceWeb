package fr.uge.projet.bikeWebService.common;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.UUID;

public interface IBikeManager extends Remote {

	  IBike[] getAll() throws RemoteException;

	  String[] lookComment(UUID id) throws RemoteException;

	  IBike buyBike(UUID idBike, long amount) throws RemoteException;

}
