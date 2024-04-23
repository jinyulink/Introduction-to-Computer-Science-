package assignment;
/*
 * Assignment 07
 * Name: 李倬安
 * Student Number: 110403516
 * Course 2024-CE1002-資工3A
 */
import java.io.*;
import java.util.*;

public class A07_110403516 {
    // create a class to store the puzzle
    public static class puzzle {
        public ArrayList<String[]> board = new ArrayList<String[]>();

        public puzzle(ArrayList<String[]> board) {
            this.board = board;// set the board
        }

        public ArrayList<String[]> getBoard() {
            return board;// get the board
        }

        public int getrow() {
            return board.size();// get the row
        }

        public int getcol() {
            return board.get(0).length;// get the column
        }
    }

    private static ArrayList<puzzle> puzzlelist = new ArrayList<puzzle>();// create a list to store the puzzle
    private static int count = 0;// set a variable to store the count of the puzzle

    public static void writeFile(ArrayList<String[]> finalboard, String fileName, int count) {
        boolean flag = false;// set a flag to check if the puzzle can be placed
        boolean boolexception = false;// set a flag to check if the exception is thrown
        for (int h = 0; h < puzzlelist.size(); h++) {
            for (int i = 0; i < 8; i++) {// loop to check if the puzzle can be placed
                for (int j = 0; j < 8; j++) {
                    boolexception = false;
                    flag = false;
                    try {
                        if (finalboard.get(i)[j].equals("0")) {// check if the position is empty
                            for (int k = i; k < i + puzzlelist.get(h).getrow(); k++) {
                                for (int l = j; l < j + puzzlelist.get(h).getcol(); l++) {
                                    if (!puzzlelist.get(h).getBoard().get(k - i)[l - j].equals("0")) {// check if the puzzle is empty
                                        if (finalboard.get(k)[l].equals("0")) {
                                            flag = true;
                                        } else {
                                            flag = false;
                                            break;
                                        }
                                    }
                                }
                                if (!flag) {
                                    break;// if the puzzle can't be placed, break the loop
                                }
                            }
                            if (flag) {
                                for (int m = i; m < i + puzzlelist.get(h).getrow(); m++) {
                                    for (int n = j; n < j + puzzlelist.get(h).getcol(); n++) {
                                        if (puzzlelist.get(h).getBoard().get(m - i)[n - j].equals("0")) {// check if the puzzle is not empty,so can place in finalboard
                                            continue;
                                        }
                                        finalboard.get(m)[n] = puzzlelist.get(h).getBoard().get(m - i)[n - j];// place the puzzle in the finalboard
                                    }
                                }
                                count++;// add the count
                                break;
                            }
                        }
                    } catch (Exception e) {
                        boolexception = true;
                        System.out.println("hi " + e.getMessage() + " " + h + " " + i + " " + j);// print the exception message
                    }
                }
                if (flag && !boolexception) {
                    break;// if the puzzle can be placed, and the exception is not thrown, break the loop
                }
            }
        }
        try {
            FileWriter fw = new FileWriter(fileName);// write the finalboard to the file
            fw.write("We use " + count + " pieces of puzzles.\n");
            for (int i = 0; i < finalboard.size(); i++) {
                for (int j = 0; j < finalboard.get(i).length; j++) {
                    fw.write(finalboard.get(i)[j] + " ");
                }
                fw.write("\n");
            }
            fw.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());// print the exception message
        }
    }

    private static void readFile(File file) {
        ArrayList<String[]> board = new ArrayList<String[]>();
        try {
            Scanner sc = new Scanner(file);// read the file
            while (sc.hasNextLine()) {
                String[] row = sc.nextLine().split(" ");
                board.add(row);
            }
            puzzle p = new puzzle(board);// create a puzzle
            puzzlelist.add(p);// add the puzzle to the list
            sc.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());// print the exception message
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String folder = sc.next();
        File file = new File(folder);// read the folder
        File[] files = file.listFiles();// read the files in the folder
        for (File f : files) {// loop to read the files
            if (f.isFile()) {
                readFile(f);
            }
        }
        ArrayList<String[]> finalboard = new ArrayList<String[]>();
        for (int i = 0; i < 8; i++) {
            finalboard.add(new String[] { "0", "0", "0", "0", "0", "0", "0", "0" });// create the finalboard with 8*8
        }
        String filename = folder + "_110403516.txt";// set the filename
        writeFile(finalboard, filename, count);// write the finalboard to the file
        sc.close();
    }
}
