package com.test.addition;

import java.util.Random;
import java.util.Scanner;

public class MineSweeper {

	int size = 10; // default size
    char[][] mines, board;
    boolean gameOver = false;
    boolean win = false;
    int selCnt = 0;

    public void initGame() {
		// TODO Auto-generated constructor stub

        mines = new char[size][size];
        board = new char[size][size];
        setMines();
        setNumbers();
        initBoard();
    }

    private void setMines() {
        Random r = new Random();
        int range = size * size;
        int ranNum;
        for (int i = 0; i < size; i++) {
            ranNum = r.nextInt(range);
            mines[ranNum / size][ranNum % size] = '*';
        }
    }

    private void setNumbers() {

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if(mines[i][j] != '*')
                    mines[i][j] = neighborMines(i, j);
            }
        }

    }

    public void initBoard(){
        for(int i=0 ; i<size ; i++)
            for(int j=0 ; j<size ; j++)
                board[i][j]= '-';
    }

    private char neighborMines(int c1, int c2) {

        int cnt=0;
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if((c1+i > -1 && c1+i < size) && (c2+j > -1 && c2+j < size) && mines[c1+i][c2+j] == '*'){
                    cnt++;
                }
            }
        }
        return (char)(cnt+'0');
    }

    public void drawBoard(){
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }

    public void setSelection(int r,int c){

        if(mines[r][c] == '*')
            gameOver = true;

        board[r][c] = mines[r][c];
        selCnt++;

        if(selCnt == (size*size)-size && !gameOver)
            win = true;
    }
    
    public void start() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Minesweeper Size:");
        size = scanner.nextInt();
        initGame();
        int row, col;
        while (!gameOver && !win) {

            System.out.println("Row:");
            row = scanner.nextInt();
            System.out.println("Col:");
            col = scanner.nextInt();

            this.setSelection(row,col);
            this.drawBoard();

        }

        if(win)
            System.out.println("You Won :)");
        else
            System.out.println("You Lost :(");

        scanner.close();
}
    
    public static void main(String[] args) {

        System.out.println("Game Started!");
        MineSweeper m = new MineSweeper();
        m.start();
        
        System.out.println("Game Ended!");
        System.out.println();
    }
}
