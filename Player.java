import java.util.Scanner;

public class Player {

    private String name;
    private static Die die = new Die();

    private int numBiscuits; // SneakySteve's Code
    private int numSticks; // SneakySteve's Code
    public int myLastPosition; // SneakySteve's Code
    public int myNewPosition; // SneakySteve's Code

    //Initialize the fields
    public Player(String name){
        this.name = name;
    }

    // ### SneakySteve's Code ###
    /**
     * Gives the player a biscuit
     */
    public void addBiscuit() {
        this.numBiscuits ++;
        System.out.println(name + " got a biscuit");
    }

    /**
     * Consumes 1 biscuit from the player
     */
    public void consumeBiscuit() {
        this.numBiscuits --;
    }

    /**
     *
     * @return The number of biscuits the player has
     */
    public int getNumBiscuits() {
        return this.numBiscuits;
    }

    /**
     * Gives the player a big stick
     */
    public void addStick() {
        this.numSticks ++;
        System.out.println(name + " found a big stick");
    }

    /**
     * Consumes 1 big stick from the player
     */
    public void consumeStick() {
        this.numSticks --;
    }

    /**
     *
     * @return The number of big sticks the player has
     */
    public int getNumSticks() {
        return this.numSticks;
    }

    /**
     *
     * @return The name of the player
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the previous position of the player
     * @param pos the previous player position
     */
    public void setLastPosition(int pos) {
        this.myLastPosition = pos;
    }

    /**
     * Sets the new position of the player
     * @param pos the new player position
     */
    public void setNewPosition(int pos) {
        this.myNewPosition = pos;
    }

    /**
     *
     * @return The previous position of the player
     */
    public int getLastPosition() {
        return this.myLastPosition;
    }

    /**
     *
     * @return The new position of the player
     */
    public int getNewPosition() {
        return this.myNewPosition;
    }

    /**
     * This method prints the results of a player's turn to the board
     * @param roll What the player rolled
     */
    public void outputResultOfTurn(int roll) {
        System.out.println(name + " rolled " + roll + ". " + name + " moved from [" + getLastPosition() + "]" + " to " + "[" + getNewPosition() + "]");
    }
    // ### END ###

    /**
     * This method plays out the player's turn.
     * @return The number of spaces to move on the board.
     */
    public int takeTurn(){

        //Initialize scanner
        Scanner scan = new Scanner(System.in);
        //Prompt user for roll
        System.out.print(name+"'s turn: ");
        String input = scan.nextLine();

        //Translate the input to some numeric value between 1 and 9
        int val = 0;
        for (int idx = 0; idx < input.length(); idx++){
            val+= input.charAt(idx);
        }
        val = val % 10;
        if (val == 0){
            val = 1;
        }

        //Throw away the next 'val' random values
        for (int idx = 0; idx < val; idx++){
            die.rollD6();
        }

        //Get the roll
        int roll = 0;

        roll = die.rollD6();

        // ### Removed by SneakySteve. Replaced by method 'outputResultOfTurn' ###
        //System.out.println(name + " rolled " + roll + ". " + name + " moved from [" + getLastPosition() + "]" + " to " + "[" + getNewPosition() + "]");

        return roll;
    }


    public String toString(){
        return name.substring(0, 2).toUpperCase(); // SneakySteve's code
        // return name; <- Removed by SneakySteve
    }
}