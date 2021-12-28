package 数组.差分求区间重叠值;
/*
 * @lc app=leetcode.cn id=1943 lang=java
 *
 * [1943] 描述绘画结果
 */

// @lc code=start
class Solution {
    public List<List<Long>> splitPainting(int[][] segments) {
        List<List<Long>> result = new ArrayList<>();
        int maxNum = 0;
        for(int i = 0 ; i < segments.length; i++ ){
            maxNum = Math.max(segments[i][1],maxNum); //求最大区间右边界   
        }
        long[] helpList = new long[maxNum+1];
        long[] resultList = new long[maxNum];
        Map<Integer,Integer> hmap = new HashMap<>();
        for (int i = 0; i < segments.length; i++) {
            //这段函数本来是在一次循环中进行进入区间加和离开区间减的，
            //但是为了区分两端不同的线段，需要搞清楚线段之间的边界
            //因此这里先全部进行进入区间加
            //比如[[1,4,5],[1,4,7],[4,7,1],[4,7,11]]
            //其helpList循环后为[12,0,0,0,12,0,0,0,0]
            helpList[segments[i][0]-1] += segments[i][2];
            //helpList[segments[i][1]-1] -= segments[i][2];
        }
        for (int i = 0; i < segments.length; i++) {
            //然后这里进行离开区间减法，
            //循环后为[12,0,0,0,{0},0,0,0,-12]
            //注意，在这里，原来的12被减成0了，说明这边前后的两个线段的值是相等的，但是这依然是两条不同的线段
            //helpList[segments[i][0]-1] += segments[i][2];
            helpList[segments[i][1] - 1] -= segments[i][2];
            if (helpList[segments[i][1] - 1] == 0) {
                //这就是线段分界的地方
                hmap.put(segments[i][1] - 2, 1);//需要把这个分界的地方登记一下，在生成结果的时候，把这里分成两段线段生成
            }
        }
        long tempSum = 0;
        for(int i = 0; i < maxNum; i++){
            tempSum += helpList[i];
            resultList[i] = tempSum;
            //System.out.println(resultList[i]);
        }
        int begin = 0;
        int end = 0;
        for(int i = 0; i < maxNum-1 ; i++){
            if (resultList[i] == 0) {
                //刚开始为0，说明没有线段，不需要记录
                begin = i+1;
                end = i+1;
                continue;
            }else if((hmap.get(i) == null) && (i+1 != maxNum && resultList[i] == resultList[i+1])){
                //如果相等，还是在这个区间中
                continue;
            }else{
                //如果是线段分界线，也说明离开了这个区间
                //如果不等，说明离开了这个区间，需要记录一下
                end = i+1;
                List<Long> temp = new ArrayList<>();
                temp.add((long)begin+1);
                temp.add((long)end+1);
                temp.add((long)resultList[i]);
                begin = i+1;
                result.add(temp);
            }
        }
        return result;
    }
}
// @lc code=end

