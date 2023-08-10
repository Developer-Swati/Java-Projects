package chatapplication;

import static chatapplication.Server.f;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;
import java.text.*;
import java.util.*;
import java.net.*;
import java.io.*;

    public class Client implements ActionListener{
    JTextField text;
    static JPanel a1;
    static DataOutputStream dout;
    static JFrame f = new JFrame();
    static Box vertical = Box.createVerticalBox(); // Align Hello(msg) vertical one after another
    Scrollbar scroll = new Scrollbar();
    Client(){
        f.setLayout(null);
        JPanel p1 = new JPanel();
        p1.setBackground(new Color(7,94,84));
        p1.setBounds(0, 0, 450, 70);
        p1.setLayout(null);
        f.add(p1);
        //Adding Arrow(Back)
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/3.png"));
        Image i2 = i1.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT); //Belongs to AWT
        ImageIcon i3 = new ImageIcon(i2);
        JLabel back = new JLabel(i3); //Can't Pass AWT onject so modify into swing
        back.setBounds(5, 20, 25, 25);
        p1.add(back);
        back.addMouseListener(new MouseAdapter() {
           public void mouseClicked(MouseEvent ae){
               System.exit(0);
           } 
        });
        //Adding Profile Picture
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/2.png"));
        Image i5 = i4.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel profile = new JLabel(i6);
        profile.setBounds(42, 10, 50, 50);
        p1.add(profile);
        // Adding video logo
        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("icons/video.png"));
        Image i8 = i7.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i8);
        JLabel video = new JLabel(i9);
        video.setBounds(300, 20, 30, 30);
        p1.add(video);
        // Adding phone logo
        ImageIcon i10 = new ImageIcon(ClassLoader.getSystemResource("icons/phone.png"));
        Image i11 = i10.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
        ImageIcon i12 = new ImageIcon(i11);
        JLabel phone = new JLabel(i12);
        phone.setBounds(360, 20, 30, 30);
        p1.add(phone);
        // Adding morevert logo
        ImageIcon i13 = new ImageIcon(ClassLoader.getSystemResource("icons/3icon.png"));
        Image i14 = i13.getImage().getScaledInstance(10, 25, Image.SCALE_DEFAULT);
        ImageIcon i15 = new ImageIcon(i14);
        JLabel morevert = new JLabel(i15);
        morevert.setBounds(410, 20, 10, 25);
        p1.add(morevert);

        //Adding name
        JLabel name = new JLabel("Peter");
        name.setBounds(110,15 ,100, 18);
        name.setForeground(Color.WHITE);
        name.setFont(new Font("SAN-SERIF",Font.BOLD,18));
        p1.add(name);
        
        //Adding Status
        JLabel status = new JLabel("Active Now");
        status.setBounds(110,39 ,100, 14);
        status.setForeground(Color.WHITE);
        status.setFont(new Font("SAN-SERIF",Font.BOLD,14));
        p1.add(status);
        
        //Design new panel
        a1 = new JPanel();
        a1.setBounds(4, 75, 442, 520);
        f.add(a1);
        
        //Adding textfield
        text = new JTextField();
        text.setBounds(4, 600, 315, 40);
        text.setFont(new Font("SAN_SERIF",Font.PLAIN,16)); //For text
        f.add(text);
        
         //Adding scrollbar       
       /* scroll.setOrientation(Scrollbar.VERTICAL);
        scroll.setBounds(800, 70, 30, 600);
        scroll.setMaximum(600);
        scroll.setMinimum(70);
        scroll.setVisibleAmount(30);
        a1.add(scroll);*/
        
        
        //Adding button
        JButton send = new JButton("Send"); //Adding to frame not to panel
        send.setBounds(322, 600, 118, 40);
        send.setBackground(new Color(7,94,84));
        send.setForeground(Color.WHITE);
        send.setFont(new Font("SAN_SERIF",Font.PLAIN,16));
        f.add(send);
        send.addActionListener(this);
        //designing frame
        f.setSize(450,650);
        f.setLocation(800, 50);
        f.setUndecorated(true); //To remove header of frame
        f.getContentPane().setBackground(Color.WHITE);
        f.setVisible(true);
        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);

    }
    public void actionPerformed(ActionEvent ae){
        try{
      String out = text.getText();  
      JPanel p2 = formatLabel(out);
      a1.setLayout(new BorderLayout());// can add component at top, below,right and left as well as cener
      JPanel right = new JPanel(new BorderLayout());
      right.add(p2,BorderLayout.LINE_END);
      vertical.add(right);
      vertical.add(Box.createVerticalStrut(15));
      a1.add(vertical,BorderLayout.PAGE_START);
      dout.writeUTF(out);
      // to empty textbar
      text.setText("");
      //To reload messages
      f.repaint(); //Method inside JFrame to reload frame
      f.invalidate();
      f.validate();
        }catch(Exception e){
            e.printStackTrace();
        }         
    }
    public static JPanel formatLabel(String out){
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); //Y_AXIS means vertical
        //CSS to add width of 150px
        JLabel output = new JLabel("<html><p style=\"width: 150px\">"+ out +"</p></html>"); 
        output.setFont(new Font("Tahoma",Font.PLAIN,16));
        output.setBackground(new Color(37,211,102));
        output.setOpaque(true);
        output.setBorder(new EmptyBorder(15, 15, 15, 50));
        panel.add(output);
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        JLabel time = new JLabel();
         //To get current time
        time.setText(sdf.format(cal.getTime()));
        panel.add(time);
        return panel;
    }
    public static void main(String args[]){
        new Client();
        try{
            // Create Socket to connect to Server
           Socket s = new Socket("127.0.0.1",6001);  // local host 
           DataInputStream din = new DataInputStream(s.getInputStream()); // to receive(read) message
           dout = new DataOutputStream(s.getOutputStream()); // to send message
           while(true){
                    a1.setLayout(new BorderLayout());
                    String msg = din.readUTF(); // Use protocol readUTF to read msg
                    JPanel panel = formatLabel(msg);
                    JPanel left = new JPanel(new BorderLayout());
                    left.add(panel,BorderLayout.LINE_START); // show received msg left send
                    vertical.add(left); // to verticle align msgs
                    vertical.add(Box.createVerticalStrut(15));
                    a1.add(vertical,BorderLayout.PAGE_START);
                    f.validate();
                    
                }

           
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}

