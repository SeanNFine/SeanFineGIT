package testMain;

/**
 * Created by Sean on 6/4/2014.
 */
public class lockerTest {
    //there are 1000 lockers that are all closed and 1000 people,
    // 1st person goes and opens all the lockers, 2nd closes every 2nd locker, 3rd changes every 3rd locker, and so on
    //Figure out how many lockers are left open

    public static void main(String[]args) {
        boolean[] lockers = new boolean[1000];
        int openCount = 0;

        for (int i = 1; i <= 1000; i++) {
            for(int j=0; j<lockers.length; j+=i){
                lockers[j]=!lockers[j];

                if(lockers[j]) openCount++;
                else openCount--;
            }

        }
        System.out.println("There are "+openCount+" open lockers and "+(1000-openCount)+" closed lockers");

    }
}
