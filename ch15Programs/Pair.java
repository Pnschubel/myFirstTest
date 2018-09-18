
/**
 * Pair class to act as 'locations' to 'fill' with floodfill program
 * 
 * @author Payton Schubel
 * @version 9-12-2018
 */
public class Pair
{
    //instance Values
    private int[] coordinates = new int[2]; //the row/column pair of the Pair

    /**
     * Constructor for objects of class Pair
     * @param int row -- the row number of the Pair
     * @param int column -- the column number of the Pair
     * The fill number is originally set to zero, standing for 'unfilled'
     */
    public Pair(int row, int column)
    {
        //Initializing Variables
        this.coordinates[0] = row;
        this.coordinates[1] = column;
    }
    
    /**
     * Returns the Pair of coordinates for the location N, S, E, W (depending) of this pair.
     * @precondition in the direction called, the coordinate exists.
     * 
     * @param char -- the direction (will be 'n'/'N', 'e'/'E', 's'/'S', or 'w'/'W')
     * @return Pair -- the coordinate pair of on that side of this current pair
     */
    public Pair sidePair(char location){
        Pair newPair; //the pair to hold the new coordinates
        int row = this.coordinates[0];
        int column = this.coordinates[1]; //temp values to hold the coordinate locations
        
        //Creates the new pair for the proper location
        if (location == 'n' || location == 'N'){
            //creates a pair 'above' this one
            newPair = new Pair(row - 1, column);
        }else{
            if (location == 'e' || location == 'E'){
                //creates a pair 'to the right' of this one
                newPair = new Pair (row, column + 1);
            }else{
                if (location == 's' || location == 'S'){
                    //creates a pair 'below' this one
                    newPair = new Pair(row + 1, column);
                }else{
                    //At this point, we know that the char is w/W (or a typo, but should be w/W), so west
                    //creates a pair 'to the left' of this one
                    newPair = new Pair(row, column - 1);
                }
            }
        }
        
        return newPair;
    }
    
    /**
     * Returns the row number of the Pair class.
     * @param none
     * @return int the row number
     */
    public int getRow(){
        return this.coordinates[0];
    }
    
    /**
     * Returns the column number of the Pair class.
     * @param none
     * @return int the column number
     */
    public int getColumn(){
        return this.coordinates[1];
    }
    
    /**
     * Returns the row and column of the Pair class.
     * @param none
     * @return int[2] row, column pair
     */
    public int[] getCoordinates(){
        return this.coordinates;
    }
}
