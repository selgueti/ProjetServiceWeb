package fr.uge.projet.bikeWebService;
import java.io.File;
import java.net.URL;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.util.UUID;

import fr.uge.projet.bikeWebService.common.IBikeManager;

public class Application {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		try {
			System.out.println("Service launched");
			
			String codebase = "file:////C:/Users/Cedric/Documents/Ecole/UPEM/Projets/M2/WebRest/ProjetServiceWeb/out/production/ProjetServiceWeb/fr/uge/projet/bike/sell/";

			System.setProperty("java.rmi.server.codebase", codebase);
			
			String secpath = "src/main/java/fr/uge/projet/bikeWebService/";
			System.setProperty("java.security.policy", secpath + "sec.policy");
			
			System.setSecurityManager(new RMISecurityManager());
			IBikeManager bikeManager = (IBikeManager) Naming.lookup("rmi://localhost:1099/BikeSellService");
			
			/*
			IBike[] bikes = bikeManager.getAll();
			
			System.out.println("bikes: "+bikes);
			for(IBike bike : bikes) {
				System.out.println(bike);
			}
			*/
			System.out.println("Service ended");
			
		} catch(Exception e) {
			System.out.println("Error: "+e);
		}
	}
}
