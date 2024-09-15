class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        // O(n) O(1)
        int len = flowerbed.length;

        for (int i = 0; i < len; i++) {
            if (n == 0)
                return true;

            if (flowerbed[i] == 0) {
                int prev = (i == 0) ? 0 : flowerbed[i - 1];
                int next = (i == len - 1) ? 0 : flowerbed[i + 1];

                if (prev == 0 && next == 0) {
                    flowerbed[i] = 1;
                    n--;
                }
            }

        }

        return n == 0;
    }
}