class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int start = 0;
        int end = 0;
        double sum = 0;
        double maxAvg = Double.NEGATIVE_INFINITY;

     
        while (end < nums.length) {
            sum += nums[end];
            
            if (end - start + 1 < k) {
                end++;
            } else {
                double avg = sum / k;
                maxAvg = Math.max(maxAvg, avg);
                
                sum -= nums[start];
                start++;
                end++;
            }
        }

        return maxAvg;
    }
}
