package CentralMessagingSystem;

public class observer2  extends Observers{
	public observer2() {
	}
	public void update(String message) {
		System.out.println("This is Observer Type 2 NO. "+ myID + " got the message "+ " ' "+ message+" ' " +" from the Central Messaging System"+'\n');

	}
}
