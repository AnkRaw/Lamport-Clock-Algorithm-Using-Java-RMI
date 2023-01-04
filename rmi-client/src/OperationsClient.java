import java.rmi.registry.*;
import java.util.*;

public class OperationsClient
{
	private static int logicalClock = 0;
	private static String processId = "P0";
	private static int a = 4;
	private static int b = 2;
	
	public static void main(String args[])
	{
		try
		{
			System.out.println("Process: " + processId + "\tLocal logical clock: " + logicalClock);
			
			String ip = "127.0.0.1";
			int port = 10908;
			Registry registry = LocateRegistry.getRegistry(ip, port);
			NewEvent("Get registry");		// event get registry
			
			OperationsInterface stub = (OperationsInterface)registry.lookup("Operations");
			NewEvent("Stub creation");		// event stub creation
			
			OutputMessage outputMessage = new OutputMessage();
			InputMessage inputMessage = new InputMessage(a, b, logicalClock, processId);
			
			System.out.println("Number 1: " + a + "\tNumber 2: " + b);
			
			while(true)
			{
				System.out.println("Choose an operation: 1 Addition | 2 Subtraction | 3 Multiplication | 4 Division");
				Scanner input = new Scanner(System.in);
				String msg = input.nextLine();
				//input.close();
				NewEvent("Choose operation");	// event ask for operation
				
				int operation = Integer.parseInt(msg);
				
				SendMessage();
				inputMessage.logicalClock = logicalClock;
				
				switch (operation)
				{
					case 1:
						outputMessage = stub.Addition(inputMessage);
						break;
					case 2:
						outputMessage = stub.Addition(inputMessage);
						break;
					case 3:
						outputMessage = stub.Addition(inputMessage);
						break;
					case 4:
						outputMessage = stub.Addition(inputMessage);
						break;
				}
				
				ReceiveMessage(outputMessage.processId, outputMessage.logicalClock);
				System.out.println("Operation answer: " + outputMessage.c);
			}
		}
		catch (Exception ex)
		{
			System.out.println("Err: " + ex.toString());
		}
	}
	
	private static void SendMessage()
	{
		NewEvent("Send message");	// send a message is an event
		System.out.println("Message send to process: P0 \tLocal logical clock: " + logicalClock);
	}
	
	private static void ReceiveMessage(String processId, int senderLogicalClock)
	{
		NewEvent("Receive message");	// receive a message is an event
		int maxLogicalClock = max(logicalClock, senderLogicalClock);
		logicalClock = maxLogicalClock + 1;
		System.out.println("Message received from process: " + processId + " (logical clock:" + senderLogicalClock
				+ ")\tLocal logical clock: " + logicalClock);
	}
	
	private static int max(int a, int b)
	{
		if (a > b)
			return a;
		else
			return b;
	}
	
	private static void NewEvent(String event)
	{
		logicalClock++;
		System.out.println("Internal Event: " + event + "\tLocal logical clock: " + logicalClock);
	}
}
