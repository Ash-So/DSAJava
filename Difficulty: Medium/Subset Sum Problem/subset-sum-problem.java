//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if(ob.isSubsetSum(N, arr, sum))
            System.out.println(1);
            else
            System.out.println(0);

            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{


    static Boolean isSubsetSum(int n, int arr[], int sum){
        // O(nk) O(k)
        boolean[] prev = new boolean[sum+1];
        for(int i = 0 ; i < sum+1 ; i++) prev[i] = false;
        
        prev[0] = true;
        
        if(arr[0] <= sum){
             prev[arr[0]] = true;   
        }
        
        for(int i = 1 ; i < n ; i++){
            boolean[] curr = new boolean[sum+1];
            curr[0] = true;
            for(int target = 1 ; target <= sum ; target++){
                boolean take = false;
                if(target >= arr[i]) take = prev[target-arr[i]];
                boolean notTake = prev[target];
                curr[target] = take | notTake;
            }
            prev = curr;
        }
        return prev[sum];
    }
}