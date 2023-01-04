import java.io.Serializable;

public class InputMessage implements Serializable
{
	private static final long serialVersionUID = 1L;
	int a;
	int b;
	int logicalClock;
	String processId;
	
	public InputMessage(int a, int b, int logicalClock, String processId)
	{
		this.a = a;
		this.b = b;
		this.logicalClock = logicalClock;
		this.processId = processId;
	}
}
