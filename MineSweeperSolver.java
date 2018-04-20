package org.main;

import java.util.Scanner;

public class MineSweeperSolver {
	
	int row = 4;
	int col = 4;
	char [][] iparr ;
	
	public void start(){
	
		// Take user input
		
		Scanner scan=new Scanner(System.in);
		
		//System.out.println("Enter Row Size");
		row = scan.nextInt();
		
		//System.out.println("Enter Column Size");
		col = scan.nextInt();
		
		//System.out.println("Enter Matrix");
		iparr = new char[row][col];
		
		for (int i = 0; i < row; i++) {
	        String data = "";
	        if (scan.hasNext()) { // input from user 
	            data = scan.next();
	        } else {
	            break;
	        }
	        for (int j = 0; j < col; j++)
	            iparr[i][j] = data.charAt(j); 
	    }
		
		char [][] oparr = new char[row][col];
		
		for(int x = 0; x < row; x ++) {
		      for(int y = 0; y < col; y ++) {
		        if(iparr[x][y] != '*') {
		        	oparr[x][y] = minesNear(x, y);
		        }
		        else{
		        	oparr[x][y] = '*';
		        }
		      }
		 }
		
		drawMinefield(oparr);
		
	}
	
	 public void drawMinefield(char[][] oparr) {
		    for(int y = 0; y < row; y ++) {
		      for(int x = 0; x < col; x ++) {
		        System.out.print(oparr[y][x]);
		      }
		      System.out.print("\n");
		    }
	  }
	 
	 // returns 1 if there's a mine a y,x or 0 if there isn't
	  public int mineAt(int y, int x) {
	    // we need to check also that we're not out of array bounds as that would
	    // be an error
	    if(y >= 0 && y < row && x >= 0 && x < col && iparr[y][x] == '*') {
	      return 1;
	    } else {
	      return 0;
	    }
	  }
	  
	public char minesNear(int y, int x) {
	    int mines = 0;
	    // check mines in all directions
	    mines += mineAt(y - 1, x - 1);  // NW
	    mines += mineAt(y - 1, x);      // N
	    mines += mineAt(y - 1, x + 1);  // NE
	    mines += mineAt(y, x - 1);      // W
	    mines += mineAt(y, x + 1);      // E
	    mines += mineAt(y + 1, x - 1);  // SW
	    mines += mineAt(y + 1, x);      // S
	    mines += mineAt(y + 1, x + 1);  // SE
	    if(mines > 0) {
	      // we're changing an int to a char
	      // why?!
	      // http://www.asciitable.com/
	      // 48 is ASCII code for '0'
	      return (char)(mines + 48);
	    } else {
	      return '0';
	    }
	  }
	
	public static void main(String[] args) {
		
		System.out.println("Task Started");
		
		MineSweeperSolver mss = new MineSweeperSolver();
		mss.start();
		
		System.out.println("Task Completed");

	}
	
}
