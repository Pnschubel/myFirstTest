import java.util.Stack;
import java.util.Scanner;
/**
 * Last-In First-Out Parking System
 * 
 * @Payton Schubel
 * @09/07/18
 */
public class Parking
{
    /**
     * Removes car from driveway, putting cars into the street as necessary
     * @param   Stack<Integer> drive    cars in driveway
     *          Stack<Integer> road     cars in street
     *          String liscence            car you wanna remove
     * @return  Stack<Integers> cars in driveway
     */
    private static Stack removeCar(Stack<Integer> drive, Stack<Integer> road, int liscense){
        int temp;
        if(!drive.contains(liscense)){
            //Informs user that the car isn't in the drive
            System.out.println("\n!ERROR: Car " + liscense + " not present in driveway.");
        
        }else{
            //Temporarily stores the car from the drive
            temp = drive.pop();
            while (temp != liscense){
                //If not the car we're looking for, put in street
                road.push(temp);
                System.out.println("\nMOVING CARS. \tDriveway: " + drive + "\tStreet: " + road);
                temp = drive.pop();
            }
            //Move all cars in street back to 
            while (road.size() != 0){
                drive.push(road.pop());
                System.out.println("\nREPLACING CARS:\tDriveway: " + drive + "\tStreet: " + road);
            }
        }
        return drive;
    }
    
    //Gets cars in and out of driveway
    public static void main (String[] args){
        //Stacks to represent the cars in the driveway/street
        Stack<Integer> driveway = new Stack<>();
        Stack<Integer> street = new Stack<>();
        //To get user input
        Scanner keyboard = new Scanner(System.in);
        int choice = 1; //How the user will choose what do do.
        
        //Welcome message
        System.out.println("Welcome to the Parking Program!");
        
        while (choice != 0){
            //Menu so user knows their options:
            System.out.println("\nPositive Liscense: Add car to drive.\nNegative Liscense: Remove car from drive.");
            System.out.println("Zero: Quit");
            System.out.print("\nEnter Car's Plates: ");
            choice = keyboard.nextInt();
            
            //If positive liscense, adds the car to the drive.
            if (choice > 0){
                System.out.println("Adding car to drive...");
                driveway.push(choice);
            }
            //If negative liscense, removes car from drive.
            if (choice < 0){
                //Makes choice positive
                choice *= -1;
                System.out.println("Removing car from drive...");
                removeCar(driveway, street, choice);
            }
            
            //Prints the drive and the street so people can see it.
            System.out.println("\nDriveway: " + driveway + "\nStreet: " + street);
        }
    }
}
