package fr.uge.projet.rest;

import fr.uge.projet.bike.IBike;
import fr.uge.projet.bike.IBikeManager;
import org.springframework.stereotype.Component;

import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.List;

public class BikeManagerHandler {

    public BikeManagerHandler(IBikeManager manager) {
        this.manager = manager;
    }
    public List<IBike> getAll(){
        try {
            return Arrays.stream(manager.getAll()).toList();
        } catch (RemoteException e) {
            throw new AssertionError();
        }
    }

    private final IBikeManager manager;

}
