package fr.uge.projet.user;

import fr.uge.projet.bike.State;
import fr.uge.projet.bike.IBike;
import fr.uge.projet.bike.IBikeManager;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.UUID;
import java.util.logging.Logger;

public class UserServer {

  private final static Logger logger = Logger.getLogger(UserServer.class.toString());

  public static void main(String[] args) throws InterruptedException {

    try {
      // RMI
      IBikeManager bikeManager = (IBikeManager) Naming.lookup("rmi://localhost:1099/BikeLeaseService");

      // User DB
      IUserManager userManager = new UserManager();
      IUser student1 = userManager.registerUser("Doe.John", "password");
      IUser student2 = userManager.registerUser("Dae.Jeanne", "PASSWORD");
      IUser student3 = userManager.registerUser( "Dop.Eric", "secretCode");
      IUser employee1 = userManager.registerUser("Dupont.Tom", "12304");
      IUser employee2 = userManager.registerUser("Dupont.Pierre", "43210");
      
      
      // Test connexion
      IUser user1connected = userManager.connectionUser("Doe.John", "password");
      if(user1connected == null) {
        System.out.println("Doe.John connexion failed, wrong password");
      } else {
        System.out.println("Doe.John: connected");
      }
      
      // 2 bike added
      UUID idBike1 = bikeManager.addBike(student1, State.NEW, 123);
      UUID idBike2 = bikeManager.addBike(student2, State.NEW, 342);

      // User look the catalog
      IBike[] bikes = bikeManager.getAll();

      System.out.println("User look the catalog:");
      Arrays.stream(bikes).forEach(b -> {
        try {
          System.out.println(b.asString());
        } catch (RemoteException e) {
          throw new RuntimeException(e);
        }
      });

      
      bikeManager.registerOnWaitingList(employee1, idBike1);
      bikeManager.registerOnWaitingList(employee2, idBike1);
      bikeManager.registerOnWaitingList(student3, idBike1);
      bikeManager.registerOnWaitingList(student3, idBike2);
      
      
      System.out.println("Some registration to list...");
      Thread.sleep(5000);
      bikeManager.returnToService(employee1, idBike1, State.NEW, "Bon état");
      System.out.println("employee1 return the bike");

      Thread.sleep(5000);
      bikeManager.returnToService(employee2, idBike1, State.DAMAGED,
          "Pneu creuvé");
      System.out.println("employee2 return the bike");

      // User look comment of the bike1
      var comment = bikeManager.lookComment(idBike1);
      System.out.println(">>> look comment of bike1");
      Arrays.stream(comment).forEach(System.out::println);
    } catch (RemoteException e) {
      logger.warning("RemoteException: " + e.getMessage());
    } catch (MalformedURLException e) {
      logger.warning("MalformedURLException: " + e.getMessage());
    } catch (NotBoundException e) {
      logger.warning("NotBoundException: " + e.getMessage());
    }
  }
}
