class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] magCharCount = new int[256];
        for (int i = 0; i < magazine.length(); i++) {
            magCharCount[magazine.charAt(i)]++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            magCharCount[ransomNote.charAt(i)]--;
            if (magCharCount[ransomNote.charAt(i)] < 0) {
                return false;
            }
        }
        return true;
    }
}
