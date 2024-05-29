public class HashFunction {
    // hash function for hashing lab
    // author:  Briana Morrison

    public static void main(String[] args) {
        // declare array with all the values
        int[] arr = {47, 89, 90, 126, 140, 145, 153, 177, 285, 393, 395, 467, 566, 601, 735};
        int i;
        int key;

        System.out.println("table with 20 positions");
        System.out.println("key\thash\tindex\toffset");
        for (i = 0; i < 15; i++)  {
            // print array value, hash value, hash value mod table size, hash value divided by table size
            System.out.println( arr[i] + "\t"
                + hashFunc(arr[i]) + "\t"
                + hashFunc(arr[i])%20 + "\t"
                + hashFunc(arr[i])/20);
        }


        System.out.println("table with 10 positions");
        System.out.println("key\thash\tindex\toffset");
        for (i = 0; i < 15; i++)
        {
            // print array value, hash value, hash value mod table size
            System.out.println( arr[i] + "\t"
                    + hashFunc(arr[i]) + "\t"
                    + hashFunc(arr[i])%10);
        }



        System.out.println("table with 5 positions");
        System.out.println("key\thash\tindex\toffset");
        for (i = 0; i < 15; i++)
        {
            // print array value, hash value, hash value mod table size
            System.out.println( arr[i] + "\t"
                    + hashFunc(arr[i]) + "\t"
                    + hashFunc(arr[i])%5);
        }

        System.out.println("table with 40 positions");
        System.out.println("key\thash\tindex\toffset");
        for (i = 0; i < 15; i++)
        {
            // print array value, hash value, hash value mod table size
            System.out.println( arr[i] + "\t"
                    + hashFunc(arr[i]) + "\t"
                    + hashFunc(arr[i])%40);
        }
    }

    public static int hashFunc (int item) {
        int value = item * item;    		// square the item;
        value /= 256;				// discard the low order 8 bits
        return Math.abs(value % 65536); 	// return item in range 0 to 65535;
    }

}
