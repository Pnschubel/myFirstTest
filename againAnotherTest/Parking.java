import java.util.Stack;
/**
 * Last-In First-Out Parking System
 * 
 * @Payton Schubel
 * @09/07/18
 */
public class Parking
{
    //Stacks to represent the cars in the driveway/street
    Stack<Integer> driveway = new Stack<>();
    Stack<Integer> street = new Stack<>();
    
    /**
     * Removes car from driveway, putting cars into the street as necessary
     * @param   Stack<Integer> drive    cars in driveway
     *          Stack<Integer> road     cars in street
     *          int liscence            car you wanna remove
     * @return  Stack<Integers> cars in driveway
     */
    public Stack removeCar(Stack drive, Stack road){
        //Do this tomorrow
        return drive;
    }
    
    //Gets cars in and out of driveway
    public static void main (String[] args){
        //Welcome message
        System.out.println("Welcome to the Parking Program!");
        
    }
}
