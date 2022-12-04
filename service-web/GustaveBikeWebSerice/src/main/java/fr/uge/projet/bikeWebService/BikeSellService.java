package fr.uge.projet.bikeWebService;

import java.lang.reflect.Array;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.util.Objects;

import javax.xml.rpc.ServiceException;

import fr.uge.projet.bank.BankService;
import fr.uge.projet.bank.BankServiceServiceLocator;
import fr.uge.projet.bikeWebService.common.IBike;
import fr.uge.projet.bikeWebService.common.IBikeManager;
import fr.uge.projet.change.ChangeService;
import fr.uge.projet.change.ChangeServiceServiceLocator;

public class BikeSellService {
	private static ChangeService changeService;
	private static BankService bankService;

	public Bike[] getAllBikes() throws RemoteException {
		String[] comments = {"Joli", "Bleu"};
		Bike b1 =  new Bike(11, "Super vélo bleu", 1234, comments);
		Bike b2 =  new Bike(12, "Super vélo rouge", 1135, comments);
		Bike b3 =  new Bike(13, "Super vélo vert", 31432, comments);
		Bike b4 =  new Bike(14, "Super vélo jaune", 39743, comments);
		Bike[] bikes = {b1, b2, b3, b4};
		return bikes;
	}

	public Bike getBike(int id) throws RemoteException {
		String[] comments = {"Joli", "Bleu"};
		return new Bike(12, "Super vélo bleu", 1135, comments);
	}


	private long getAmountInCurrency(String currencySrc, long amount) throws ServiceException, RemoteException {
		if ("euro".equals(currencySrc))
			return amount;

		if (null == changeService)
			changeService = new ChangeServiceServiceLocator().getChangeService();

		return changeService.change("euro", currencySrc, amount);
	}

	private boolean getBankResponse(int id, long amount) throws ServiceException, RemoteException {
		if (null == bankService)
			bankService = new BankServiceServiceLocator().getBankService();

		return bankService.checkAvailableBalance(id, "euro", amount);
	}

	public boolean buyBike(int id, String currency, long amount) throws RemoteException, ServiceException {
		Objects.requireNonNull(currency);

		long a = getAmountInCurrency(currency, amount);

		return getBankResponse(id, a);
	}

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		try {
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

		} catch(Exception e) {
			System.out.println("Error: "+e);
		}
	}
}
