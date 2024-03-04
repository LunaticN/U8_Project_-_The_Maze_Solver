import java.util.ArrayList;

public class MazeSolver {
    private String[][] maze;
    private ArrayList<String> path;

    public MazeSolver(String[][] maze){
        this.maze = maze;
        path = new ArrayList<String>();
    }
    
    public void traverse(){
        int r = 0;
        int c = 0;
        path.add("(" + 0 + ", " + 0 + ")");
        while(!(r == maze.length - 1 && c == maze[0].length - 1)){
            String routes = lookAround(r, c);
            maze[r][c] = "#";
            if (Integer.parseInt(routes) == 0){
                r++;
            }
            if (Integer.parseInt(routes) == 1){
                r--;
            }
            if (Integer.parseInt(routes) == 2){
                c--;
            }
            if (Integer.parseInt(routes) == 3){
                c++;
            }
            path.add("(" + r + ", " + c + ")");
        }
    }

    public String lookAround(int r, int c){
        String directions = "";
        //up?
        try{
            if (maze[r + 1][c].equals(".")){
                directions += "0";
            }
        }
        catch (ArrayIndexOutOfBoundsException ignored){}
        //down?
        try{
            if (maze[r - 1][c].equals(".")){
                directions += "1";
            }
        }
        catch (ArrayIndexOutOfBoundsException ignored){}
        //left?
        try{
            if (maze[r][c - 1].equals(".")){
                directions += "2";
            }
        }
        //right?
        catch (ArrayIndexOutOfBoundsException ignored){}
        try{
            if (maze[r][c + 1].equals(".")){
                directions += "3";
            }
        }
        catch (ArrayIndexOutOfBoundsException ignored){}

        return directions;
    }

    public void printPath(){
        for (int i = 0; i < path.size(); i++) {
            if (i == path.size() - 1){
                System.out.println(path.get(i));
                break;
            }
            System.out.print(path.get(i) + "-->");
        }
    }
}
