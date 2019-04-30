package dynamicprogramming;

public class DistinctSubArrays {
    public static void main(String[] args) {
        DistinctSubArrays d = new DistinctSubArrays();
        int a[] = {6,5,3,8,1};
        int k = 2;
        System.out.println(d.distinctSubArraysWithAtmostKOddElements(a, k));
    }

    public int distinctSubArraysWithAtmostKOddElements(int[] a, int k) {
        int l = a.length;
        int[][] dp = new int[k + 1][l];

        for (int j = 0; j < l; j++) {
            dp[0][j] = a[j] % 2 == 0 ? 1 : 0;
        }

        for (int i = 1; i <= k; i++) {
            dp[i][0] = 1;
        }

        for (int j = 1; j <= k; j++) {
            for (int i = 1; i < l; i++) {
                if (a[i] % 2 == 0) {
                    dp[j][i] = Math.max(dp[j - 1][i], 1 + Math.max(dp[j - 1][i - 1], dp[j][i - 1]));
                } else {
                    dp[j][i] = Math.max(dp[j - 1][i], 1 + dp[j - 1][i - 1]);
                }
            }
        }

        int tot = 0;
        for (int i = 0; i < l; i++) {
            tot += dp[k][i];
        }

        return tot;
    }
}
