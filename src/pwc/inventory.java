package pwc;

import java.util.*;
import java.util.concurrent.TimeUnit;

import org.joda.time.DateTime;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.lang.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;



public class inventory {
	
	
	
	public void display(ArrayList cars){
		System.out.print(cars);
	}

	
	
	
	public ArrayList borrow(ArrayList cars, String c){
		if(cars.contains(c)) {
			System.out.println("");
			System.out.println(c+" available for rent");
			LocalDateTime startDate = LocalDateTime.now();
		    DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		    this.s = startDate;
		    this.start = startDate.format(format);
		    System.out.println("");
		    System.out.println("Date and Time of borrowing: " + this.start);
			cars.remove(cars.indexOf(c));
		}
		else {
			System.out.println("");
			System.out.println(c+" unavailable");
		}
		return cars;
	}
	
	
	
	public ArrayList add(ArrayList cars, String c){
		if(cars.contains(c)) {
			System.out.println("");
			System.out.println(c+" already owned, hence unchanged");
		}
		else {
			System.out.println("");
			System.out.println(c+" added");
			cars.add(c);
		}
		return cars;
	}
	
	
	
	
	public ArrayList ret(ArrayList cars, String c){
		if(cars.contains(c)) {
			System.out.println("");
			System.out.println(c+" already returned");
		}
		else {
			try {
				TimeUnit.SECONDS.sleep(5);  //to give a time difference
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("");
			cars.add(c);
			System.out.println(c+" returned");
			
			LocalDateTime stopDate = LocalDateTime.now();
		    DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		    this.e = stopDate;
		    this.end = stopDate.format(format);
		    System.out.println("");
		    System.out.println("Date and Time of returning: " + this.end);
		    
		    //System.out.println(formattedDate.getClass().getName());
		}
		return cars;
	}
	
	
	LocalDateTime s;
	LocalDateTime e;
	
	
	String start ;
	String end ;
	
	public long calc() {
		
		
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");  

		Date d1 = null;
		Date d2 = null;
		try {
		    d1 = format.parse(this.start);
		    d2 = format.parse(this.end);
		} catch (ParseException e) {
		    e.printStackTrace();
		}    

		// Get msec from each, and subtract.
		long diff = d2.getTime() - d1.getTime();
		long diffSeconds = diff / 1000;         
		
		System.out.println("SYSTEM Time DIFF in seconds: " + diffSeconds + " seconds. "
				+ "\n (To show mathematical formula working 5 second delay is given, "
				+ "\n but for calculation of car hourly rent, pre-set dates are already entered: \"01-02-2021 09:29:58\", \"13-02-2021 11:29:58\" "
				+ "\n and user-defined dates can be given in the modified ret method, "
				+ "\n shown in the last section of program- in TEST CASES Section)");         

		
		
		//let us choose 2 dates of borrow and return
		
		String sta = "01-02-2021 09:29:58";
		String endd = "13-02-2021 11:29:58";
		Date d3 = null;
		Date d4 = null;
		try {
		    d3 = format.parse(sta);
		    d4 = format.parse(endd);
		} catch (ParseException e) {
		    e.printStackTrace();
		}    

		// Get msec from each, and subtract.
		long dif = d4.getTime() - d3.getTime();

		long difhr = dif / (60 * 60 * 1000); 

		//System.out.println("");
 
		//System.out.println("Time in hours: " + difhr + " hours."); 
		
		
		
		return difhr;
	}
	
	
	
	
	public long rent(ArrayList cars, String c, long hr) {
		long pay = 0;
		HashMap<String, Integer> map = new HashMap<>();
		  
   
        // hashmap for all cars to their hourly rent
		for(int i=0;i<cars.size();i++) {
			map.put((String) cars.get(i), 10*(i+1));    // car id numm * 10 = car rate
		}
		
		//base fare
		if (map.containsKey(c)) {
            Integer a = map.get(c);
            pay = a*hr;
        }
				
		return pay;
	}
	
	
	
	public double disc(String type, long fare) {
		
		double dis=0;
		if(type=="Regular") {
			if(fare<=4000) {
				dis=0;
			}
			else if(fare>4000 & fare<=8000) {
				dis=0.15;
			}
			else if(fare>8000 & fare<=12000) {
				dis=0.20;
			}
			else if(fare>12000) {
				dis=0.25;
			}
		}
		
		else if(type=="Premium") {
			if(fare<=5000) {
				dis=0;
			}
			else if(fare>5000 & fare<=10000) {
				dis=0.1;
			}
			else if(fare>10000) {
				dis=0.2;
			}
		}
		System.out.println("Discount given is:"+(dis*100)+"%");	
		
		return dis;
	}




	public long paym(long rent, double dis) {
		long pay = (long) (rent*(1-dis));
		return pay;
	}
	
	
	public long calc2(String s2, String e2) {
		
		
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");  

				
		String sta = s2;
		String endd = e2;
		Date d5 = null;
		Date d6 = null;
		try {
		    d5 = format.parse(sta);
		    d6 = format.parse(endd);
		} catch (ParseException e) {
		    e.printStackTrace();
		}
		
		// Get msec from each, and subtract.
				long dif3 = d6.getTime() - d5.getTime();
		         
				long difhr3 = dif3 / (60 * 60 * 1000);     
				//System.out.println("");
		 
				//System.out.println("Time in hours: " + difhr2 + " hours."); 
				return difhr3;
				
	}




	public double conv(HashMap<String, Double> cur, String ch, long pay) {
		double conv=pay;
		double rate=1;
		
		//Set<String> sett = cur.keySet();
		//for (String value : sett) {
			//if(value.substring(0,3) == ch) {
				//double cov = cur.get(value);
				//System.out.println("Conversion");
			//}
		//}
		List<Double> val = new ArrayList<Double>();
		for (Double v2 : cur.values())
            val.add(v2);

		
		if(ch=="EUR") {
			rate= rate*val.get(5);
			ch="USD";
			}
		if(ch=="USD") {
			rate= rate*val.get(3);
			ch="GBP";
		}
		if(ch=="GBP") {
			rate= rate*val.get(0);
			ch="AUD";
		}
		if(ch=="AUD") {
			rate= rate*val.get(1);
			ch="JPY";
		}
		if(ch=="GBP") {
			rate= rate*val.get(2);
			ch="JPY";
		}
		if(ch=="JPY") {
			rate= rate*val.get(4);
			ch="INR";
		}
		if(ch=="INR") {
			
			conv=pay*rate;
			
		}
		return conv;    
        
		
	}	
}
