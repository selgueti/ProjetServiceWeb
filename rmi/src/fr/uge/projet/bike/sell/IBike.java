package fr.uge.projet.bike.sell;

import fr.uge.projet.bike.State;
import fr.uge.projet.user.IUser;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.UUID;

public interface IBike extends Remote{
  UUID getId() throws RemoteException;

  boolean isAvailable() throws RemoteException;

  String[] getComment() throws RemoteException;
}
