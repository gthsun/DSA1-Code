public class PasswordTester {

    public static void main(String[] args){
        Password pass = new Password("Incredible");
        System.out.println(pass);

        pass.setPassword("Incredibl3");
        System.out.println(pass);

        pass.setPassword("BroIAmHungry");
        System.out.println(pass);

        pass.setPassword("am00gus");

        System.out.println(pass.getPassword());

    }
}
