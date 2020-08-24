package CentralMessagingSystem;

public class observer3  extends Observers{
	public observer3() {
			
	}
	public void update(String message) {
		System.out.println("This is Observer Type 3 NO. "+ myID + " got the message "+ " ' "+ message+" ' " +" from the Central Messaging System"+'\n');

	}
}
