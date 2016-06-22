

/**
 * BrokerImpl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package broker;

    /*
     *  BrokerImpl java interface
     */

    public interface BrokerImpl {
          

        /**
          * Auto generated method signature
          * 
                    * @param queryVacancy0
                
             * @throws broker.BrokerImplRemoteExceptionException : 
         */

         
                     public brokerserver.QueryVacancyResponse queryVacancy(

                        brokerserver.QueryVacancy queryVacancy0)
                        throws java.rmi.RemoteException
             
          ,broker.BrokerImplRemoteExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param queryVacancy0
            
          */
        public void startqueryVacancy(

            brokerserver.QueryVacancy queryVacancy0,

            final broker.BrokerImplCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param queryHotel2
                
             * @throws broker.BrokerImplRemoteExceptionException : 
         */

         
                     public brokerserver.QueryHotelResponse queryHotel(

                        brokerserver.QueryHotel queryHotel2)
                        throws java.rmi.RemoteException
             
          ,broker.BrokerImplRemoteExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param queryHotel2
            
          */
        public void startqueryHotel(

            brokerserver.QueryHotel queryHotel2,

            final broker.BrokerImplCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param booking4
                
             * @throws broker.BrokerImplRemoteExceptionException : 
         */

         
                     public brokerserver.BookingResponse booking(

                        brokerserver.Booking booking4)
                        throws java.rmi.RemoteException
             
          ,broker.BrokerImplRemoteExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param booking4
            
          */
        public void startbooking(

            brokerserver.Booking booking4,

            final broker.BrokerImplCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param queryRoomrate6
                
             * @throws broker.BrokerImplRemoteExceptionException : 
         */

         
                     public brokerserver.QueryRoomrateResponse queryRoomrate(

                        brokerserver.QueryRoomrate queryRoomrate6)
                        throws java.rmi.RemoteException
             
          ,broker.BrokerImplRemoteExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param queryRoomrate6
            
          */
        public void startqueryRoomrate(

            brokerserver.QueryRoomrate queryRoomrate6,

            final broker.BrokerImplCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param queryBook8
                
             * @throws broker.BrokerImplRemoteExceptionException : 
         */

         
                     public brokerserver.QueryBookResponse queryBook(

                        brokerserver.QueryBook queryBook8)
                        throws java.rmi.RemoteException
             
          ,broker.BrokerImplRemoteExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param queryBook8
            
          */
        public void startqueryBook(

            brokerserver.QueryBook queryBook8,

            final broker.BrokerImplCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param queryRoomId10
                
             * @throws broker.BrokerImplRemoteExceptionException : 
         */

         
                     public brokerserver.QueryRoomIdResponse queryRoomId(

                        brokerserver.QueryRoomId queryRoomId10)
                        throws java.rmi.RemoteException
             
          ,broker.BrokerImplRemoteExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param queryRoomId10
            
          */
        public void startqueryRoomId(

            brokerserver.QueryRoomId queryRoomId10,

            final broker.BrokerImplCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param queryCity12
                
             * @throws broker.BrokerImplRemoteExceptionException : 
         */

         
                     public brokerserver.QueryCityResponse queryCity(

                        brokerserver.QueryCity queryCity12)
                        throws java.rmi.RemoteException
             
          ,broker.BrokerImplRemoteExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param queryCity12
            
          */
        public void startqueryCity(

            brokerserver.QueryCity queryCity12,

            final broker.BrokerImplCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        
       //
       }
    