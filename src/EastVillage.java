import java.util.Random;
//extends thread so they can be used as threads

public class EastVillage extends Thread{
	private Bridge bridge;
	private Random random;
	

	//create a East village object 
	//each village can use a bridge and they will randomly do any action for a random amount of time
	public EastVillage(Bridge bridge) {
		// TODO Auto-generated constructor stub
		this.bridge = bridge;
		this.random=new Random();
	}
	// eat a donut for random amount of time
	private void eat() throws InterruptedException{
		System.out.println(this + " is eating a donut");
		Thread.sleep(random.nextInt(3000-1000)+1000);
	}
	// they will take a random amound of time to travel
	private void travel() throws InterruptedException{
		System.out.println(this + " is using the bridge");
		Thread.sleep(random.nextInt(3000-1000)+1000);
	}
	
	@Override
	public void run() {
		try {
			//simple where if the bridge is in use then the other people wont use it and they people on the bridge will continue to use it untill
			//they have returned from their trip
			while(true) {
				eat();
				if(bridge.useBridge(this)) {
					travel();
					bridge.returnBridge(this);
				}
				
			}
	}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	//toString for my purposes
	@Override
	public String toString() {
		return "EastVillager";
	}

}
// each village can have a villager travel on the bridge or eat a donut
