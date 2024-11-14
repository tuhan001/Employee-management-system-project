package employee_managment_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class Remove extends JFrame implements ActionListener {

    Choice choiceemid;
    JButton delete,back;
    Remove(){

        JLabel label = new JLabel("Employee ID");
        label.setBounds(50,50,100,30);
        label.setFont(new Font("Tahoma", Font.BOLD,15));
        add(label);


        choiceemid = new Choice();
        choiceemid.setBounds(200,50,150,30);
        add(choiceemid);


        try {
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from employee");
            while (resultSet.next()){
                choiceemid.add(resultSet.getString("emid"));

            }
        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel labelname = new JLabel("Name");
        labelname.setBounds(50,100,100,30);
        labelname.setFont(new Font("Tahoma", Font.BOLD,15));
        add(labelname);

        JLabel textname = new JLabel();
        textname.setBounds(200,100,100,30);
        add(textname);

        JLabel labelphone = new JLabel("phone");
        labelphone.setBounds(50,150,100,30);
        labelphone.setFont(new Font("Tahoma", Font.BOLD,15));
        add(labelphone);

        JLabel textphone = new JLabel();
        textphone.setBounds(200,150,100,30);
        add(textphone);

        JLabel labelemail = new JLabel("Email");
        labelemail.setBounds(50,200,100,30);
        labelemail.setFont(new Font("Tahoma", Font.BOLD,15));
        add(labelemail);

        JLabel textemail = new JLabel();
        textemail.setBounds(200,200,100,30);
        add(textemail);

        try {
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from employee where  emid = '"+choiceemid.getSelectedItem()+"'");
            while (resultSet.next()){
                textname.setText(resultSet.getString("name"));
                textphone.setText(resultSet.getString("phone"));
                textemail.setText(resultSet.getString("email"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }


        choiceemid.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
             try {
                 conn c = new conn();
                 ResultSet resultSet = c.statement.executeQuery("select * from employee where  emid = '"+choiceemid.getSelectedItem()+"'");
                 while (resultSet.next()){
                     textname.setText(resultSet.getString("name"));
                     textphone.setText(resultSet.getString("phone"));
                     textemail.setText(resultSet.getString("email"));
                 }

             }catch (Exception E){
                 E.printStackTrace();
             }
            }
        });


        delete = new JButton("DELETE");
        delete.setBounds(80,300,100,30);
        delete.setBackground(Color.black);
        delete.setForeground(Color.white);
        add(delete);

        delete.addActionListener(this);

        back = new JButton("BACK");
        back.setBounds(220,300,100,30);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        add(back);
        back.addActionListener(this);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icon/delete.png"));
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(700,80,200,200);
        add(img);



        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("Icon/rback.png"));
        Image i12 = i11.getImage().getScaledInstance(1120,630,Image.SCALE_DEFAULT);
        ImageIcon i13 = new ImageIcon(i12);
        JLabel imga = new JLabel(i13);
        imga.setBounds(0,0,1120,630);
        add(imga);




        setSize(1000,400);
        setLocation(300,150);
        setLayout(null);
        setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==delete){
            try {
                conn c = new conn();
                String qurey = "delete from employee where emid = '"+choiceemid.getSelectedItem()+"'";
                c.statement.executeUpdate(qurey);
                JOptionPane.showMessageDialog(null,"Employee Delected Succsessfully");
                setVisible(false);
            }catch (Exception E){
                E.printStackTrace();
            }
        }else {
            setVisible(false);
        }

    }

    public static void main(String[] args) {
        new Remove();
    }
}
