
package clientTest;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class clientMain {
  public static void main(String[] args) throws RemoteException, NotBoundException {
    Registry registry = LocateRegistry.getRegistry("localhost", 10);

    serverTest.interfaceC cal = (serverTest.interfaceC)registry.lookup("Cal");

    // Scanner scanner = new Scanner(System.in);
    // double a = scanner.nextDouble();
    // double b = scanner.nextDouble();
    System.out.println(cal.add(1, 2));
    // scanner.close();

  }
}
