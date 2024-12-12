package serverTest;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class C extends UnicastRemoteObject implements interfaceC, Serializable{
  public C () throws RemoteException{
  }
  public double add(double a, double b) throws RemoteException {
    return a+b;
  }
  public double subtract(double a, double b) throws RemoteException {
    return a-b;
  }
}
