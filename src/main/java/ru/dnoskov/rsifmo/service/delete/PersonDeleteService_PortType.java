/**
 * PersonDeleteService_PortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package client.service.delete;

public interface PersonDeleteService_PortType extends java.rmi.Remote {
    public boolean deletePerson(int arg0) throws java.rmi.RemoteException, client.model.faults.IncorrectArgumentFault, client.model.faults.WorkWithSQLFault;
}
