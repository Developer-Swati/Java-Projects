package javaapplication129;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;



public class Create_Account extends JFrame implements ActionListener {
    Connection cn = null;
    Statement st;
    ResultSet rs;
   
   
    Font f = new Font("mangal",Font.BOLD,25);
    
   ImageIcon img = new ImageIcon("C:\\Users\\ram\\Pictures\\google.png");
   JLabel jl0 = new JLabel(img);
    JLabel jl1 = new JLabel("Sign in");
    JLabel jl2 = new JLabel("to continue to Gmail"); 
    JLabel jl3 = new JLabel("Enter email");
   JLabel jl4 = new JLabel("Enter password");
    JTextField tf1 = new JTextField();
    JButton jb1 = new JButton("Create account");
     JButton jb2 = new JButton("Sign in");
     JPasswordField tf2 = new JPasswordField();
     
     Container c ;
     
     Create_Account()
     {
         c = getContentPane();       
         setLayout(null);
         jl0.setBounds(145,10,140, 120);
         jl1.setBounds(150,100,100, 30);
         jl1.setFont(f);
         jl2.setBounds(135,120,160, 50);
         jl3.setBounds(90,160,100, 30);
         tf1.setBounds(85,182,290, 40);
         jl4.setBounds(90,230,100, 30);
         tf2.setBounds(85,252,290, 40);
         jb1.setBounds(60, 350, 130, 20);
         jb2.setBounds(350, 350, 90, 20);

         c.add(jl0);
         add(jl1);
         add(jl2);
         add(jl3);
         add(tf1);
         add(jl4);
         add(tf2);
         add(jb1);
         add(jb2);
       jb1.addActionListener(this);
       jb2.addActionListener(this);
       
        try
      {
         DriverManager.registerDriver(new sun.jdbc.odbc.JdbcOdbcDriver()); 
         cn = DriverManager.getConnection("jdbc:odbc:SWATI");
         st = cn.createStatement();
       //  JOptionPane.showMessageDialog(rootPane, "Connection is ok");
      }
      catch(Exception ex)
      {
        JOptionPane.showMessageDialog(rootPane, ex);  
      }
     
     }
  public void actionPerformed( ActionEvent ae )
  {
      if(ae.getSource()==jb1)      //works like main() for class A
      {
          A ob = new A();
          ob.setSize(690,690);
          ob.setVisible(true);   
      }
      if(ae.getSource()==jb2)    
      {
            try
           {
            
             rs = st.executeQuery("select * from GTBLACC where UNAME='"+tf1.getText()+"'"); //always use single inverted commas along double commas i.e. with string in quary 
             if(rs.next())  //get value
              {
                  String s;
                  s = rs.getString(4);
                if(tf2.getText().equals(s))  //use equals method to compare strings.
                {
  
                  B ok = new B();
                  ok.setSize(550,550);
                  ok.setVisible(true);
               
                }
             
              else
              {
                   JOptionPane.showMessageDialog(rootPane, "Invalid Username or password");
              }  
          }
           }
      catch(Exception ex)
              {
                   JOptionPane.showMessageDialog(rootPane, ex); 
  
              }
  }
 
  }    

    
    public static void main(String[] args) {
        Create_Account jv = new Create_Account();
        jv.setSize(500,500);
        jv.setVisible(true);
        jv.setTitle("Email");
       jv.setDefaultCloseOperation(EXIT_ON_CLOSE);
       jv.setLocation(500, 200);
        
    }
}
class A extends JFrame implements ActionListener
{
     Connection cn = null;
    Statement st;
    ResultSet rs;
    
