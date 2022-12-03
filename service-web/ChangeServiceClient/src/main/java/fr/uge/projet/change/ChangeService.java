/**
 * ChangeService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package fr.uge.projet.change;

public interface ChangeService extends java.rmi.Remote {
    public long change(java.lang.String currencySrc, java.lang.String currencyDest, long amount) throws java.rmi.RemoteException;
}
