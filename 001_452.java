import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        List<Set<String>> favoriteCompaniesSets = new ArrayList<>();
        for (List<String> favs : favoriteCompanies) {
            favoriteCompaniesSets.add(new HashSet<>(favs));
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < favoriteCompaniesSets.size(); i++) {
            if (!isSubSet(favoriteCompaniesSets, favoriteCompaniesSets.get(i))) {
                result.add(i);
            }
        }
        return result;
    }

    public boolean isSubSet(List<Set<String>> favoriteCompaniesSets, Set<String> favs) {
        for (Set<String> favsSet : favoriteCompaniesSets) {
            if (favs.size() >= favsSet.size()) {
                continue;
            }
            boolean isSubSet = true;
            for (String fav : favs) {
                if (!favsSet.contains(fav)) {
                    isSubSet = false;
                }
            }
            if (isSubSet) {
                return true;
            }
        }
        return false;
    }
}
