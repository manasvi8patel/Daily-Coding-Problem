/**
 * DCP : Problem #47 [Easy] This problem was asked by Facebook.
 * Given a array of numbers representing the stock prices of a company in chronological order, write a function that calculates the maximum profit you could have made from buying and selling that stock once. You must buy before you can sell it.
 * For example, given [9, 11, 8, 5, 7, 10], you should return 5, since you could buy the stock at 5 dollars and sell it at 10 dollars.
 */

// Time Complexity : O(n)
// Space Complexity : O(1)

public class StockSellOnce {
  public static void main(String[] args) {
    int[] stockPrices = {6, 2, 18, 21, 1, 15, 25};//{};//{9, 11, 8, 5, 7, 10};

    int result = calculateMaxProfit(stockPrices);
    System.out.println(result);
  }

  public static int calculateMaxProfit(int[] stockPrices)
  {
      int maxProfit = 0, minPrice = Integer.MAX_VALUE;

      for (int price : stockPrices)
      {
          // keeping track of minimum price seen so far
          minPrice = Math.min(minPrice, price);

          // updating maxProfit only if the difference between current price and minimum price is greater than previous maximum profit
          maxProfit = Math.max(maxProfit, price - minPrice);
      }
      return maxProfit;
  }
}
