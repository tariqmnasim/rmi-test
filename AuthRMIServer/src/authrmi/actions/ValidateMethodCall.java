
package authrmi.actions;

import authrmi.*;
import authrmi.permissions.*;
import java.util.*;
import java.security.*;

/**
 * Assures that the a certain method can be called in the context
 * of the running code.
 */
public class ValidateMethodCall
  implements PrivilegedExceptionAction
{
  /** The method to be called */
  private String methodName;

  //////////////////////////

  /**
   *  Make sure that the current user (defined by its context) has
   *  the permissions to call the "methodName" method. For checking
   *  this, a ServerPermission is required.
   *
   *  authrmi.permissions.ServerPermission "methodName"
   *    -> authorizes the call of a certain method
   *  authrmi.permissions.ServerPermission "*"
   *    -> authorizes the call of all methods
   */
  public ValidateMethodCall(String methodName)
  {
    this.methodName = methodName;
  }

  public Object run()
  {
    // Only has to check if the appropriate ServerPermission is owned by
    // the user. If not an exception is thrown.
    AccessController.checkPermission(new ServerPermission(methodName));
    return null;
  }
}
