package anagram;

import sclist.ListNode;
import sclist.SCLinkedList;
import java.util.ArrayList;

public class AnagramPuzzle {
    private SCLinkedList<Character> puzzle;
    private java.util.LinkedList<Character> solution;

    /* Constructs an anagram puzzle.
       @param answ is the solution to the puzzle
       @param init is the initial scrambled letter sequence
     */
    public AnagramPuzzle(String answ, String init) {
        solution = new java.util.LinkedList<Character>();
        for (int i = 0; i < answ.length(); i++)
            solution.add(answ.charAt(i));
        puzzle = new SCLinkedList<Character>();
        for (int i = 0; i < init.length(); i++)
            puzzle.insertAtTail(init.charAt(i));
    }

    // Shifts the letters left one position, the leftmost letter is moved
    // to the right end of the puzzle.
    public void shiftLeft() {
        //TODO:  Implement this method
        puzzle.insertAtTail(puzzle.removeAtHead());
    }

    // Swaps the letters at the left and right ends of the puzzle.
    public void swapEnds() {
        //TODO:  Implement this method
        Character front = puzzle.removeAtTail();
        Character end = puzzle.removeAtHead();
        puzzle.insertAtTail(end);
        puzzle.insertAtHead(front);
    }

    // Displays an anagram puzzle.
    public void display() {
        System.out.println("Current puzzle is  :  " + puzzle.toString());
    }

    // Returns true if a puzzle is solved, otherwise returns false.
    public boolean isSolved() {
        // remove , from Java toString
        String temp = solution.toString();
        temp = temp.replace(",", "");
        // add space before closing ] in Java toString
        temp = temp.substring(0, temp.length()-1) + " ]";

        return temp.equals(puzzle.toString());
    }
}
