package client.service.update;

public class PersonUpdateServiceProxy implements client.service.update.PersonUpdateService_PortType {
  private String _endpoint = null;
  private client.service.update.PersonUpdateService_PortType personUpdateService_PortType = null;
  
  public PersonUpdateServiceProxy() {
    _initPersonUpdateServiceProxy();
  }
  
  public PersonUpdateServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initPersonUpdateServiceProxy();
  }
  
  private void _initPersonUpdateServiceProxy() {
    try {
      personUpdateService_PortType = (new client.service.update.PersonUpdateService_ServiceLocator()).getPersonUpdateServicePort();
      if (personUpdateService_PortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)personUpdateService_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)personUpdateService_PortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (personUpdateService_PortType != null)
      ((javax.xml.rpc.Stub)personUpdateService_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public client.service.update.PersonUpdateService_PortType getPersonUpdateService_PortType() {
    if (personUpdateService_PortType == null)
      _initPersonUpdateServiceProxy();
    return personUpdateService_PortType;
  }
  
  public boolean updatePerson(client.model.Person arg0) throws java.rmi.RemoteException, client.model.faults.IncorrectArgumentFault, client.model.faults.WorkWithSQLFault, client.model.faults.EmptyArgumentFault{
    if (personUpdateService_PortType == null)
      _initPersonUpdateServiceProxy();
    return personUpdateService_PortType.updatePerson(arg0);
  }
  
  
}