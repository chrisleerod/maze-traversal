/*

Name: Chris Rodriguez
Class: CSC 1120
Instructor: Tisha Gaines
Date: 11/11/2019

I will not give or receive aid during examinations; I will not give or receive false or impermissible aid in course
work, in the preparation of reports, or in any other type of work that is to be used by the instructor as the
basis of my grade; I will not engage in any form of academic fraud. Furthermore, I will uphold my
responsibility to see to it that others abide by the spirit and letter of this Honor Pledge.

 */

import java.util.*;
import java.io.*;

/**
 * MazeTester uses recursion to determine if a maze can be traversed.
 *
 * @author Java Foundations
 * @version 4.0
 */
public class MazeTester
{
    /**
     * Creates a new maze, prints its original form, attempts to
     * solve it, and prints out its final form.
     */
    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the name of the file containing the maze: ");
        String filename = scan.nextLine();

        Maze labyrinth = new Maze(filename); // file path: /Users/tishagaines/Desktop/Recursive_Maze/resource/maze.txt

        System.out.println(labyrinth);

        MazeSolver solver = new MazeSolver(labyrinth);

        if (solver.traverse(labyrinth.getStartRow(), labyrinth.getStartCol())) {
            System.out.println("The maze was successfully traversed!");
            // Prints the amount of times the amount of times valid positions are called in traverse.
            System.out.println("Maze was called " + labyrinth.getNumber() + " times.");
            // Prints the amount of breadcrumbs that are translated from available path points/grid.
            System.out.println("There are " + (labyrinth.getCounter()-1) + " breadcrumbs.");
        }
        else {
            System.out.println("There is no possible path.");
        }
        System.out.println(labyrinth);
    }
}