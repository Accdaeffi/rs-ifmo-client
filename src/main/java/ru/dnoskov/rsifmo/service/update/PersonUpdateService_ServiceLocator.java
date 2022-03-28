/**
 * PersonUpdateService_ServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package client.service.update;

public class PersonUpdateService_ServiceLocator extends org.apache.axis.client.Service implements client.service.update.PersonUpdateService_Service {

    public PersonUpdateService_ServiceLocator() {
    }


    public PersonUpdateService_ServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public PersonUpdateService_ServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for PersonUpdateServicePort
    private java.lang.String PersonUpdateServicePort_address = "http://127.0.0.1:8080/PersonUpdateService";

    public java.lang.String getPersonUpdateServicePortAddress() {
        return PersonUpdateServicePort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String PersonUpdateServicePortWSDDServiceName = "PersonUpdateServicePort";

    public java.lang.String getPersonUpdateServicePortWSDDServiceName() {
        return PersonUpdateServicePortWSDDServiceName;
    }

    public void setPersonUpdateServicePortWSDDServiceName(java.lang.String name) {
        PersonUpdateServicePortWSDDServiceName = name;
    }

    public client.service.update.PersonUpdateService_PortType getPersonUpdateServicePort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(PersonUpdateServicePort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getPersonUpdateServicePort(endpoint);
    }

    public client.service.update.PersonUpdateService_PortType getPersonUpdateServicePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            client.service.update.PersonUpdateServicePortBindingStub _stub = new client.service.update.PersonUpdateServicePortBindingStub(portAddress, this);
            _stub.setPortName(getPersonUpdateServicePortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setPersonUpdateServicePortEndpointAddress(java.lang.String address) {
        PersonUpdateServicePort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (client.service.update.PersonUpdateService_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                client.service.update.PersonUpdateServicePortBindingStub _stub = new client.service.update.PersonUpdateServicePortBindingStub(new java.net.URL(PersonUpdateServicePort_address), this);
                _stub.setPortName(getPersonUpdateServicePortWSDDServiceName());
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
        if ("PersonUpdateServicePort".equals(inputPortName)) {
            return getPersonUpdateServicePort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://soap.services.webservice/", "PersonUpdateService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://soap.services.webservice/", "PersonUpdateServicePort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("PersonUpdateServicePort".equals(portName)) {
            setPersonUpdateServicePortEndpointAddress(address);
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
