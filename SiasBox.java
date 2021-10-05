//Source: Implementation of Max Priority Queue : https://www.softwaretestinghelp.com/java-priority-queue-tutorial/


import java.util.*;

public class SiasBox {

    public static void main(String args[]){

        //Scanner for reading in standard input.
        Scanner in = new Scanner(System.in);

        //Store the total number of operations that will be performed.
        int numOfOperations = in.nextInt();

        //Set a boolean variable for each possible data structure, initially all set to true
        //These will be changed to false only when we have discovered that that data structure is impossible given the circumstances
        boolean stack = true;
        boolean queue = true;
        boolean pq = true;

        //Variable to hold the value removed from each data structure on a remove/pop operation
        int removedValue;

        //Declare each data structure that we will be using
        Stack<Integer> stackie = new Stack<Integer>();
        Queue<Integer> queueie = new LinkedList<Integer>();
        //Specify the comparator for priority queue, to implement a max priority queue
        PriorityQueue<Integer> pqie = new PriorityQueue<Integer>(new Comparator<Integer>() {
            public int compare(Integer lhs, Integer rhs) {
                if (lhs < rhs) return +1;
                if (lhs.equals(rhs)) return 0;
                    return -1;
            }
        });

        //For each instruction given...
        for (int i = 0; i < numOfOperations; i++){

            int type = in.nextInt();    //Read in the type of operation (add or remove, push or pop)

            int value = in.nextInt();   //Read in the value for the operation

            //If it's an add operation...
            if (type == 1){

                //Insert the read in value into each data structure
                stackie.push(value);
                queueie.add(value);
                pqie.add(value);

            }
            //Otherwise, it must be an removal operation...
            else if (type == 2){

                //If stack hasn't been eliminated as a data structure possibly being used...
                if (stack == true){

                    //If the stack is empty, it can't be used in this sequence of operations, so we eliminate it.
                    if (stackie.empty()) stack = false;

                    //Else if the stack is not empty...
                    else{
                        removedValue = stackie.pop();   //Remove the top element

                        //If the removed element is NOT equal to the value provided by input,
                        //then stack must be eliminated as a possible data structure in this situation
                        if (removedValue != value){
                            stack = false;
                        }
                    }
                }
                
                //If queue hasn't been eliminated as a data structure possibly being used...
                if (queue == true){

                    //If the queue is empty, it can't be used in this sequence of operations, so we eliminate it.
                    if (queueie.isEmpty()) queue = false;

                    //Else if the queue is not empty...
                    else{
                        removedValue = queueie.remove(); //Remove the first element

                        //If the removed element is NOT equal to the value provided by input,
                        //then queue must be eliminated as a possible data structure in this situation
                        if (removedValue != value){
                            queue = false;
                        }
                    }
                }
                
                //If max priority queue hasn't been eliminated as a data structure possibly being used...
                if (pq == true){

                    //If the max priority queue is empty, it can't be used in this sequence of operations, so we eliminate it.
                    if (pqie.isEmpty()) pq = false;

                    //Else if the max priority queue is not empty...
                    else{
                        removedValue = pqie.remove();   //Remove the first element

                        //If the removed element is NOT equal to the value provided by input,
                        //then max priority queue must be eliminated as a possible data structure in this situation
                        if (removedValue != value){
                            pq = false;
                        }
                    }
                }

            }

            //If the value given for the type of operation is not 1 or 2, something is wrong.
            //Print error message. [debugging]
            else{
                System.out.println("Something is wrong...");
            }

        }
        
        in.close(); //Close the scanner used for reading standard input.

        //If stack is the only possible data structure, print "stack"
        if (stack == true && queue == false && pq == false){
            System.out.println("stack");
        }
        //If queue is the only possible data structure, print "queue"
        else if (stack == false && queue == true && pq == false){
            System.out.println("queue");
        }
        //Else if max priority queue is the only possible data structure, print "priority queue"
        else if (stack == false && queue == false && pq == true){
            System.out.println("priority queue");
        }
        //Else if all of the previous situations are false, and at least one of the booleans is true,
        //then we aren't sure which data structure it is, print "not sure"
        else if (stack == true || queue == true || pq == true){
            System.out.println("not sure");
        }
        //Else, it must be impossible for all 3 data structures
        else{
            System.out.println("impossible");
        }

    }
    
}
