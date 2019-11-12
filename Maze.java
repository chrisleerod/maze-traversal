import java.util.*;
import java.io.*;

/**
 * Maze represents a maze of characters. The goal is to get from the
 * top left corner to the bottom right, following a path of 1's. Arbitrary
 * constants are used to represent locations in the maze that have been TRIED
 * and that are part of the solution PATH.
 *
 * @author Java Foundations
 * @version 4.0
 */
public class Maze
{
    private static final String TRIED = "?";
    private static final String PATH = "o";

    private int numberRows, numberColumns;
    private String[][] grid;
    private int bread = 0;
    public int counter = 0;


    /**
     * Constructor for the Maze class. Loads a maze from the given file.
     * Throws a FileNotFoundException if the given file is not found.
     *
     * @param filename the name of the file to load
     * @throws FileNotFoundException if the given file is not found
     */
    public Maze(String filename) throws FileNotFoundException
    {
        Scanner scan = new Scanner(new File(filename));
        numberRows = scan.nextInt();
        numberColumns = scan.nextInt();

        grid = new String[numberRows][numberColumns];
        for (int i = 0; i < numberRows; i++)
            for (int j = 0; j < numberColumns; j++)
                grid[i][j] = scan.next();
    }

    /**
     * Marks the specified position in the maze as TRIED
     *
     * @param row the index of the row to try
     * @param col the index of the column to try
     */
    public void tryPosition(int row, int col)
    {
        if(!(getGridString(row, col).contains("C")) && !(getGridString(row, col).contains("R"))) {
            grid[row][col] = TRIED;
        }
    }
    /**
     * Return the number of rows in this maze
     *
     * @return the number of rows in this maze
     */
    public int getRows()
    {
        return grid.length;
    }

    /**
     * Return the number of columns in this maze
     *
     * @return the number of columns in this maze
     */
    public int getColumns()
    {
        return grid[0].length;
    }

    /**
     * Marks a given position in the maze as part of the PATH
     *
     * @param row the index of the row to mark as part of the PATH
     * @param col the index of the column to mark as part of the PATH
     */
    public void markPath(int row, int col)
    {
        // Ignores C when converting traversed path into "o's."
        if(!(getGridString(row, col).contains("C"))) {
            grid[row][col] = PATH;
            bread++;
        }
    }
    /**
     * Determines if a specific location is valid. A valid location
     * is one that is on the grid, is not blocked, and has not been TRIED.
     *
     * @param row the row to be checked
     * @param column the column to be checked
     * @return true if the location is valid
     */
    public boolean validPosition(int row, int column)
    {
        boolean result = false;

        // check if cell is in the bounds of the matrix
        if (row >= 0 && row < grid.length &&
                column >= 0 && column < grid[row].length)

            //  check if cell is not blocked and not previously tried
            if (grid[row][column].contains(".") || grid[row][column].contains("C") || grid[row][column].contains("R")) {
                result = true;
            }
        return result;
    }
    /**
     * Returns the maze as a string.
     *
     * @return a string representation of the maze
     */
    public String toString()
    {
        String result = "\n";

        for (int row=0; row < grid.length; row++)
        {
            for (int column=0; column < grid[row].length; column++)
                result += grid[row][column] + "";
            result += "\n";
        }

        return result;
    }
    public String getGridString(int row, int col) {
        return grid[row][col];
    }

    public int getStartRow() {
        for (int i = 0; i < getRows(); i++) {
            for (int j = 0; j < getColumns(); j++) {
                if (grid[i][j].contains("R")){
                    return i;
                }
            }
        }
        return 0;
    }
    public int getStartCol() {
        for (int i = 0; i < getRows(); i++) {
            for (int j = 0; j < getColumns(); j++) {
                if (grid[i][j].contains("R")){
                    return j;
                }
            }
        }
        return 0;
    }
    // Returns the amount of breadcrumbs that is traversed through.
    public int getCounter() {
        return bread;
    }
    // Adds to the int counter for the amount of times maze is called.
    public void CounterIncrease() {
        counter++;
    }
    // Returns the amount of times maze is called.
    public int getNumber() {
        return counter;
    }
}

