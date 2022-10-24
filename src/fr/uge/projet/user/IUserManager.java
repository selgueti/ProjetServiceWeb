package fr.uge.projet.user;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.UUID;

public interface IUserManager extends Remote {

  IUser registerUser(User user, String firstName, String LastName) throws RemoteException;

  IUser retrieveUser(UUID id) throws RemoteException;
}
