package fr.uge.projet.bikeWebService.common;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.UUID;

public interface IBike extends Remote {
	  UUID getId() throws RemoteException;

	  boolean isAvailable() throws RemoteException;

	  String[] getComment() throws RemoteException;

	  long getPrice();
}
