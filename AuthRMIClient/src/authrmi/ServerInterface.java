package authrmi;

/**
 * The interface of the server.
 */
public interface ServerInterface
  extends java.rmi.Remote
{
  /**
   * The first operation.
   *
   * @throws SecurityException If the client doesn't have permissions
   * for executing this method.
   */
  public void doFirstOperation()
    throws java.rmi.RemoteException, SecurityException;

  /**
   * The second operation.
   *
   * @throws SecurityException If the client doesn't have permissions
   * for executing this method.
   */
  public void doSecondOperation()
    throws java.rmi.RemoteException, SecurityException;
}
