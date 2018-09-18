import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
/**
   Class for simulating a runway.
*/
public class RunwaySimulator
{
   //instance variables
   Queue<String> takeOff; //queue of planes waiting to take off
   Queue<String> landing; //queue of planes waiting to land
    
   /**
      Constructor.
   */
   public RunwaySimulator()
   {
      //Creates takeOff and landing queues
      takeOff = new LinkedList<>();
      landing = new LinkedList<>();
   }

   /**
      Add a flight symbol to the taking off queue.
      @param flightSymbol the flight symbol.
   */
   public void addTakeOff(String flightSymbol)
   {
       //Adds the new plane to the queue of planes needing to take off
       this.takeOff.add(flightSymbol);
   }

   /**
      Add a flight symbol to the landing queue.
      @param flightSymbol the flight symbol.
   */
   public void addLanding(String flightSymbol)
   {
       //Adds the new plane to the queu of planes needing to land
       landing.add(flightSymbol);
   }

   /**
      If plane needs to land, lands plane. Else, lets plane take off.
   */
   public void handleNextAction()
   {
       //Sees if a plane needs to land. If so, lands plane.
       if (landing.size() != 0){
           System.out.println("\nFlight " + landing.remove() + " is landing now.");
        }else{
            //Sees if plane needs to take off. If so, lets plane take off.
            if (takeOff.size() != 0){
                System.out.println("\nFlight " + takeOff.remove() + " is taking off now.");
            }else{
                //If this runs, nothing is due to happen. Tells user so.
                System.out.println("\nNo flights in need of runway.");
            }
        }
   }
}
