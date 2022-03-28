/**
 * PersonReadService_ServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package client.service.read;

public class PersonReadService_ServiceLocator extends org.apache.axis.client.Service implements client.service.read.PersonReadService_Service {

    public PersonReadService_ServiceLocator() {
    }


    public PersonReadService_ServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public PersonReadService_ServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for PersonReadServicePort
    private java.lang.String PersonReadServicePort_address = "http://127.0.0.1:8080/PersonReadService";

    public java.lang.String getPersonReadServicePortAddress() {
        return PersonReadServicePort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String PersonReadServicePortWSDDServiceName = "PersonReadServicePort";

    public java.lang.String getPersonReadServicePortWSDDServiceName() {
        return PersonReadServicePortWSDDServiceName;
    }

    public void setPersonReadServicePortWSDDServiceName(java.lang.String name) {
        PersonReadServicePortWSDDServiceName = name;
    }

    public client.service.read.PersonReadService_PortType getPersonReadServicePort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(PersonReadServicePort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getPersonReadServicePort(endpoint);
    }

    public client.service.read.PersonReadService_PortType getPersonReadServicePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            client.service.read.PersonReadServicePortBindingStub _stub = new client.service.read.PersonReadServicePortBindingStub(portAddress, this);
            _stub.setPortName(getPersonReadServicePortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setPersonReadServicePortEndpointAddress(java.lang.String address) {
        PersonReadServicePort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (client.service.read.PersonReadService_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                client.service.read.PersonReadServicePortBindingStub _stub = new client.service.read.PersonReadServicePortBindingStub(new java.net.URL(PersonReadServicePort_address), this);
                _stub.setPortName(getPersonReadServicePortWSDDServiceName());
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
        if ("PersonReadServicePort".equals(inputPortName)) {
            return getPersonReadServicePort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://soap.services.webservice/", "PersonReadService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://soap.services.webservice/", "PersonReadServicePort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("PersonReadServicePort".equals(portName)) {
            setPersonReadServicePortEndpointAddress(address);
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
