import java.util.ArrayList;
import java.util.concurrent.Semaphore;

/**
 * Created by vibodha on 2/8/18.
 */
public class Riders extends Thread {

    int riderID;
    Semaphore busArrSem = new Semaphore(0);
    ArrayList<Rider> waitingArea = new ArrayList<Rider>();
    Semaphore mutex = new Semaphore(0);

    public Riders(int riderID, Semaphore busSem, ArrayList<Rider> waitingArea, Semaphore mutex) {
        this.riderID = riderID;
        this.busArrSem = busSem;
        this.waitingArea = waitingArea;
        this.mutex = mutex;
    }

    public void run(){
        try {
            //busArrSem.acquire();
            mutex.acquire();
                Rider rider = new Rider();
            rider.riderArrive(riderID);
            waitingArea.add(rider);
            mutex.release();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
