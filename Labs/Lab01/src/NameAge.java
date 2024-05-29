import java.util.Scanner;

public class NameAge {

    public static void main(String args[]){

        Scanner scan = new Scanner(System.in);
        System.out.println("What is your name?");
        String name = scan.nextLine();
        System.out.println("What is your age?");
        int age = scan.nextInt();
        System.out.println("Hi " +name+ "! You were born in " + (2023-age)+ " or " +(2023-age-1));
    }
}
