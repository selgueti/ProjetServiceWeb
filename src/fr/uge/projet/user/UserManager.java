package fr.uge.projet.user;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Objects;
import java.util.UUID;

/*
 * Thread safe class to manager users
 * */
public class UserManager extends UnicastRemoteObject implements IUserManager {

  private final HashMap<UUID, IUser> usersById = new HashMap<>();

  protected UserManager() throws RemoteException {
    super();
  }

  @Override
  public IUser registerUser(User user, String firstName, String lastName) throws RemoteException {
    UUID id = UUID.randomUUID();
    Objects.requireNonNull(firstName);
    Objects.requireNonNull(lastName);
    synchronized (usersById) {
      while (usersById.containsKey(id)) {
        id = UUID.randomUUID();
      }
      switch (user) {
        case STUDENT -> {
          var student = new Student(id, firstName, lastName);
          usersById.put(id, student);
          return student;
        }
        case EMPLOYEE -> {
          var employee = new Employee(id, firstName, lastName);
          usersById.put(id, employee);
          return employee;
        }
      }
    }
    return null;
  }

  @Override
  public IUser retrieveUser(UUID id) throws RemoteException {
    Objects.requireNonNull(id);
    synchronized (usersById) {
      if (usersById.containsKey(id)) {
        return usersById.get(id);
      }
    }
    return null;
  }
}