    ImageIcon img2 = new ImageIcon("C:\\Users\\ram\\Pictures\\google.png");
    JLabel jla1 = new JLabel(img2);
    JLabel jla2 = new JLabel("Create your Google Account");
    JLabel jla3 = new JLabel("to continue to Gmail");
    JLabel jla4 = new JLabel("First name");
    JTextField tf3 = new JTextField();
    JLabel jla5 = new JLabel("Last name");
    JTextField tf4 = new JTextField();
    JLabel jla6 = new JLabel("Username");
    JTextField tf5= new JTextField();
    JLabel jla7 = new JLabel("Password");
    JPasswordField tf6 = new JPasswordField();
    JLabel jla8 = new JLabel("Confirm");
    JPasswordField tf7 = new JPasswordField();
    ImageIcon img3 = new ImageIcon("C:\\Users\\ram\\Pictures\\Account.png");
    JLabel jla9 = new JLabel(img3);
    JCheckBox chk = new JCheckBox(" Show password");
    JButton jlb1 = new JButton("sign in instead");
    JButton jlb2 = new JButton("Save");
    JLabel jla10 = new JLabel("One account .All of Google");
    JLabel jla11 = new JLabel("working for you.");
    JLabel jla12 = new JLabel("Phone number");
    JTextField tf8 = new JTextField();
    JLabel jla13 = new JLabel("Your Birthday");
    JLabel jla14 = new JLabel("Month");
    JLabel jla15 = new JLabel("Day");
    JLabel jla16 = new JLabel("Year");
    JTextField tf9 = new JTextField();
    JTextField tf10 = new JTextField();
    JTextField tf11 = new JTextField();

     Font f = new Font("mangal",Font.BOLD,25);
      Font f1 = new Font("mangal",Font.BOLD,18);
    Container con ;
    String str[] = {"Gender","Male","Female"};
    JComboBox cb = new JComboBox(str);
    A()
    {
      con = getContentPane();
      setLayout(null);
      con.add(jla1);
      jla1.setBounds(20, 5, 140, 100);
      jla2.setBounds(20, 80, 350, 70);
      jla2.setFont(f);
      jla3.setBounds(20, 130, 150, 30);
      jla4.setBounds(25, 160, 80, 30);
      tf3.setBounds(25, 180, 175,30);
      jla5.setBounds(220, 160, 80, 30);
      tf4.setBounds(220, 180, 175,30);
      jla6.setBounds(25, 220, 80, 30);
      tf5.setBounds(25, 240, 355,30);
      con.add(jla9);
      jla9.setBounds(420,140, 250, 300);
      jla7.setBounds(25, 270, 80, 30);
      tf6.setBounds(25, 290, 175,30);
      jla8.setBounds(220, 270, 80, 30);
      tf7.setBounds(220, 290, 175,30);
     chk.setBounds( 25,330 , 140, 30);
     jlb1.setBounds(25, 500, 120, 30);
     jlb2.setBounds(300, 500, 80, 30);
     jla10.setBounds(420,450, 250, 30);
     jla11.setBounds(420,480, 150, 30);
     jla10.setFont(f1);
     jla11.setFont(f1);
     
     cb.setBounds(30,365 , 70,20);
     jla12.setBounds(220, 330, 100, 30);
     tf8.setBounds(220,350,175, 30);
     jla13.setBounds(30, 390, 150, 30);
     jla14.setBounds(30, 420, 100, 30);
     tf9.setBounds(25,450,90, 30);
     jla15.setBounds(140, 420, 100, 30);
     tf10.setBounds(130,450,90, 30);
     jla16.setBounds(240, 420, 100, 30);
     tf11.setBounds(230,450,90, 30);

     con.add(cb);
      add(jla2);
      add(jla3);
      add(jla4);
      add(tf3);
      add(jla5); 
      add(jla6); 
      add(jla7); 
      add(jla8); 
      add(tf4);
      add(tf5);
      add(tf6);
      add(tf7);
      add(jlb1);
      add(jlb2);
      add(jla10);
      add(jla11);
      add(jla12);
      add(tf8);
      add(jla13);
      add(jla14);
      add(jla15);
      add(jla16);
      add(tf9);
      add(tf10);
      add(tf11);
  
    
       jlb2.addActionListener(this);
       cb.addActionListener(this);

    try
      {
         DriverManager.registerDriver(new sun.jdbc.odbc.JdbcOdbcDriver()); 
         cn = DriverManager.getConnection("jdbc:odbc:SWATI");  //Write here DSN name which we have taken at the time of making connection
         st = cn.createStatement();
       //  JOptionPane.showMessageDialog(rootPane, "Connection is ok");
      }
      catch(Exception ex)
      {
        JOptionPane.showMessageDialog(rootPane, ex);  
      }
     }
      
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==jlb2)
        {
         try{
              Object ob;  //Here Object is a pre-defined class.
             String str;
             ob = cb.getSelectedItem();
             str = ob.toString();  //convert into string.
             
           st.executeUpdate("insert into GTBLACC values('"+tf3.getText()+"','"+tf4.getText()+"','"+tf5.getText()+"','"+tf6.getText()+"','"+tf7.getText()+"',"+tf8.getText()+",'"+tf9.getText()+"','"+tf10.getText()+"',"+tf11.getText()+",'"+str+"')");
            if(tf6.getText().equals(tf7.getText()))
            {
              JOptionPane.showMessageDialog(rootPane, "Record is inserted");   
            }
           else
            {
                  JOptionPane.showMessageDialog(rootPane, "Passwords do not match");   
  
            }
           
          
      }
      catch(Exception ex)
      {
            JOptionPane.showMessageDialog(rootPane, "Record is not inserted"); 
 
      }
        }
    }
}
class B extends JFrame implements ActionListener 
{
    Connection ct = null;
    Statement sta;
    ResultSet rst;
    
