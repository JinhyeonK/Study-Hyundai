import java.io.*;

public class Main {
    static int[][] dp = new int[41][2]; // dp[i][0]: 0의 출력 횟수, dp[i][1]: 1의 출력 횟수

    public static void main(String[] args) throws IOException {
        prepareDP(); // DP 테이블 미리 계산

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n][0]).append(" ").append(dp[n][1]).append("\n");
        }

        System.out.print(sb);
    }

    public static void prepareDP() {
        dp[0][0] = 1; // fibonacci(0) 호출 시 0 출력
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1; // fibonacci(1) 호출 시 1 출력

        for (int i = 2; i <= 40; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
            dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
        }
    }
}