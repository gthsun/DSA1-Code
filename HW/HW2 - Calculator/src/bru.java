public class bru {
    public static void main(String[] args){
        int x = 0;
        String word = "";
        switch (x+3) {
            default:
                word = "apple ";

            case 1:
                word = "strawberry ";
            case 4:
                word = "peanut ";
            case 3:
                word = "green bean ";
            case 2:
                word = "cabbage ";


        }
        System.out.println("The secret word is "+ word);
    }
}
