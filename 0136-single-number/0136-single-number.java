class Solution {
    public int singleNumber(int[] nums) {
        // Initialize ans with the first element of the array
        int ans = nums[0];
        
        // Iterate through the rest of the array starting from index 1
        for (int i = 1; i < nums.length; i++) {
            ans ^= nums[i];
        }
        
        return ans;
    }
}