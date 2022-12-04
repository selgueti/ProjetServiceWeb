package fr.uge.projet;

import fr.uge.projet.bike.IBikeManager;
import fr.uge.projet.rest.BikeManagerHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

@ComponentScan
@Configuration
public class Config {

    @Bean
    BikeManagerHandler bikeManagerHandler (){
        try {
            IBikeManager manager = (IBikeManager) Naming.lookup("rmi://localhost:1099/BikeLeaseService");
            return new BikeManagerHandler(manager);
        } catch (Exception e) {
            throw new AssertionError();
        }

    }
}
