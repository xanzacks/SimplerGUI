
//This is E10.8

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class E10_8{

    static class clicklistner implements ActionListener{
        int n = 0;
        JLabel lable = new JLabel("I am clicked " + n + " times.");
        @Override
        public void actionPerformed(ActionEvent e) {
            n++;
            lable.setText("I am clicked " + n + " times.");
        }

        JLabel Returnlable(){ return lable; }
    }

    public static void main(String[] args){
        JFrame frame = new JFrame();
        JPanel Panel = new JPanel();
        JButton button1 = new JButton("Click me");
        JButton button2 = new JButton("Click me");
        ActionListener listener1 = new clicklistner();
        ActionListener listener2 = new clicklistner();
        clicklistner obj1 = (clicklistner)listener1;
        clicklistner obj2 = (clicklistner)listener2;
        Panel.add(button1);
        Panel.add(button2);
        Panel.add(obj1.Returnlable());
        Panel.add(obj2.Returnlable());
        frame.add(Panel);
        button1.addActionListener(listener1);
        button2.addActionListener(listener2);
        frame.setSize(300,400);
        frame.setTitle("Mine");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}