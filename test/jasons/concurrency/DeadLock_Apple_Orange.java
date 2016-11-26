package jasons.concurrency;

public class DeadLock_Apple_Orange {  
	  public static void main(String[] args) {  
	    final String apple = "Apple";  
	    final String orange = "Orange";  
	    // t1 tries to lock resource1 then resource2  
	    Thread jasons = new Thread() {  
	      public void run() {  
	         synchronized (apple) {  
	           System.out.println("Jason: I got apple");  
	         }
	         System.out.println("Jason: I give you apple"); 
	         
	           try { Thread.sleep(100);} catch (Exception e) {}  
	           //System.out.println("Jason: Give me orange first, then i will give you apple");
	           
	           synchronized (orange) {  
	            System.out.println("Jason: I got orange :)");  
	           }  
	         //}  
	         // System.out.println("Jason: I give you apple");  
	      }  
	    };  
	  
	    // t2 tries to lock resource2 then resource1  
	    Thread maggie = new Thread() {  
	      public void run() {  
	        synchronized (orange) {  
	          System.out.println("Maggie: I got orange");  
	  
	          try { Thread.sleep(100);} catch (Exception e) {}  
	          System.out.println("Maggie: Give me apple first, then i will give you orange");
	  
	          synchronized (apple) {  
	            System.out.println("Maggie: I got apple :)");  
	          }  
	        }
	        
	        System.out.println("Maggie: I give you orange");  
	      }  
	    };  
	    
	    // ====================================
	    System.out.println("There is a room, which has two thing: Apple and Orange");
	    jasons.start();  
	    maggie.start();  
	  }  
	}


// Greedy: Both of them want to have the apple and orange at the same time (synchronize)
// but the reality is that: there is one apple and one orange. So this is impossible unless there are two apples and two oranges
// 