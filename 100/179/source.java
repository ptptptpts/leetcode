import java.util.Arrays;

class Solution {
    public String largestNumber(int[] nums) {
        String[] objNums = new String[nums.length];
        for (int cursor = 0; cursor < nums.length; cursor++) {
            objNums[cursor] = String.valueOf(nums[cursor]);
        }

        Arrays.sort(objNums, (a, b) -> {
            String ab = a + b;
            String ba = b + a;
            return ab.compareTo(ba) * -1;
        });

        if (objNums[0].equals("0")) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (String num : objNums) {
            sb.append(num);
        }
        return sb.toString();
    }
}
