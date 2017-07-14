package th605;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) {
            return true;
        }
        int m = flowerbed.length;
        if ((m + 1) / 2 < n) {
            return false;
        }

        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 1) {
                continue;
            } else if ((i > 0 && flowerbed[i - 1] == 1) || (i < flowerbed.length - 1 && flowerbed[i + 1] == 1)) {
                continue;
            } else {
                n--;
                flowerbed[i] = 1;
                if (n == 0)
                    return true;
            }

        }


        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().canPlaceFlowers(new int[]{0, 0, 0, 0, 0, 0, 0}, 2));
    }
}