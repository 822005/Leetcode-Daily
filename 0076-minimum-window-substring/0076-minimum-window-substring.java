class Solution {
    public boolean correct(int[] have, int[] needed) {
        for (int i = 0; i < 256; i++) {
            if (have[i] < needed[i]) {
                return false;
            }
        }
        return true;
    }

    public String minWindow(String s, String t) {
        int[] have = new int[256];
        int[] needed = new int[256];
        
        for (int i = 0; i < t.length(); i++) {
            needed[t.charAt(i)]++;
        }
        
        int low = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;
        
        for (int high = 0; high < s.length(); high++) {
            have[s.charAt(high)]++;
            
            while (correct(have, needed)) {
                int len = high - low + 1;
                if (minLen > len) {
                    minLen = len;
                    start = low;
                }
                have[s.charAt(low)]--;
                low++;
            }
        }
        
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}