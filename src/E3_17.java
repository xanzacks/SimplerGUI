//This is E3.17
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
public class E3_17 {

    public static class DrawEllipse extends JComponent{
        @Override
        public void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            Ellipse2D.Double ellipse = new Ellipse2D.Double(0, 0, this.getWidth(), this.getHeight());
            g2.draw(ellipse);
            g2.setColor(Color.PINK);
            g2.fill(ellipse);
        }
    }

    public static void main(String[] args){
        final int width = 300;
        final int height = 400;
        JFrame frame = new JFrame("Ellipse");
        frame.setSize(width,height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new DrawEllipse());
        frame.setVisible(true);
    }
}
