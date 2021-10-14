import java.util.*;

public class QueueingWithFriends {

    static HashMap<Integer, Friend> hm = new HashMap<Integer, Friend>();

    static PriorityQueue<Friend>[] groups;

    static List<Integer> activeGroups = new ArrayList<Integer>();

    static int timer = 0;

    public static void main(String args[]){

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        int inputGroupCounter = 0;
        int numFriends = 0;
        while (inputGroupCounter < n){

            numFriends = in.nextInt();

            for (int i = 0; i < numFriends; i++){
                int currentFriend = in.nextInt();
                Friend lauren = new Friend(currentFriend, inputGroupCounter);
                hm.put(currentFriend, lauren);
            }
            
            inputGroupCounter++;

        }

        in.nextLine();  //read out the line break

        //Create the array that will hold each friend group's queue
        groups = new PriorityQueue[n];
        for (int i = 0; i < n; i++){
            PriorityQueue<Friend> groupOfFriends = new PriorityQueue<Friend>(new CustomFriendComparator());
            groups[i] = groupOfFriends;
        }

        /*for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
            Integer keyValue = entry.getKey();
            Integer value = entry.getValue();
            System.out.println("key, " + keyValue + " value " + value);
        }*/

        String instruction;
        int index;

        while (in.hasNext()){

            instruction = in.next();

            if (instruction.equals("Shutdown")){
                break;
            }

            else if (instruction.equals("Push")){
                index = in.nextInt();
                in.nextLine();  //read out the line break
                push(index);
            }

            else if (instruction.equals("Pop")){
                in.nextLine(); 
                pop();
            }

            timer++;

        }

        in.close();

    }

    public static void pop(){

        //Get the first group in the queue of active groups
        int groupNumber = activeGroups.get(0);

        //Print out the number
        System.out.println(groups[groupNumber].poll().friendNumber);

        //If the group is not EMPTY, remove it from the active queue
        if (groups[groupNumber].isEmpty()){
            activeGroups.remove(0);
        }

    }

    public static void push(int friend){

        //Get the object of the corresponding friend
        Friend evie = hm.get(friend);

        //Set the friend's push time
        evie.pushTime = timer;

        //If the friend's group is empty, add it to the queue of active queues, since we know that it will now be active.
        if (groups[evie.groupNumber].isEmpty()){
            activeGroups.add(evie.groupNumber);
        }

        //Add the friend to its friend group queue
        groups[evie.groupNumber].add(evie);

    }
    
}

class Friend{

    int pushTime;
    int friendNumber; 
    int groupNumber;

    public Friend(int friendNumber, int groupNumber) {
        this.friendNumber = friendNumber;
        this.groupNumber = groupNumber;
        this.pushTime = -1;
    }

}

class CustomFriendComparator implements Comparator<Friend> {

    @Override
    public int compare(Friend o1, Friend o2) {
        return o1.pushTime > o2.pushTime ? 1 : -1;
    }
}
