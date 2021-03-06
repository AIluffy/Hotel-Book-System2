package corba.hotelbooking;


/**
* corba/hotelbooking/HotelWMPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from HotelWM.idl
* Saturday, May 16, 2015 4:28:13 PM CST
*/

public abstract class HotelWMPOA extends org.omg.PortableServer.Servant
 implements corba.hotelbooking.HotelWMOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("queryHotel", new java.lang.Integer (0));
    _methods.put ("queryRoomrate", new java.lang.Integer (1));
    _methods.put ("queryVacancy", new java.lang.Integer (2));
    _methods.put ("queryRoomId", new java.lang.Integer (3));
    _methods.put ("booking", new java.lang.Integer (4));
    _methods.put ("queryBook", new java.lang.Integer (5));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // corba/hotelbooking/HotelWM/queryHotel
       {
         String req = in.read_string ();
         String $result = null;
         $result = this.queryHotel (req);
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       case 1:  // corba/hotelbooking/HotelWM/queryRoomrate
       {
         String req = in.read_string ();
         String $result = null;
         $result = this.queryRoomrate (req);
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       case 2:  // corba/hotelbooking/HotelWM/queryVacancy
       {
         String req = in.read_string ();
         String $result = null;
         $result = this.queryVacancy (req);
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       case 3:  // corba/hotelbooking/HotelWM/queryRoomId
       {
         String req = in.read_string ();
         String $result = null;
         $result = this.queryRoomId (req);
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       case 4:  // corba/hotelbooking/HotelWM/booking
       {
         String req = in.read_string ();
         String $result = null;
         $result = this.booking (req);
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       case 5:  // corba/hotelbooking/HotelWM/queryBook
       {
         String req = in.read_string ();
         String $result = null;
         $result = this.queryBook (req);
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:corba/hotelbooking/HotelWM:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public HotelWM _this() 
  {
    return HotelWMHelper.narrow(
    super._this_object());
  }

  public HotelWM _this(org.omg.CORBA.ORB orb) 
  {
    return HotelWMHelper.narrow(
    super._this_object(orb));
  }


} // class HotelWMPOA
