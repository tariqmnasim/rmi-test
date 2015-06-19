
package authrmi;

import java.rmi.registry.*;
import java.rmi.server.*;
import java.rmi.*;
import java.util.*;

/**
 * A simple test client. Both operations are tried on a specific server.
 */
public class MyClient
{
  public static void main(String[] args)
  {
    String server = "127.0.0.1";
    String user   = "";
    String pass   = "";

    // Parse arguments

    if (args.length!=2 && args.length!=3)
      invalidOptions();
    else
    {
        user = args[0];
        pass = args[1];

        if (args.length == 3)
          server = args[2];
    }

    // Connect to the server, and authenticate

    String serverObject = "rmi://" + server + ":" +
      Constants.SERVER_PORT + "/" + Constants.LOGIN_OBJECT;

    LoginInterface loginServer = null;
    try
    {
      loginServer = (LoginInterface) Naming.lookup(serverObject);
    }
    catch (Exception e)
    {
      System.out.println(e);
      System.exit(0);
    }

    // Now we've got login object. Let's try to login and perfom both
    // operations

    try
    {
      System.out.println("-------- TRYING LOGIN --------");
      ServerInterface
        theServer = (ServerInterface) loginServer.login(user, pass);
      System.out.println("---------- LOGIN OK ----------\n");

      try
      {
        System.out.println("-------- TRYING First Operation --------");
        theServer.doFirstOperation();
        System.out.println("---------- First Operation Ok ----------");
      }
      catch (Exception e)
      {
        System.out.println(e);
      }

      try
      {
        System.out.println("-------- TRYING Second Operation --------");
        theServer.doSecondOperation();
        System.out.println("---------- Second Operation Ok ----------");
      }
      catch (Exception e)
      {
        System.out.println(e);
      }
    }
    catch (Exception e)
    {
      System.out.println(e);
      System.exit(0);
    }
  }

  private static void invalidOptions()
  {
    System.out.println("MyClient <username password> [server]");
    System.exit(0);
  }
}
