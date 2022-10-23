class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        boolean isPlaceAllFlowers = false;

        if (n == 0) {
            isPlaceAllFlowers = true;
        } else if (flowerbed != null) {
            if (flowerbed.length == 1) {
                if ((n == 1) && (flowerbed[0] == 0)) {
                    isPlaceAllFlowers = true;
                }
            } else if (flowerbed.length > 1) {
                int remainFlowers = n;

                if ((flowerbed[0] == 0) && (flowerbed[1] == 0)) {
                    if (remainFlowers > 1) {
                        flowerbed[0] = 1;
                        remainFlowers -= 1;
                    } else {
                        isPlaceAllFlowers = true;
                    }
                }
                if (!isPlaceAllFlowers) {
                    for (int cursor = 1; cursor < flowerbed.length - 1; cursor++) {
                        if ((flowerbed[cursor - 1] == 0)
                                && (flowerbed[cursor] == 0)
                                && (flowerbed[cursor + 1] == 0)) {
                            flowerbed[cursor] = 1;
                            remainFlowers -= 1;
                            if (remainFlowers == 0) {
                                isPlaceAllFlowers = true;
                                break;
                            }
                        }
                    }
                    if ((flowerbed[flowerbed.length - 2] == 0)
                            && (flowerbed[flowerbed.length - 1] == 0)
                            && (remainFlowers == 1)) {
                        isPlaceAllFlowers = true;
                    }
                }
            }
        }

        return isPlaceAllFlowers;
    }
}
