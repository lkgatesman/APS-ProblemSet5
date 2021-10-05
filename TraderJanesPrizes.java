import java.util.*;

public class TraderJanesPrizes {

    public static void main(String args[]){

        //Scanner to read in standard input.
        Scanner in = new Scanner(System.in);

        //The total number of days that forms are submitted.
        int totalDays = in.nextInt();

        //The total number of forms that were submitted for the current day.
        int forms = 0;

        //List to hold the price paid for each customer that made a submission.
        List<Integer> submissions = new ArrayList<Integer>();

        int min = -1;   //holds the current minimum of all the submissions
        int max = -1;   //holds the current maximum of all the submissions
        int prizes = 0; //stores the total value of all prizes given out

        //For each day i...
        for (int i = 0; i < totalDays; i++){

            //Store the number of forms submitted for day i
            forms = in.nextInt();

            //Add the price from each form j to the submissions list
            for (int j = 0; j < forms; j++){
                submissions.add(in.nextInt());
            }

            //Sort the list of submissions
            Collections.sort(submissions);

            //Retrieve the minimum submission and maximum submission, remove them from the list
            min = submissions.remove(0);
            max = submissions.remove(submissions.size() - 1);

            //And add the difference between max and min to the array
            prizes += (max - min);

        }

        System.out.println(prizes);
        in.close();
        
    }
    
}
