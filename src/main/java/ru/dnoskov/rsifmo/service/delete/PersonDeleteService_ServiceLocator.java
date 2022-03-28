/**
 * PersonDeleteService_ServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package client.service.delete;

public class PersonDeleteService_ServiceLocator extends org.apache.axis.client.Service implements client.service.delete.PersonDeleteService_Service {

    public PersonDeleteService_ServiceLocator() {
    }


    public PersonDeleteService_ServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public PersonDeleteService_ServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for PersonDeleteServicePort
    private java.lang.String PersonDeleteServicePort_address = "http://127.0.0.1:8080/PersonDeleteService";

    public java.lang.String getPersonDeleteServicePortAddress() {
        return PersonDeleteServicePort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String PersonDeleteServicePortWSDDServiceName = "PersonDeleteServicePort";

    public java.lang.String getPersonDeleteServicePortWSDDServiceName() {
        return PersonDeleteServicePortWSDDServiceName;
    }

    public void setPersonDeleteServicePortWSDDServiceName(java.lang.String name) {
        PersonDeleteServicePortWSDDServiceName = name;
    }

    public client.service.delete.PersonDeleteService_PortType getPersonDeleteServicePort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(PersonDeleteServicePort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getPersonDeleteServicePort(endpoint);
    }

    public client.service.delete.PersonDeleteService_PortType getPersonDeleteServicePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            client.service.delete.PersonDeleteServicePortBindingStub _stub = new client.service.delete.PersonDeleteServicePortBindingStub(portAddress, this);
            _stub.setPortName(getPersonDeleteServicePortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setPersonDeleteServicePortEndpointAddress(java.lang.String address) {
        PersonDeleteServicePort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (client.service.delete.PersonDeleteService_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                client.service.delete.PersonDeleteServicePortBindingStub _stub = new client.service.delete.PersonDeleteServicePortBindingStub(new java.net.URL(PersonDeleteServicePort_address), this);
                _stub.setPortName(getPersonDeleteServicePortWSDDServiceName());
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
        if ("PersonDeleteServicePort".equals(inputPortName)) {
            return getPersonDeleteServicePort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://soap.services.webservice/", "PersonDeleteService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://soap.services.webservice/", "PersonDeleteServicePort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("PersonDeleteServicePort".equals(portName)) {
            setPersonDeleteServicePortEndpointAddress(address);
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
