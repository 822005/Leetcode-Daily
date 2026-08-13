class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int ans = n; // Start with n because the loop only goes up to n-1
        
        for (int i = 0; i < n; i++) {
            ans ^= i;       // XOR the index
            ans ^= nums[i]; // XOR the value
        }
        
        return ans;
    }
}