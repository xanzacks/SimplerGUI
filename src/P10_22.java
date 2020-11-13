//This is P10.22
import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

public class P10_22 {

    public static class Car{
        double xLeft;
        double yTop;

        Car(double x, double y){
            xLeft = x;
            yTop = y;
        }

        public Car() {
            xLeft = 0;
            yTop = 0;
        }

        void setxLeft(double xLeft){this.xLeft = xLeft;};
        void setyTop(double xLeft){this.yTop = xLeft;};

        public void draw(Graphics2D g2){
            Rectangle body = new Rectangle((int)xLeft - 60, (int)yTop - 20, 60, 10);
            Ellipse2D.Double frontTire  = new Ellipse2D.Double(xLeft - 50, yTop - 10, 10, 10);
            Ellipse2D.Double rearTire = new Ellipse2D.Double(xLeft - 20, yTop - 10, 10, 10);
            Point2D.Double r1 = new Point2D.Double(xLeft - 50, yTop - 20);
            Point2D.Double r2 = new Point2D.Double(xLeft - 40, yTop - 30);
            Point2D.Double r3 = new Point2D.Double(xLeft - 20, yTop - 30);
            Point2D.Double r4 = new Point2D.Double(xLeft - 10, yTop - 20);
            Line2D.Double frontWindshield = new Line2D.Double(r1, r2);
            Line2D.Double roofTop = new Line2D.Double(r2, r3);
            Line2D.Double rearWindshield = new Line2D.Double(r3, r4);
            g2.draw(body);
            g2.draw(frontTire);
            g2.draw(rearTire);
            g2.draw(frontWindshield);
            g2.draw(roofTop);
            g2.draw(rearWindshield);
        }
    }

    static class DrawCars extends JComponent {
        Car car;
        double x = 60;
        double y = 30;
        double lastHeight = 0;
        double lastWidth = 0;
        int n = 0;

        DrawCars(){
            car = new Car(x, y);
        }

        double getx(){return x;}
        double gety(){return y;}

        public void moveby(){
            if(n == 0){
                lastHeight = (double)getHeight();
                lastWidth = (double) getWidth();
            }
            double difference;
            difference = ((double)getWidth()-60)/10 - (lastWidth-60)/10;
            System.out.println(difference);
            x = difference + x + ((double)getWidth()-60)/10;
            difference = ((double)getHeight()-30)/10 - (lastHeight-30)/10;
            y = difference + y + ((double)getHeight()-30)/10;
            car.setxLeft(x);
            car.setyTop(y);
            lastHeight = (double)getHeight();
            lastWidth = (double)getWidth();
            n++;
            System.out.println(getWidth() + " " + getHeight());
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D)g;
            car.draw(g2);
        }
    }

    public static class Movingframe extends JFrame{
        private static final int FRAME_WIDTH = 300;
        private static final int FRAME_HEIGHT = 400;
        private DrawCars cars;
        Timer time;

        class Timerlistner implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(cars.getx() + " " + cars.gety());
                if((int)cars.getx() >= cars.getWidth() - getWidth()/20 || (int)cars.gety() >= getHeight() - getHeight()/20){
                    //if(cars.getx() >= (double) cars.getWidth() || cars.gety() >= (double) getHeight()) {
                    time.stop();
                }
                else{cars.moveby();}
            }
        }
        public Movingframe(){
            cars = new DrawCars();
            add(cars);
            setSize(FRAME_WIDTH, FRAME_HEIGHT);
            ActionListener listener = new Timerlistner();
            final int Delay = 1000;
            time = new Timer(Delay, listener);
            time.start();
        }
    }
    public static void main(String[] args){
        JFrame frame = new Movingframe();
        frame.setTitle("Mycars");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
