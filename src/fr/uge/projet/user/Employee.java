package fr.uge.projet.user;

import fr.uge.projet.bike.location.IBike;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Objects;
import java.util.UUID;

public class Employee extends UnicastRemoteObject implements IUser {

  private final UUID id;
  private final String lastName;
  private final String firstName;

  public Employee(UUID id, String lastName, String firstName) throws RemoteException {
    super();
    Objects.requireNonNull(this.id = id);
    Objects.requireNonNull(this.lastName = lastName);
    Objects.requireNonNull(this.firstName = firstName);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    Employee employee = (Employee) o;
    return Objects.equals(id, employee.id) && Objects.equals(lastName,
        employee.lastName) && Objects.equals(firstName, employee.firstName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), id, lastName, firstName);
  }

  @Override
  public String toString() {
    return "Employee { " +
        "lastName='" + lastName + '\'' +
        ", firstName='" + firstName + '\'' +
        " }";
  }

  @Override
  public void notifyAvailability(IBike bike) throws RemoteException {
    Objects.requireNonNull(bike);
    System.out.println("New location by " + this);
  }
}
