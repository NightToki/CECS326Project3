import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProduceExchange {
	public static void main(String args[]) throws Exception
	   {
		try {
			//create a bridge object
			Bridge bridge = new Bridge();
			//creat and east and west village object that share the smae bridge
			WestVillage v1 = new WestVillage(bridge);
			EastVillage v2 = new EastVillage(bridge);
			// start both threads of vilalges.
			v1.start();
			v2.start();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	   }

}
//simple way to start a thread.
// this will go on infinitely with no deadlock
//Tony Tran + Linh Nguyen
// ID: 026293564 + 025852006