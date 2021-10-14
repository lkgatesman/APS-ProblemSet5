import java.util.Scanner;
import java.util.HashMap;

public class UniqueSubarrays{

    public static void main(String args[]){

        //Read in the input
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        int[] original = new int[length];
        for (int i = 0; i < length; i++){
            original[i] = in.nextInt();
        }

        in.close(); //close the scanner

        //Hash map that holds each integer we have already encountered in our unique subarray so far
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();

        int uniques = 0;    //stores the number of elements in the unique subarray we are currently looking at
        int max = 0;    //stores the number of elements in the largest unique subarray
        int i = 0;

        //For each element in the original array...
        while( i < length ){

            //If we have encountered it before in this subarray...
            if (hm.containsKey(original[i])){
                //And the current subarray is longer than our previous max subarray, update the max value
                if (uniques > max){
                    max = uniques;
                }
                uniques = 0;    //reset the value of uniques to 0, since we are starting at a new subarray
                i = hm.get(original[i]) + 1;
                hm.clear(); //clear out the hashmap, since we are starting at a new subarray
                continue;
            }

            //If we haven't seen this element in our current unique subarray before...
            else{
                hm.put(original[i], i);  //add it to the hashmap
                uniques++;  //increase the number of unique values that we have seen in this subarray
                
                //If the uniques is now greater than the max, replace max
                //NOTE: this is here in case the longest unique subarray occurs at the end
                //of the array, and so we never find another duplicate value. Thus we must update uniques if needed.
                if (i == length-1 && uniques > max){
                    max = uniques;
                }
                i++;
            }
        }

        System.out.println(max);

    }

}