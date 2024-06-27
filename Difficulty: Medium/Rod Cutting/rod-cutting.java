//{ Driver Code Starts
import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[])throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        
        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(s[i]);

            Solution ob = new Solution();
            out.println(ob.cutRod(arr, n));
        }
        out.close();
    }
}

// } Driver Code Ends

 
class Solution{
    // O() O()
    public int cutRod(int price[], int n) {
        int[] prev = new int[n + 1];
        
        //base condition if ind = 0
        for(int N = 0 ; N <= n ; N++){
            prev[N] = N * price[0];
        }
        
        for(int ind = 1 ; ind < n ; ind++){
            int[] curr = new int[n + 1];
            for(int N = 0 ; N <= n ; N++){
                int notTake = prev[N];
                int take = Integer.MIN_VALUE;
                int rodLength = ind + 1;
                if(N >= rodLength) take = price[ind] + curr[N - rodLength];
                curr[N] = Integer.max(take, notTake);
            }
            prev = curr;
        }
        
        return prev[n];
    }
}