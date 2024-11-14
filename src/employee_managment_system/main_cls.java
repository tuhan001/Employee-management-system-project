package employee_managment_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class main_cls extends JFrame {
    main_cls() {


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icon/home.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1120, 650, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel ima = new JLabel(i3);
        ima.setBounds(0, 0, 1120, 650);
        add(ima);

        JLabel heading = new JLabel("Employee Management System");
        heading.setBounds(340,155,400,40);
        heading.setFont(new Font("Raleway",Font.BOLD,25));
        ima.add(heading);


        JButton add = new JButton("Add Employee");
        add.setBounds(335,270,150,40);
        add.setForeground(Color.white);
        add.setBackground(Color.black);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddEmployee();
                setVisible(false);

            }
        });
        ima.add(add);


        JButton rem = new JButton("Remove Employee");
        rem.setBounds(440,370,150,40);
        rem.setForeground(Color.white);
        rem.setBackground(Color.black);
        rem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Remove();
            }
        });
        ima.add(rem);


        JButton view = new JButton("View Employee");
       view.setBounds(565,270,150,40);
        view.setForeground(Color.white);
        view.setBackground(Color.black);
        view.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 new ViewEmployee();
                 setVisible(false);

            }
        });
        ima.add(view);


        setSize(1120, 650);
        setLocation(250, 100);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new main_cls();
    }
}
