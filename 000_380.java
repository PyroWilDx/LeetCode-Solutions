import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

class RandomizedSet {
    Map<Integer, Integer> idxMap;
    List<Integer> valList;
    Random rd;

    public RandomizedSet() {
        idxMap = new HashMap<>();
        valList = new ArrayList<>();
        rd = new Random();
    }

    public boolean insert(int val) {
        if (idxMap.containsKey(val)) {
            return false;
        }

        idxMap.put(val, valList.size());
        valList.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!idxMap.containsKey(val)) {
            return false;
        }

        int valIdx = idxMap.get(val);
        int lastIdx = valList.size() - 1;
        int lastValue = valList.get(lastIdx);
        valList.set(valIdx, lastValue);
        idxMap.put(lastValue, valIdx);

        valList.remove(valList.size() - 1);
        idxMap.remove(val);

        return true;
    }

    public int getRandom() {
        return valList.get(rd.nextInt(valList.size()));
    }
}
