

/**
 * Created by vibodha on 2/8/18.
 */
public class Rider {

    int id;



    public void riderArrive(int id){
        this.id = id;
        System.out.println("Rider "+String.valueOf(this.id)+" arrived.");
    }

    public void boardBus(){
        System.out.println("Rider "+String.valueOf(id)+" board bus.");
    }

}
