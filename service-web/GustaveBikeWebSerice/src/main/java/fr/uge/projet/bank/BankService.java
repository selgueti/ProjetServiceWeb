/**
 * BankService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package fr.uge.projet.bank;

public interface BankService extends java.rmi.Remote {
    public boolean checkAvailablebalanceF(int id, java.lang.String currency, long amount) throws java.rmi.RemoteException;
    public boolean checkAvailableBalance(int id, java.lang.String currency, long amount) throws java.rmi.RemoteException;
}
