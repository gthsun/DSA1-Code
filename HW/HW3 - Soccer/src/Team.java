//Name: Geethan Sundaram
//Computing ID: mhy9qc@virginia.edu
//Homework Name: HW3 - Soccer
//Resources used: https://www.geeksforgeeks.org/selection-sort/

//This is the Team class. It represents a team of female soccer players. It creates a Team object consisting
//of an array of Player objects. It has its own getters, setters, and methods.
public class Team {

    //Instance Variable
    //team: Player[] - an array consisting of Player objects with their own attributes
    private Player[] team;

    //Constructor
    //Uses the team mutator/setter method to set the team field to a deep copy of the parameter array
    public Team(Player[] team){
        setTeam(team);
    }

    /*
    A helper class that creates and returns a deep copy of the parameter Player
    Creates a completely new Player with the same attributes as the parameter Player
    This is a deep copy because it returns a separate reference from the parameter Player
    */
    public Player playerCopy(Player o){
        return new Player(o.getName(), o.getPosition(), o.getMinutes_played(),
                o.getGoals(), o.getAssists(), o.getSog_percentage());
    }

    //Returns the team field of the Player
    public Player[] getTeam() {
        return team;
    }

    //Sets the team field of the Player
    //The team field is set to be a deep copy of the parameter using the helper playerCopy method
    public void setTeam(Player[] team) {
        this.team = new Player[team.length];
        for(int i = 0; i < team.length; i++)
            this.team[i] = playerCopy(team[i]);
    }

    //Returns a String consisting of all the Players and their individual attributes within the team field
    public String toString(){
        String s = "";
        for(Player p: team){
            System.out.println(p+"\n");
        }
        return s;
    }

    /*
    Checks if this Team is equal to another object
    The object must not be null (returns false)
    If the object has the same reference as this Team, it returns true
    If the object is an instance of this Team (same type), the class checks if the attributes of all
    the players in their team fields match before returning true
     */
    public boolean equals(Object o){
        if(o == null){return false;}
        if(this == o){return true;}
        if(o instanceof Team){
            Team t = (Team) o;
            for(int i = 0; i < team.length; i++){
                if(!this.getTeam()[i].equals(t.getTeam()[i])){return false;}
            }
            return true;
        }
        return false;
    }

    //Returns the average of all the Players' Sog_percentage within the team field
    public double SOGAverage(){
        double sum = 0;
        for(Player p: team){
            sum += p.getSog_percentage();
        }
        return sum/team.length;
    }

    //Returns the number of Players within the team field with the parameter position String
    //Sets the parameter to full lowercase to keep the method case-insensitive
    public int positionCount(String position){
        int num = 0;
        for(Player p: team){
            if(p.getPosition().equals(position.toLowerCase())){
                num++;
            }
        }
        return num;
    }

    //Returns a Player array sorted from highest to lowest minutes_played
    public Player[] sort(){
        //Creates a deep copy of the team field
        Player[] players = new Player[team.length];
        for(int i = 0; i < players.length; i++)
            players[i] = playerCopy(team[i]);

        //Moves the boundary (or current index) one by one
        for (int i = 0; i < players.length-1; i++)
        {
            //Finds the highest value element within the array
            int max = i;
            for (int j = i+1; j < players.length; j++)
                if (players[j].getMinutes_played() > players[max].getMinutes_played())
                    max = j;

            //Swap the found highest element with the element at i, the boundary
            Player temp = players[max];
            players[max] = players[i];
            players[i] = temp;
        }

        return players;
    }

    //Returns whether a Player with the parameter name is in the team field
    //Iterates through the team field array to check if each player shares the name
    public boolean onTeam(String name){
        for(Player p: team)
            if(p.getName().equals(name))
                return true;
        return false;
    }

    //Returns the Player with the highest amount of goals scored within the team field
    //Returns a shallow copy, which is fine here since the specific best Player is meant to be returned
    public Player mostGoals(){
        Player best = new Player();
        for(Player p: team){
            if(p.getGoals() > best.getGoals())
                best = p;
        }
        return best;
    }
}

