package homework_sample_code;
import java.util.*;

public class sample_assignment03 {
    public static ArrayList<int[]> domain = new ArrayList<int[]>();
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt(), m = scn.nextInt();
        int[] hacker = new int[n];
        
        for(int i = 0; i < hacker.length; i++) hacker[i] = scn.nextInt();
        for(int i = 0; i < m; i++) {
            int[] temp = new int[n];
            for(int j = 0; j < n; j++) temp[j] = scn.nextInt();
            domain.add(temp);
        }
        char method = scn.next().charAt(0);
        scn.close();
        if(method == 'A') System.out.println("At most " + hacking_data_A(domain, hacker) + " count.");
        else if(method == 'B') System.out.println("At most " + hacking_data_B(domain, hacker) + " value.");
        printDomain();
    }


    // 入侵方法A：最多資料個數
    public static int hacking_data_A(ArrayList<int[]> original_domain, int[] hacker) {
        /*
        @param original_domain: 駭客入侵前的原始網域
        @hacker: 駭客電腦資料
        @return: 駭到的最多資料數 count
        */
        // TODO
        int maxCount = -1, position = -1;
        for(int i = 0; i < original_domain.size() + 1; i++){
            original_domain.add(i, hacker);
            for(int j = 0; j < original_domain.get(i).length; j++) {
                if(original_domain.get(i)[j] != 0) continue;
                else {
                    original_domain.get(i)[j] = 1;
                    int temp = longestPath(original_domain, i, j) - 1;
                    if(maxCount < temp) {
                        maxCount = temp;
                        position = i;
                    }
                    original_domain.get(i)[j] = 0;
                }
            }
            original_domain.remove(i);
        }
        original_domain.add(position, hacker);
        return maxCount;
    }

    

    public static int findLongestPath(ArrayList<int[]> original_domain, boolean[][] visited, int row, int col, int length) {
        if (!isValidMove(original_domain, visited, row, col)) {
            return length;
        }
        visited[row][col] = true;
        int right = findLongestPath(original_domain, visited, row, col + 1, length + 1);
        int down = findLongestPath(original_domain, visited, row + 1, col, length + 1);
        int left = findLongestPath(original_domain, visited, row, col - 1, length + 1);
        int up = findLongestPath(original_domain, visited, row - 1, col, length + 1);
        
        visited[row][col] = false;
        return Math.max(Math.max(up, down), Math.max(left, right));
    }

    public static int longestPath(ArrayList<int[]> original_domain, int row, int col) {
        int rows = original_domain.size();
        int cols = original_domain.get(0).length;
        boolean[][] visited = new boolean[rows][cols];
        return findLongestPath(original_domain, visited, row, col, 0);
    }

    // 入侵方法B：最高資料總價值
    public static int hacking_data_B(ArrayList<int[]> original_domain, int[] hacker) {
        /*
        @param original_domain: 駭客入侵前的原始網域
        @hacker: 駭客電腦資料
        @return: 駭到的最高資料總價值 value
        */
        // TODO

        int maxValue = -1, position = -1;
        for(int i = 0; i < original_domain.size() + 1; i++){
            original_domain.add(i, hacker);
            for(int j = 0; j < original_domain.get(i).length; j++) {
                if(original_domain.get(i)[j] != 0) continue;
                else {
                    original_domain.get(i)[j] = 1;
                    int temp = highestValuePath(original_domain, i, j) - 1;
                    if(maxValue < temp) {
                        maxValue = temp;
                        position = i;
                    }
                    original_domain.get(i)[j] = 0;
                }
            }
            original_domain.remove(i);
        }
        original_domain.add(position, hacker);
        
        return maxValue;
    }
    public static boolean isValidMove(ArrayList<int[]> original_domain, boolean[][] visited, int row, int col) {
        int rows = original_domain.size();
        int cols = original_domain.get(0).length;
        return row >= 0 && row < rows && col >= 0 && col < cols && original_domain.get(row)[col] != 0 && !visited[row][col];
    }
    public static int findHighestValuePath(ArrayList<int[]> original_domain, boolean[][] visited, int row, int col, int sum) {
        if (!isValidMove(original_domain, visited, row, col)) {
            return sum;
        }
        visited[row][col] = true;
        int currentValue = original_domain.get(row)[col];
        int right = findHighestValuePath(original_domain, visited, row, col + 1, sum + currentValue);
        int down = findHighestValuePath(original_domain, visited, row + 1, col, sum + currentValue);
        int left = findHighestValuePath(original_domain, visited, row, col - 1, sum + currentValue);
        int up = findHighestValuePath(original_domain, visited, row - 1, col, sum + currentValue);
        visited[row][col] = false;
        return Math.max(Math.max(up, down), Math.max(left, right));
    }

    public static int highestValuePath(ArrayList<int[]> original_domain, int row, int col) {
        int rows = original_domain.size();
        int cols = original_domain.get(0).length;
        boolean[][] visited = new boolean[rows][cols];
        return findHighestValuePath(original_domain, visited, row, col, 0);
    }

    // 印出結果
    public static void printDomain() {
        /*
        @return: 印出整個網域，數值與數值之間以空格區隔
        */
        // TODO
        for(int i = 0; i < domain.size(); i++) {
            for(int j = 0; j < domain.get(i).length; j++) {
                System.out.print(domain.get(i)[j] + " ");
            }
            System.out.println();
        }
    }
}