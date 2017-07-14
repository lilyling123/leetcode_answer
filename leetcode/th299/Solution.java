package th299;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        int[] numbers = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) bulls++;
            else {
                if (numbers[secret.charAt(i) - '0']++ < 0) cows++;
                if (numbers[guess.charAt(i) - '0']-- > 0) cows++;
            }
        }
        return bulls + "A" + cows + "B";

    }

    public static void main(String[] args) {
        System.out.println(new Solution().getHint("1122", "1222"));
    }
}