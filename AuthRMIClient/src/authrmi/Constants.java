package authrmi;

/**
 * The constants for this simple application.
 */
public interface Constants
{
  /** Password filename */
  public static final String PASS_FILENAME = "./config/passfile";

  /** The security policy file */
  public static final String POLICY_FILE   = "./config/security.policy";

  /** Authorization file (by user) */
  public static final String AUTH_FILE     = "./config/auth.policy";

  /** Login object name */
  public static final String LOGIN_OBJECT  = "LOGIN_OBJECT";

  /** The server port */
  public static final int SERVER_PORT      = 6000;
}