/* Team Client
 * Tests information for a basketball team
 * Morrison
 * If you write your code correctly then you should not have to change anything
 * in this file. You may need to alter some of the calls to some methods,
 * depending on how you write them. Please highlight any lines changed.
 */
public class TeamClient
{
    public static void main( String [] args )
    {
        Player r = new Player("AAA", "forward", 1, 2,3, 0.4);
        Player q = new Player("BBB", "Forward", 1, 2, 3, 0.4);
        if (r.equals(q))
            System.out.println("equal (incorrect)");
        else
            System.out.println("not equal (correct)");
        q.setName("AAA");
        if (r.equals(q))
            System.out.println("equal (correct)");
        else
            System.out.println("not equal (incorrect)");
        boolean good = false;
        Player[] arr = new Player[3];
        arr[0] = new Player("AAA", "GOALIE", 20, 20, 20, 20);
        arr[1] = new Player("BBB", "defense", 10, 10, 10, 10);
        arr[2] = new Player("CCC", "forward", 30, 30, 30, 30);
        Team t = new Team(arr);
        Player[] answer = t.getTeam();
        if (answer.length == 3)
            good = true;
        Player[] arr2 = new Player[2];
        arr2[0] = new Player("DDD", "goalie", 21, 21, 21, 21);
        arr2[1] = new Player("EEE", "Forward", 15, 15, 15, 15);
        t.setTeam(arr2);
        answer = t.getTeam();
        if (good && answer.length == 2)
            good = true;
        else
            good = false;
        if (good) System.out.println("GOOOOOD");
//first let's create an array of Players
        Player [] Caveliers = new Player[12];
        Caveliers[0] = new Player("Maggie Cagle", "forward", 477, 5, 3, .429);
// System.out.println(Caveliers[0].getName() + " " +
        //Caveliers[0].getPosition() + " " + Caveliers[0].getPPGame();
// System.out.println(Caveliers[0]);
        Caveliers[1] = new Player("Talia Staude", "defense", 577, 2, 2, 0.429);
        Caveliers[2] = new Player("Alexis Theoret", "midfield", 540, 0, 2, 0.500);
        Caveliers[3] = new Player("Lacey McCormack", "defense", 536, 0, 1, 0.000);
        Caveliers[4] = new Player("Yuna McCormack", "midfield", 453, 1, 3, 0.333);
        Caveliers[5] = new Player("Chloe Japic", "defense", 419, 0, 0, 1.0);
        Caveliers[6] = new Player("Jill Flammia", "midfield", 408, 0, 1, 0.5);
        Caveliers[7] = new Player("Samar Guidry", "defense", 405, 0, 1, 0.5);
        Caveliers[8] = new Player("Meredith McDermott", "forward", 373, 5, 2,
                0.538);
        Caveliers[9] = new Player("Kiki Maki", "defense", 362, 0, 0, 0.0);
        Caveliers[10] = new Player("Allie Ross", "forward", 299, 4, 1, 0.429);
        Caveliers[11] = new Player("Maya Carter","forward", 280, 1, 0, 0.28);
// now instantiate the team calling the overloaded constructor
        Team cavs = new Team(Caveliers);
// now let's print the team (call toString)
        System.out.println(cavs);
// instantiate identical object
        Team cavs2 = new Team( Caveliers);
// calling accessors
        Player [ ] xx = cavs2.getTeam();
        System.out.println( "The players on cavs2 are: ");
        for (Player y : xx)
            System.out.println(y);
        System.out.println();
// test equals
        if ( cavs.equals( cavs2 ) )
            System.out.println( "Objects are equal (this is correct)" );
        else
            System.out.println( "Objects are not equal (WRONG)" );
// change some data
        System.out.println( "\nUsing mutators to change cavs3 data" );
        Caveliers[0].setSog_percentage(0.250);
        Caveliers[0].setName("Briana Scurry");
        Caveliers[0].setPosition("goalie");
        Team cavs3 = new Team(Caveliers);
// call toString
        System.out.println( "\ncavs3:\n" + cavs3 );
// test equals again
        if ( cavs.equals( cavs3 ) )
            System.out.println( "Objects are equal (WRONG)" );
        else
            System.out.println( "Objects are not equal (This is correct)" );
        System.out.println();
// find team SOG percentage
        System.out.println( "\ncavs SOG average:" );
        System.out.println( cavs.SOGAverage());
        System.out.println( );
        System.out.println();
// number of centers?
        int x = (cavs3.positionCount("FORWARD"));
        System.out.println( "cavs3 have " + x + " forwards (should be 3)");
        System.out.println();
// test sort
        System.out.println("Caveliers sorted by minutes played, descending");
        Player [ ] sort = cavs.sort();
        for (int i = 0; i < sort.length; i++)
            System.out.println(sort[i]);
//sort[0].setName("ZZZ");
//System.out.println(cavs);
        System.out.println();
// test for players on team
        String name = "Mia Hamm";
        if (cavs.onTeam(name))
            System.out.println(name + " is on the cavs. (WRONG)");
        else
            System.out.println(name + " is not on the cavs. (This is correct)");
        name = "kiki maki";
        if (cavs.onTeam(name))
            System.out.println(name + " is on the cavs. (This is correct)");
        else
            System.out.println(name + " is not on the cavs. (WRONG)");
// test best 3 point shooter
        Player p = cavs.mostGoals();
        System.out.println("cavs with the most goals is is " + p.getName());

        String s = new String("hi");
        String xy = s;
        String xz = new String("hi");
        boolean a = s == xy;
        boolean b = s == xz;
        System.out.println(a + " " + b);
    }
}