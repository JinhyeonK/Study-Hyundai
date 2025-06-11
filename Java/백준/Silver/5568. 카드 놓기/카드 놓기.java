import java.io.*;
import java.util.*;

public class Main {
    static int n, k;
    static String[] cards;
    static boolean[] visited;
    static HashSet<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        cards = new String[n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            cards[i] = br.readLine();
        }

        dfs(0, "");
        System.out.println(set.size());
    }

    static void dfs(int depth, String current) {
        if (depth == k) {
            set.add(current);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(depth + 1, current + cards[i]);
                visited[i] = false;
            }
        }
    }
}
