package fr.uge.projet.user;

import fr.uge.projet.bike.IBike;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Objects;
import java.util.UUID;

public class Student extends UnicastRemoteObject implements IUser {

  private final UUID id;
  private final String lastName;
  private final String firstName;

  public Student(UUID id, String lastName, String firstName) throws RemoteException {
    super();
    this.id = id;
    this.lastName = lastName;
    this.firstName = firstName;
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
    Student student = (Student) o;
    return Objects.equals(id, student.id) && Objects.equals(lastName,
        student.lastName) && Objects.equals(firstName, student.firstName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), id, lastName, firstName);
  }

  @Override
  public String toString() {
    return "Student{ " +
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
