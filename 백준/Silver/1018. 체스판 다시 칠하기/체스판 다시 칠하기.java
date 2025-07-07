import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] board = new char[N][M];
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        int minRepaints = 64; // 8x8 체스판의 최대 칸 수

        // 모든 시작점을 기준으로 8x8 체스판을 검사
        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                minRepaints = Math.min(minRepaints, calculateRepaints(board, i, j));
            }
        }
        System.out.println(minRepaints);
    }

    // 특정 8x8 부분의 최소 다시 칠할 개수 계산
    public static int calculateRepaints(char[][] board, int startRow, int startCol) {
        String[] chessPatterns = {"WBWBWBWB", "BWBWBWBW"};
        int repaintCount1 = 0; // 'W'로 시작하는 패턴
        int repaintCount2 = 0; // 'B'로 시작하는 패턴

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                char expectedChar1 = chessPatterns[i % 2].charAt(j);
                char expectedChar2 = chessPatterns[(i + 1) % 2].charAt(j);

                if (board[startRow + i][startCol + j] != expectedChar1) {
                    repaintCount1++;
                }
                if (board[startRow + i][startCol + j] != expectedChar2) {
                    repaintCount2++;
                }
            }
        }
        return Math.min(repaintCount1, repaintCount2);
    }
}