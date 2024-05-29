//Name: Geethan Sundaram
//Computing ID: mhy9qc@virginia.edu
//Homework Name: HW3 - Soccer
//Resources used: https://www.geeksforgeeks.org/selection-sort/

//This is the Player class. It represents a female soccer player at the University of Virginia.
//It creates a Player object with getters, setters, and methods.
public class Player {
    /*
    Instance Variables:
    name: String - The first and last name of the Player
    position: String - The players position: "defense", "midfield", "forward", and "goalie"
    minutes_played: int - Total amount of minutes played by the Player
    goals: int - Number of goals scored by the Player
    assists: int - Number of goal assisted by the Player
    sog_percentage: double - Shots on goal percentage: Percentage of shots that were goals
     */
    private String name;
    private String position;
    private int minutes_played;
    private int goals;
    private int assists;
    private double sog_percentage;

    //Default Constructor
    //Not tested, but assigns the following default values to the Player
    public Player(){
        name = "First Last";
        position = " ";
        minutes_played = 0;
        goals = 0;
        assists = 0;
        sog_percentage = 0;
    }

    //Constructor with Arguments
    //Uses mutator/setter methods to verify and set each instance variable
    public Player(String name, String position, int minutes_played, int goals, int assists, double sog_percentage) {
        this.name = "First Last"; setName(name);
        this.position = " "; setPosition(position);
        this.minutes_played = 0; setMinutes_played(minutes_played);
        this.goals = 0; setGoals(goals);
        this.assists = 0; setAssists(assists);
        this.sog_percentage = 0; setSog_percentage(sog_percentage);
    }

    //Getters and Setters

    //Returns the name field of the Player
    public String getName() {
        return name;
    }

    //Sets the name field of the Player
    public void setName(String name) {
        this.name = name;
    }

    //Returns the position field of the player
    public String getPosition() {
        return position;
    }

    /*
    Sets the position field of the Player
    Only sets the field if parameter is "defense", "midfield", "forward", or "goalie"
    Ignores case of parameter when checking; sets position field as lowercase, whether parameter is or not
     */
    public void setPosition(String position) {
        if(position.equalsIgnoreCase("defense")||
           position.equalsIgnoreCase("midfield")||
           position.equalsIgnoreCase("forward")||
           position.equalsIgnoreCase("goalie"))
            this.position = position.toLowerCase();
    }

    //Returns the minutes_played field of the Player
    public int getMinutes_played() {
        return minutes_played;
    }

    //Sets the minutes_played field of the Player
    //Ensures parameter is greater than or equal to zero before setting it
    public void setMinutes_played(int minutes_played) {
        if(minutes_played >= 0)
            this.minutes_played = minutes_played;
    }

    //Returns the goals field of the Player
    public int getGoals() {
        return goals;
    }

    //Sets the goals field of the Player
    //Ensures parameter is greater than or equal to zero before setting it
    public void setGoals(int goals) {
        if(goals >= 0)
            this.goals = goals;
    }

    //Returns the assists field of the Player
    public int getAssists() {
        return assists;
    }

    //Sets the assists field of the Player
    //Ensures parameter is greater than or equal to zero before setting it
    public void setAssists(int assists) {
        if(assists >= 0)
            this.assists = assists;
    }

    //Returns the sog_percentage field of the Player
    public double getSog_percentage() {
        return sog_percentage;
    }

    //Sets the sog_percentage field of the Player
    //Ensures parameter is between 0% and 100% inclusive before setting it
    public void setSog_percentage(double sog_percentage) {
        if(goals >= 0 && goals <= 100)
            this.sog_percentage = sog_percentage;
    }

    //Returns a String consisting of the Player's attributes
    //Overriden from Object class
    public String toString(){
        return "Name: "+name+", Position: "+position+", Minutes Played: "+minutes_played+", Goals: "
                +goals+", Assists: "+assists+", and Shots on goal percentage: " +sog_percentage+"%";
    }

    /*
    Checks if this Player is equal to another object
    The object must not be null (returns false)
    If the object has the same reference as this Player, it returns true
    If the object is an instance of this Player (same type), the class ensures that their attributes match
    after casting the object to be a Player before returning true
     */
    public boolean equals(Object o){
        if(o == null){return false;}
        if(this == o){return true;}
        if(o instanceof Player){
            Player oPlayer = (Player) o;
            if(this.getName().equals(oPlayer.getName()) &&
            this.getPosition().equals(oPlayer.getPosition()) &&
            this.getMinutes_played() == oPlayer.getMinutes_played() &&
            this.getGoals() == oPlayer.getGoals() &&
            this.getAssists() == oPlayer.getAssists() &&
            this.getSog_percentage() == oPlayer.getSog_percentage())
                return true;
        }
        return false;
    }

}
