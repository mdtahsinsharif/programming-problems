/* 
Given list of schedules for different flights in a month, determine maximum number of flights that can be in the air anytime in that month. 
Input : list of schedules for flights.- spread over a month. 
*/

import java.util.HashMap;
import java.util.Collections;
import java.util.ArrayList;

public class FlightSchedule {
    
    int dayhour, dayhourarrival;
    String departure, arrival;
    
    public FlightSchedule(String departure, String arrival){
        if(departure==null || arrival==null) throw new IllegalArgumentException();
        this.departure = departure;
        this.arrival = arrival;
    }
    
    public int getdayhourdeparture(){
        String[] parts = departure.split(":");
        String finalnumbers = "0", temp = "0";
        for(int i = 0; i<parts.length; i++){
            finalnumbers = finalnumbers.concat(parts[i]);
        }
        return Integer.parseInt(finalnumbers);
    }
    
    public int getdayhourarrival(){
        String[] parts = arrival.split(":");
        String finalnumbers = "0";
        for(int i = 0; i<parts.length; i++){
            finalnumbers = finalnumbers.concat(parts[i]);
        }
        return Integer.parseInt(finalnumbers);
    }
    
    public static int schedule_flights(FlightSchedule[] arr){
        HashMap<Integer, Integer> mp = new HashMap<Integer, Integer>();
        for(int i=0; i<arr.length; i++)
        {
            int departure = arr[i].getdayhourdeparture();
            int arrival = arr[i].getdayhourarrival();
            while(departure < arrival)
            {
                if(mp.containsKey(departure))
                {
                    mp.put(departure, mp.get(departure)+1);
                } 
                else 
                {
                    mp.put(departure, 1);
                }
                int departure_minute = departure % 100;
                int departure_hour = departure/100;
                int departure_date = departure/10000;
                if(departure_minute == 59)
                {
                    if((departure_hour%100)==23)
                    {
                        if(departure_date == 30)
                        {
                            departure = 302459;
                        } 
                        else 
                        {
                            departure = (departure_date+1)*10000;
                        }
                    }
                    else
                    {
                        departure = (departure_hour+1)*100;
                    }
                } 
                else 
                {
                    departure++;
                }
            }
            
        }
        
        int max_flight_hours = Collections.max(mp.values());
        
        
        return max_flight_hours;
    }
    
    
    
    public static void main(String args[]) {
        int x=10;
        int y=25;
        int z=x+y;
        
        String[] departure = {"20:18:18", "19:16:23", "20:18:06"}; 
        String[] arrival = {"21:10:19", "20:18:24", "21:07:07"};
        ArrayList<FlightSchedule> arr= new ArrayList<FlightSchedule>();
        for(int i = 0; i<departure.length; i++){
            arr.add(new FlightSchedule(departure[i], arrival[i]));
        }
        
        System.out.println("Maximum flights in any one time: " + schedule_flights(arr.toArray(new FlightSchedule[arr.size()])));
    }
}
