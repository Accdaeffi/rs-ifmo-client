/**
 * PersonUpdateService_PortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package client.service.update;

public interface PersonUpdateService_PortType extends java.rmi.Remote {
    public boolean updatePerson(client.model.Person arg0) throws java.rmi.RemoteException, client.model.faults.IncorrectArgumentFault, client.model.faults.WorkWithSQLFault, client.model.faults.EmptyArgumentFault;
}
