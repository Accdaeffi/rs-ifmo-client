package client.service.read;

public class PersonReadServiceProxy implements client.service.read.PersonReadService_PortType {
  private String _endpoint = null;
  private client.service.read.PersonReadService_PortType personReadService_PortType = null;
  
  public PersonReadServiceProxy() {
    _initPersonReadServiceProxy();
  }
  
  public PersonReadServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initPersonReadServiceProxy();
  }
  
  private void _initPersonReadServiceProxy() {
    try {
      personReadService_PortType = (new client.service.read.PersonReadService_ServiceLocator()).getPersonReadServicePort();
      if (personReadService_PortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)personReadService_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)personReadService_PortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (personReadService_PortType != null)
      ((javax.xml.rpc.Stub)personReadService_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public client.service.read.PersonReadService_PortType getPersonReadService_PortType() {
    if (personReadService_PortType == null)
      _initPersonReadServiceProxy();
    return personReadService_PortType;
  }
  
  public client.model.Person[] getPersonsByPatronymic(java.lang.String arg0) throws java.rmi.RemoteException, client.model.faults.WorkWithSQLFault, client.model.faults.EmptyArgumentFault{
    if (personReadService_PortType == null)
      _initPersonReadServiceProxy();
    return personReadService_PortType.getPersonsByPatronymic(arg0);
  }
  
  public client.model.Person[] getPersonsByNameAndSurname(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException, client.model.faults.WorkWithSQLFault, client.model.faults.EmptyArgumentFault{
    if (personReadService_PortType == null)
      _initPersonReadServiceProxy();
    return personReadService_PortType.getPersonsByNameAndSurname(arg0, arg1);
  }
  
  public client.model.Person[] getPersonsByFullName(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2) throws java.rmi.RemoteException, client.model.faults.WorkWithSQLFault, client.model.faults.EmptyArgumentFault{
    if (personReadService_PortType == null)
      _initPersonReadServiceProxy();
    return personReadService_PortType.getPersonsByFullName(arg0, arg1, arg2);
  }
  
  public client.model.Person[] getPersonsYoungerThan(int arg0) throws java.rmi.RemoteException, client.model.faults.IncorrectArgumentFault, client.model.faults.WorkWithSQLFault{
    if (personReadService_PortType == null)
      _initPersonReadServiceProxy();
    return personReadService_PortType.getPersonsYoungerThan(arg0);
  }
  
  public client.model.Person[] getPersonsBySurname(java.lang.String arg0) throws java.rmi.RemoteException, client.model.faults.WorkWithSQLFault, client.model.faults.EmptyArgumentFault{
    if (personReadService_PortType == null)
      _initPersonReadServiceProxy();
    return personReadService_PortType.getPersonsBySurname(arg0);
  }
  
  public client.model.Person[] getPersonsOlderThan(int arg0) throws java.rmi.RemoteException, client.model.faults.IncorrectArgumentFault, client.model.faults.WorkWithSQLFault{
    if (personReadService_PortType == null)
      _initPersonReadServiceProxy();
    return personReadService_PortType.getPersonsOlderThan(arg0);
  }
  
  public client.model.Person[] getPersonsByName(java.lang.String arg0) throws java.rmi.RemoteException, client.model.faults.WorkWithSQLFault, client.model.faults.EmptyArgumentFault{
    if (personReadService_PortType == null)
      _initPersonReadServiceProxy();
    return personReadService_PortType.getPersonsByName(arg0);
  }
  
  public client.model.Person getPersonById(int arg0) throws java.rmi.RemoteException, client.model.faults.WorkWithSQLFault, client.model.faults.PersonWithSuchIdNotFoundFault{
    if (personReadService_PortType == null)
      _initPersonReadServiceProxy();
    return personReadService_PortType.getPersonById(arg0);
  }
  
  public client.model.Person[] getAllPersons() throws java.rmi.RemoteException, client.model.faults.WorkWithSQLFault{
    if (personReadService_PortType == null)
      _initPersonReadServiceProxy();
    return personReadService_PortType.getAllPersons();
  }
  
  public client.model.Person[] getPersonsByAge(int arg0) throws java.rmi.RemoteException, client.model.faults.IncorrectArgumentFault, client.model.faults.WorkWithSQLFault{
    if (personReadService_PortType == null)
      _initPersonReadServiceProxy();
    return personReadService_PortType.getPersonsByAge(arg0);
  }
  
  
}