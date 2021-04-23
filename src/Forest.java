import java.awt.*;
import java.util.ArrayList;

public class Forest {

    public int x;
    public int y;
    public int w;
    public int h;
    public int n;
    public ArrayList<Integer> forest_1;
    public ArrayList<Integer> forest_2;

    public Forest(int y0, int width0) {
        x = 0;
        this.y = y0;
        this.w = width0;
        this.h = 30;
        n = (int) (Math.random() * 3);

        forest_1 = new ArrayList<>();
        forest_2 = new ArrayList<>();

        int i = 0;
        while (true){
            double r = Math.random();
            if (r < 0.5){

            } else if (r < 0.7){
                forest_1.add(i);
            } else {
                forest_2.add(i);
            }
            i++;
            if (w < h * i){
                break;
            }
        }

    }
}
