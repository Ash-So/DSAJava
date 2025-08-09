// User function Template for Java
class Solution {
    public static int[] productExceptSelf(int arr[]) {
        // code here
        // [10,   30, 150, 900, 1800]
        // [1800, 180, 60,  12, 2]
        // [180,  600, 360, 300, 900]
        
        int[] res = new int[arr.length];
        int[] fwd = new int[arr.length];
        int[] bwd = new int[arr.length];
        int n = arr.length;
        int f = 1, b = 1;
        
        for(int i = 0 ; i < n ; i++){
            fwd[i] = arr[i] * f;
            f = fwd[i];
        }
        
        for(int i = n - 1 ; i >= 0 ; i--){
            bwd[i] = arr[i] * b;
            b = bwd[i];
        }
        
        res[0] = bwd[1];
        res[n-1] = fwd[n-2];
        for(int i = 1 ; i < n - 1 ; i++){
            res[i] = fwd[i - 1] * bwd [i + 1];
        }
        
        return res;
    }
}
