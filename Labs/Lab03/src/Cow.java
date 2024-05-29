public class Cow extends Animal
{
    public Cow(String nm)     {
        super(nm);    // builds ala parent
    }
    public void speak()  {  // this method specific to Cow
        System.out.println("Mooooo");
    }

    public void testIt3() {
        System.out.println("Three-Cow");
    }
}
