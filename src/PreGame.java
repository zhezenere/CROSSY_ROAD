import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferStrategy;
import java.io.File;
import java.io.IOException;

public class PreGame extends JFrame implements MouseListener {

    public ClickObject gent;
    public ClickObject l;
    public boolean gender = true;
    public ClickObject start;
    public boolean isDrawing = true;


    public PreGame() {
        setResizable(false);
        setVisible(true);
        setSize(600, 320);
        gent = new ClickObject(0, 30, 200, 120, "gentleman");
        l = new ClickObject(260, 30, 590, 120, "lady");
        start = new ClickObject(170, 220, 420, 320, "START");
        addMouseListener(this);
    }


    public void paint(Graphics g) {
        BufferStrategy bufferStrategy = getBufferStrategy();
        if (bufferStrategy == null) {
            createBufferStrategy(2);
            bufferStrategy = getBufferStrategy();
        }
        g = bufferStrategy.getDrawGraphics();
        Graphics2D g2d = (Graphics2D) g;

        try {
            g2d.drawImage(ImageIO.read(new File("data/PreGame.jpg")), 0,0,getWidth(),getHeight(), null);
        } catch (IOException e) {
            e.printStackTrace();
        }

        g.dispose();
        bufferStrategy.show();
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        if (gent.checkClick(e)) {
            gent.color = Color.GREEN;
            l.color = Color.WHITE;
            gender = true;
        }
        if (l.checkClick(e)) {
            gent.color = Color.WHITE;
            l.color = Color.RED;
            gender = false;
        }
        if (start.checkClick(e)) {
            isDrawing = false;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
