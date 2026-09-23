 class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> ans = new ArrayList<>();

        if (intervals.length == 0) {
            return new int[][] { newInterval };
        }

        boolean insert = false;
     
        for(int i =0; i<intervals.length; i++){

            int start = intervals[i][0]; 
           
            if(insert == false && start>= newInterval[0]) {
                ans.add(newInterval);
                insert = true;
            }
        ans.add(intervals[i]);
        }

        if (!insert) {
            ans.add(newInterval);
        }

        int[][] arr = ans.toArray(new int[ans.size()][]);

        Arrays.sort(arr, (a,b)->a[0] - b [0]);
        int start1 = arr[0][0];
        int end1 = arr[0][1];

        List <int[]> res = new ArrayList<>();

        for(int i = 1; i<arr.length; i++){

            int start2 = arr[i][0];
            int end2 = arr[i][1];

            if( end1 >= start2){

            start1 = start1;
            end1 = Math.max(end1, end2);
            continue;
            }
            res.add(new int[] {start1, end1});

            start1 = start2;
            end1 = end2;
        }

        res.add(new int[]{start1, end1});
        return res.toArray(new int[res.size()][]);

        }
}