import java.io.Serializable;

public class OutputMessage implements Serializable
{
	private static final long serialVersionUID = 1L;
	int c;
	String processId;
	int logicalClock;
	
	public OutputMessage(int c, String processId, int logicalClock)
	{
		this.c = c;
		this.processId = processId;
		this.logicalClock = logicalClock;
	}
}
