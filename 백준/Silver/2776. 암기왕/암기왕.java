import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[] note1 = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                note1[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(note1); // 이분 탐색을 위해 정렬

            int M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                int target = Integer.parseInt(st.nextToken());
                sb.append(binarySearch(note1, target) ? "1\n" : "0\n");
            }
        }
        System.out.print(sb);
    }

    static boolean binarySearch(int[] arr, int key) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == key) return true;
            else if (arr[mid] < key) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }
}