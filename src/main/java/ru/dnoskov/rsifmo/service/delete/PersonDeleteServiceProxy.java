package client.service.delete;

public class PersonDeleteServiceProxy implements client.service.delete.PersonDeleteService_PortType {
  private String _endpoint = null;
  private client.service.delete.PersonDeleteService_PortType personDeleteService_PortType = null;
  
  public PersonDeleteServiceProxy() {
    _initPersonDeleteServiceProxy();
  }
  
  public PersonDeleteServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initPersonDeleteServiceProxy();
  }
  
  private void _initPersonDeleteServiceProxy() {
    try {
      personDeleteService_PortType = (new client.service.delete.PersonDeleteService_ServiceLocator()).getPersonDeleteServicePort();
      if (personDeleteService_PortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)personDeleteService_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)personDeleteService_PortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (personDeleteService_PortType != null)
      ((javax.xml.rpc.Stub)personDeleteService_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public client.service.delete.PersonDeleteService_PortType getPersonDeleteService_PortType() {
    if (personDeleteService_PortType == null)
      _initPersonDeleteServiceProxy();
    return personDeleteService_PortType;
  }
  
  public boolean deletePerson(int arg0) throws java.rmi.RemoteException, client.model.faults.IncorrectArgumentFault, client.model.faults.WorkWithSQLFault{
    if (personDeleteService_PortType == null)
      _initPersonDeleteServiceProxy();
    return personDeleteService_PortType.deletePerson(arg0);
  }
  
  
}