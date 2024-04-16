package midterm01;

import java.util.ArrayList;
import java.util.Scanner;

public class E02_110403518 {
    static int maxCount = 0;
    static int maxValue = 0;
    static int n, m;
    public static void main(String[] args) {
        // TODO
        // 基本上就是在輸入資料
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        int[] hacker = new int[n];
        for (int i = 0; i < n; i++) {
            hacker[i] = scanner.nextInt();
        }
        ArrayList<int[]> original_domain = new ArrayList<int[]>();
        for (int i = 0; i < m; i++) {
            int[] tmp = new int[n];
            for (int j = 0; j < n; j++) {
                tmp[j] = scanner.nextInt();
            }
            original_domain.add(tmp);
        }
        String method = scanner.next();
        while(!method.equals("END")){
            if(method.equals("A")) {
                hacking_data_A(original_domain, hacker);
            } else if(method.equals("B")) {
                hacking_data_B(original_domain, hacker);
            }
            method = scanner.next();
        }
    }

    public static int dfs(ArrayList<int[]> domain, boolean[][] visited, int i, int j, int count, int value, char method, int step) { // O(nm)
        // base case，如果超出邊界或是已經走過了，就return 0
        if (i < 0 || i >= domain.size() || j < 0 || j >= domain.get(i).length || visited[i][j] || (domain.get(i)[j] == 0 && step > 0)) {
            return 0;
        }
    
        visited[i][j] = true;
        count++;
        value += domain.get(i)[j];
    
        int result = method == 'A' ? count : value;
    
        // 遞迴
        result = Math.max(result, dfs(domain, visited, i - 2, j, count, value, method, step + 1)); // Up
        result = Math.max(result, dfs(domain, visited, i + 2, j, count, value, method, step + 1)); // Down
        result = Math.max(result, dfs(domain, visited, i, j - 1, count, value, method, step + 1)); // Left
        result = Math.max(result, dfs(domain, visited, i, j + 1, count, value, method, step + 1)); // Right
    
        visited[i][j] = false; // Backtrack
    
        return result;
    }

    // 入侵方法A：最多資料個數
    public static int hacking_data_A(ArrayList<int[]> original_domain, int[] hacker) {
        // TODO
        // 把hacker放進去，然後每次都跑一遍dfs，找出最大的count
        int maxRow = 0;
        int preMaxCount = 0;
        for (int row = 0; row <= original_domain.size(); row++) {
            ArrayList<int[]> domain = new ArrayList<>(original_domain);
            domain.add(row, hacker);
            for (int i = 0; i < hacker.length; i++) {
                if (hacker[i] == 0) {
                    boolean[][] visited = new boolean[domain.size()][hacker.length];
                    int result = dfs(domain, visited, row, i, -1, 0, 'A', 0);
                    maxCount = Math.max(maxCount, result);
                    if (result > preMaxCount) {
                        preMaxCount = result;
                        maxRow = row;
                    }
                }
            }
        }
        ArrayList<int[]> finalDomain = new ArrayList<>(original_domain);
        finalDomain.add(maxRow, hacker);
        System.out.println("At most " + maxCount + " count.");
        printDomain(finalDomain);
        return maxCount;
    }

    // 入侵方法B：最高資料總價值
    public static int hacking_data_B(ArrayList<int[]> original_domain, int[] hacker) {
        // TODO
        // 把hacker放進去，然後每次都跑一遍dfs，找出最大的value
        int maxRow = 0;
        int preMaxValue = 0;
        for (int row = 0; row <= original_domain.size(); row++) {
            ArrayList<int[]> domain = new ArrayList<>(original_domain);
            domain.add(row, hacker);
            for (int i = 0; i < hacker.length; i++) {
                if (hacker[i] == 0) {
                    boolean[][] visited = new boolean[domain.size()][hacker.length];
                    int result = dfs(domain, visited, row, i, 0, 0, 'B', 0);
                    maxValue = Math.max(maxValue, result);
                    if (result > preMaxValue) {
                        preMaxValue = result;
                        maxRow = row;
                    }
                }
            }
        }
        ArrayList<int[]> finalDomain = new ArrayList<>(original_domain);
        finalDomain.add(maxRow, hacker);
        System.out.println("At most " + maxValue + " value.");
        printDomain(finalDomain);
        return maxValue;
    }

    // 印出結果
    public static void printDomain(ArrayList<int[]> domain) {
        /*
        @return: 印出整個網域，數值與數值之間以空格區隔
        */
        // TODO
        for (int[] row : domain) {
            for (int i = 0; i < row.length; i++) {
                System.out.print(row[i]);
                if (i < row.length - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}