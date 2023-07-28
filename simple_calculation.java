
package javaapplication121;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;



public class simple_calculation extends Frame implements ActionListener{
    
    Label l1 = new Label("Enter the first number:");
    Label l2 = new Label("Enter the second number:");
    Label l3 = new Label("The result is:");
    TextField tf1 = new TextField(30);  //TextField has by default String so convert later into integer
    TextField tf2 = new TextField(30);
    TextField tf3 = new TextField(30);
    Button b1 = new Button("Addition");
    Button b2 = new Button("Subtract");
    Button b3 = new Button("Multiplication");
    Button b4 = new Button("Division");
    Button b5 = new Button("Mode");
    Button b6 = new Button("Close");
    Button b7 = new Button("Reset");
    simple_calculation()
    {
      //  setLayout(new FlowLayout());
        setLayout(null);
         l1.setBounds(100,100,150,30);
        l2.setBounds(100,150,150,30);
        l3.setBounds(100,200,150,30);
        tf1.setBounds(270,100,100,30);
        tf2.setBounds(270,150,100,30);
        tf3.setBounds(270,200,100,30);
        b1.setBounds(100, 280, 90, 30);
        b2.setBounds(220, 280, 90, 30);
        b3.setBounds(340, 280, 90, 30);
        b4.setBounds(100, 340, 90, 30);
        b5.setBounds(220, 340, 90, 30);
        b6.setBounds(320, 340, 90, 30);
        b7.setBounds(420, 340, 90,30);
      add(l1); 
      add(tf1); 
      add(l2); 
      add(tf2); 
      add(l3); 
      add(tf3); 
      add(b1); 
      add(b2); 
      add(b3); 
      add(b4); 
      add(b5); 
      add(b6); 
      add(b7); 
      b1.addActionListener(this);
      b2.addActionListener(this);
      b3.addActionListener(this);
      b4.addActionListener(this);
      b5.addActionListener(this);
      b6.addActionListener(this);
      b7.addActionListener(this); 
      
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==b1)
        {
            int i,j,k;
            i = Integer.parseInt(tf1.getText());
            j = Integer.parseInt(tf2.getText());
            k = i+j;
            tf3.setText(k+"");
        }
        if(ae.getSource()==b2)
        {
            int a,b,c;
            a = Integer.parseInt(tf1.getText());
            b = Integer.parseInt(tf2.getText());
            c = a-b;
            tf3.setText(c+"");
        }
        if(ae.getSource()==b3)
        {
            int m,n,p;
            m = Integer.parseInt(tf1.getText());
            n = Integer.parseInt(tf2.getText());
            p = m*n;
            tf3.setText(p+"");
        }
        if(ae.getSource()==b4)
        {
            int x,y,z;
            x = Integer.parseInt(tf1.getText());
            y = Integer.parseInt(tf2.getText());
            z = x/y;
            if(y==0)
            {
                JOptionPane.showMessageDialog(this, "Cannot divide by zero");
            }
            tf3.setText(z+"");
        }
         if(ae.getSource()==b5)
        {
            int u,v,w;
            u = Integer.parseInt(tf1.getText());
            v = Integer.parseInt(tf2.getText());
            w = u%v;
            tf3.setText(w+"");
        }
          if(ae.getSource()==b6)
        {
           System.exit(1);
        }
          if(ae.getSource()==b7)
        {
            tf1.setText("");
            tf2.setText("");
            tf3.setText("");
        } 
    }

    
    public static void main(String[] args) {
        simple_calculation jv = new simple_calculation();
        jv.setSize(550,550);
        jv.setVisible(true);
        jv.setTitle("Calculation");
        jv.addWindowListener(new WindowAdapter()
        { 
           public void windowClosing(WindowEvent ev)
           {
             System.exit(1);  
           }
       });
}
}
