package fr.uge.projet.user;

import fr.uge.projet.bike.IBike;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IUser extends Remote {

  void notifyAvailability(IBike bike) throws RemoteException;

  String asString() throws RemoteException;
}
