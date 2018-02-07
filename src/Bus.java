import java.util.ArrayList;
import java.util.concurrent.Semaphore;

/**
 * Created by vibodha on 2/8/18.
 */
public class Bus extends Thread{

    int id = 0;
    Semaphore busSem = new Semaphore(0);
    ArrayList<Rider> waitingArea = new ArrayList<Rider>();

    public Bus(int id, Semaphore busSem, ArrayList<Rider> waitingArea) {
        this.id = id;
        this.busSem = busSem;
        this.waitingArea = waitingArea;
    }

    public void run(){
        try {
            busSem.acquire();
            busArrive();
            for(int i = 0;i<Math.min(50,waitingArea.size());i++){
                waitingArea.get(0).boardBus();
            }
            busSem.release();
            depart();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void busArrive(){
        System.out.println("Bus "+String.valueOf(id)+" arrived.");
    }

    public void depart(){
        System.out.println("Bus "+String.valueOf(id)+" depart bus.");
    }

}
