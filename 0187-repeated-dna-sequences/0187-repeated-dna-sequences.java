class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        int n = s.length();
        // step 1:
        if (n <= 10) {
            return new ArrayList<>();
        }
        // step 2:
        Map<String, Integer> d = new HashMap<>();
        for (int i = 0; i <= n - 10; i++) {
            String key = s.substring(i, i + 10); // keeping a window of size 10
            if (!d.containsKey(key)) {
                d.put(key, 1);
            } else {
                d.put(key, d.get(key) + 1);
            }
        }
        // step 3:
        List<String> result = new ArrayList<>();
        for (String key : d.keySet()) {
            if (d.get(key) > 1) { // return all the repetitive strings
                result.add(key);
            }
        }
        return result;
    }
}
