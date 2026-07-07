class Solution {
    public int minimumRecolors(String nums, int k) {
        int n = nums.length();
        int low = 0;
        int high = 0;
        int sum = 0; // number of W's in the current window
        int minc = Integer.MAX_VALUE;

        while (high < n) {
            // to get the first window
            if (high - low + 1 < k) {
                if (nums.charAt(high) == 'W') {
                    sum++;
                }
                high++;
            } 
            // once you get the k size window, maintain and shift it
            else {
                if (nums.charAt(high) == 'W') {
                    sum++;
                }
                minc = Math.min(sum, minc);
                if (nums.charAt(low) == 'W') {
                    sum--;
                }
                high++;
                low++;
            }
        }
        
        return minc;
    }
}
