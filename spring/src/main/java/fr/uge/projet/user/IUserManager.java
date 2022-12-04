package fr.uge.projet.user;

        import java.rmi.Remote;
        import java.rmi.RemoteException;

public interface IUserManager extends Remote {

    /**
     * register a new user
     * @param pseudo of the user
     * @param password of the user
     * @return null if the user already exist, user otherwise
     * @throws RemoteException
     */
    IUser registerUser(String pseudo, String password) throws RemoteException;

    /**
     * Try to connect to user account
     * @param pseudo of the user
     * @param password of the user
     * @return User if the connection succeed, null otherwise
     * @throws RemoteException
     */
    IUser connectionUser(String pseudo, String password) throws RemoteException;

    /**
     * if the user exists
     * @param pseudo of the user
     * @return True if the user exists, false else-way
     */
    boolean existsUser(String pseudo) throws RemoteException;

    /**
     * Get the user by his pseudo
     * @param pseudo of the searched user
     * @return User
     * @throws RemoteException
     */
    IUser retrieveUser(String pseudo) throws RemoteException;
}