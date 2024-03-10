class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend == (1<<31)  && divisor == -1) return Integer.MAX_VALUE;
        if(dividend == (1<<31)  && divisor == 1) return Integer.MIN_VALUE;
        
        int res = 0;
        int sign = (dividend>0) == (divisor>0) ? 1 : -1;
        int dd = Math.abs(dividend);
        int dv = Math.abs(divisor);
        
        while(dd-dv >= 0){
            int sum = dv, count = 1;
            while((dd-(sum<<1))>=0){
                sum <<= 1;
                count <<= 1;
            }
            res+=count;
            dd -= sum;
        }
        
        // if((dividend>0 && divisor<0) || (dividend<0 && divisor>0)) return (-res);
        return res*sign;
    }
}