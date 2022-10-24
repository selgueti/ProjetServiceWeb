package fr.uge.projet.bike;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.logging.Logger;

public class BikeServer {

  private final static Logger logger = Logger.getLogger(BikeServer.class.toString());
  private final static String URI = "rmi://localhost:1099/BikeService";

  public static void main(String[] args) {
    try {
      LocateRegistry.createRegistry(1099);
      IBikeManager bikeManager = new BikeManager();
      Naming.rebind(URI, bikeManager);
      logger.info("Bike Server run on: " + URI);

    } catch (RemoteException e) {
      logger.warning("RemoteException: " + e);
    } catch (MalformedURLException e) {
      logger.warning("MalformedURLException: " + e);
    }
  }
}
