public class FindKeysMinimumAttempts implements IFindKeys {
    @Override
    public int[] findKeys(int N, int k, ITreasureExtractor treasureExtractor) {
        int[] bitmap = new int[N];
        for (int i = 0; i < N; i ++) {
            bitmap[i] = 1; // array of N 1s : [1, 1, 1, ...., 1]
        }

        int keys = 0;
        int keysUsed = N;

        for (int i = 0; i < N; i++) {
            if (keys == k) {
                bitmap[i] = 0;
            } else {
                bitmap[i] = 0;
                keysUsed--;

                if (keysUsed < k || !treasureExtractor.tryUnlockChest(bitmap)) {
                    keys ++;
                    bitmap[i] = 1;
                    keysUsed++;
                }
            }
        }

        return bitmap;
    }
    //        int[] bitmap = new int[N];
//        for (int i = 0; i < N; i++) {
//            bitmap[i]  = 1; // array of N 1s : [1, 1, 1, ...., 1]
//        }
//
//        int keys = 0;
//        int keysUsed = 0;
//
//
//
//        for (int i = 0; i < N; i++) {
//            if (treasureExtractor.tryUnlockChest(bitmap) == true) {
//                bitmap[i] = 0;
//            } else {
//                bitmap[i]= 0;
//                bitmap[i-1] = 1;
//                }
//            }
//        return bitmap;
}
