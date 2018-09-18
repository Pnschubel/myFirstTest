import java.util.Stack;

/**
 * Grid Class to be filled with pairs for floodfill program
 * 
 * @author Payton Schubel
 * @version 9/13/2018
 */
public class Grid
{
   private static final int SIZE = 10;
   int[][] grid = new int[SIZE][SIZE];
   int fill = 1; //what the squares are filled with, starts with one
   Stack<Pair> squares= new Stack<>(); //Stack to be filled with coordinates on grid
   
   /**
    * Constructor: Fills squares of grid and creates intial variables
    */
   public Grid(){
       this.fill = 1; //What squares are filled with; starts w/ one
       squares = new Stack<>();//Stack to be filled with unfilled coordinates on grid
       
       //Fills grid with zeroes
       for (int i = 0; i < SIZE; i++){
           for (int j = 0; j < SIZE; j++){
               grid[i][j] = 0;
            }
        }
    }
   
   /**
    * Fills a single square on the grid, adds neighbouring coordinates to stack
    * @param Pair the coordinates to be filled.
    * @return none
   */
   private void fillSquare(Pair coordinates)
   {  
      //Sees if the coordinate pair is filled by seeing if that location on the grid is 0 or not.
      if (grid[coordinates.getRow()][coordinates.getColumn()] == 0){
          //if the grid is unfilled at that location, fill it.
          grid[coordinates.getRow()][coordinates.getColumn()] = this.fill;
          this.fill += 1; //adds one to the fill number
        }
      
      /**ADDS ALL UNFILLED SIDE COORDINATES TO STACK**/
      
      //Adds the pair in the northern direction
      if(coordinates.getRow() > 0){//0 is the northmost coordinate, can't go further
          //Makes sure the pair isn't filled yet
          if (grid[coordinates.getRow() - 1][coordinates.getColumn()] == 0){
            //fills the square
            grid[coordinates.getRow()-1][coordinates.getColumn()] = this.fill;
            //updates fill
            this.fill += 1;
            this.squares.push(coordinates.sidePair('n'));//gets coodrinates of northern sidePair
        }
        }
      
      //Adds the eastword direction, makes sure coordinate exists
      if(coordinates.getColumn() < (SIZE-1)){//SIZE-1 is the eastmost coordinate, can't go further
          //Makes sure the pair isn't filled yet
          if (grid[coordinates.getRow()][coordinates.getColumn() + 1] == 0){
            //fills the square
            grid[coordinates.getRow()][coordinates.getColumn()+1] = this.fill;
            //updates fill
            this.fill += 1;
            this.squares.push(coordinates.sidePair('e'));
        }
        }//gets coordinates of eastern sidePair
        
      
      //Adds the pair in the southward direction, lowest of which is at 9
      if(coordinates.getRow() < (SIZE-1)){//SIZE - 1 is the southmost coordinate, can't go further
          //Makes sure the pair isn't filled yet
          if (grid[coordinates.getRow() + 1][coordinates.getColumn()] == 0){
            //fills the square
            grid[coordinates.getRow()+1][coordinates.getColumn()] = this.fill;
            //updates fill
            this.fill += 1;
            this.squares.push(coordinates.sidePair('s'));//gets coodrinates of southern sidePair
        }
        }
        
      //Adds the pair in the western direction, 
      if(coordinates.getColumn() > 0){//0 is the westmost coordinate, can't go further
          //Makes sure the pair isn't filled yet
          if (grid[coordinates.getRow()][coordinates.getColumn() - 1] == 0){
            //fills the square
            grid[coordinates.getRow()][coordinates.getColumn()-1] = this.fill;
            //updates fill
            this.fill += 1;
            this.squares.push(coordinates.sidePair('w'));//gets coodrinates of western sidePair
        }
        }
        
   }
   
   /**
    * Fills the entire grid, given starting coordinates.
    * @param int row -- row of starting coordinates
    * @param int column -- column of starting coordinates
    * @return none
    */
   public void fillGrid(int row, int column){
       //Creates a starting pair
       Pair start = new Pair(row, column);
       //Adds starting pair onto the stack.
       this.squares.push(start);
       
       //If grid isn't full, squares will have values in it.
       //So when square is empty, done with loop.
       while (this.squares.size() > 0){
           this.fillSquare(this.squares.pop());
        }
    }

   /**
    * Prints the grid in a readable manner
    * @return string -- the printable string
    */
   @Override
   public String toString()
   {
      String r = "";
      for (int i = 0; i < SIZE; i++)
      {
         for (int j = 0; j < SIZE; j++)
            r = r + String.format("%4d", grid[i][j]);
         r = r + "\n";
      }
      return r;
   }
}
