public class EditDistance {
    public static int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        
        // Initialize base cases
        for (int i = 0; i <= m; i++) dp[i][0] = i;
        for (int j = 0; j <= n; j++) dp[0][j] = j;
        
        // Fill DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1]; // Characters match, no operation needed
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], // Replace
                                   Math.min(dp[i - 1][j],      // Delete  
                                            dp[i][j - 1]));    // Insert
                }
            }
        }
        
        return dp[m][n];
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(minDistance("horse", "ros"));        // 3
        System.out.println(minDistance("intention", "execution")); // 5
        System.out.println(minDistance("", "abc"));             // 3
        System.out.println(minDistance("abc", "abc"));          // 0
        System.out.println(minDistance("sea", "eat"));          // 2
    }
}
