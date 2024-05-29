//Name: Geethan Sundaram
//Computing ID: mhy9qc@virginia.edu
//Homework: HW8 - Recursion
//Resources Used: None

//Imported Random Class to utilize in toString
import java.util.Random;

//A Password, represented by a String, that can only be changed if the new password meets certain conditions
public class Password {

    //Instance variables
    private String curPassword; //The current Password
    private String newPassword; //A new password that must be checked before setting curPassword to it

    //1-Argument constructor that accepts a String of what you want to set the current password to
    //Current password is empty if new password is invalid
    public Password(String pass){
        curPassword = "";
        newPassword = "";
        setPassword(pass);
    }

    //Default constructor; sets the current password to an empty string
    public Password(){
        curPassword = "";
        newPassword = "";
    }

    /**
     * Checks whether the new password contains at least one digit
     * Returns true if it does, false if it does not
     */
    private boolean hasDigit(){
        //null check
        if(newPassword != null)
            return hasDigit(newPassword);
        else return false;
    }

    //Helper method for hasDigit()
    private boolean hasDigit(String pass){
        if(pass.length() <= 0) return false;
        if(pass.charAt(pass.length()-1) >= '0' && pass.charAt(pass.length()-1) <= '9') return true;
        else return hasDigit(pass.substring(0, pass.length()-1));
    }

    /**
     * Checks whether the new password is equal to the current password
     * Returns true if it is, false if it is not
     */
    private boolean passMatch(){
        //null check
        if(curPassword != null && newPassword != null)
            return passMatch(curPassword, newPassword);
        //if both are null, then they technically match
        else if(curPassword == null && newPassword == null)
            return true;
        else return false;
    }

    //Helper method for passMatch()
    private boolean passMatch(String oldPass, String newPass){
        if(oldPass.length() == 0 && newPass.length() == 0) return true;
        else if(oldPass.length() == 0 || newPass.length() == 0) return false;
        if(oldPass.charAt(oldPass.length()-1) == newPass.charAt(newPass.length()-1)){
            return passMatch(oldPass.substring(0, oldPass.length()-1), newPass.substring(0, newPass.length()-1));
        } else return false;
    }

    /**
     * Checks the amount of differences between the current password and the new password
     * Increments the number of differences for each index with different characters
     * If one password is longer than the other, it also adds the difference in length between the two
     * Returns the total differences
     */
    private int diffChar(){
        //null check
        //if both are null, they have 0 different chars
        if(curPassword == null && newPassword == null)
            return 0;
        //if one is null, the difference is the length of the other
        else if (curPassword == null || newPassword == null){
            if(curPassword == null)
                return newPassword.length();
            else
                return curPassword.length();
        }
        else
            return diffChar(curPassword, newPassword);
    }

    //Helper method for diffChar
    private int diffChar(String oldPass, String newPass){
        if(oldPass.length() == 0 && newPass.length() == 0) return 0;
        else if(oldPass.length() == 0 || newPass.length() == 0) {
            return Math.max(oldPass.length(), newPass.length());
        } else{
            int num = 0;
            if(oldPass.charAt(0) != newPass.charAt(0)) num = 1;
            return diffChar(oldPass.substring(1), newPass.substring(1)) + num;
        }
    }

    /**
     * Checks the differences between the current and new password using diffChar
     * Compares the number of differences with a threshold int parameter
     * Returns true if the differences are greater than or equal to the threshold and false otherwise
     */
    private boolean differentEnough(int num){
        if(diffChar() >= num) return true;
        return false;
    }

    /**
     * Sets the new password (what we want to change the current password to) to the String parameter
     * Ensures new password has atleast a digit, doesn't exactly match the current password, and at least
     * 50% of its characters are different
     * Sets current password to new password and returns true if all conditions are true
     * If any condition is not true, it does not set current password and returns false
     */
    public boolean setPassword(String pass){
        newPassword = pass;
        if(hasDigit() && !passMatch() && differentEnough(curPassword.length()/2)){
            curPassword = newPassword;
            newPassword = "";
            return true;
        }
        return false;
    }

    //Returns the current password String
    public String getPassword(){
        return curPassword;
    }

    /**
     * A String representation of the current Password
     * Returns the first and last letter of the password, with a random number of asterisks in between
     * Number of asterisks can range from 1 to 20
     */
    public String toString(){
        if(curPassword.equals("")) return "";
        String pass = curPassword.charAt(0) +"";
        Random rand = new Random();
        int asterisks = rand.nextInt(20)+1;
        for(int i = 0; i < asterisks; i++){
            pass += "*";
        }
        return pass + curPassword.charAt(curPassword.length()-1);
    }

    /**
     * Checks if two Password instances are equal
     * If the other is null, returns false
     * If they are aliases, returns true
     * If the other object is a Password, checks to ensure the current passwords of both match
     * Returns false if none of these conditions are true
     */
    public boolean equals(Object o){
        if(o == null){return false;}
        if(this == o){return true;}
        if(o instanceof Password){
            Password pass = (Password) o;
            return this.getPassword().equals(pass.getPassword());
        }
        return false;
    }

}
