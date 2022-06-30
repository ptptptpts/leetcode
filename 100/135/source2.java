class Solution {
    public int candy(int[] ratings) {
        if (ratings.length == 1) {
            return 1;
        }

        int result = 1;

        int upSlope = 0;
        int downSlope = 0;
        int previousSlope  = 0;
        int currentSlope = 0;
        for (int i = 1; i < ratings.length; i++) {
            currentSlope = (ratings[i] > ratings[i-1]) ? 1 :
                (ratings[i] < ratings[i-1]) ? -1 : 0;

            if (currentSlope == 1) {
                upSlope += 1;
            } else if (currentSlope == -1) {
                downSlope += 1;
            }
            
            if (previousSlope == 1) {
                if (currentSlope == 1) {
                    result += 1 + upSlope;
                } else if (currentSlope == 0) {
                    upSlope = 0;
                    downSlope = 0;
                    result += 1;
                } else if (currentSlope == -1) {
                    result += 1;
                }
            } else if (previousSlope == 0) {
                if (currentSlope == 1) {
                    result += 1 + upSlope;
                } else if (currentSlope == 0) {
                    result += 1;
                } else if (currentSlope == -1) {
                    result += 1 + downSlope;
                }
            } else if (previousSlope == -1) {
                if (currentSlope == 1) {
                    upSlope = 1;
                    downSlope = 0;
                    result += 1 + upSlope;
                } else if (currentSlope == 0) {
                    upSlope = 0;
                    downSlope = 0;
                    result += 1;
                } else if (currentSlope == -1) {
                    if (upSlope < downSlope) {
                        result += 1 + downSlope;
                    } else {
                        result += downSlope;
                    }
                }
            }
            
            previousSlope = currentSlope;
        }

        return result;
    }
}
