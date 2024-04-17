class Solution {
    public int hIndex(int[] citations) {
        int low = 0, high = citations.length;
        while(low < high){
            int mid = (low+high+1)/2;
            int c = 0;
            for(int i=0 ; i < citations.length ;i++){
                if(citations[i]>=mid) c++;
            }
            if(c>=mid) low =mid;
            else high = mid-1;
        }
        return low;
    }
}