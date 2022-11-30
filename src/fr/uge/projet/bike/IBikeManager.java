package fr.uge.projet.bike;

import fr.uge.projet.user.IUser;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.UUID;

public interface IBikeManager extends Remote, fr.uge.projet.bike.location.IBikeManager, fr.uge.projet.bike.sell.IBikeManager {
    UUID addBike(IUser user, State state) throws RemoteException;

    boolean registerOnWaitingList(IUser user, UUID idBike) throws RemoteException;

    void returnToService(IUser user, UUID idBike, State state, String comment) throws RemoteException;

    IBike[] getAll() throws RemoteException;

    String[] lookComment(UUID id) throws RemoteException;

    IBike buyBike(IUser user, UUID idBike) throws RemoteException;
}
