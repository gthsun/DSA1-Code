public class WorkingDog extends Dog implements Working{

    public WorkingDog(String nm){
        super(nm);
    }

    @Override
    public void work() {
        speak();
        System.out.println("I can herd sheep and cows");
    }

    public void speak(){
        System.out.println("bruh");
        super.speak();
    }

    public void testIt1() {
        System.out.println("One-WorkingDog");
    }

    public void testIt3() {
        System.out.println("Three-WorkingDog");
    }
}
