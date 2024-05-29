public class Tester {

    public static int theValue(int A, int B, int N) {
        int ReturnValue;
        System.out.println("Enter: A = " + A + " B = " + B);
        int C = (A + B) / 2;
        if (C*C <= N)
            ReturnValue = C;
        else
            ReturnValue = theValue (A, C-1, N);
        System.out.println("Leave: A = " + A + " B = " + B);
        return ReturnValue;
    }

    public static void DispOct(int N) {
        if (N > 0) {
            if (N / 8 > 0)
                DispOct (N / 8);
            System.out.println( N % 8);
        }
    }
    public static void R(int X, int Y) {
        if (Y > 0) {
            ++X;
            --Y;
            System.out.println(X + " " + Y);
            R (X, Y);
            System.out.println(X + " " + Y);
        }
    }

    public static int Rose(int n) {
        if (n == 1)
            return 0;
        else
            return (1 + Rose (n/2));
    }

    public static int Mystery(int n) {
        if (n <= 2)
            return 1;
        else
            return (Mystery(n-1) +Mystery(n-2));
    }

    public static int Wow (int M, int N) {
        if (M < 10)
            if (N < 10)
                return M + N;
            else
                return Wow (M, N-2) + N;
        else
            return Wow (M-1, N) + M;
    }


    public static void main(String[] args){
        System.out.println(theValue(1, 7, 7));
        DispOct(100);
        R(5, 3);
        System.out.println(Mystery(6));
        System.out.println(Rose(100));
        System.out.println(Wow(12, 15));

    }
}
