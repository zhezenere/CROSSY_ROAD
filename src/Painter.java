import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Painter {
    Image character;
    Image background_up;
    Image background_down;
    Image river;
    Image bridge;
    Image road;
    ArrayList<Image> cars = new ArrayList<>();
    ArrayList<Image> forest = new ArrayList<>();

    Painter(boolean gender) throws IOException {
        String s;
        if(gender == true){
            s = "gentleman";
        } else {
            s = "lady";
        }
        character = ImageIO.read(new File("data/"+s+"/man.png"));// Название персонажа
        background_up = ImageIO.read(new File("data/"+s+"/background_up.png"));
        background_down = ImageIO.read(new File("data/"+s+"/background_down.png"));
        river = ImageIO.read(new File("data/river.png"));
        bridge = ImageIO.read(new File("data/wood.png"));
        for(int i = 1; i < 4; i++){
            forest.add(ImageIO.read(new File("data/forest_00"+i+".png")));
        }
        for(int  i = 1; i < 10; i++){
            cars.add(ImageIO.read(new File("data/"+s+"/Cars/car_00"+i+".png")));
        }
        for(int  i = 10; i < 51; i++){
            cars.add(ImageIO.read(new File("data/"+s+"/Cars/car_0"+i+".png")));
        }
        road = ImageIO.read(new File("data/road.png"));
    }

    public void draw(Graphics2D g2d, int x, int y, int w, int h, String s, int number, boolean t){
        if (s.equals("road")){
            Image test = road;
            g2d.drawImage(road, x,y,w,h,null);
        }
        if(s.equals("car")){
            Image test = cars.get(number);
            if( t == true) {
                g2d.drawImage(test, x, y, w, h, null);
            } else {
                g2d.drawImage(test, x + w, y, -w, h,null);
            }
        }
        if(s.equals("up")){
            Image test = background_up;
            g2d.drawImage(test,x,y,w,h,null);
        }
        if(s.equals("down")){
            Image test = background_down;
            g2d.drawImage(test,x,y,w,h,null);
        }
        if(s.equals("man")){
            Image test = character;
            g2d.drawImage(test, x,y,w,h,null);
            g2d.setColor(Color.magenta);
            g2d.drawRect(x,y,w,h);
            g2d.drawRect(x+1,y+1,w-2,h-2);
            // Рисует красную рамку вокруг персонажа
        }
        if(s.equals("river")){
            int i = 0;
            while (true){
                g2d.drawImage(river, x + i * h, y, h,h,null);
                i = i + 1;
                if (h * i > w){
                    break;
                }
            }
        }
        if(s.equals("bridge")){
            g2d.drawImage(bridge,x,y,w,h,null);
        }
    }
    public void drawForest(Graphics2D g2d, Forest f){
        g2d.drawImage(forest.get(0), f.x, f.y, f.w, f.h, null);
        for (int i = 0; i < f.forest_1.size(); i++){
            g2d.drawImage(forest.get(1), 30 * f.forest_1.get(i), f.y, f.h, f.h, null);
        }
        for (int i = 0; i < f.forest_2.size(); i++){
            g2d.drawImage(forest.get(2), 30 * f.forest_2.get(i), f.y, f.h, f.h, null);
        }
    }
}
