package views;

import java.io.IOException;
import java.util.*;

import dataAccess.DataReader;
import models.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FacilitySystemClient {
    public static void main(String[] args) throws IOException {
        DataReader dr = new DataReader();
        HashMap<String,Object> input;
        try{ 
            input = dr.read();
        }
        catch (IOException e){
            throw new IOException();
        }
        Iterator i = input.entrySet().iterator();
        while(i.hasNext()){
            Map.Entry element = (Map.Entry)i.next();
            String key = element.getKey().toString();
            Object val = element.getValue();
            GeneralFacility f;
            Building b;
            Room r;
            MaintenanceRequest mr;
            Use u;
            switch(key){
                case "Facility":
                    f = (GeneralFacility)val;
                    System.out.println("Facility " + f.getName());
                    System.out.println("Facility details: " + f.getDetails());
                    System.out.println("Maintenance requests: " + f.listMaintRequests().size());
                    System.out.println("Capacity: " + f.requestAvailableCapacity());
                    break;
                case "Building":
                    b = (Building)val;
                    System.out.println("Building "+ b.getName());
                    System.out.println(b.getAddress());
                    System.out.println("Rooms: " + b.getRooms().size());
                    break;
                case "Room":
                    r = (Room)val;
                    System.out.println("Room " + r.getRoomNumber());
                    break;
                case "MaintenanceRequest":
                    mr = (MaintenanceRequest)val;
                    System.out.println(mr.toString());
                    break;
                case "Use":
                    u = (Use)val;
                    System.out.println("Use " + u.getDetails());
                    System.out.println("Date " + u.getDate());
                    System.out.println("Duration: " + u.getDuration());
                    System.out.println("Room: " + u.getRoom().getRoomNumber());
                    break;
            }
        }
    }
}
