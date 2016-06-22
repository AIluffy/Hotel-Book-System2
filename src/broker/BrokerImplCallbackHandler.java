
/**
 * BrokerImplCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package broker;

    /**
     *  BrokerImplCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class BrokerImplCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public BrokerImplCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public BrokerImplCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for queryVacancy method
            * override this method for handling normal response from queryVacancy operation
            */
           public void receiveResultqueryVacancy(
                    brokerserver.QueryVacancyResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from queryVacancy operation
           */
            public void receiveErrorqueryVacancy(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for queryHotel method
            * override this method for handling normal response from queryHotel operation
            */
           public void receiveResultqueryHotel(
                    brokerserver.QueryHotelResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from queryHotel operation
           */
            public void receiveErrorqueryHotel(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for booking method
            * override this method for handling normal response from booking operation
            */
           public void receiveResultbooking(
                    brokerserver.BookingResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from booking operation
           */
            public void receiveErrorbooking(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for queryRoomrate method
            * override this method for handling normal response from queryRoomrate operation
            */
           public void receiveResultqueryRoomrate(
                    brokerserver.QueryRoomrateResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from queryRoomrate operation
           */
            public void receiveErrorqueryRoomrate(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for queryBook method
            * override this method for handling normal response from queryBook operation
            */
           public void receiveResultqueryBook(
                    brokerserver.QueryBookResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from queryBook operation
           */
            public void receiveErrorqueryBook(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for queryRoomId method
            * override this method for handling normal response from queryRoomId operation
            */
           public void receiveResultqueryRoomId(
                    brokerserver.QueryRoomIdResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from queryRoomId operation
           */
            public void receiveErrorqueryRoomId(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for queryCity method
            * override this method for handling normal response from queryCity operation
            */
           public void receiveResultqueryCity(
                    brokerserver.QueryCityResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from queryCity operation
           */
            public void receiveErrorqueryCity(java.lang.Exception e) {
            }
                


    }
    