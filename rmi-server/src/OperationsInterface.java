import java.rmi.*;

public interface OperationsInterface extends Remote
{
	OutputMessage Addition(InputMessage inputMessage) throws RemoteException;
	OutputMessage Subtraction(InputMessage inputMessage) throws RemoteException;
	OutputMessage Multiplication(InputMessage inputMessage) throws RemoteException;
	OutputMessage Division(InputMessage inputMessage) throws RemoteException;
}