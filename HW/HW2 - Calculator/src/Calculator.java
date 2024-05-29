//Name: Geethan Sundaram
//Computing ID: mhy9qc@virginia.edu
//Homework Name: Calculator
//Resources used: None

import org.w3c.dom.ls.LSOutput;

public class Calculator {

    //Fields
    private int mem1;
    private int mem2;
    private String op;

    //Default Constructor
    public Calculator() {
        mem1 = 0; mem2 = 0; op = " ";
    }

    //3 Argument Constructor
    public Calculator(int op1, int op2, String newOp) {
        setMem1(op1);
        setMem2(op2);
        op = " ";
        setOp(newOp);
    }

    //Getters and Setters
    public int getMem1() {
        return mem1;
    }

    public void setMem1(int mem1) {
        this.mem1 = mem1;
    }

    public int getMem2() {
        return mem2;
    }

    public void setMem2(int mem2) {
        this.mem2 = mem2;
    }

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        if(op.equals("+")||op.equals("-")||op.equals("/")||op.equals("*")||op.equals("^"))
            this.op = op;
    }

    public String toString() {
        return mem1+ " " +op+ " " +mem2;
    }

    /*
    Performs a calculation with mem1 and mem2 using the operation in the op string
    Sets mem2 as the integer answer and returns mem2 (an integer value)
    If op is "+", the sum of mem1 and mem2 is returned
    If op is "-", the difference between mem1 and mem2 is returned
    If op is "*", the product between mem1 and mem2 is returned
    If op is "/" and mem2 = 0, then zero is returned, otherwise the quotient between
    mem1 and mem2 is returned, truncated
    If op is "^", mem1 to the power of mem2 is returned */
    public int perform(){
        if(op.equals("+"))
            mem2 += mem1;
        if(op.equals("-"))
            mem2 = mem1 - mem2;
        if(op.equals("*"))
            mem2 *= mem1;
        if(op.equals("/")){
            if(mem2 != 0){
                mem2 = mem1/mem2;
            }
        }
        if(op.equals("^")){
            int num = mem2;
            mem2 = 1;
            if(mem2 != 0);{
                for (int i = 0; i < num; i++) {
                    mem2 *= mem1;
                }
            }
        }
        return mem2;
    }

    /*
    Performs a division operation if op is "/" and mem2 is not 0
    Returns the double quotient of mem1 and mem2
    If either of the two conditions are not fulfilled, the method returns 0.0 */
    public double performDiv(){
        if(op.equals("/") && mem2 != 0)
            return (double)mem1/mem2;
        else {return 0.0;}
    }

    //Swaps the values of mem1 and mem2
    public void swap(){
        int store = mem1;
        mem1 = mem2;
        mem2 = store;
    }
}
