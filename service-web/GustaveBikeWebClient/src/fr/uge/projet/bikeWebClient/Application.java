package fr.uge.projet.bikeWebClient;

import java.rmi.RemoteException;
import java.util.Objects;

import fr.uge.projet.bikeWebService.Bike;
import fr.uge.projet.bikeWebService.BikeSellService;
import fr.uge.projet.bikeWebService.BikeSellServiceServiceLocator;

public class Application {
	private static Bike giveBike(int id, String name, long price, boolean available, String[] comments) {
		String mechanismeType = null;
		return new Bike(available, comments, id, mechanismeType, name, price);
	}
	
	private static String bikeToString(Bike b) {
		return "id: " + b.getId() + "   name : " + b.getName() + "  price : " + b.getPrice() + "   [" + b.isAvailable() + "]"; 
	}
	
	private static Bike getBlueBike() {
		String[] comments = {"Joli", "Bleu"};
		return giveBike(1, "Velo bleu", 12345, true, comments); 
	}
	
	private static Bike getRedBike() {
		String[] comments = {"dégradé", "rouge"};
		return giveBike(2, "Velo rouge", 125637, true, comments); 
	}
	
	private static Bike getYellowBike() {
		String[] comments = {"neuf", "jaune"};
		return giveBike(3, "Velo jaune", 12345, true, comments); 
	}
	
	private static Bike getPurpleBike() {
		String[] comments = {"Pas disponible", "violet"};
		return giveBike(4, "Velo violet", 12345, false, comments); 
	}
	
	private static Bike getGreenBike() {
		String[] comments = {"Trop cher", "vert"};
		return giveBike(5, "Velo vert", 1000000, true, comments); 
	}
	
	private static void addBike(BikeSellService bss, Bike bike) throws RemoteException {
		Objects.requireNonNull(bss);
		Objects.requireNonNull(bike);
		
		System.out.println("Ajout du vélo : " + bikeToString(bike));
		if (bss.addBike(bike)) {
			System.out.println("Vélo ajouté");
		} else {
			System.out.println("Velo non Ajouté");
		}
	}
	
	public static void main(String[] args) {
		try {
			BikeSellService bss = new BikeSellServiceServiceLocator().getBikeSellService();
			
			System.out.println("AJOUT DES VELOS");
			addBike(bss, getBlueBike());
			addBike(bss, getRedBike());
			addBike(bss, getYellowBike());
			addBike(bss, getPurpleBike());
			addBike(bss, getGreenBike());
			System.out.println("FIN DE L'AJOUT\n\n\n\n");
			
			// Display all available bikes
			System.out.println("AFFICHAGE DE TOUS LES VELOS DISPONIBLES");
			for(Bike b: bss.getAllBikes()) {
				System.out.println(bikeToString(b));
			}
			
			// Buy available bike
			
			
			
		} catch(Exception e) {
			System.out.println("Error " + e);
		}
	}
}
