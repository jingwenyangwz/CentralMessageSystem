package CentralMessagingSystem;

public abstract class Observers {
	
	protected int myID;
	protected static int counter = 0;
	protected Observers() {
		counter++;
		myID = counter;	
	}
	
	protected int GetID() {
			return myID;
	}
	abstract void update(String message);

	
}
