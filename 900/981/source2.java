import java.util.HashMap;
import java.util.Map.Entry;
import java.util.TreeMap;

class TimeMap {
    private HashMap<String, TreeMap<Integer, String>> mValues = new HashMap<>();

    public TimeMap() {
    }

    public void set(String key, String value, int timestamp) {
        TreeMap<Integer, String> values = mValues.computeIfAbsent(key, s -> new TreeMap<>());
        values.put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        TreeMap<Integer, String> values = mValues.get(key);
        if (values == null) {
            return "";
        }
        Entry<Integer, String> entry = values.floorEntry(timestamp);
        if (entry != null) {
            return entry.getValue();
        } else {
            return "";
        }
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
