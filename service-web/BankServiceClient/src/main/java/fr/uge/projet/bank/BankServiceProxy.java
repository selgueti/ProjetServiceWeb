package fr.uge.projet.bank;

public class BankServiceProxy implements fr.uge.projet.bank.BankService {
  private String _endpoint = null;
  private fr.uge.projet.bank.BankService bankService = null;
  
  public BankServiceProxy() {
    _initBankServiceProxy();
  }
  
  public BankServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initBankServiceProxy();
  }
  
  private void _initBankServiceProxy() {
    try {
      bankService = (new fr.uge.projet.bank.BankServiceServiceLocator()).getBankService();
      if (bankService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)bankService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)bankService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (bankService != null)
      ((javax.xml.rpc.Stub)bankService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public fr.uge.projet.bank.BankService getBankService() {
    if (bankService == null)
      _initBankServiceProxy();
    return bankService;
  }
  
  public boolean checkAvailableBalance(int id, java.lang.String currency, long amount) throws java.rmi.RemoteException{
    if (bankService == null)
      _initBankServiceProxy();
    return bankService.checkAvailableBalance(id, currency, amount);
  }
  
  public boolean checkAvailablebalanceF(int id, java.lang.String currency, long amount) throws java.rmi.RemoteException{
    if (bankService == null)
      _initBankServiceProxy();
    return bankService.checkAvailablebalanceF(id, currency, amount);
  }
  
  
}