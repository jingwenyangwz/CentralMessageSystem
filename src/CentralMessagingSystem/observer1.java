package CentralMessagingSystem;

public class observer1 extends Observers{
	public observer1() {
	}
	
	public void update(String message) {
		System.out.println("This is Observer Type 1 NO. "+ myID + " got the message "+ " ' "+ message+" ' " +" from the Central Messaging System"+'\n');

	}
	
}
