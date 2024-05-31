class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // O(n) O(1)
        int n = gas.length;
        int sumg = 0, sumc = 0;
        for(int i = 0 ; i < n ; i++){
            sumg += gas[i];
            sumc += cost[i];
        }
        if(sumg < sumc) return -1;
        
        int total = 0, start = 0;
        for(int i = 0 ; i < n ; i++){
            total += (gas[i] - cost[i]);
            
            if(total < 0){ 
                total = 0;
                start = i+1;
            }
        }
        return start;
    }
}