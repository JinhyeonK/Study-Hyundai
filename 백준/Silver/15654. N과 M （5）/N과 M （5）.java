import java.util.*;
import java.io.*;

public class Main {
    public static ArrayList<Integer> arr = new ArrayList<>();
    public static int[] a;
    public static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        a = new int[n];
        st = new StringTokenizer(br.readLine()); // 새 줄 입력

        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(a);
        choose(0);
    }

    public static void choose(int depth) {
        if (depth == m) {
            printArr();
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!arr.contains(a[i])) {
                arr.add(a[i]);
                choose(depth + 1);
                arr.remove(arr.size() - 1);
            }
        }
    }

    public static void printArr() {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
