//Name: Geethan Sundaram
//Computing ID: mhy9qc@virginia.edu
//Homework: HW12 - Priority Queues
//Resources Used: ChatGPT for debugging purposes - helped with dealing with Comparable with generics

@SuppressWarnings("unchecked")

//A class representing a certain task with a priority (higher number being more important)
public class Task implements Comparable<Task>{

    //Instance variables
    private String name; //String representing the task itself
    private int priority;//Numerical value representing importance of task

    //Task-only constructor (is priority is not being considered)
    public Task(String name){
        this.name = name;
    }

    //Two-argument constructor (considers priority)
    public Task(String name, int priority){
        this.name = name;
        this.priority = priority;
    }

    //Getters and Setters
    public String getName(){
        return name;
    }

    public void setName(String name){
        if(name.length() > 0){ //Makes sure task name is not left blank
            this.name = name;
        }
    }

    public int getPriority(){
        return priority;
    }

    //Makes sure priority is a positive number
    public void setPriority(int priority){
        if(priority > 0){
            this.priority = priority;
        }
    }

    //Returns a string representation of Task with the task name and its priority
    public String toString(){
        return "[ " +name+ ", " +priority+ " ]";
    }

    //Defines whether two instances of a Task are equal
    public boolean equals(Object obj) {
        if(obj == null) return false; //Null check
        else if(this == obj) return true; //Aliases are equal
        else{
            if(obj instanceof Task){ //If parameter is an instance of Task
                Task tObj = (Task) obj;
                return name.equals(tObj.getName()); //Check if task names are equal
            }
        }
        return false;
    }

    public int compareTo(Task o) { //Compares tasks based on their priority
        Task t = (Task) o;
        return this.getPriority() - t.getPriority(); //Higher priority "wins"
    }
}
