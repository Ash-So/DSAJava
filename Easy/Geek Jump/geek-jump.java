//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG{
    public static void main(String args[]) throws IOException{
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int N=sc.nextInt();
            int []arr=new int[N];
            for(int i=0;i<N;i++){
                arr[i]=sc.nextInt();
                
            }
            Solution obj=new Solution();
            int res=obj.minimumEnergy(arr,N);
            System.out.println(res);
            
        }
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution{
    // Tabulation -> SPACE OPTIMIZATION
    public int minimumEnergy(int arr[],int n){
        // O(n) O(1)
        int prev = 0, prev2 = 0;
        
        for(int i = 1 ; i < n ; i++){
            int left = prev + Math.abs(arr[i] - arr[i-1]);
            int right = Integer.MAX_VALUE;
            if(i > 1) right = prev2 + Math.abs(arr[i] - arr[i-2]);
            
            int curr = Math.min(left, right);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
    
    // //Memoization DP
    // public int minimumEnergy(int arr[],int N){
    //     //O(n) O(n+n)
    //     int[] dp = new int[N];
    //     for(int i = 0 ; i < N ; i++){
    //         dp[i] = -1;
    //     }
        
    //     dp[0] = 0;
        
    //     for(int i = 1 ; i < N ; i++){
    //         int left = dp[i-1] + Math.abs(arr[i] - arr[i-1]);
    //         int right = Integer.MAX_VALUE;
    //         if(i > 1) right = dp[i-2] + Math.abs(arr[i] - arr[i-2]);
            
    //         dp[i] = Math.min(left, right);
    //     }
        
    //     return dp[N-1];
    // }
}