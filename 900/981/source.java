import java.util.ArrayList;
import java.util.HashMap;

class TimeMap {
    private HashMap<String, ArrayList<Integer>> mTimestampStore = new HashMap<>();
    private HashMap<String, ArrayList<String>> mValueStore = new HashMap<>();

    /** Initialize your data structure here. */
    public TimeMap() {

    }

    public void set(String key, String value, int timestamp) {
        ArrayList<Integer> timestamps = mTimestampStore.computeIfAbsent(key, s -> new ArrayList<>());
        ArrayList<String> values = mValueStore.computeIfAbsent(key, s -> new ArrayList<>());

        timestamps.add(timestamp);
        values.add(value);
    }

    public String get(String key, int timestamp) {
        ArrayList<Integer> timestamps = mTimestampStore.get(key);

        if (timestamps == null) {
            return "";
        }
        if (timestamps.get(0) > timestamp) {
            return "";
        }

        int start = 0;
        int end = timestamps.size();
        while (start < (end - 1)) {
            int middle = (start + end) / 2;
            Integer middleTimestamps = timestamps.get(middle);
            if (middleTimestamps == timestamp) {
                start = middle;
                end = middle;
            } else if (middleTimestamps > timestamp) {
                end = middle;
            } else {
                start = middle;
            }
        }

        return mValueStore.get(key).get(start);
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */