package pwc;


import java.util.*;

//5 second intentional delay in ret method to show time calc

public class Cars{

	public static void main(String[] args) {
		
		users p2 = new users();
		
		ArrayList<List> li = new ArrayList<List>();
		
		
		System.out.println("PART 1");
		//Part 1
		String email = "abc@gmail.com";
		String type = "Premium";
		li.add(p2.create("e",email,type));
		li.add(p2.create("m","1234567890",type));
		li.add(p2.create("e","xyz@gmail.com",type));
		System.out.println("CREATED"+li);
		//System.out.print(); how to access final create list in user.java
		
		li=p2.update(li,"abc@gmail.com","Regular");
		System.out.println("UPDATING"+li);
		
		li=p2.delete(li,"xyz@gmail.com","Regular");
		System.out.println("DELETING"+li);//inactive
		
		System.out.println("Stored Lists:"+p2.display(li));
		
		
		System.out.println("");
		System.out.println("");
		System.out.println("PART 2");
		
		
		//Part 2
		//Cars owned by the company
		ArrayList<String> cars = new ArrayList<String>();
		cars.add("Mercedes");
	    cars.add("BMW");
	    cars.add("Audi");
	    cars.add("Range Rover");
	    
	    
	    
	    inventory p3 = new inventory();
	    p3.display(cars);
	    System.out.println("");
	    cars = p3.borrow(cars,"Audi"); 
	    p3.display(cars);
	    cars = p3.borrow(cars,"Lamborghini");
	    p3.display(cars);
	    System.out.println("");
	    cars = p3.add(cars,"Lamborghini");
	    p3.display(cars);
	    cars = p3.add(cars,"BMW");
	    p3.display(cars);
	    System.out.println("");
	    System.out.println("");
	    System.out.println("An Intentional 5 Second Delay is Introduced");
	    System.out.println("");
	    cars = p3.ret(cars,"Audi"); //5 second delay given here intentionally to show working of calc method
	    p3.display(cars);
	    
	    // Part 3
	    System.out.println("");
		System.out.println("");
		System.out.println("PART 3");
		
		
		
	    long hours = p3.calc();
	    System.out.println("");
	    System.out.println("Car rented for "+hours+" hours");
	    
	    //let user choose Audi
	    long rent = p3.rent(cars,"Audi",hours);
	    System.out.println("");
	    System.out.println("Rent to be paid: "+rent);
	    
	    
	    
	    // Part 4
	    System.out.println("");
		System.out.println("");
		System.out.println("PART 4");
		System.out.println("");
	    // let person be Regular, then disc:
	    double dis = p3.disc("Regular",rent);
	    
	    
	    
	    // Part 5
	    System.out.println("");
		System.out.println("");
		System.out.println("PART 5");
		System.out.println("");
	    // let person be Regular, then disc:
	    long pay = p3.paym(rent,dis);
	    
	    System.out.println("Currency Conversion section (Final Bill to be in INR):");
	    System.out.println("You can change currency rates in this section, stored values:\n"
	    		+ "EUR/USD => 1.2\r\n"
	    		+ "USD/GBP => 0.75\r\n"
	    		+ "GBP/AUD => 1.7\r\n"
	    		+ "AUD/JPY => 90\r\n"
	    		+ "GBP/JPY => 150\r\n"
	    		+ "JPY/INR => 0.6");
	    
	    //curr conv chart
	    HashMap<String, Double> cur = new HashMap<>();
	    cur.put("EUR/USD", (double) 1.2);
	    cur.put("USD/GBP", (double) 0.75);
	    cur.put("GBP/AUD", (double) 1.7);
	    cur.put("AUD/JPY", (double) 90);
	    cur.put("GBP/JPY", (double) 150);
	    cur.put("JPY/INR", (double) 0.6);
    
	  //let currency chosen be: USD
	    String ch = "USD";
	    double curp = p3.conv(cur,ch,pay);
	    System.out.println("Pre-conversion Bill: "+ch+" "+pay);
	    System.out.println("Final Bill in Rs: "+(int) curp);
	    
	    
	    //
	    
	    //
	    
	    //
	    
	    //TEST CASES TESTING
	    System.out.println("");
	    System.out.println("");
	    System.out.println("PART : EXPERIMENTAL TEST CASES for validation");
	    System.out.println("Some Test Cases:");
	    // Checking with other combinations of cars, reg/prem, dates
	    System.out.println("For other combiations: Regular,BMW ; Premium,Mercedes");
	    long rent2 = p3.rent(cars,"BMW",400);//giving hours rented as 40 hrs
	    System.out.println("");
	    System.out.println("Rent to be paid: "+rent2);
	    double dis2 = p3.disc("Regular",rent2);//Regular
	    long pay2 = p3.paym(rent2,dis2);
	    System.out.println("Final Bill: Rs "+pay2);
	    
	    long rent3 = p3.rent(cars,"Mercedes",300);//giving gours rented as 20 hrs
	    System.out.println("");
	    System.out.println("Rent to be paid: "+rent3);
	    double dis3 = p3.disc("Premium",rent3);//Premium
	    long pay3 = p3.paym(rent3,dis3);
	    System.out.println("Final Bill: Rs "+pay3);
	    

	    
	    System.out.println("");
	    System.out.println("");
	    String ch2 = "AUD";
	    System.out.println("Let currency be AUD, bill is 2000");
	    double curp2 = p3.conv(cur,ch2,2000);
	    System.out.println("Pre-conversion Bill:"+ch2+" 2000");
	    System.out.println("Final Bill in Rs: "+(int) curp2);
	    
	    System.out.println("");
	    String ch3 = "EUR";
	    System.out.println("Let currency be EUR, bill is 15421");
	    double curp3 = p3.conv(cur,ch3,15421);
	    System.out.println("Pre-conversion Bill:"+ch3+" 15421");
	    System.out.println("Final Bill in Rs: "+(int) curp3);
	    
	    
	    
	    
	    System.out.println("");
	    System.out.println("Dates changed to: \"02-01-2021 08:29:58\",\"03-01-2021 19:29:58\"");
	    
	    //modified calc method that takes start and end dates as inputs
	    long hours2 = p3.calc2("02-01-2021 08:29:58","03-01-2021 19:29:58"); 
	    System.out.println("Car rented for "+hours2+" hours");
	    System.out.println("");
	    System.out.println("End of TEST CASES and Program");
	    
	    
	}

}
