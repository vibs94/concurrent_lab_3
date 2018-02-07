import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 * Created by vibodha on 2/8/18.
 */
public class MainClass {

    static Semaphore busSem = new Semaphore(0);
    static Semaphore busArrSem = new Semaphore(0);
    static Semaphore mutex = new Semaphore(1);
    static ArrayList<Rider> waitingArea = new ArrayList<Rider>();

    public static void main(String[] args) {

        int num = 10;
        int rand;
        int busID = 0;
        int riderID = 0;
        Riders riderThread;
        Bus busThread;

        for(int i=0;i<num;i++){
            Random random = new Random();
            rand = Math.abs(random.nextInt()%10);
            System.out.println(rand);
            if(rand>0){
                riderThread = new Riders(riderID,busArrSem,waitingArea,mutex);
                riderThread.start();
                riderID++;
            }
            else{
                busThread = new Bus(busID,busSem,waitingArea);
                busThread.start();
                busID++;
            }
        }


    }

}
