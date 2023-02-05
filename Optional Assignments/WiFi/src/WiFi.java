import java.util.Arrays;

class WiFi {

    /**
     * Implement your solution here
     */
    public static double computeDistance(int[] houses, int numOfAccessPoints) {
        Arrays.sort(houses);
        double low = houses[0];
        double high = houses[houses.length - 1];
        // max distance between first and last
        while (high - low > 0) {
            double mid = (low + high) / 2;
            if (coverable(houses, numOfAccessPoints, mid)) {
                high = mid; //reduces distance of router
            } else {
                low = mid; // makes low = mid so that high - low = mid - mid and exits the loop.
                //this means low is the min distance for the given houses[] and numAccespoints
            }
        }
        return low;
    }

    /**
     * Implement your solution here
     */
    public static boolean coverable(int[] houses, int numOfAccessPoints, double distance) {
        int i = 0; // first house in the street
        int j = 0; // first router potentially to be placed.
        while (i < houses.length) { // checks for more houses to cover
            if (j >= numOfAccessPoints) return false; // loops for router used <= num
            // returns false if j is more than number of routers available
            int next = i + 1;
            // next is used to keep track the next house that is beyond the range of the current router
            //
            while (next < houses.length && houses[next] <= houses[i] + 2 * distance) next++;
            // next moves to the next house
            j++; // router placed
            i = next; // house index moved to the next

        }
        return true;
    }
}



