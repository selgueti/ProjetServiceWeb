package fr.uge.projet.bike;

import java.rmi.Remote;

public interface IBike extends Remote, fr.uge.projet.bike.lease.IBike, fr.uge.projet.bike.sell.IBike {
}
