public class TestIt {

    public static void main(String[] args) {
        Animal var1 = new Dog("dog");
        Animal var2 = new Cow("cow");
        WorkingDog var3 = new WorkingDog("workdog");
        Dog var4 = new Dog("workdog2");
        Dog var42 = new WorkingDog("workdog2");
        Cow var7 = new Cow("cow2");
        //var7 = var2;
        Snake var8 = new Snake("snake");
        Object var5 = new Cow("cow3");
        Object var6 = new Dog("dog2");
        Dog var9 = var4;

        Dog a = new WorkingDog("a");
        WorkingDog b = new WorkingDog("b");

        Animal q = new Dog("dog");
        Cow w = new Cow("cow");
        w = (Cow) q;



        a.testIt1();


        var1.testIt1(); //One-Animal
        //var2.testIt2(); // Compiler Error
        var3.testIt1(); //One-WorkingDog
        var4.testIt1(); //One-WorkingDog
        //var5.testIt3(); //Compiler Error
        //var6.testIt1(); //Compiler Error
        var4.testIt2(); //Two-Dog
        var3.testIt3(); //Three-WorkingDog
        //var4.testIt3(); //Compiler Error
        ((Dog) var1).testIt2(); //Two-Dog
        //((Cow) var2).testIt2(); //Compiler Error
        ((Animal) var8).testIt1(); //One-Snake
        //var7 = var2; //Compiler Error
        var7.testIt3(); //Three-Cow
        ((Cow) var2).testIt3(); //Three-Cow
        //((WorkingDog) var4).testIt3();

        /*
        int i = Integer.MAX_VALUE;
        System.out.println(i);
        double d = i;
        System.out.println(d);
        d = Double.MAX_VALUE;
        System.out.println(d);
        i = (int) d;
        System.out.println(i);
         */
        /*
        Animal myAnimal = new Cow("hi");
        Dog myDog = (Dog) myAnimal;*/

    }
}