package 动态规划;
import java.lang.invoke.ClassSpecializer.Factory;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=638 lang=java
 *
 * [638] 大礼包
 */

// @lc code=start
class Solution {
    public int result = Integer.MAX_VALUE;
    public int num = 0;
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        //动态规划
        //把单买的普通商品看成大礼包:[0,...1,0,price[i]],special是p[]
        //1.找状态：needs相当于个大礼包产品的组合
        //2.找状态转移方程 f(n) = min(f(n-a)+p[a],f(n-b)+p[b],f(n-c)+p[c])
        result = justMoney(price,needs);
        List<List<Integer>> newSpList = new ArrayList<>();
        for (int i = 0; i < special.size(); i++) {
            if (isCheaper(special.get(i), price)) {
                newSpList.add(special.get(i));//如果大礼包更加优惠，才考虑买大礼包
            }
        }
        for (int i = 0; i < price.size(); i++) {
            newSpList.add(paserSpecial(price.size(), price.get(i), i));
        }
        

        List<Integer> have = new ArrayList<>();
        for (int i = 0; i < needs.size(); i++) {
            have.add(0);
        }
        help(newSpList, needs, have, 0,0);
        return result;
    }

    public void help(List<List<Integer>> special, List<Integer> needs, List<Integer> have,int count,int startIndex) {
        int matchResult = matchNeeds(needs, have);
        if (matchResult == 0) {
            result = Math.min(result, count);
            return;
        } else if (matchResult == -1 || count >= result) {
            return;
        }
        for (int i = startIndex; i < special.size(); i++) {
            //加startIndex的原因是全排列中减少数字相同顺序不同的情况。
            //这道题本质上是对于大礼包产品进行全排列
            //全排列购买大礼包
            List<Integer> currentSp = special.get(i);
            List<Integer> haveUpdated = addSpecial(have, currentSp);
            int sPrice = currentSp.get(currentSp.size()-1);
            help(special, needs, haveUpdated, count+sPrice,i);
        }
    }

    public int matchNeeds(List<Integer> needs, List<Integer> have) {
        for (int i = 0; i < have.size(); i++) {
            if (have.get(i) > needs.get(i)) {
                //如果有的多于需要的
                return -1;
            }
        }
        for (int i = 0; i < have.size(); i++) {
            if (have.get(i) < needs.get(i)) {
                //如果有的少于需要的
                return 1;
            }
        }
        return 0;
    }

    public List<Integer> addSpecial(List<Integer> have, List<Integer> sp) {
        //给have添加一个礼包
        List<Integer> haveUpdated = new ArrayList<>();
        for (int i = 0; i < have.size(); i++) {
            haveUpdated.add(have.get(i) + sp.get(i));
        }
        return haveUpdated;
    }

    public boolean isCheaper(List<Integer> sp, List<Integer> price) {
        boolean result = false;
        int count = 0;
        for (int i = 0; i < price.size(); i++) {
            count += sp.get(i) * price.get(i);
        }
        return count > sp.get(sp.size() - 1);
    }
    public int justMoney(List<Integer>price,List<Integer> needs){
        //不用大礼包的价格
        int count = 0 ;
        for(int i = 0; i < needs.size();i++){
            count += needs.get(i)*price.get(i);
        }
        return count;
    }

    public List<Integer> paserSpecial(int length, int price,int index) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            if (i == index) {
                result.add(1);
            } else {
                result.add(0);
            }
        }
        result.add(price);
        return result;
    }
}
// @lc code=end

