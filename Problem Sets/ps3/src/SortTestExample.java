import java.util.concurrent.ThreadLocalRandom;

/**
 * This class is a simple example for how to use the sorting classes.
 * It sorts three numbers, and measures how long it takes.
 */
public class SortTestExample extends SortingTester {
    public static void main(String[] args) {
        // Create three key value pairs
        KeyValuePair[] testArray = new KeyValuePair[3];
        testArray[0] = new KeyValuePair(10, 20);
        testArray[1] = new KeyValuePair(5, 20);
        testArray[2] = new KeyValuePair(8, 20);

        KeyValuePair[] asc = new KeyValuePair[1000];
        for ( int i = 0; i < asc.length; i++) {
            asc[i] = new KeyValuePair(i, 1);
        }

        KeyValuePair[] asc2 = new KeyValuePair[100];
        for ( int i = 0; i < asc2.length; i++) {
            asc2[i] = new KeyValuePair(i, 1);
        }

        KeyValuePair[] rnd = new KeyValuePair[1000000];
        for ( int i = 0; i < rnd.length; i++) {
            rnd[i] =  new KeyValuePair(ThreadLocalRandom.current().nextInt(1, 999), 1);
        }

        KeyValuePair[] dsc = new KeyValuePair[1000];
        for ( int i = 0; i < dsc.length; i++) {
            dsc[i] = new KeyValuePair(1000 - i, 1);        }

        KeyValuePair[] almost = new KeyValuePair[1000]; //
        almost[999] = asc[0];
        for ( int i = 0; i < almost.length; i++) {
            almost[i] = new KeyValuePair(i + 1, 1);
        }

        KeyValuePair[] almost2 = new KeyValuePair[100];
        almost2[99] = asc[0];
        for ( int i = 0; i < almost2.length; i++) {
            almost2[i] = new KeyValuePair(i + 1, 1);
        }



        //Create a Sorter
        ISort sortingObject = new SorterB();

        // Do the sorting
        long sortCost = sortingObject.sort(rnd);
       //  long Ascending = sortingObject.sort();



        System.out.println(testArray[0]);
        System.out.println(testArray[1]);
        System.out.println(testArray[2]);
        System.out.println("Sorted: " + checkSort(sortingObject, 100000));
        System.out.println("Stable: " + isStable(sortingObject, 100));
        System.out.println("Ascending: " + sortingObject.sort(asc));
        System.out.println("Ascending2: " + sortingObject.sort(asc2));
        System.out.println("Descending: " + sortingObject.sort(dsc));
        System.out.println("Random: " + sortingObject.sort(rnd));
        System.out.println("Almost: " + sortingObject.sort(almost));
        System.out.println("Almost2: " + sortingObject.sort(almost2));

        //        System.out.println("Nearly Sorted: " + isStable(sortingObject, 100));
        System.out.println("Sort Cost: " + sortCost);
    }
}
