import java.sql.SQLOutput;
import java.util.ArrayList;

public class Lab02 {

    public static int findLongest (String[] strArr) {
        int len = 0;
        int index = 0;
        for(int i = 0; i < strArr.length; i++){
            if(strArr[i].length() > len){
                index = i;
                len = strArr[i].length();
            }
        }
        return index;
    }

    public static int countSubstring (String[] strArr, String str){
        int cnt = 0;
        for(int i = 0; i < strArr.length; i++){
            for(int j = 0; j <= strArr[i].length()-str.length(); j++){
                if(strArr[i].substring(j, j+str.length()).equals(str)){
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void removeSubstring (String[] strArr, String str){
        for(int i = 0; i < strArr.length; i++){
            for(int j = 0; j <= strArr[i].length()-str.length(); j++){
                if(strArr[i].substring(j, j+str.length()).equals(str)){
                    strArr[i] = strArr[i].substring(0, j) + strArr[i].substring(j+str.length());
                    j--;
                }
            }
        }
    }

    public static String[] removeDup (String[] strArr){
        ArrayList<String> arr = new ArrayList<String>();
        for(int i = 0; i < strArr.length; i++){
            if(!arr.contains(strArr[i])){
                arr.add(strArr[i]);
            }
        }
        String[] newArr = new String[arr.size()];
        for(int j = 0; j < arr.size(); j++){
            newArr[j] = arr.get(j);
        }

        return newArr;

    }

    public static void main(String args[]){
        String[] arr = {"hi", "hii", "hiii", "hiiii", "hi"};
        System.out.println(findLongest(arr));

        String[] arr2 = {"hello", "lohellohello", "hello hello lohel lohel"};
        System.out.println(countSubstring(arr2, "lo"));
        removeSubstring(arr2, "lo");
        for(int i = 0; i < arr2.length; i++){
            System.out.println("Index " +i+ ", " +arr2[i]);
        }
        String[] arr3 = {"hi", "hi", "bye", "bye", "hi", "hello", "goodbye", "hello"};
        String[] newArr = removeDup(arr3);
        for(int i = 0; i < newArr.length; i++){
            System.out.println("Index " +i+ ", " +newArr[i]);
        }

    }
}
