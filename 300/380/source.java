import java.util.HashMap;
import java.util.Random;

class RandomizedSet {
    private HashMap<Integer, Integer> mMap = new HashMap<>();
    private int mSizeOfArray = 0;
    private int[] mArrayToRandom = new int[200000];
    private Random mRandom = new Random();

    /** Initialize your data structure here. */
    public RandomizedSet() {
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (mMap.containsKey(val)) {
            return false;
        } else {
            mMap.put(val, mSizeOfArray);
            mArrayToRandom[mSizeOfArray] = val;
            mSizeOfArray += 1;
            return true;
        }
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (mMap.containsKey(val)) {
            int pos = mMap.remove(val);
            mSizeOfArray -= 1;
            if (pos < mSizeOfArray) {
                mArrayToRandom[pos] = mArrayToRandom[mSizeOfArray];
                mMap.put(mArrayToRandom[pos], pos);
            }
            return true;
        } else {
            return false;
        }
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return mArrayToRandom[mRandom.nextInt(mSizeOfArray)];
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
