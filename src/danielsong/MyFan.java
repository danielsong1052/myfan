package danielsong;

import java.lang.NumberFormatException;
import java.util.Scanner;

public class MyFan {

	 public static void main(String[] args) throws Exception
	  {
	    Scanner sc = new Scanner(System.in);

	    while(true) 
	    {
	      System.out.println("#####################");
	      System.out.println("#        Fan        #");
	      System.out.println("#####################");
	    
	      System.out.println("=== Select speed ===");
	      System.out.println("1. Speed-1  2. Speed-2  3. Turn off the fan");
	      System.out.print("Put speed: ");

	      try {
	                    
	        String sNum = sc.next();          
	        
	        if(!MyFan.isNotNumeric(sNum)) {
	          System.out.println("");
	          System.out.println("*** Speed Error: Just put the Number.");
	          System.out.println("");
	          continue;   
	        }

	        int speed = Integer.parseInt(sNum);        

	        if ((speed%3) == 0) {
	          break;
	        } else {
	          speed = speed%3;
	        } 

	        while(true) {
	          System.out.println("=== Select direction ===");
	          System.out.println("1. right  2. left  3. Put any button to return");
	          System.out.print("Put direction: ");   
	          
	          String dNum = sc.next();              
	          
	          if(Integer.parseInt(dNum) > 2 || !MyFan.isNotNumeric(dNum)) {
	            System.out.println("");
	            System.out.println("*** Direction Error: Just put the Number, 1 or 2.");
	            System.out.println("");
	            break;   
	          }        
	  
	          int direction = Integer.parseInt(dNum);
	                   
	          MyFan.runningFan(speed, direction); 
	          
	        }

	      } catch (NumberFormatException ne) {        
	      } catch (Exception e) {
	        System.out.println(e);
	      }      
	    }    
	    System.out.println("Bye ~~");
	  }  
	  
	  public static void runningFan(int speed, int direction) { 
		 Scanner sc = new Scanner(System.in);		 
		 String continueValue;
		 int x = 0;
		  
	    if(direction == 1) {
	      System.out.println("Direction - right"); 	      	
	      
	      while(x < 10) {	    	  
	    	if( x == 9) {
              System.out.println("=>>>))"); 
              System.out.println("");
              
              System.out.print("Want to stop the Fan, put 'N'. If not, put any button : ");
    	      continueValue = sc.next();      	      
    	      if(continueValue.equals("N") || continueValue.equals("n")) {
    	    	  x = 11;    	    	  
    	      } else {    	    	  
    	    	  x = 0;
    	      }
    	      
            } else {
            	
            	if(x == 11) { break;}
            	
            	System.out.print("=>>>)) ");
              
            	++x;        
  	        
  	        	try {            
	  	            Thread.sleep((speed * 1000) / (speed * speed));
	  	        }
	  	        catch (Exception e) {
	  	            System.out.println(e);
	  	        }
            }	         	        
	      } 
	      
	    } else {
	    	System.out.println("Direction - left");
	    	while(x < 10) {	    	  
		    	if( x == 9) {
		    	  System.out.println("((<<<= ");
	              System.out.println("");
	              
	              System.out.print("Want to stop the Fan, put 'N'. If not, put any button : ");
	    	      continueValue = sc.next();      	      
	    	      if(continueValue.equals("N") || continueValue.equals("n")) {
	    	    	  x = 11;    	    	  
	    	      } else {    	    	  
	    	    	  x = 0;
	    	      }
	    	      
	            } else {
	            	
	            	if(x == 11) { break;}
	            	
	            	System.out.print("((<<<= ");
	              
	            	++x;        
	  	        
	  	        	try {            
		  	            Thread.sleep((speed * 1000) / (speed * speed));
		  	        }
		  	        catch (Exception e) {
		  	            System.out.println(e);
		  	        }
	            }	         	        
		    }       
	      
	    }     
	  }

	  public static boolean isNotNumeric(String s){
	    return s.replaceAll("[+-]?\\d+","").equals("") ? true : false;  
	  }  


}
