import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
public class Bridge {
	//create a bridge
	private Lock lock;
	// the only property of this bridge is that it has a lock on it so if it is in use no one else can use it 
	public Bridge() {
		this.lock = new ReentrantLock();
	}
	//use the bridge and it will lock the bridge
	public boolean useBridge(Object villages) throws InterruptedException{
		if(lock.tryLock(10,TimeUnit.MILLISECONDS)) {
			System.out.println(villages +" crossed the bridge ");
			return true;
		}
		return false;
	}
	// return from the bridge crossing and unlock the bridge
	public void returnBridge(Object villages) {
		lock.unlock();
		System.out.println(villages + " has returned from crossing the bridge");
	}
	
}

// this is the bridge object that is created that the two villages will share