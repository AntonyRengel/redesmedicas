/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package redesmedicasdesktop.Modelo;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.xml.namespace.QName;
import javax.xml.soap.*;

/**
 *
 * @author antony
 */
public class ModeloSoapCliente {
    
    
   private static final String endpoint = "http://localhost/SOAPService/MySoapService";
 
    public static void inicioarServicio() throws SOAPException {
        SOAPMessage message = MessageFactory.newInstance().createMessage();
        SOAPHeader header = message.getSOAPHeader();
        header.detachNode();
 
        SOAPEnvelope envelope = message.getSOAPPart().getEnvelope();
        envelope.setAttribute("namespace","namespaceUrl");
 
        SOAPBody body = message.getSOAPBody();
        QName bodyName = new QName("getResponse");
        SOAPBodyElement bodyElement = body.addBodyElement(bodyName);
        SOAPElement symbol = bodyElement.addChildElement("name");
        symbol.addTextNode("Harry Joy");
 
        SOAPConnection connection = SOAPConnectionFactory.newInstance().createConnection();
        SOAPMessage response = connection.call(message, endpoint);
        connection.close();
 
        SOAPBody responseBody = response.getSOAPBody();
        SOAPBodyElement responseElement = (SOAPBodyElement)responseBody.getChildElements().next();
        SOAPElement returnElement = (SOAPElement)responseElement.getChildElements().next();
        
        if(responseBody.getFault()!=null){
            System.out.println(returnElement.getValue()+" "+responseBody.getFault().getFaultString());
        } else {
            System.out.println(returnElement.getValue());
        }
 
        try {
            System.out.println(getXmlFromSOAPMessage(message));
            System.out.println(getXmlFromSOAPMessage(response));
        } catch (IOException e) {
            e.printStackTrace();
        }
 
    }
 
    private static String getXmlFromSOAPMessage(SOAPMessage msg) throws SOAPException, IOException {
        ByteArrayOutputStream byteArrayOS = new ByteArrayOutputStream();
        msg.writeTo(byteArrayOS);
        return new String(byteArrayOS.toByteArray());
    }
 
}