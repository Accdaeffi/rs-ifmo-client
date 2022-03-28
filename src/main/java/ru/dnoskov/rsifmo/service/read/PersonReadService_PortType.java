/**
 * PersonReadService_PortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package client.service.read;

public interface PersonReadService_PortType extends java.rmi.Remote {
    public client.model.Person getPersonById(int arg0) throws java.rmi.RemoteException, client.model.faults.WorkWithSQLFault, client.model.faults.PersonWithSuchIdNotFoundFault;
    public client.model.Person[] getPersonsByAge(int arg0) throws java.rmi.RemoteException, client.model.faults.IncorrectArgumentFault, client.model.faults.WorkWithSQLFault;
    public client.model.Person[] getPersonsByName(java.lang.String arg0) throws java.rmi.RemoteException, client.model.faults.WorkWithSQLFault, client.model.faults.EmptyArgumentFault;
    public client.model.Person[] getAllPersons() throws java.rmi.RemoteException, client.model.faults.WorkWithSQLFault;
    public client.model.Person[] getPersonsYoungerThan(int arg0) throws java.rmi.RemoteException, client.model.faults.IncorrectArgumentFault, client.model.faults.WorkWithSQLFault;
    public client.model.Person[] getPersonsByNameAndSurname(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException, client.model.faults.WorkWithSQLFault, client.model.faults.EmptyArgumentFault;
    public client.model.Person[] getPersonsByPatronymic(java.lang.String arg0) throws java.rmi.RemoteException, client.model.faults.WorkWithSQLFault, client.model.faults.EmptyArgumentFault;
    public client.model.Person[] getPersonsByFullName(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2) throws java.rmi.RemoteException, client.model.faults.WorkWithSQLFault, client.model.faults.EmptyArgumentFault;
    public client.model.Person[] getPersonsOlderThan(int arg0) throws java.rmi.RemoteException, client.model.faults.IncorrectArgumentFault, client.model.faults.WorkWithSQLFault;
    public client.model.Person[] getPersonsBySurname(java.lang.String arg0) throws java.rmi.RemoteException, client.model.faults.WorkWithSQLFault, client.model.faults.EmptyArgumentFault;
}
