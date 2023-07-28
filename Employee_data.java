
package javaapplication128;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;



public class Employee_data extends JFrame implements ActionListener{
    Connection con=null;
    Statement st;
    ResultSet rs;
    
    JLabel jl1 = new JLabel("Enter Roll no.");
    JLabel jl2 = new JLabel("Enter Student name");
    JLabel jl3 = new JLabel("Enter City");
    TextField tf1 = new TextField();
    TextField tf2 = new TextField();
    TextField tf3 = new TextField();
    JButton jb1 = new JButton("Save"); //also known as INSERT 
    JButton jb2 = new JButton("Find");  //also known as SELECT
    JButton jb3 = new JButton("Delete");
    JButton jb4 = new JButton("Update");
    JButton jb5 = new JButton("Close");
    JButton jb6 = new JButton("Reset");
    
    Employee_data()
    {
        setLayout(null);
        jl1.setBounds(60, 30, 110, 30);
        tf1.setBounds(190, 30, 110, 30);
        jl2.setBounds(60, 70, 140, 30);
        tf2.setBounds(190, 70, 110, 30);
        jl3.setBounds(60, 110, 100, 30);
        tf3.setBounds(190, 110, 110, 30);
        jb1.setBounds(30, 160, 80, 30);
        jb2.setBounds(180, 160, 80, 30);
        jb3.setBounds(320, 160, 80, 30);
        jb4.setBounds(30, 220, 80, 30);
        jb5.setBounds(180, 220, 80, 30);
        jb6.setBounds(320, 220, 80, 30);


        add(jl1);
        add(tf1);
        add(jl2);
        add(tf2);
        add(jl3);
        add(tf3);
        add(jb1);
        add(jb2);
        add(jb3);
        add(jb4);
        add(jb5);
        add(jb6);
      jb1.addActionListener(this);
      jb2.addActionListener(this);
      jb3.addActionListener(this);
      jb4.addActionListener(this);
      jb5.addActionListener(this);
      jb6.addActionListener(this);
      try
      {
          DriverManager.registerDriver(new sun.jdbc.odbc.JdbcOdbcDriver());
          con=DriverManager.getConnection("jdbc:odbc:STUDENT");
          st = con.createStatement();
          JOptionPane.showMessageDialog(rootPane, "Connection is ok");
      }
      catch(Exception ex)
      {
          JOptionPane.showMessageDialog(rootPane, ex);
      }

    }
    public void actionPerformed(ActionEvent ae)
    {
       if(ae.getSource()==jb1)
       {
           try
           {
               
              // String str="insert into TBLSTD values("+tf1.getText()+",'"+tf2.getText()+"','"+tf3.getText()+"')";
               st.executeUpdate("insert into TBLSTD values("+tf1.getText()+",'"+tf2.getText()+"','"+tf3.getText()+"')");
             JOptionPane.showMessageDialog(rootPane, "Record is inserted"); 
             
           }
           catch(Exception ex)
           {
              JOptionPane.showMessageDialog(rootPane, "Record is not inserted"); 
  
           }
       }
        
        
        
        if(ae.getSource()==jb2)
        {
           try
           {
              rs = st.executeQuery("select * from TBLSTD where ROLLNO="+tf1.getText()); //roll no store into rs 
              if(rs.next())  //get value
              {
                  tf2.setText(rs.getString(2));  //put values at tf2 and tf3
                  tf3.setText(rs.getString(3));
                  JOptionPane.showMessageDialog(rootPane, "Record is found");
              }
              else
              {
                   JOptionPane.showMessageDialog(rootPane, "Record is not found");
              }
              
           }
           catch(Exception ex)
           {
               
           }
                   
        }
          if(ae.getSource()==jb3)
        {
           try
           {
              rs = st.executeQuery("delete*from TBLSTD where ROLLNO="+tf1.getText()); 
                  JOptionPane.showMessageDialog(rootPane, "Record is deleted");
             }
             catch(Exception ex)
              {
                   JOptionPane.showMessageDialog(rootPane, "Record is not deleted");
              }
                   
        }
          if(ae.getSource()==jb4)
          {
              try
              {
                String s1 = tf1.getText();
                String s2 = tf2.getText();
                String s3 = tf3.getText();
                
                st .executeUpdate("update TBLSTU set SNAME='"+s2+"',CITY='"+s3+"'where ROLLNO='"+s1+"'");
               JOptionPane.showMessageDialog(rootPane, "Record is updated");
              }
              catch(Exception ex)
              {
                   JOptionPane.showMessageDialog(rootPane, "Record is  not updated");
              }
          }
          if(ae.getSource()==jb5)
          {
              System.exit(0);
          }
           if(ae.getSource()==jb6)
          {
             tf1.setText("");
             tf2.setText("");
             tf3.setText("");

          } 
        
    }

    
    public static void main(String[] args) {
        Employee_data jv  = new Employee_data();
        jv.setSize(500,500);
        jv.setVisible(true);
        jv.setTitle("Student");
        jv.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       jv.setLocation(500, 200);
    }
}
