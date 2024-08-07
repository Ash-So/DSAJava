//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.matrixMultiplication(N, arr));
        }
    }
}

// } Driver Code Ends

 
//User function Template for Java

class Solution{
    // // Memoization
    // static int f(int i, int j, int[] arr, int[][] dp){
    //     if(i == j) return 0;
    //     if(dp[i][j] != -1) return dp[i][j];
    //     int mini = Integer.MAX_VALUE;
    //     for(int k = i ; k < j ; k++){
    //         int steps = arr[i-1]*arr[k]*arr[j] + f(i, k, arr, dp) + f(k+1, j, arr, dp);
    //         mini = Math.min(mini, steps);
    //     }
        
    //     return dp[i][j] = mini;
    // }
    
    // // Recursion
    // // O(exponential) O(N)
    // static int f(int i, int j, int[] arr){
    //     if(i == j) return 0;
        
    //     int mini = Integer.MAX_VALUE;
    //     for(int k = i ; k < j ; k++){
    //         int steps = arr[i-1]*arr[k]*arr[j] + f(i, k, arr) + f(k+1, j, arr);
    //         mini = Math.min(mini, steps);
    //     }
        
    //     return mini;
    // }
    static int matrixMultiplication(int N, int arr[])
    {
        // Tabulation
        // O(N*N*N) O(N*N)
        int[][] dp = new int[N][N];
        
        for(int i = 1 ; i < N ; i++){
            dp[i][i] = 0;
        }
        
        for(int i = N-1 ; i >= 1 ; i--){
            for(int j = i+1 ; j < N ; j++){
                int mini = Integer.MAX_VALUE;
                for(int k = i ; k <= j-1 ; k++){
                    int steps = arr[i-1]*arr[k]*arr[j] + dp[i][k] + dp[k+1][j];
                    mini = Math.min(mini, steps);
                }
                dp[i][j] = mini;
            }
        }
        
        return dp[1][N-1];
        
        // // Recursion
        // int ans = f(1, N-1, arr);
        // return ans;
        
        // // Memoization
        // // O(N*N*N) O(N*N)+O(N)
        // int[][] dp = new int[N][N];
        // for(int[] row : dp){
        //     Arrays.fill(row, -1);
        // }
        // return f(1, N-1, arr, dp);
    }
}