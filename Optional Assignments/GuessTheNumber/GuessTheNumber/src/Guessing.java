public class Guessing {

    // Your local variables here
    private int low = 0;
    private int high = 1000;

    private int prev;

    /**
     * Implement how your algorithm should make a guess here
     */

//    public int guessNumber(int n) {
//
//        while ( low <= high ) {
//            mid = low + (high - mid)/2;
//            return mid;
//            if ( guess() == 1 ) {
//                low = mid + 1;
//            } else {
//                high = mid - 1;
//            }
//
//
//        }
//        return -1;

    public int guess() {
        return prev = (low + high)/2;
    }

    /**
     * Implement how your algorithm should update its guess here
     */
    public void update(int answer) {
        if ( answer == 1 ) {
            high = guess() -1;
//            low = prev + 1;
            } else if ( answer == -1 ){
            low = guess() + 1;
//            high = prev - 1;
        }

    }
}
