
package authrmi;

import authrmi.actions.*;
import javax.security.auth.*;

/**
 * Proxy that protects the server from direct calls by
 * the clients. All calls go through a security check.
 */
public class ServerProxy
  extends java.rmi.server.UnicastRemoteObject
  implements ServerInterface
{
  /** A reference to the real server object */
  private ServerInterface theServer;

  /** The user associated with this proxy */
  private Subject         user;

  ////////////////////////

  /**
   * Class constructor.
   *
   * @param user A subject representing the user for this proxy.
   * @param theServer The real server object.
   */
  public ServerProxy(Subject user, ServerInterface theServer)
    throws java.rmi.RemoteException
  {
    this.theServer = theServer;
    this.user      = user;
  }

  ////////////////////////

  /**
   * The client calls this method. If he client has the
   * appropriate permissions, the call goes through.
   */
  public void doFirstOperation()
    throws java.rmi.RemoteException, SecurityException
  {
    checkPermission("doFirstOperation");
    theServer.doFirstOperation();
  }

  /**
   * The client calls this method. If he client has the
   * appropriate permissions, the call goes through.
   */
  public void doSecondOperation()
    throws java.rmi.RemoteException, SecurityException
  {
    checkPermission("doSecondOperation");
    theServer.doSecondOperation();
  }

  ////////////////////////

  /**
   * Check if the current client can call a certain method.
   * The check is made through JAAS and its policy file.
   *
   * @param methodName The method that will be called.
   * @throws SecurityException If the client doesn't have the necessary
   * permissions.
   */
  private void checkPermission(String methodName)
    throws SecurityException
  {
    // Assume the identity of the user, and validate if he can
    // call this method
    try
    {
      Subject.doAs(user, new ValidateMethodCall(methodName));
    }
    catch (java.security.PrivilegedActionException e)
    {
      throw (SecurityException) e.getException();
    }
  }
}

