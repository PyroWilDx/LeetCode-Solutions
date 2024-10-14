import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> bankSet = new HashSet<>();
        for (String mut : bank) {
            bankSet.add(mut);
        }

        if (!bankSet.contains(endGene)) {
            return -1;
        }

        Deque<Mutation> deque = new ArrayDeque<>();
        deque.addLast(new Mutation(startGene, 0));
        while (!deque.isEmpty()) {
            Mutation mutation = deque.removeFirst();
            if (mutation.mut.equals(endGene)) {
                return mutation.mutCount;
            }

            String[] combs = getCombinations(mutation.mut);
            for (String comb : combs) {
                if (bankSet.contains(comb)) {
                    deque.addLast(new Mutation(comb, mutation.mutCount + 1));
                    bankSet.remove(comb);
                }
            }
        }
        return -1;
    }

    public String[] getCombinations(String mut) {
        String[] result = new String[32];
        int k = 0;
        for (int i = 0; i < 8; i++) {
            String start = mut.substring(0, i);
            String end = mut.substring(i + 1, mut.length());
            result[k++] = start + "A" + end;
            result[k++] = start + "C" + end;
            result[k++] = start + "G" + end;
            result[k++] = start + "T" + end;
        }
        return result;
    }

    public class Mutation {
        public String mut;
        public int mutCount;

        public Mutation(String mut, int mutCount) {
            this.mut = mut;
            this.mutCount = mutCount;
        }
    }
}
