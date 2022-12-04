/**
 * BikeSellServiceServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package fr.uge.projet.bikeWebService;

public class BikeSellServiceServiceLocator extends org.apache.axis.client.Service implements fr.uge.projet.bikeWebService.BikeSellServiceService {

    public BikeSellServiceServiceLocator() {
    }


    public BikeSellServiceServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public BikeSellServiceServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for BikeSellService
    private java.lang.String BikeSellService_address = "http://localhost:8080/GustaveBikeWebSerice/services/BikeSellService";

    public java.lang.String getBikeSellServiceAddress() {
        return BikeSellService_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String BikeSellServiceWSDDServiceName = "BikeSellService";

    public java.lang.String getBikeSellServiceWSDDServiceName() {
        return BikeSellServiceWSDDServiceName;
    }

    public void setBikeSellServiceWSDDServiceName(java.lang.String name) {
        BikeSellServiceWSDDServiceName = name;
    }

    public fr.uge.projet.bikeWebService.BikeSellService getBikeSellService() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(BikeSellService_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getBikeSellService(endpoint);
    }

    public fr.uge.projet.bikeWebService.BikeSellService getBikeSellService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            fr.uge.projet.bikeWebService.BikeSellServiceSoapBindingStub _stub = new fr.uge.projet.bikeWebService.BikeSellServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getBikeSellServiceWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setBikeSellServiceEndpointAddress(java.lang.String address) {
        BikeSellService_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (fr.uge.projet.bikeWebService.BikeSellService.class.isAssignableFrom(serviceEndpointInterface)) {
                fr.uge.projet.bikeWebService.BikeSellServiceSoapBindingStub _stub = new fr.uge.projet.bikeWebService.BikeSellServiceSoapBindingStub(new java.net.URL(BikeSellService_address), this);
                _stub.setPortName(getBikeSellServiceWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("BikeSellService".equals(inputPortName)) {
            return getBikeSellService();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://bikeWebService.projet.uge.fr", "BikeSellServiceService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://bikeWebService.projet.uge.fr", "BikeSellService"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("BikeSellService".equals(portName)) {
            setBikeSellServiceEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
