package DSA_Assignment2_Q3;

/**
 *
 * @author flynn
 */
import java.util.List;

public class DepthFirst {
    
    //depth first search of maze to find path
    public static boolean searchPath(int[][] maze, int x, int y, List<Integer> path) {
        
        //check if path reached exit coordinates
        if (maze[y][x] == 9) {
            path.add(x);
            path.add(y);
            return true;
        }
        
        //else recursively traverse maze
        if (maze[y][x] == 0) {
            //mark as visited
            maze[y][x] = 2;
            
            int dx = -1;
            int dy = 0;
            if (searchPath(maze, x + dx, y + dy, path)) {
                path.add(x);
                path.add(y);
                return true;
            }

            dx = 1;
            dy = 0;
            if (searchPath(maze, x + dx, y + dy, path)) {
                path.add(x);
                path.add(y);
                return true;
            }

            dx = 0;
            dy = -1;
            if (searchPath(maze, x + dx, y + dy, path)) {
                path.add(x);
                path.add(y);
                return true;
            }

            dx = 0;
            dy = 1;
            if (searchPath(maze, x + dx, y + dy, path)) {
                path.add(x);
                path.add(y);
                return true;
            }
        }
        return false;
    }
    
}