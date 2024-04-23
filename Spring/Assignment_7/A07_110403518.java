/*
Assignment 07
Name: 林晉宇
Student Number: 110403518
Course 2024-CE1002-3B
*/
// package assignment; 
// 本次作業可以不包package（package assignment 可寫可不寫） 4/22

import java.io.*;
import java.util.*;

public class A07_110403518 {
    public static void main(String[] args) {
        //step 1. 輸入資料夾名稱
        Scanner scanner = new Scanner(System.in);
        String folderName = scanner.nextLine();
        scanner.close();
        //step 2. 讀取資料夾內所有檔案，並存進ArrayList<String[][]>中
        ArrayList<String[][]> puzzles = new ArrayList<>();
        ArrayList<String[]> board = new ArrayList<>();
        for(int i = 0; i < 8; i++) {
            String[] row = new String[8];
            for(int j = 0; j < 8; j++) {
                row[j] = "0";
            }
            board.add(row);
        }
        File folder = new File(folderName);
        File[] files = folder.listFiles();
        for(File file : files)  {
            // readFile(file);
            String[][] puzzle = readFile(file);
            puzzles.add(puzzle);
        }
        //call writeFile
        String fileName = folderName + "_110403518.txt";
        writeFile(board, puzzles, fileName, 0);
    }

    public static Boolean checkLegal(ArrayList<String[]> board, String[][] puzzle, int x, int y) { // check if the puzzle can be placed on the board
        // System.out.println("x: " + x + " y: " + y);
        for(int i = 0; i < puzzle.length; i++){
            for(int j = 0; j < puzzle[i].length; j++){
                // if(x == 3 && y == 3)    System.out.print(puzzle[i][j] + " ");
                if(x + i >= 8 || y + j >= 8) return false;
                if(!board.get(x + i)[y + j].equals("0") && !puzzle[i][j].equals("0")) return false;
            }
        }
        return true;
    }

    public static void writeFile(ArrayList<String[]> board, ArrayList<String[][]> puzzles, String fileName, int count) {
        //函示中的傳入參數請勿修改或刪除，但可新增，函數回傳型別也可自行更改
        /*
         * @param board: the 8x8 board
         * @param fileName: the output file name
         * @param count: the number of puzzles you used
         */
        for(String[][] puzzle : puzzles) { // for each puzzle
            Boolean flag = false;
            for(int i = 0; i < 8; i++){ // for each row
                for(int j = 0; j < 8; j++){ // for each column
                    if(board.get(i)[j].equals("0") && checkLegal(board, puzzle, i, j)){ // if the puzzle can be placed on the board
                        count += 1;
                        flag = true;
                        for(int k = 0; k < puzzle.length; k++){
                            for(int l = 0; l < puzzle[k].length; l++){
                                if(board.get(i + k)[j + l].equals("0"))    board.get(i + k)[j + l] = puzzle[k][l];
                            }
                        }
                        break;
                    }
                    else    continue;
                }
                if(flag)    break;
            }
        }
        try {
            // write the txt file
            FileWriter writer = new FileWriter(fileName);
            if(count == 1)  writer.write("We use " + count + " piece of puzzle.\n");
            else    writer.write("We use " + count + " pieces of puzzles.\n");
            for(int i = 0; i < 8; i++){
                for(int j = 0; j < 8; j++){
                    writer.write(board.get(i)[j] + ' ');
                }
                writer.write("\n");
            }
            writer.close();
        }
        catch (Exception e) {
            // print e.getMessage() here
            System.out.println(e.getMessage());
        }
    }

    private static String[][] readFile(File file) {
        //函示中的傳入參數請勿修改或刪除，但可新增，函數回傳型別也可自行更改
        /*
         * @param file: the txt file
         */
        String[][] puzzle = null;
        try {
            // read the txt file
            Scanner scanner = new Scanner(file);
            String fileContent = "";
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                line += "\n";
                fileContent += line;
            }
            String[] lines = fileContent.split("\n");
            puzzle = new String[lines.length][lines[0].split(" ").length];
            for(int i = 0; i < lines.length; i++){
                String[] row = lines[i].split(" ");
                for(int j = 0; j < row.length; j++){
                    puzzle[i][j] = row[j];
                }
            }
            scanner.close();
        }
        catch (Exception e) {
            // print e.getMessage() here
            System.out.println(e.getMessage());
        }
        return puzzle;
    }
}
