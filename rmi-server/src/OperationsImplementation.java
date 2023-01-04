
public class OperationsImplementation implements OperationsInterface
{
	private int logicalClock = 0;
	private String processId = "P1";
	
	public int getLogicalClock()
	{
	    return this.logicalClock;
	}
	
	public String getProcessId()
	{
	    return this.processId;
	}
	
	public OutputMessage Addition(InputMessage inputMessage)
	{
		ReceiveMessage(inputMessage.processId, inputMessage.logicalClock);
		int c = inputMessage.a + inputMessage.b;
		NewEvent("Addition");
		SendMessage(inputMessage.processId);
		OutputMessage outputMessage = new OutputMessage(c, this.processId, this.logicalClock);
		return outputMessage;
	}
	
	public OutputMessage Subtraction(InputMessage inputMessage)
	{
		ReceiveMessage(inputMessage.processId, inputMessage.logicalClock);
		int c = inputMessage.a - inputMessage.b;
		NewEvent("Subtraction");
		SendMessage(inputMessage.processId);
		OutputMessage outputMessage = new OutputMessage(c, this.processId, this.logicalClock);
		return outputMessage;
	}
	
	public OutputMessage Multiplication(InputMessage inputMessage)
	{
		ReceiveMessage(inputMessage.processId, inputMessage.logicalClock);
		int c = inputMessage.a * inputMessage.b;
		NewEvent("Multiplication");
		SendMessage(inputMessage.processId);
		OutputMessage outputMessage = new OutputMessage(c, this.processId, this.logicalClock);
		return outputMessage;
	}
	
	public OutputMessage Division(InputMessage inputMessage)
	{
		ReceiveMessage(inputMessage.processId, inputMessage.logicalClock);
		int c = inputMessage.a / inputMessage.b;
		NewEvent("Division");
		SendMessage(inputMessage.processId);
		OutputMessage outputMessage = new OutputMessage(c, this.processId, this.logicalClock);
		return outputMessage;
	}
	
	private void ReceiveMessage(String processId, int senderLogicalClock)
	{
		NewEvent("Receive message");	// receive a message is an event
		int maxLogicalClock = max(this.logicalClock, senderLogicalClock);
		this.logicalClock = maxLogicalClock + 1;
		System.out.println("Message received from process: " + processId + " (logical clock:" + senderLogicalClock
				+ ")\tLocal logical clock: " + logicalClock);
	}
	
	private int max(int a, int b)
	{
		if (a > b)
			return a;
		else
			return b;
	}
	
	private void SendMessage(String processId)
	{
		NewEvent("Send message");	// send a message is an event
		System.out.println("Message send to process: " + processId + "\tLocal logical clock: " + this.logicalClock);
	}
	
	public void NewEvent(String event)
	{
		this.logicalClock++;
		System.out.println("Internal Event: " + event + " \tLocal logical clock: " + logicalClock);
	}
}
