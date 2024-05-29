package sclist;

import java.util.Random;
import java.util.Scanner;

public class TestSCList {
    public static void main(String[] args) {
        // Testing the singly linked circular list

        //create an empty list
        SCLinkedList<Integer> aList = new SCLinkedList<>();
        boolean quit = false;
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        int value = 0;

        while (!quit) {
            System.out.println("Current list is : " + aList.toString());
            menu();
            int choice = scan.nextInt();
            switch (choice) {
                case 1: // insertHead
                    value = rand.nextInt(100) + 1;
                    aList.insertAtHead(value);
                    System.out.println("Inserting " + value + " at head");
                    break;
                case 2: // insertTail
                    value = rand.nextInt(100) + 1;
                    aList.insertAtTail(value);
                    System.out.println("Inserting " + value + " at tail");
                    break;
                case 3: // removeHead
                    value = aList.removeAtHead();
                    System.out.println("Removed " + value + " from head");
                    break;
                case 4: // removeTail
                    value = aList.removeAtTail();
                    System.out.println("Removed " + value + " from tail");
                    break;
                case 5: // size
                    System.out.println("size is : " + aList.size());
                    break;
                case 6: // clear
                    aList.clear();
                    break;
                case 7: // find
                    break;
                case 0: quit = true; break;
                default: System.out.println("Invalid choice");
            }

        }
    }

    public static void menu() {
        System.out.println("1 for insertHead ");
        System.out.println("2 for insertTail ");
        System.out.println("3 for removeHead ");
        System.out.println("4 for removeTail ");
        System.out.println("5 for size ");
        System.out.println("6 for clear ");
        System.out.println("7 for find ");
        System.out.println("0 for quit ");
    }
}
