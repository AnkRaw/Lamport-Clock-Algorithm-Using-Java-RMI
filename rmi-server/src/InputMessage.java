import java.io.Serializable;

public class InputMessage implements Serializable
{
	private static final long serialVersionUID = 1L;
	int a;
	int b;
	int logicalClock;
	String processId;
}
