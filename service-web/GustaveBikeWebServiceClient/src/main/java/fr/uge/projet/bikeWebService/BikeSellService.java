/**
 * BikeSellService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package fr.uge.projet.bikeWebService;

public interface BikeSellService extends java.rmi.Remote {
    public java.lang.String[] getAllBikes() throws java.rmi.RemoteException;
    public boolean buyBike(int id, java.lang.String currency, long amount) throws java.rmi.RemoteException;
    public fr.uge.projet.bikeWebService.Bike getBike(int id) throws java.rmi.RemoteException;
}
