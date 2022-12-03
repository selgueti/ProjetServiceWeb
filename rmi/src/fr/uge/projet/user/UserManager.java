package fr.uge.projet.user;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Objects;

/*
 * Thread safe class to manager users
 * */
public class UserManager extends UnicastRemoteObject implements IUserManager {
  private final HashMap<String, Pair> usersByPseudo = new HashMap<>();

  private static class Pair {
      private final IUser user;
      private int hashedPassword;

    public Pair(IUser user, int hashedPassword) {
      Objects.requireNonNull(this.user = user);
      this.hashedPassword = hashedPassword;
    }

    public IUser getUser() {
      return user;
    }

    public int getHashedPassword() {
      return hashedPassword;
    }
  }

  protected UserManager() throws RemoteException {
    super();
  }

  private int hashPassword(String password) {
    return password.hashCode();
  }

  @Override
  public IUser registerUser(String pseudo, String password) throws RemoteException {
    Objects.requireNonNull(pseudo);
    Objects.requireNonNull(password);

    synchronized (usersByPseudo) {
      if (usersByPseudo.containsKey(pseudo))
        return null;

      IUser user = new User(pseudo);
      var pair = new Pair(user, hashPassword(password));
      usersByPseudo.put(pseudo, pair);
      return user;
    }
  }

  @Override
  public IUser connectionUser(String pseudo, String password) {
    Objects.requireNonNull(pseudo);
    Objects.requireNonNull(password);

    synchronized (usersByPseudo) {
      if (!usersByPseudo.containsKey(pseudo))
        return null;

      Pair pair = usersByPseudo.get(pseudo);
      if (pair.getHashedPassword() == hashPassword(password))
        return pair.getUser();
      return null;
    }
  }

  @Override
  public boolean existsUser(String pseudo) {
    Objects.requireNonNull(pseudo);

    return usersByPseudo.containsKey(pseudo);
  }

  @Override
  public IUser retrieveUser(String pseudo) throws RemoteException {
    Objects.requireNonNull(pseudo);

    synchronized (usersByPseudo) {
      if (usersByPseudo.containsKey(pseudo)) {
        return usersByPseudo.get(pseudo).user;
      }
    }

    return null;
  }
}
