import java.util.Random;

/**
 * class NaiveKeysLowestCost
 *
 * @author Jeriel
 * Description: Naive algorithm that randomly picks k keys in an attempt to open the treasure chest
 */
public class NaiveKeysLowestCost implements IFindKeys {

    Random random = new Random();

    @Override
    public int[] findKeys(int N, int k, ITreasureExtractor treasureExtractor) {
        int[] bitmap = new int[N];
        for (int i = 0; i < bitmap.length; i ++) {
            bitmap[i] = 1; // array of N 1s : [1, 1, 1, ...., 1]
        }

        int keys = 0;
        int keysUsed = bitmap.length;

        for (int i = 0; i < bitmap.length; i++) {
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
}
