package DSA_Assignment2_Q3;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.List;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author flynn
 */
public class ViewMaze extends JFrame {

    /**
     * 0 = not-visited node 1 = wall (blocked) 2 = visited node 9 = target node
     *
     * start at (4, 0) end at (12, 4)
     */

    private int[][] maze = 
           {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 0, 0, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1},
            {1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1},
            {1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 9, 1},
            {1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1},
            {1, 1, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 1, 1},
            {1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1},
            {1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1},
            {1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},};


    private final java.util.List<Integer> path = new ArrayList<Integer>();
    private int pathIndex;

    public ViewMaze() {
        setTitle("Q3. Maze");
        setSize(550, 475);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Start DepthFirst path search at (1, 5);
        DepthFirst.searchPath(maze, 1, 5, path);
        pathIndex = path.size() - 2;
    }

    public void update() {
        pathIndex -= 2;
        if (pathIndex < 0) {
            pathIndex = 0;
        }
    }

    //making maze GUI
    @Override
    public void paint(Graphics g) {
        super.paint(g);

        g.translate(50, 50);

        // draw and color the maze
        for (int row = 0; row < maze.length; row++) {
            for (int col = 0; col < maze[0].length; col++) {
                Color color;
                switch (maze[row][col]) {
                    case 1:
                        color = Color.BLACK;
                        break;
                    case 9:
                        color = Color.RED;
                        break;
                    default:
                        color = Color.WHITE;
                }
                g.setColor(color);
                g.fillRect(30 * col, 30 * row, 30, 30);
                g.setColor(Color.BLACK);
                g.drawRect(30 * col, 30 * row, 30, 30);
            }
        }

        // draw the path
        for (int p = 0; p < path.size(); p += 2) {
            int pathX = path.get(p);
            int pathY = path.get(p + 1);
            g.setColor(Color.GREEN);
            g.fillRect(pathX * 30, pathY * 30, 30, 30);
        }
    }

}
