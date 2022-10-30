class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> combinationList = new ArrayList<String>();
        generateCombinations(combinationList, "", n, 0);
        return combinationList;
    }

    private void generateCombinations(List<String> results, String currentCombi, int opens, int closes) {
        if (opens > 0) {
            generateCombinations(results, currentCombi + "(", opens - 1, closes + 1);
            if (closes > 0) {
                generateCombinations(results, currentCombi + ")", opens, closes - 1);
            }
        } else {
            if (closes > 0) {
                generateCombinations(results, currentCombi + ")", opens, closes - 1);
            } else {
                results.add(currentCombi);
            }
        }
    }
}
