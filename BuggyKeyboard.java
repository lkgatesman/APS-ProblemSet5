import java.util.*;

public class BuggyKeyboard {

    public static void main(String args[]){

        //Scanner object to read in standard input.
        Scanner in = new Scanner(System.in);

        //Read in input as one string
        String input = in.nextLine();   //Note that we can do this because there are no new line characters 'allowed' in the input.

        in.close(); //Close the scanner

        //String builder to build our string of 
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < input.length(); i++){

            //If the current character is a backspace, delete the last character of the string builder
            if (input.charAt(i) == '<'){
                sb.deleteCharAt(sb.length() - 1);
            }
            //If the current character is not a backspace, add it to the string builder
            else{
                sb.append(input.charAt(i));
            }
            
        }

        //Convert the string builder to a string
        String output = sb.toString();

        //Print out the output (not on a new line, and with no extra spaces)
        System.out.print(output);

    }
    
}
