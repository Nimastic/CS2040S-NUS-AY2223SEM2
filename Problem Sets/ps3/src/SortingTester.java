import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class SortingTester {
    public static boolean checkSort(ISort sorter, int size) {
        // TODO: implement this
       // int randomNum;
        Random rng = new Random();
        KeyValuePair[] testArray = new KeyValuePair[size];

        for (int i = 0; i < size; i++) {
           // randomNum = ThreadLocalRandom.current().nextInt(1, size + 1);
            testArray[i] = new KeyValuePair(rng.nextInt(), i);

        }

        sorter.sort(testArray);

        for ( int i = 0; i < size - 1; i++ ) {
            if (testArray[i].getKey() > testArray[i+1].getKey()) {
                return false;
            }
        }
        return true;
    }

    public static boolean isStable(ISort sorter, int size) {
        // TODO: implement this
        int randomNum;
        //Random rng = new Random();

        KeyValuePair[] testArray1 = new KeyValuePair[size];

        for (int i = 0; i < size; i++) {
            randomNum = ThreadLocalRandom.current().nextInt(1, (size + 1)/2);
            testArray1[i] = new KeyValuePair(randomNum, i);

        }

        sorter.sort(testArray1);

        for (int i = 0; i < size-1; i++) {
            if (testArray1[i].getKey() == testArray1[i + 1].getKey()) {
                if (testArray1[i].getValue() > testArray1[i + 1].getValue()) {
                    return false;
                }
            }


        }

        return true;
    }

    public static void main(String[] args) {
        // TODO: implement this

    }
}
