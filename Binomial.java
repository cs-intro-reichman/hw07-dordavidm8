/** Computes the binomial(n,k) function. */
public class Binomial {	
    public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int k = Integer.parseInt(args[1]);
		
	System.out.println(binomial(n, k));
	}

	public static int binomial1(int n, int k) { 
		if (k > n) {
		   	return 0; 
		}
		if (n == 0 || k == 0) {
		   	return 1; 
		}
		return binomial1(n - 1, k) + binomial1(n - 1, k - 1);

	 }
	

	

	public static long binomial(int n, int k) {
        if (k > n) return 0;
        if (k == 0 || n == 0) return 1;

        // מערך הזיכרון הופך ל-long כדי לתמוך בתוצאות גדולות
        long[][] memo = new long[n + 1][k + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                memo[i][j] = -1;
            }
        }
        return binomial(n, k, memo);
    }

    // פונקציית העזר הרקורסיבית - שונתה ל-long
    private static long binomial(int n, int k, long[][] memo) {
        if (memo[n][k] != -1) {
            return memo[n][k];
        }
        if (k > n) {
            memo[n][k] = 0; 
            return 0;
        }
        if (n == 0 || k == 0) {
            memo[n][k] = 1; 
            return 1;
        }
        
        // החישוב מתבצע כעת על long
        memo[n][k] = binomial(n - 1, k, memo) + binomial(n - 1, k - 1, memo);
        return memo[n][k];
    }
}



