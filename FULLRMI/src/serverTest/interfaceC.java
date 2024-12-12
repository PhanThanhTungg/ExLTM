package serverTest;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface interfaceC extends Remote{
  public double add(double a, double b) throws RemoteException;
  public double subtract(double a, double b) throws RemoteException;
}

  

