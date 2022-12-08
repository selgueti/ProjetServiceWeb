package fr.uge.projet.user;

import fr.uge.projet.bike.IBike;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Objects;

public class User extends UnicastRemoteObject implements IUser {
  private final String pseudo;

  public User(String pseudo) throws RemoteException {
    super();
    Objects.requireNonNull(this.pseudo = pseudo);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    if (!super.equals(o)) return false;
    User user = (User) o;
    return Objects.equals(pseudo, user.pseudo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), pseudo);
  }

  @Override
  public void notifyAvailability(IBike bike) throws RemoteException {
    Objects.requireNonNull(bike);
    System.out.println("New location by " + asString());
  }

  @Override
  public String asString() throws RemoteException {
    return pseudo;
  }
}
