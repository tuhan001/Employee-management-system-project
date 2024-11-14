package employee_managment_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateEmployee extends JFrame implements ActionListener{
    JTextField teducation;
    JTextField tfname;
    JTextField taddress;
    JTextField tphone;
    JLabel temid;
    JTextField tnid;
    JTextField temail;
    JTextField tsalary;
    JTextField tdesignatio;


    JButton add, back;
    String number;
    UpdateEmployee(String number){

        this.number = number;
        getContentPane().setBackground(new Color(163, 255, 188));

        JLabel heading = new JLabel("Add Employee Detail");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("seif", Font.BOLD, 25));
        add(heading);

        JLabel name = new JLabel("Name");
        name.setBounds(50, 150, 150, 30);
        name.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(name);

        JLabel tname = new JLabel();
        tname.setBounds(200, 150, 150, 30);
        tname.setBackground(new Color(177, 252, 197));
        add(tname);


        JLabel fname = new JLabel("Father Name");
        fname.setBounds(400, 150, 150, 30);
        fname.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(fname);

        tfname = new JTextField();
        tfname.setBounds(600, 150, 150, 30);
        tfname.setBackground(new Color(177, 252, 197));
        add(tfname);

        JLabel dob = new JLabel("Date of Birth");
        dob.setBounds(50, 200, 150, 30);
        dob.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(dob);

        JLabel tdob = new JLabel();
        tdob.setBounds(200,200,150,30);
        tdob.setFont(new Font("Tahoma",Font.BOLD,20));
        add(tdob);


        JLabel salary = new JLabel("Salary");
        salary.setBounds(400, 200, 150, 30);
        salary.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(salary);

        tsalary = new JTextField();
        tsalary.setBounds(600, 200, 150, 30);
        tsalary.setBackground(new Color(177, 252, 197));
        add(tsalary);


        JLabel address = new JLabel("Address");
        address.setBounds(50, 250, 150, 30);
        address.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(address);

        taddress = new JTextField();
        taddress.setBounds(200, 250, 150, 30);
        taddress.setBackground(new Color(177, 252, 197));
        add(taddress);


        JLabel phone = new JLabel("Phone Number");
        phone.setBounds(400, 250, 150, 30);
        phone.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(phone);

        tphone = new JTextField();
        tphone.setBounds(600, 250, 150, 30);
        tphone.setBackground(new Color(177, 252, 197));
        add(tphone);


        JLabel email = new JLabel("Email");
        email.setBounds(50, 300, 150, 30);
        email.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(email);

        temail = new JTextField();
        temail.setBounds(200, 300, 150, 30);
        temail.setBackground(new Color(177, 252, 197));
        add(temail);



        JLabel education = new JLabel("Education");
        education.setBounds(400, 300, 150, 30);
        education.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(education);


        teducation = new JTextField();
        teducation.setBounds(600, 300, 150, 30);
        teducation.setBackground(new Color(177, 252, 197));
        add(teducation);





        JLabel nid = new JLabel("NID");
        nid.setBounds(400, 350, 150, 30);
        nid.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(nid);

        JLabel tnid = new JLabel();
        tnid.setBounds(600, 350, 150, 30);
        tnid.setBackground(new Color(177, 252, 197));
        add(tnid);


        JLabel emid = new JLabel("Employee ID");
        emid.setBounds(50, 400, 150, 30);
        emid.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(emid);


        temid = new JLabel();

        temid.setBounds(200, 400, 150, 30);
        temid.setFont(new Font("SANS_SERIF", Font.BOLD, 20));
        temid.setForeground(Color.red);
        add(temid);


        JLabel designation = new JLabel("Designation");
        designation.setBounds(50, 350, 150, 30);
        designation.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(designation);

        tdesignatio = new JTextField();
        tdesignatio.setBounds(200, 350, 150, 30);
        tdesignatio.setBackground(new Color(177, 252, 197));
        add(tdesignatio);

        try {
            conn c = new conn();
            String query = "select * from employee where emid = '"+number+"' ";
            ResultSet resultSet = c.statement.executeQuery(query);
            while (resultSet.next()){
                tname.setText(resultSet.getString("name"));
                tfname.setText(resultSet.getString("fname"));
                tdob.setText(resultSet.getString("dob"));
                taddress.setText(resultSet.getString("address"));
                tsalary.setText(resultSet.getString("salary"));
                tphone.setText(resultSet.getString("phone"));
                temail.setText(resultSet.getString("email"));
                teducation.setText(resultSet.getString("education"));
                tnid.setText(resultSet.getString("nid"));
                temid.setText(resultSet.getString("emid"));
                tdesignatio.setText(resultSet.getString("designation"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }


        add = new JButton("UPDATE");
        add.setBounds(450, 550, 150, 40);
        add.setBackground(Color.black);
        add.setForeground(Color.white);
        add.addActionListener(this);
        add(add);

        back = new JButton("BACK");
        back.setBounds(250, 550, 150, 40);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);


        setSize(900, 700);
        setLayout(null);
        setLocation(300, 50);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if ((e.getSource()==add)){
            String fname = tfname.getText();
            String salary = tsalary.getText();
            String address = taddress.getText();
            String phone = tphone.getText();
            String email = temail.getText();
            String education = teducation.getText();
            String designation = tdesignatio.getText();

            try {
                conn c = new conn();
                String query = "update employee set fname = '"+fname+"',salary = '"+salary+"',address= '"+address+"',phone= '"+phone+"',email = '"+email+"', education = '"+education+"', designation = '"+designation+"' where emid = '"+number+"'";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Details update successsfully");
                setVisible(false);
            }catch (Exception E){
                E.printStackTrace();
            }
        }else {
            setVisible(false);
            new ViewEmployee();
        }
    }

    public static void main(String[] args) {
        new UpdateEmployee("");
    }
}
