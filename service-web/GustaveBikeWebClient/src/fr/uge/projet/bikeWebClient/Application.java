package fr.uge.projet.bikeWebClient;

import fr.uge.projet.bikeWebService.Bike;
import fr.uge.projet.bikeWebService.BikeSellService;
import fr.uge.projet.bikeWebService.BikeSellServiceServiceLocator;

public class Application {
	public static void main(String[] args) {
		try {
			BikeSellService bbs = new BikeSellServiceServiceLocator().getBikeSellService();
			
			Bike[] bikes = bbs.getAllBikes();
			System.out.println("Available bikes :");
			for(Bike bike: bikes) {
				System.out.println("id : "+bike.getId()+" - name : "+bike.getName()+" - price : "+ bike.getPrice()+"€");
			}
		} catch(Exception e) {
			System.out.println("Error " + e);
		}
	}
}
