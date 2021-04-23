import java.awt.*;

public class Bridge {
    public int x;
    public int y;
    public int w;
    public int h;
    public Bridge(int n, int y0){
        int w0 = (int) (Math.random() * 3);

        this.x = 60 + w0 * 30 + 210 * (n - 1);
        this.y = y0;

        w = 30 + 30 * ((int)(3 * Math.random()));
        h = 30;
    }
    public void draw(Graphics2D g2d, Painter p){
        g2d.setColor(new Color(125,50,50));
        p.draw(g2d, x,y,w,h,"bridge", 0, true);
    }
}
