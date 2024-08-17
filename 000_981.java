import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class TimeMap {
    private HashMap<String, List<Pair>> hashMap;

    public TimeMap() {
        hashMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!hashMap.containsKey(key)) {
            hashMap.put(key, new ArrayList<>());
        }
        hashMap.get(key).add(new Pair(value, timestamp));
    }

    public String get(String key, int timestamp) {
        if (!hashMap.containsKey(key))
            return "";

        List<Pair> list = hashMap.get(key);
        final int N = list.size();
        if (list.get(0).timestamp > timestamp)
            return "";
        if (list.get(N - 1).timestamp <= timestamp)
            return list.get(N - 1).value;

        int left = 0;
        int right = N;
        while (left < right) {
            int mid = (left + right) / 2;
            if (list.get(mid).timestamp == timestamp)
                return list.get(mid).value;

            if (list.get(mid).timestamp < timestamp) {
                if (list.get(mid + 1).timestamp == timestamp)
                    return list.get(mid + 1).value;
                if (list.get(mid + 1).timestamp > timestamp)
                    return list.get(mid).value;

                left = mid;
            } else {
                right = mid;
            }
        }

        return list.get(left).value;
    }

    static class Pair {
        public String value;
        public int timestamp;

        public Pair(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }
}
