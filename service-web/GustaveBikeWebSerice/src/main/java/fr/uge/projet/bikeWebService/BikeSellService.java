package fr.uge.projet.bikeWebService;

import java.lang.reflect.Array;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;

import fr.uge.projet.bank.BankService;
import fr.uge.projet.bank.BankServiceServiceLocator;
import fr.uge.projet.bikeWebService.common.IBike;
import fr.uge.projet.bikeWebService.common.IBikeManager;
import fr.uge.projet.change.ChangeService;
import fr.uge.projet.change.ChangeServiceServiceLocator;

public class BikeSellService {
	private static ChangeService changeService;
	private static BankService bankService;
	
	public String[] getAllBikes() throws RemoteException {
		String[] a = {"aaa", "bbb", "ccc"};
		return null;
	}
	
	public Bike getBike(int id) throws RemoteException {
		return new Bike(12, "Super vélo bleu", 1135);
	}
		
	// Prendre la devise de l'achat
	public boolean buyBike(int id, String currency, long amount) throws RemoteException {
		changeService.change("euro", currency, amount);
		boolean bankResponse = bankService.checkAvailableBalance(id, "euro", amount);
		return bankResponse;
	}
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		try {
			System.out.println("Service launched");
			changeService = new ChangeServiceServiceLocator().getChangeService();
			bankService = new BankServiceServiceLocator().getBankService();
			
			long res = changeService.change("euro", "dollar", 10L);
			System.out.println(res);
			
			BikeSellService bss = new BikeSellService();
			
			System.out.println(bss.buyBike(0, "dol", 10));
			
			/*
			
			String codebase = "file:////ProjetServiceWeb/out/production/ProjetServiceWeb/fr/uge/projet/bike/sell/";

			System.setProperty("java.rmi.server.codebase", codebase);
			
			String secpath = "src/main/java/fr/uge/projet/bikeWebService/";
			System.setProperty("java.security.policy", secpath + "sec.policy");
			
			System.setSecurityManager(new RMISecurityManager());
			IBikeManager bikeManager = (IBikeManager) Naming.lookup("rmi://localhost:1099/BikeSellService");
			*/
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
