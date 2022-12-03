package fr.uge.projet.bikeWebService;

public class BikeSellServiceProxy implements fr.uge.projet.bikeWebService.BikeSellService {
  private String _endpoint = null;
  private fr.uge.projet.bikeWebService.BikeSellService bikeSellService = null;
  
  public BikeSellServiceProxy() {
    _initBikeSellServiceProxy();
  }
  
  public BikeSellServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initBikeSellServiceProxy();
  }
  
  private void _initBikeSellServiceProxy() {
    try {
      bikeSellService = (new fr.uge.projet.bikeWebService.BikeSellServiceServiceLocator()).getBikeSellService();
      if (bikeSellService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)bikeSellService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)bikeSellService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (bikeSellService != null)
      ((javax.xml.rpc.Stub)bikeSellService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public fr.uge.projet.bikeWebService.BikeSellService getBikeSellService() {
    if (bikeSellService == null)
      _initBikeSellServiceProxy();
    return bikeSellService;
  }
  
  public java.lang.String[] getAllBikes() throws java.rmi.RemoteException{
    if (bikeSellService == null)
      _initBikeSellServiceProxy();
    return bikeSellService.getAllBikes();
  }
  
  public boolean buyBike(int id, java.lang.String currency, long amount) throws java.rmi.RemoteException{
    if (bikeSellService == null)
      _initBikeSellServiceProxy();
    return bikeSellService.buyBike(id, currency, amount);
  }
  
  public fr.uge.projet.bikeWebService.Bike getBike(int id) throws java.rmi.RemoteException{
    if (bikeSellService == null)
      _initBikeSellServiceProxy();
    return bikeSellService.getBike(id);
  }
  
  
}