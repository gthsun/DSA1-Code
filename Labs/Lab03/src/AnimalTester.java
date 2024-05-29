public class AnimalTester{

    public static void main(String[] args){
        Animal lion = new Dog("Lion");
        Cow bossy = new Cow("Bossy");
        Dog rover = new Dog("Rover");
        Snake ernie = new Snake("Ernie");
        WorkingDog spot = new WorkingDog("Spot");
        lion.speak();
        bossy.speak();
        rover.speak();
        ernie.speak();
        spot.speak();
        System.out.println(lion);
        System.out.println(bossy);
        System.out.println(rover);
        System.out.println(ernie);

        Animal[] animals = new Animal[4];
        animals[0] = bossy;
        animals[1] = rover;
        animals[2] = ernie;
        animals[3] = spot;
        for(Animal a : animals){
            a.speak();
            System.out.println(a);
            if(a instanceof WorkingDog){
                WorkingDog wd = (WorkingDog) a;
                wd.work();
            }
        }
        bossy.equals(lion);

        Dog d = (Dog) new Dog("hi");
        WorkingDog w = new WorkingDog("hi");
        d = w;
        w.testIt1();

        Animal var2 = new Dog("dog");
        Cow var3 = new Cow("cow");
        var3 = (Cow) var2;

    }
}
