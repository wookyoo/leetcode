class Solution {
    public int maxProfit(int[] prices) {
        int minBuy = prices[0];
        int maxProfit = 0;
        if(prices.length != 1) {
            for(int i = 1; i < prices.length; i++) {
                if(minBuy >= prices[i]) {
                    minBuy = prices[i];
                }
                else if(maxProfit < prices[i] - minBuy) {
                    maxProfit = prices[i] - minBuy;
                }
            }
        }
        return maxProfit;
    }
}

/*
 * 
 */

/*
Runtime
    Details
    1ms
    Beats 99.95% of users with Java
Memory
    Details
    58.61MB
    Beats 93.80% of users with Java
 */