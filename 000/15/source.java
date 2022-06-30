import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int zeroCounter = 0;
        HashSet<Integer> negativeSet = new HashSet<>();
        HashSet<Integer> negativeDuplicateSet = new HashSet<>();
        HashSet<Integer> positiveSet = new HashSet<>();
        HashSet<Integer> positiveDuplicateSet = new HashSet<>();
        for (int num : nums) {
            if (num < 0) {
                if (!negativeSet.contains(num)) {
                    negativeSet.add(num);
                } else {
                    negativeDuplicateSet.add(num);
                }
            } else if (num > 0) {
                if (!positiveSet.contains(num)) {
                    positiveSet.add(num);
                } else {
                    positiveDuplicateSet.add(num);
                }
            } else {
                zeroCounter += 1;
            }
        }

        ArrayList<List<Integer>> ret = new ArrayList<>();

        if (zeroCounter >= 3) {
            ArrayList<Integer> innerRet = new ArrayList<>();
            innerRet.add(0);
            innerRet.add(0);
            innerRet.add(0);
            ret.add(innerRet);
        }
        
        if (zeroCounter > 0) {
            for (int negative : negativeSet) {
                if (positiveSet.contains(negative * -1)) {
                    ArrayList<Integer> innerRet = new ArrayList<>();
                    innerRet.add(0);
                    innerRet.add(negative);
                    innerRet.add(negative * -1);
                    ret.add(innerRet);
                }
            }
        }

        for (int negative : negativeDuplicateSet) {
            int sum = negative * -2;
            if (positiveSet.contains(sum)) {
                ArrayList<Integer> innerRet = new ArrayList<>();
                innerRet.add(negative);
                innerRet.add(negative);
                innerRet.add(sum);
                ret.add(innerRet);
            }
        }
        for (int positive : positiveDuplicateSet) {
            int sum = positive * -2;
            if (negativeSet.contains(sum)) {
                ArrayList<Integer> innerRet = new ArrayList<>();
                innerRet.add(positive);
                innerRet.add(positive);
                innerRet.add(sum);
                ret.add(innerRet);
            }
        }

        HashSet<Integer> negativeVisited = new HashSet<>();
        HashSet<Integer> positiveVisited = new HashSet<>();
        for (int negative : negativeSet) {
            negativeVisited.add(negative);

            positiveVisited.clear();
            for (int positive :positiveSet) {
                positiveVisited.add(positive);

                int sum = (negative + positive) * -1;
                boolean hasZero = false;
                
                if (sum > 0) {
                    if (!positiveVisited.contains(sum) && positiveSet.contains(sum)) {
                        hasZero = true;
                    }
                } else if (sum < 0) {
                    if (!negativeVisited.contains(sum) && negativeSet.contains(sum)) {
                        hasZero = true;
                    }
                }

                if (hasZero) {
                    ArrayList<Integer> innerRet = new ArrayList<>();
                    innerRet.add(sum);
                    innerRet.add(negative);
                    innerRet.add(positive);
                    ret.add(innerRet);
                }
            }
        }

        return ret;
    }
}
