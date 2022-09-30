import java.util.Scanner;

public class RPSLO {

    // Rock = 0, Paper = 1, Scissors = 2, Lizzard = 3, Spock = 4
    // Scissors cut Paper
    // Paper covers Rock
    // Rock crushes Lizard
    // Lizard poisons Spock
    // Spock smashes Scissors
    // Scissors decapitate Lizard
    // Lizard eats Paper
    // Paper disproves Spock
    // Spock vaporizes Rock
    // Rock crushes Scissors

    // S > P
    // P > R
    // R > L
    // L > O
    // O > S
    // S > L
    // L > P
    // P > O
    // O > R
    // R > S

    public static void main(String[] args) {
        System.out.println("Enter your play: R, P, S, L, O");
        Scanner scanner = new Scanner(System.in);
        // Write your code below
        // Write your code above

        String playerInput = scanner.nextLine();
        char playerTurnChar = playerInput.charAt(0);
        int playerTurnInt = -1;

        // :/
        if (playerTurnChar == 'R' || playerTurnChar == 'r')
            playerTurnInt = 0;
        else if (playerTurnChar == 'P' || playerTurnChar == 'p')
            playerTurnInt = 1;
        else if (playerTurnChar == 'S' || playerTurnChar == 's')
            playerTurnInt = 2;
        else if (playerTurnChar == 'L' || playerTurnChar == 'l')
            playerTurnInt = 3;
        else if (playerTurnChar == 'O' || playerTurnChar == 'o')
            playerTurnInt = 4;
        else {
            System.out.println("Invalid input (valid inputs: R, P, S, L, O)");
            scanner.close();
            return;
        }

        int computersTurn = (int) Math.floor(Math.random() * 5);
        char computersTurnChar = 'I'; // temp I

        if (computersTurn == 0)
            computersTurnChar = 'R';
        else if (computersTurn == 1)
            computersTurnChar = 'P';
        else if (computersTurn == 2)
            computersTurnChar = 'S';
        else if (computersTurn == 3)
            computersTurnChar = 'L';
        else if (computersTurn == 4)
            computersTurnChar = 'O';
        System.out.println("Computer play is " + computersTurnChar);

        // Pain isn't real
        // Pain ->

        if (computersTurn == 2 && playerTurnInt == 1) {
            gameOver();
        } else if (computersTurn == 1 && playerTurnInt == 0) {
            gameOver();
        } else if (computersTurn == 0 && playerTurnInt == 3) {
            gameOver();
        } else if (computersTurn == 3 && playerTurnInt == 4) {
            gameOver();
        } else if (computersTurn == 4 && playerTurnInt == 2) {
            gameOver();
        } else if (computersTurn == 2 && playerTurnInt == 3) {
            gameOver();
        } else if (computersTurn == 3 && playerTurnInt == 1) {
            gameOver();
        } else if (computersTurn == 1 && playerTurnInt == 4) {
            gameOver();
        } else if (computersTurn == 4 && playerTurnInt == 0) {
            gameOver();
        } else if (computersTurn == 0 && playerTurnInt == 2) {
            gameOver();
        }
        // And it continues
        else if (computersTurn == 1 && playerTurnInt == 2) {
            win();
        } else if (computersTurn == 0 && playerTurnInt == 1) {
            win();
        } else if (computersTurn == 3 && playerTurnInt == 0) {
            win();
        } else if (computersTurn == 4 && playerTurnInt == 3) {
            win();
        } else if (computersTurn == 2 && playerTurnInt == 4) {
            win();
        } else if (computersTurn == 3 && playerTurnInt == 2) {
            win();
        } else if (computersTurn == 1 && playerTurnInt == 3) {
            win();
        } else if (computersTurn == 4 && playerTurnInt == 1) {
            win();
        } else if (computersTurn == 0 && playerTurnInt == 4) {
            win();
        } else if (computersTurn == 2 && playerTurnInt == 0) {
            win();
        } else {
            tie();
        }

        scanner.close();
    }

    public static void gameOver() {
        System.out.println("Computer wins!");
    }

    public static void win() {
        System.out.println("You win!");
    }

    public static void tie() {
        System.out.println("It is a tie!");
    }
}