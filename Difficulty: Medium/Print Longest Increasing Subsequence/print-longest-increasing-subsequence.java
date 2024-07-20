//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            Solution obj = new Solution();
            ArrayList<Integer> ans = obj.longestIncreasingSubsequence(N, arr);
            for (int i = 0; i < ans.size(); i++) {
                System.out.print(ans.get(i) + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public ArrayList<Integer> longestIncreasingSubsequence(int n, int arr[]) {
        // Tabulation
        // O(N*N) O(2N)
        int[] dp=new int[n];
    Arrays.fill(dp,1);
    int[] hash=new int[n];
    Arrays.fill(hash,1);
    
    for(int i=0; i<=n-1; i++){
        
        hash[i] = i; // initializing with current index
        for(int prev_index = 0; prev_index <=i-1; prev_index ++){
            
            if(arr[prev_index]<arr[i] && 1 + dp[prev_index] > dp[i]){
                dp[i] = 1 + dp[prev_index];
                hash[i] = prev_index;
            }
        }
    }
    
    int ans = -1;
    int lastIndex =-1;
    
    for(int i=0; i<=n-1; i++){
        if(dp[i]> ans){
            ans = dp[i];
            lastIndex = i;
        }
    }
    
    ArrayList<Integer> temp=new ArrayList<>();
    temp.add(arr[lastIndex]);
    
    while(hash[lastIndex] != lastIndex){ // till not reach the initialization value
        lastIndex = hash[lastIndex];
        temp.add(arr[lastIndex]);    
    }
        // int[] dp = new int[n];
        // Arrays.fill(dp, 1);
        // int[] hash = new int[n];
        // Arrays.fill(hash, 1);
        
        // int maxi = -1;
        // int last_index = -1;
        
        // for(int ind = 0 ; ind < n ; ind++){
        //     hash[ind] = ind;
        //     for(int prev = 0 ; prev < ind-1 ; prev++){
        //         if(arr[prev] < arr[ind] && 1 + dp[prev] > dp[ind]){
        //             dp[ind] = 1 + dp[prev];
        //             hash[ind] = prev;
        //         }
        //     }
        //     if(dp[ind] > maxi){
        //         maxi = dp[ind];
        //         last_index = ind;
        //     }
        // }
        
        // ArrayList<Integer> lis = new ArrayList<>();
        // lis.add(arr[last_index]);
        
        // while(hash[last_index] != last_index){
        //     last_index = hash[last_index];
        //     lis.add(arr[last_index]);
        // }
        Collections.reverse(temp);
        return temp;
    }
}
