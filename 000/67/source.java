class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();

        int aCursor = a.length() - 1;
        int bCursor = b.length() - 1;
        int left = 0;
        while ((aCursor >= 0) || (bCursor >= 0)) {
            int aValue = 0;
            if (aCursor >= 0) {
                aValue = a.charAt(aCursor) - '0';
            }
            int bValue = 0;
            if (bCursor >= 0) {
                bValue = b.charAt(bCursor) - '0';
            }

            int sum = aValue + bValue + left;
            left = sum / 2;
            sb.append(sum % 2);

            aCursor--;
            bCursor--;
        }

        if (left == 1) {
            sb.append('1');
        }

        return sb.reverse().toString();
    }
}