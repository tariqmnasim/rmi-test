
package authrmi;

import java.rmi.registry.*;
import java.rmi.server.*;
import java.rmi.*;
import java.util.*;

/**
 * The main class for the server.
 */
public class MyServer
{
  public static void main(String[] args)
  {
    // Installs a security manager and configures the location
    // of the policy files
    System.setProperty("java.security.policy", Constants.POLICY_FILE);
    System.setProperty("java.security.auth.policy", Constants.AUTH_FILE);
    System.setSecurityManager(new RMISecurityManager());

    // Assures that the identifiers generated for the server objects
    // will be secure
    System.setProperty("java.rmi.server.randomIDs", "true");

    // Opens a port (registry) for the login interface and registers
    // the object
    try
    {
      ServerInterface theServer  = new ServerImpl();
      LoginInterface loginObject = new LoginImpl(theServer);

      Registry loginRegistry =
        LocateRegistry.createRegistry(Constants.SERVER_PORT);
      loginRegistry.bind(Constants.LOGIN_OBJECT, loginObject);

      System.out.println((new Date()) + ": Server up and running");
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }
}
