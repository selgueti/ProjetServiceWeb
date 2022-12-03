package fr.uge.projet.change;

public class ChangeServiceProxy implements fr.uge.projet.change.ChangeService {
  private String _endpoint = null;
  private fr.uge.projet.change.ChangeService changeService = null;
  
  public ChangeServiceProxy() {
    _initChangeServiceProxy();
  }
  
  public ChangeServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initChangeServiceProxy();
  }
  
  private void _initChangeServiceProxy() {
    try {
      changeService = (new fr.uge.projet.change.ChangeServiceServiceLocator()).getChangeService();
      if (changeService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)changeService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)changeService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (changeService != null)
      ((javax.xml.rpc.Stub)changeService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public fr.uge.projet.change.ChangeService getChangeService() {
    if (changeService == null)
      _initChangeServiceProxy();
    return changeService;
  }
  
  public long change(java.lang.String currency1, java.lang.String currency2, long amount) throws java.rmi.RemoteException{
    if (changeService == null)
      _initChangeServiceProxy();
    return changeService.change(currency1, currency2, amount);
  }
  
  
}