import java.rmi.registry.*;
import java.rmi.server.*;

public class OperationsServer
{
	public static void main(String args[])
	{
		// creating instance of implemented class
		OperationsImplementation operationsImplementation = new OperationsImplementation();
		System.out.println("Process: " + operationsImplementation.getProcessId() + "\tLocal logical clock: " +
				operationsImplementation.getLogicalClock());
		
		// important for the rmi registry location
		String ip = "127.0.0.1";
		System.setProperty("java.rmi.server.hostname", ip);
		
		Registry registry = null;
		
		try
		{
			int port = 10908;
			registry = LocateRegistry.createRegistry(port);
			operationsImplementation.NewEvent("Create registry");	// event create registry
		}
		catch (Exception ex)
		{
			System.out.println();
			System.out.println("Error: " + ex.toString());
		}
		
		try
		{
			OperationsInterface skeleton = (OperationsInterface)UnicastRemoteObject.exportObject(operationsImplementation, 0);
			
			registry.rebind("Operations", skeleton);
			operationsImplementation.NewEvent("Rebind object");	// event rebind
			
			System.out.println("Server has been started.");
		}
		catch (Exception ex)
		{
			System.out.println("Error: " + ex.toString());
		}
		
		return;
	}
}
