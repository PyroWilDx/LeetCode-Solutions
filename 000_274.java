class Solution {
    public int hIndex(int[] citations) {
        int lastH = -1;
        int minH = 0;
        int maxH = getMax(citations);
        while (minH < maxH) {
            int h = (maxH + minH) / 2;
            if (h == lastH) {
                if (isValidHIndex(citations, h + 1)) {
                    return h + 1;
                }
                return h;
            }

            boolean isValidHIndex = isValidHIndex(citations, h);
            if (isValidHIndex) {
                minH = h;
            } else {
                maxH = h;
            }
            lastH = h;
        }
        return minH;
    }

    public int getMax(int[] citations) {
        int result = 0;
        for (int citation : citations) {
            result = Math.max(result, citation);
        }
        return result;
    }

    public boolean isValidHIndex(int[] citations, int h) {
        int paperAmount = 0;
        for (int citation : citations) {
            if (citation >= h) {
                paperAmount++;
            }
        }
        return paperAmount >= h;
    }
}
