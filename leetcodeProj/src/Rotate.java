/**
 * @Description 旋转数组 url:https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2skh7/
 * @Author Lce
 * @Create 2021-12-01
 */
public class Rotate {

    public int profit;

    public static void main(String[] args) {

    }

    /**
     * 暴力算法（递归，如果数据过大会堆栈溢出）
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int len = prices.length;
        //数组长度不足2时收益为0
        if (len < 2) {
            return 0;
        }
        this.profit = 0;
        maxProfit(prices, 0, len, 0, profit);
        return 0;
    }

    /**
     * @param prices 价格数组
     * @param index  表示天数
     * @param len    数组长度
     * @param status 0-持有，1-不持有
     * @param profit 当前收益
     */
    private void maxProfit(int[] prices, int index, int len, int status, int profit) {
        if (index == len) {
            //代表最后一天
            this.profit = Math.max(this.profit, profit);
            return;
        }
        //与前一天状态相同时
        maxProfit(prices, index + 1, len, status, profit);
        //与前一天状态不同时
        if (status == 0) {
            //不持有->持有，买入操作，收益为当前收益-当天买入价格
            maxProfit(prices, index + 1, len, 1, profit - prices[index]);
        }
        if (status == 1) {
            //持有->不持有，卖出操作,收益为当前收益+当天卖出价格
            maxProfit(prices, index + 1, len, 0, profit + prices[index]);
        }
    }

    /**
     * 动态规划
     *
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        /*
            dp[i][0]:表示第i天不持有的最大收益，dp[i][1]:表示第i天持有的最大收益
         */
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        //i表示第几天,第0天已有数据，则从第一天开始
        for (int i = 1; i < n; i++) {
            //当天选择不持有时：前一天的状态若为不持有，则收益不变，若前一天状态为持有，则为卖出操作，选取两种情况中的最大值
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            //当天选择持有时：前一天的状态若为持有，则收益不变，若前一天状态为不持有，则为买入操作，选取两种情况中的最大值
            dp[i][0] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        /*
           最后一天有恒定dp[n-1][0]>dp[n-1][1]，不持有最大收益必大于持有最大收益，则直接返回dp[n-1][0]
         */
        return dp[n - 1][0];
    }

    /**
     * 贪心算法
     *
     * @param prices
     * @return
     */
    public int maxProfit3(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }
        int res = 0;
        //i表示第几天，从第0天开始
        for (int i = 1; i < len; i++) {
            //上一天买入，当天卖出
            int diff = prices[i] - prices[i - 1];
            if (diff > 0) {
                res += diff;
            }
        }
        return res;
    }
}
