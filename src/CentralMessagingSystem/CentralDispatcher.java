package CentralMessagingSystem;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map.Entry;


public class CentralDispatcher {


	protected static CentralDispatcher central_ptr = null;
	private static HashMap<String,ArrayList<Observers>> map = new HashMap<String, ArrayList<Observers>>();
	
//make sure there is only one subject
	public static CentralDispatcher Instance() {
		
		if(central_ptr == null)
			central_ptr = new CentralDispatcher();
		return central_ptr;
	}
	
//the constructor of the subject	
	private CentralDispatcher() {
	}
	
	
	public void Subscribe(String topic,Observers obs) {
//create an array to accommodate subscribers
		ArrayList<Observers> arr = new ArrayList<Observers>();

//check if the input topic has already exist
		if (map.containsKey(topic)==false) {
			arr.add(obs);
			map.put(topic, arr);
		}
		else {
			arr= map.get(topic);
			arr.add(obs);	
		}

		System.out.println("The observer NO. " + obs.GetID()+ " has subscribed the Topic '" + topic + "' successfully!\n");
		
	}
	
	
	public void UnSubscribe(String topic,Observers obs) {
		ArrayList<Observers> arr = new ArrayList<Observers>();
		
		if (map.containsKey(topic)==false) {
			System.out.println("The topic/observer doesn't exist!");
		}
		else {
			arr= map.get(topic);
			arr.remove(obs);	
		}
		System.out.println("The observer NO. " + obs.GetID()+ " has unsubscribed the Topic '" + topic + "' successfully!\n");

	}
	
	public void SendMessage(String topic, String message) 
	{	
		ArrayList<Observers> array = map.get(topic);
		if(array.isEmpty()) {
			System.out.println("This topic "+topic+" has no subscribers!\n");
		}
		
		for(Observers o : array) {
			o.update(message);
		}	
		System.out.println("The message <"+message+"> has been sent successfully!\n");

		
	}
	
	public static void main(String[] args) {
		CentralDispatcher subj = new CentralDispatcher();
		observer1 obs1 = new observer1();
		observer2 obs2 = new observer2();
		observer3 obs3 = new observer3();
		observer1 obs4 = new observer1();
		observer2 obs5 = new observer2();
		observer3 obs6 = new observer3();
		
		subj.Subscribe("Movie",obs1);
		subj.Subscribe("Movie", obs2);
		subj.Subscribe("Movie", obs3);
		
		subj.Subscribe("Sports", obs4);
		subj.Subscribe("Sports", obs5);
		
		subj.Subscribe("Makeup", obs6);		
		subj.UnSubscribe("Makeup", obs6);

		subj.SendMessage("Movie","The 'Leon' is a good Movie, coming soon");
		subj.SendMessage("Sports","There will be a hiking event on this Saturday! Gathering at 8 a.m. at the gate of faculty.");
		subj.SendMessage("Makeup", "Jeffere Star will have a makeup lecture on his Youtube Channel tonight at 9 p.m.. ");
	

	
	}
	
}