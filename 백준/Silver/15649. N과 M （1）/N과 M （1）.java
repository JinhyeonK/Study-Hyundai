import java.util.*;

public class Main {
    public static ArrayList<Integer> su = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m, n;
        m = sc.nextInt();
        n = sc.nextInt();
        choose(0, n, m);
        sc.close();
    }

    public static void choose(int depth, int nn, int mm) {
        if (depth == nn) {
            printsu();
            return;
        }
        for (int i = 1; i <= mm; i++) {
            if (!su.contains(i)) { 
                su.add(i);
                choose(depth + 1, nn, mm);
                su.remove(su.size() - 1);
            }
        }
    }

    public static void printsu() {
        for (int num : su) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
