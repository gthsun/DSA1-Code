//Name: Geethan Sundaram
//Computing ID: mhy9qc@virginia.edu
//Homework Name: JavaIntro
//Resources used: None

import java.util.Random;
import java.util.Scanner;

public class JavaIntro {

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);

        System.out.println("What is your high bound? ");
        int bound = scan.nextInt();
        System.out.println("What is the target? ");
        int target = scan.nextInt();
        System.out.println("It took " +hilo(bound, target)+ " tries to find the target");

        System.out.println("Choose: rock, paper, scissor, lizard, spock: ");
        String user = scan.nextLine();
        user = scan.nextLine();
        System.out.println("User: " +user);
        String[] choices = {"rock", "spock", "paper", "lizard", "scissors"};
        Random r = new Random();
        String comp = choices[r.nextInt(choices.length)];
        System.out.println("Computer: " +comp);
        int result = rpsls(user, comp);
        if(result == 1){System.out.println("You win!");}
        else if(result == 0){System.out.println("You lose!");}
        else if(result == -1){System.out.println("It was a tie!");}

        System.out.println("Enter number one: ");
        int one = scan.nextInt();
        System.out.println("Enter number two: ");
        int two = scan.nextInt();
        System.out.println("What number will they be dividing? ");
        int input = scan.nextInt();
        System.out.println("Results: " +fuzzbizz(one, two ,input));

        System.out.println("Enter an array length: ");
        int length = scan.nextInt();
        int[] nums = new int[length];
        for(int i = 0; i < length; i++) {
            System.out.println("Add a term for index " +i+ ": ");
            nums[i] = scan.nextInt();
        }
        System.out.println("Number of runs: " +countRuns(nums));

    }

    public static int hilo(int max, int target) {
        Random rand = new Random();
        int low = 1, high = max, guess = rand.nextInt(high -low + 1) + low, cnt = 1;
        //System.out.println("Origin: " +low+ ", Bound: " +high);
        while (guess != target) {
            if (guess > target) {
                high = guess - 1;
            }
            if (guess < target) {
                low = guess + 1;
            }
            //System.out.println("Origin: " +low+ ", Bound: " +high);
            guess = rand.nextInt(high - low + 1) + low;
            cnt++;
        }
        //System.out.println(guess);
        return cnt;
    }

    public static int rpsls(String userChoice, String computerChoice) {
        /*
        String[] arr = {"rock", "spock", "paper", "lizard", "scissors"};
        ArrayList<String> choices = new ArrayList<String>();
        for(String ch: arr){choices.add(ch);
        int user = choices.indexOf(userChoice), comp = choices.indexOf(computerChoice);
        if(user == comp){return -1;}
        int lose1 = user+1, lose2 = user+2;
        if(lose1)*/
        userChoice = userChoice.toLowerCase();
        computerChoice = computerChoice.toLowerCase();
        if (userChoice.equals(computerChoice)) {
            return -1;
        }

        if (userChoice.equals("rock")) {
            if (computerChoice.equals("lizard") || computerChoice.equals("scissors")) {
                return 1;
            } else {
                return 0;
            }
        } else if (userChoice.equals("paper")) {
            if (computerChoice.equals("rock") || computerChoice.equals("spock")) {
                return 1;
            } else {
                return 0;
            }
        } else if (userChoice.equals("scissors")) {
            if (computerChoice.equals("paper") || computerChoice.equals("lizard")) {
                return 1;
            } else {
                return 0;
            }
        } else if (userChoice.equals("lizard")) {
            if (computerChoice.equals("spock") || computerChoice.equals("paper")) {
                return 1;
            } else {
                return 0;
            }
        } else {
            if (computerChoice.equals("scissors") || computerChoice.equals("rock")) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    public static String fuzzbizz(int one, int two, int input) {
        String output = "";
        if ((double) (input / one) == (double) input / one) {
            output += "fuzz";
        }
        if ((double) (input / two) == (double) input / two) {
            output += "bizz";
        }
        if (output.equals("")) {
            output = "none";
        }

        return output;
    }

    public static int countRuns(int[] numbers) {
        if(numbers.length < 2){
            return 0;
        }
        int runs = 0;
        boolean inRun = false;
        if (numbers[0] == numbers[1]) {
            inRun = true;
            runs++;
        }
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] == numbers[i - 1]) {
                if (!inRun) {
                    runs++;
                    inRun = true;
                }
            } else {
                inRun = false;
            }
        }

        return runs;
    }
}
