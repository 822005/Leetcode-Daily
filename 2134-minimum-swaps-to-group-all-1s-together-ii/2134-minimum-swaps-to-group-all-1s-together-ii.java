class Solution {
    public int minSwaps(int[] nums) {
        int k = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                k += 1;
            }
        }
        
        int low = 0;
        int high = 0;
        int sum = 0;
        int maxc = 0;
        while (high < n + k) {
            if (high - low + 1 < k) { 
                sum += nums[high];
                high += 1;
            } else { 
                sum += nums[high % n];
                maxc = Math.max(sum, maxc);
                sum -= nums[low % n]; 
                high += 1;
                low += 1;
            }
        }
        
        // min swaps required
        return k - maxc;
    }
}
