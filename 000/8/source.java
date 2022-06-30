class Solution {
    private static final long MAX_POSITIVE = 2147483647L;
    private static final long MAX_NEGATIVE = 2147483648L;

    private long mNumber = 0;
    private boolean mIsNegative = false;

    public int myAtoi(String s) {
        int cursor = 0;
        char[] cstr = s.toCharArray();
        
        cursor = skipReadingWhitespace(cstr, cursor);
        cursor = readSign(cstr, cursor);
        cursor = readDigit(cstr, cursor);

        return getConvertedInteger();
    }

    private int skipReadingWhitespace(char[] cstr, int cursor) {
        for (; cursor < cstr.length; cursor++) {
            if (cstr[cursor] != ' ') {
                break;
            }
        }

        return cursor;
    }

    private int readSign(char[] cstr, int cursor) {
        if (cursor < cstr.length) {
            if (cstr[cursor] == '+') {
                cursor++;
            } else if (cstr[cursor] == '-') {
                mIsNegative = !mIsNegative;
                cursor++;
            }
        }

        return cursor;
    }

    private int readDigit(char[] cstr, int cursor) {
        for (; cursor < cstr.length; cursor++) {
            if ((cstr[cursor] < '0') || (cstr[cursor] > '9')) {
                break;
            }
            if (mNumber > MAX_NEGATIVE) {
                break;
            }
            mNumber = (mNumber * 10) + (cstr[cursor] - '0');
        }

        return cursor;
    }

    private int getConvertedInteger() {
        if (mIsNegative) {
            if (mNumber >= MAX_NEGATIVE) {
                return (int) (MAX_NEGATIVE * -1);
            } else {
                return (int) mNumber * -1;
            }
        } else {
            if (mNumber >= MAX_POSITIVE) {
                return (int) MAX_POSITIVE;
            } else {
                return (int) mNumber;
            }
        }
    }
}