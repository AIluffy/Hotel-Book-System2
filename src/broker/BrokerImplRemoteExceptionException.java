
/**
 * BrokerImplRemoteExceptionException.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

package broker;

public class BrokerImplRemoteExceptionException extends java.lang.Exception{

    private static final long serialVersionUID = 1432014442454L;
    
    private brokerserver.BrokerImplRemoteException faultMessage;

    
        public BrokerImplRemoteExceptionException() {
            super("BrokerImplRemoteExceptionException");
        }

        public BrokerImplRemoteExceptionException(java.lang.String s) {
           super(s);
        }

        public BrokerImplRemoteExceptionException(java.lang.String s, java.lang.Throwable ex) {
          super(s, ex);
        }

        public BrokerImplRemoteExceptionException(java.lang.Throwable cause) {
            super(cause);
        }
    

    public void setFaultMessage(brokerserver.BrokerImplRemoteException msg){
       faultMessage = msg;
    }
    
    public brokerserver.BrokerImplRemoteException getFaultMessage(){
       return faultMessage;
    }
}
    