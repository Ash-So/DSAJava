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
            int [][]points=new int[N][3];
            for(int i=0;i<N;i++){
                for(int j=0;j<3;j++){
                    points[i][j]=sc.nextInt();
                }
            }
            Solution obj=new Solution();
            int res=obj.maximumPoints(points,N);
            System.out.println(res);
            
        }
    }
}
// } Driver Code Ends

 
//User function Template for Java

class Solution{
    public int maximumPoints(int points[][],int n){
        // O(n*4*3) O(4)
        int[] prev = new int[4];
        prev[0] = Math.max(points[0][1], points[0][2]);
        prev[1] = Math.max(points[0][0], points[0][2]);
        prev[2] = Math.max(points[0][1], points[0][0]);
        prev[3] = Math.max(points[0][1], Math.max(points[0][2], points[0][0]));
        
        for(int day = 1; day < n ; day++){
            int[] temp = new int[4];
            
            for(int last =  0 ; last < 4 ; last++){
                temp[last] = 0;
                
                for(int task = 0; task < 3 ; task++){
                    if(task != last){
                        temp[last] = Math.max(temp[last], points[day][task] + prev[task]);
                    }
                }
            }
            
            prev = temp;
        }
        
        return prev[3];
    }
}
