import java.util.ArrayList;

public class Fork {
    private int r;
    private int c;
    private ArrayList<String> routes;
    private boolean checked;

    public Fork(int r, int c, String routeSigns){
        this.r = r;
        this.c = c;
        routes = new ArrayList<String>();
        for (int i = 0; i < routeSigns.length() - 1; i++) {
            routes.add(routeSigns.substring(i, i + 1));
        }
        checked = false;
    }

    public void setChecked(){
        if (routes.size() == 0){
            checked = true;
        }
    }

    public int getR() {
        return r;
    }

    public int getC() {
        return c;
    }

    public ArrayList<String> getRoutes() {
        return routes;
    }

    public void setRoutes(String routeTaken){
        routes.remove(routeTaken);
    }

    public boolean isChecked(){
        return checked;
    }
}
