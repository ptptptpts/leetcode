class Solution {
    public int romanToInt(String s) {
        int ret = 0;
        char prevRoman = ' ';

        for (int cursor = 0; cursor < s.length(); cursor++) {
            char c = s.charAt(cursor);
            switch (c) {
                case 'I':
                    ret += 1;
                    break;
                case 'V':
                    if (prevRoman == 'I') {
                        ret += 3;
                    } else {
                        ret += 5;
                    }
                    break;
                case 'X':
                    if (prevRoman == 'I') {
                        ret += 8;
                    } else {
                        ret += 10;
                    }
                    break;
                case 'L':
                    if (prevRoman == 'X') {
                        ret += 30;
                    } else {
                        ret += 50;
                    }
                    break;
                case 'C':
                    if (prevRoman == 'X') {
                        ret += 80;
                    } else {
                        ret += 100;
                    }
                    break;
                case 'D':
                    if (prevRoman == 'C') {
                        ret += 300;
                    } else {
                        ret += 500;
                    }
                    break;
                case 'M':
                    if (prevRoman == 'C') {
                        ret += 800;
                    } else {
                        ret += 1000;
                    }
                    break;
                default:
                    break;
            }
            prevRoman = c;
        }

        return ret;
    }
}