    ImageIcon img2 = new ImageIcon("C:\\Users\\ram\\Pictures\\google.png");
    JLabel jlb1 = new JLabel(img2); 
    JLabel jlb2 = new JLabel(",welcome to Google");
     JLabel jlb3 = new JLabel("Swati");
    JLabel jlb5 = new JLabel("Phone no");
    JTextField jtf1 = new JTextField();
    JButton jbb1 = new JButton("Submit");
    
 
     Container con ;
     ImageIcon img3 = new ImageIcon("C:\\Users\\ram\\Pictures\\info.png");
    JLabel jlb4 = new JLabel(img3); 
    
    
    B()
    {
         con = getContentPane();
        setLayout(null);
        con.add(jlb1);
        con.add(jlb4);
       jlb1.setBounds(20, 5, 140, 100); 
       jlb4.setBounds(350, 180, 173, 200);    
       jlb5.setBounds(30, 172, 80, 30);
       jtf1.setBounds(30, 198, 110, 20);
       jbb1.setBounds(200, 400, 80, 30);
      jlb2.setBounds(60, 107, 200, 100);
       jlb3.setBounds(20,107,50, 100);
       add(jlb3);
       add(jlb5);
       add(jtf1);
       add(jbb1);
       add(jlb2);
      jbb1.addActionListener(this);
       
           try
      {
         DriverManager.registerDriver(new sun.jdbc.odbc.JdbcOdbcDriver()); 
         ct = DriverManager.getConnection("jdbc:odbc:SWATI");
         sta = ct.createStatement();
     //    JOptionPane.showMessageDialog(rootPane, "Connection is ok");
      }
      catch(Exception ex)
      {
        JOptionPane.showMessageDialog(rootPane, ex);  
      }
           
    }
   public void actionPerformed( ActionEvent e)
   {
       if(e.getSource()==jbb1)
       {
         try
           {
            rst = sta.executeQuery("select * from GTBLACC where PHONE="+jtf1.getText()+""); //always use single inverted commas along double i.c. with string in quary 
             if(rst.next())  //get value
              {  
                 String stn;
                  stn = rst.getString(1);
                  jlb3.setText(stn); //It will set stn in place of jlb3(Swati).
             }
           }
             
     catch(Exception ep)
     {
         JOptionPane.showMessageDialog(rootPane, ep); 
     }  
   }
}
}