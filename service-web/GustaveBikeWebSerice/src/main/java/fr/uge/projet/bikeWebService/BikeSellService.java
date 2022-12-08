package fr.uge.projet.bikeWebService;

import java.lang.reflect.Array;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import javax.xml.rpc.ServiceException;

import fr.uge.projet.bank.BankService;
import fr.uge.projet.bank.BankServiceServiceLocator;
import fr.uge.projet.bikeWebService.common.IBike;
import fr.uge.projet.bikeWebService.common.IBikeManager;
import fr.uge.projet.change.ChangeService;
import fr.uge.projet.change.ChangeServiceServiceLocator;

public class BikeSellService {
	private static final Map<Integer, Bike> bikes = new HashMap<>();
	private static ChangeService changeService;
	private static BankService bankService;
	
	public boolean addBike(Bike bike) {
		return null != bikes.putIfAbsent(bike.id, bike);
	}
	
	private static boolean isAvailable(Bike bike) {
		return bike.isAvailable();
	}
	
	public Bike[] getAllBikes() throws RemoteException {
		List<Bike> tmp = bikes.values().stream().collect(Collectors.<Bike>toList());
		
		List<Bike> results = new ArrayList<>();
		
		// Unavailable bikes filter
		for (Bike b : tmp) {
			if (b.available) {
				results.add(b);
			}
		}
		
		Bike[] res = new Bike[results.size()];
		for(int i = 0; i < results.size(); i++) {
			res[i] = results.get(i);
		}
		
		return res;
	}

	public Bike getBike(int id) throws RemoteException {
		return bikes.get(id);
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
		
		Bike b = bikes.get(id);
		
		// Unknown bike
		if (null == b)
			return false;
		
		// Change currency service
		long a = getAmountInCurrency(currency, amount);
		
		// Bank validation
		boolean bankResponse =  getBankResponse(id, a);
		
		// Check price
		if (a != b.price) 
			return false;
		
		if (bankResponse) {
			bikes.remove(id);
			return true;
		}
		
		return false;
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
