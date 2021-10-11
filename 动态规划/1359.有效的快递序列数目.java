import java.io.PushbackReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jdk.internal.net.http.frame.PushPromiseFrame;

/*
 * @lc app=leetcode.cn id=1359 lang=java
 *
 * [1359] 有效的快递序列数目
 */

// @lc code=start
class Solution {
    public int countOrders(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++)
            result = result * getC(i * 2) % (1000000000 + 7);
        return (int) result % (1000000000 + 7);
    }
    //找规律：countOrders(n)和countOrders(n-1)中间差C(n,2)倍
    //因为，countOrders(n)任意取走两个之后，剩下的情况就跟countOrders(n-1)是相同的。  
    //问题在于，任意拿走两个的话，有一半的情况是不满足快递要求的，所以要除以2
    //因此通过dp得到该解

    public int getC(int n){
        int result = 1;
        for(int i = 0;i < 2;i++)
            result *= n--;
        return result/2;
    }
    
}
// @lc code=end

