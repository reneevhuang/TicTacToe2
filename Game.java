import java.util.*;
/**
 * Write a description of class Game here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Game
{
    private int[][] playerMoves = new int[3][3];

    /**
     * TODO: 
     * 1. Initialize an int[3][3] and name the int array "game." make sure this is a class variable
     * Introduce the TicTacToe game with instructions how to play by calling "JOptionPane.showMessageDialog(null, [string message]);" replace [string message] with desired message
     * 2. Ask the user how many rounds she/he would like to play by callilng "JOptionPane.showInputDialog([ask how many rounds]);" set the input to an int variable called "rounds"
     * 3. Create the board by creating a Surface object. Make sure this surface object is a class variable called "Surface."
     * 4. Call "Graphic.main(null);" method
     * 5. Call "play(rounds);" method
     */ 
    public Game()
    {

    }

    /**
     * TODO:
     * 1. Create a for loop that would iterate the number of rounds played. Round number is indicated by the class variable "rounds"
     * 2. Create a while loop inside the for loop that runs while anyMovesLeft() is true. 
     * 3. Call player1Move()
     * 4. If anyMovesLeft() is false, for loop should end and start a new round while increasing "rounds" by 1 
     */
    public void play(int rounds)
    {

    }

    /**
     * TODO:
     * 1. Get player 1 move of the row based on location of mouse clicked by calling getRowClicked() and setting it to an instance int called "row"
     *  Get player 1 move of the column based on location of mouse clicked by calling getColumnClicked() and setting it to an instance int called "column"
     * 2. Add move to the playerMoves[row][column] by changing the value to 1.
     */
    public void player1Move()
    {

    }

    /**
     * TODO:
     * 1. Get player 2 move of the row based on location of mouse clicked by calling getRowClicked() and setting it to an instance int called "row"
     *  Get player 2 move of the column based on location of mouse clicked by calling getColumnClicked() and setting it to an instance int called "column"
     * 2. Add move to the playerMoves[row][column] by changing the value to 2.
     */
    public void player2Move()
    {

    }

    /**
     * TODO:
     * 1. Checks if there are any winners by calling didXWin() and didOWin(); if either returns true, the method should return false
     * 2. If there are no one, check the class variable game[][] to see if there are any moves left; create a for loop that iterates through the array to see if there are any
     * empty spaces left
     */
    public boolean anyMovesLeft()
    {
        return false;
    }

    /**
     *  
     */
    public int getRowClicked()
    {
        return -1;
    }

    /**
     * 
     */
    public int getColumnClicked()
    {
        return -1;
    }
}