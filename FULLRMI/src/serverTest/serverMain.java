package serverTest;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class serverMain {
  public static void main(String[] args) throws RemoteException, InterruptedException {
    Registry registry = LocateRegistry.createRegistry(10);

    interfaceC cSkeleton = new C();
    registry.rebind("Cal", cSkeleton);

    while(true){
      System.out.println("server is running");
      Thread.sleep(5000);
    }
  }
  
}
