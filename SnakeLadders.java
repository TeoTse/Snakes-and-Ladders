import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SnakeLadders {

    public static void main(String[] args){
        //Print welcome message.
		System.out.println("------------------------------------------------------------");
		System.out.println("---------------| Welcome to Snakes&Ladders |----------------");
		System.out.println("------------------------------------------------------------");
		System.out.println("------------------------------| Created by Hamza Shakure |--");
		System.out.println("------------------------------------------------------------");
		System.out.println("------------------------------------------------------------");

        //Initialize scanner.
        Scanner scan = new Scanner (System.in);

        //Prompt for number of players.
        int numPlayers = 0;
        while (numPlayers <= 0 || numPlayers >3 ){
			System.out.println("------------------------------------------------------------");
			System.out.println("----------| Please state the number of players |------------");
			System.out.println("          |       Must be between 1 - 3 :      |            ");
            numPlayers = scan.nextInt();
        }

        // ### SneakySteve's Code ###
        scan.nextLine(); // Clear the scanner
        ArrayList<Player> players = new ArrayList<Player>(); // Define a new arraylist of players

        // For each player
        for (int i = 0; i < numPlayers; i++) {
            System.out.println("Please enter a name for player " + (i+1) + ":"); // Ask for a player name
            String name = scan.nextLine(); // set the player name
            Player player = new Player(name); // create the player
            players.add(player); // add the player to the list
        }

        //Initialize the board.
        Board board = new Board(players);

        //Loop until a player reaches the final spot.
        //Players take turns to roll the die and move on the board
        boolean done = false;
        int playerIdx = 0;
        while (!done){
            //Player takes turn
            Player currPlayer = players.get(playerIdx);
            int roll = currPlayer.takeTurn();

            //Update the board
            done = board.movePlayer(currPlayer, roll);

            // Print the result of the player's turn to the screen
            currPlayer.outputResultOfTurn(roll); // SneakySteve's Code

            //Print the board
            System.out.println(board);
            System.out.println("-----------------------\n");

            //If we're done, print end message.
            if (done){
                System.out.println(currPlayer + " wins");
            }

            //Set up for next player
            playerIdx++;
            if (playerIdx == numPlayers){
                playerIdx = 0;
            }

        }
    }
}