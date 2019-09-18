package com.company;
import java.util.Scanner;

public class Main {
    public static void Magic(int n){
        if(n % 2 == 0){ //Check input to make sure input is odd.
            System.out.println("N must be odd to produce a magic square.");
        } else { //Input is odd proceed to initializing variables
            int[][] arr=new int[n][n]; //Create new 2D array of N by N size
            int posRow;
            int startPosCol = (int) n/2; // Start in middle index of row 1
            int[] basePos = new int[2]; //create Base position array that holds column and row
            posRow = 0; // set row to 1 or index 0 in terms of array
            for(int i = 1; i <= n*n; i++){  //loop through 1 to n^2 putting i in each element of 2D array
                if(i == 1){ //initial setup just put i into first base position
                    arr[posRow][startPosCol] = i;
                    basePos[0] = posRow;
                    basePos[1] = startPosCol;
                } else{
                   int[] tempPos= new int[2];  // create a temporary array to move through the 2D array without losing base position
                   tempPos[0] = basePos[0]; //copy base position row to temp position row
                   tempPos[1] = basePos[1]; //copy base position column to temp position column
                   tempPos[0] -= 1; // move row up by deducting one
                   tempPos[1] -= 1; // move column left by deducting one
                   if(tempPos[0] < 0){ // if row is less than 0
                       tempPos[0] = n-1; // move to the last row in the 2D array
                   }
                   if(tempPos[1] < 0){ // if column is less than 0
                       tempPos[1] = n-1; // move to the last column in the 2D array
                   }
                   if(arr[tempPos[0]][tempPos[1]] == 0){ // if element in array is empty (0)
                       arr[tempPos[0]][tempPos[1]] = i; // put value of i into that element
                   } else { // if element in Array is not empty
                       tempPos[0] = basePos[0]; //copy base position row to temp position row
                       tempPos[1] = basePos[1]; //copy base position column to temp position column
                       tempPos[0] += 1; // move down a row by adding one
                       if(tempPos[0] > n-1){ // if row is greater than last index of row
                           tempPos[0] = 0; // set row position to zero because move went out of bounds
                       }
                       arr[tempPos[0]][tempPos[1]] = i; // put value of i into that element
                   }
                   basePos[0] = tempPos[0]; // update base position row with temporary position row
                   basePos[1] = tempPos[1]; // update base position column with temporary position column
                }
            }
            for(int i=0;i<n;i++){ // outer for loop
                for(int j=0;j<n;j++){ // inner for loop
                    System.out.print(arr[i][j]+" "); // print 2D array element
                }
                System.out.println(); // print new line after line of values are printed
            }
        }
    }
    public static void main(String[] args) {
	// write your code here
        Scanner in = new Scanner(System.in);
        System.out.println("Select an whole number integer that is odd.");
        int magicNumber = in.nextInt();
        Magic(magicNumber);
    }
}

/*
    The time complexity of Magic() is O(n^2) because Magic uses only one Loop to fill the magic square but whatever the input
    the loop runs for input times input times exponentially. I'm a little confused with time complexity, I use one for loop so
    isn't that O(n) but then in my for loop I have the conditional statement as i < n * n, doesn't that mean for each input,
    the function needs to go to n^2, or isn't this function similar to a linear search function where there is a linear path,
    since we're not searching or anything the algorithm is just filling a 2D array. I know this class isn't an algorithms course,
    but I found an interest in this I even took to Khan Academy to review and learned about Big O Big 0 and Big Omega. I haven't
    gotten a chance to read the book yet but I've been reading resources online, and I don't think I've grasped asymptotic notation yet.
 */
