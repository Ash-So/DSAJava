//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Driverclass {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        // Reading total number of testcases
        int t = sc.nextInt();

        while (t-- > 0) {
            // reading the string
            String st = sc.next();

            // calling ispar method of Paranthesis class
            // and printing "balanced" if it returns true
            // else printing "not balanced"
            if (new Solution().isParenthesisBalanced(st) == true)
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
    }
}
// } Driver Code Ends



class Solution {
    // Function to check if brackets are balanced or not.
    static boolean isParenthesisBalanced(String s) {
        // code here
        Stack<Character> st = new Stack<>();
        char[] sarr = s.toCharArray();
        int c = 0;
        
        while(c != sarr.length){
            char ch  = sarr[c];
            
            if(ch == '{' || ch == '(' || ch == '['){
                st.push(ch);
            }
            
            if(ch == '}' || ch == ')' || ch == ']'){
                if(st.isEmpty()) return false;
                
                char t = st.pop();
                if((ch == '}' && t != '{') ||
                    (ch == ')' && t != '(') ||
                    (ch == ']' && t != '[')){
                    return false;
                }
            }
            
            c++;
        }
        return st.isEmpty();
    }
}
