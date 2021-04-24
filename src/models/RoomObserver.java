package models;
import java.util.*;

public class RoomObserver {
    ArrayList<String> updateLog;

    public RoomObserver(){
        this.updateLog = new ArrayList<String>();
    }

    public void update(String output) {
        this.updateLog.add(output);
    }

    public void printUpdates(){
        for(String s: this.updateLog){
            System.out.println(s);
        }
    }
}
