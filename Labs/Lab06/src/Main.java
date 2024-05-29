import java.sql.SQLOutput;

public class Main {

    public static void reverseNum(int num){
        if(num / 10 == 0){
            System.out.println(num + " ");
        }
        else{
            System.out.print(num%10 + " ");
            reverseNum(num / 10);
        }
    }

    public static void WriteLine(char c, int n){
        if(n > 0){
            System.out.print(c);
            WriteLine(c, n-1);
        } else{
            System.out.println();
        }
    }

    public static void WriteBlock(char c, int n, int m){
        if(m > 0){
            WriteLine(c, n);
            WriteBlock(c, n, m-1);
        } else{
            System.out.println();
        }
    }

    public static void reverseArray(int[] arr){
        System.out.print("[");
        reverseArray(arr, arr.length -1);
    }
    public static void reverseArray(int[] arr, int index){
        if(index < 0){
            System.out.println("]");
        }
        if(index == 0){
            System.out.print(arr[index] + "]");
        }
        else{
            System.out.print(arr[index] + ", ");
            reverseArray(arr, index-1);
        }
    }

    public static void main(String[] args){
        reverseNum(929491);

        WriteLine('*', 12);

        WriteBlock('*', 5, 3);

        int[] arr = {1, 2, 3, 4};
        reverseArray(arr);
    }
}
