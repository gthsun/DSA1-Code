import anagram.AnagramPuzzle;
import java.util.Scanner;
public class Driver {
    public static void main(String[] args) {
        AnagramPuzzle mysteryWord = new AnagramPuzzle("right", "irtgh");
        String move;
        boolean userQuit = false;
        Scanner scan = new Scanner(System.in);

        // Display initial puzzle
        mysteryWord.display();
        System.out.println("Moves are: \n" + "\tL for shift left\n"+"\tS for swap ends\n"+"\tQ for quit");
        // Loop until puzzle is solved or user quits
        while (!mysteryWord.isSolved() && !userQuit ) {
            System.out.print("Enter move (L/S/Q):  ");  // get user move
            move = scan.next();
            switch (move) {
                case "L": case "l" : mysteryWord.shiftLeft(); break;
                case "S": case "s" : mysteryWord.swapEnds(); break;
                case "Q": case "q" : userQuit = true; break;
                default: System.out.println("Invalid move");
            }
            mysteryWord.display();
        }
        if (mysteryWord.isSolved())
            System.out.println("Congratulations");

    }
}
