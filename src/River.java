import java.awt.*;
import java.util.ArrayList;

public class River {

    public int y;
    public int width;
    public int height;
    ArrayList<Bridge> bridges;


    public River(int y0, int width0) {
        bridges = new ArrayList<>();
        bridges.add(new Bridge(((int )(1)),y0));
        bridges.add(new Bridge(((int )(2)),y0));
        bridges.add(new Bridge(((int )(3)),y0));
        this.y = y0;
        this.width = width0;
        this.height = 30;
    }
    public void draw(Graphics2D g2d, Painter p){
        p.draw(g2d,0,y,width,height,"river", 0,true);
        for(int i = 0; i < bridges.size(); i = i + 1){
            bridges.get(i).draw(g2d, p);
        }
    }
}
