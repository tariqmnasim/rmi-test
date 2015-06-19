
package authrmi.exceptions;

/**
 * Exception that represents an user that was unable to authenticate.
 */
public class InvalidUserException
  extends SecurityException
{
  /** The name of the user */
  private String username;

  //////////////////////////////

  /**
   * Class constructor.
   *
   * @param username The name of the user.
   */
  public InvalidUserException(String username)
  {
    this.username = username;
  }

  /**
   * Converts the exception to a string.
   */
  public String toString()
  {
    return "Could not authenticate user: " + username;
  }
}