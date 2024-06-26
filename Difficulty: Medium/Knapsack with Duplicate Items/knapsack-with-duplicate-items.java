//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String line1[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(line1[0]);
            int W = Integer.parseInt(line1[1]);
            String line2[] = in.readLine().trim().split("\\s+");
            int val[] = new int[N];
            for(int i = 0;i < N;i++)
                val[i] = Integer.parseInt(line2[i]);
            String line3[] = in.readLine().trim().split("\\s+");
            int wt[] = new int[N];
            for(int i = 0;i < N;i++)
                wt[i] = Integer.parseInt(line3[i]);
                
            Solution ob = new Solution();
            System.out.println(ob.knapSack(N, W, val, wt));
        }
    }
}
// } Driver Code Ends

 
//User function Template for Java

class Solution{
    static int knapSack(int N, int W, int val[], int wt[])
    {
        int[] prev = new int[W+1];
        
        for(int w = wt[0] ; w <= W ; w++){
            prev[w] = ((int) w / wt[0]) * val[0];
        }
        
        for(int ind = 1 ; ind < N ; ind++){
            int[] curr = new int[W+1];
            for(int w = 0 ; w <= W ; w++){
                int notTake = prev[w];
                int take = Integer.MIN_VALUE;
                if(w >= wt[ind]) take = val[ind] + curr[w - wt[ind]];
                curr[w] = Math.max(take, notTake);
            }
            prev = curr;
        }
        
        return prev[W];
    }
}