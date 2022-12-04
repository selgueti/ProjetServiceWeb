package fr.uge.projet.bike;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.logging.Logger;

public class BikeServer {
  private final static Logger logger = Logger.getLogger(BikeServer.class.toString());
  private final static String URISell = "rmi://localhost:1099/BikeSellService";
  private final static String URILease = "rmi://localhost:1099/BikeLeaseService";

  public static void main(String[] args) {
    try {
      LocateRegistry.createRegistry(1099);

      // Lease service
      fr.uge.projet.bike.lease.IBikeManager bikeManagerLease = new BikeManager();
      Naming.rebind(URILease, bikeManagerLease);
      logger.info("Bike Lease Server run on: " + URILease);

      // Sell service
      fr.uge.projet.bike.sell.IBikeManager bikeManagerSell = new BikeManager();
      Naming.rebind(URISell, bikeManagerSell);
      logger.info("Bike Sell Server run on: " + URISell);

    } catch (RemoteException e) {
      logger.warning("RemoteException: " + e);
    } catch (MalformedURLException e) {
      logger.warning("MalformedURLException: " + e);
    }
  }
}
