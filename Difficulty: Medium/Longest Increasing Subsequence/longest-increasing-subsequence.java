//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {

        // taking input using Scanner class
        Scanner sc = new Scanner(System.in);

        // taking total testcases
        int t = sc.nextInt();
        while (t > 0) {

            // taking size of array
            int n = sc.nextInt();
            int array[] = new int[n];

            // inserting elements in the array
            for (int i = 0; i < n; ++i) {
                array[i] = sc.nextInt();
            }

            // creating an object of class Solution
            Solution ob = new Solution();

            // calling longestSubsequence() method of class
            // Solution
            System.out.println(ob.longestSubsequence(n, array));
            t--;
        }
    }
}
// } Driver Code Ends




class Solution {
    // Function to find length of longest increasing subsequence.
    static int longestSubsequence(int n, int arr[]) {
        // Binary Search
        // O() O()
        List<Integer> temp = new ArrayList<>();
        temp.add(arr[0]);
        for(int i = 1 ; i < n ; i++){
            if(arr[i] > temp.get(temp.size()-1)){
                temp.add(arr[i]);
            }
            else{
                int ind = Collections.binarySearch(temp, arr[i]);
                if(ind < 0) ind = -ind - 1;
                temp.set(ind, arr[i]);
            }
        }
        return temp.size();
    }
}