
package javaapplication123;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class JavaApplication123 extends JFrame {
    JButton [] buttons = new JButton[9];
    char playermark = 'X' ;
    int i;
    JavaApplication123()
    {
        setLayout(new GridLayout(3,3));
    for(i=0;i<=8;i++)
    {
       buttons[i] = new JButton();
       buttons[i].setText("-");
       buttons[i].setBackground(Color.white);       
       buttons[i].addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
             JButton buttonclicked = (JButton)e.getSource();  //get the particularbutton that was clicked
             buttonclicked.setText(String.valueOf(playermark));
             if(playermark=='X')
             {
                 playermark ='O';
              buttonclicked.setBackground(Color.cyan);
        
             }
             else
             {
                 playermark='X';
                  buttonclicked.setBackground(Color.orange); 
             }
               displayvictor();
                }
            });
    
   add(buttons[i]);   
    }
}
    
    public void displayvictor()
    {
       if(checkforwinner()==true)
       {
          //reverse the player mark
          //because if we put x and we win after that the game change it into o.
         //but x is the winner so first reverse the player mark
         if(playermark=='X')
             playermark = 'O';
         else
             playermark = 'X';
         
         JOptionPane pane = new JOptionPane();
        int dialogresult = JOptionPane.showConfirmDialog(pane,"Game over,"+playermark +" wins.Would you like to play again?","Game Over.",JOptionPane.YES_NO_OPTION);
      if(dialogresult == JOptionPane.YES_NO_OPTION)
          resetthebuttons();
      else
          System.exit(0);
       
       }
       
       else if(checkdraw())
       {
           JOptionPane pane = new JOptionPane();
        int dialogresult = JOptionPane.showConfirmDialog(pane,"Draw , Play again.", "Game over",JOptionPane.YES_NO_OPTION); 
          if(dialogresult == JOptionPane.YES_NO_OPTION)
          resetthebuttons();
      else
          System.exit(0);
       
       }
    }
    public void resetthebuttons()
  {
      for(int i=0;i<=8;i++)
      {
         playermark ='X';
         buttons[i].setText("-");
         buttons[i].setBackground(Color.white);
      }
  }
    public boolean checkdraw()
    {
        boolean full = true;
        for(int i=0;i<=8;i++)
        {
           if(buttons[i].getText().charAt(0)=='-')
           {
               full = false;
           }
        }
        return full;
    }
    public boolean checkforwinner()
    {
        if(checkrows()==true||checkcolumns()==true||checkdiagonals()==true)
         return true;
        else
            return false;
    }
    public boolean checkrows()
    {
        int i=0;
        for(int j=0;j<3;j++)
        {
           if( buttons[i].getText().equals(buttons[i+1].getText())&& buttons[i].getText().equals(buttons[i+2].getText())&& buttons[i].getText().charAt(0)!='-')
            {
                return true;
            }
         i = i+3;
        }
        return false;
    }
      public boolean checkcolumns()
    {
        int i=0;
        for(int j=0;j<3;j++)
        {
           if(buttons[i].getText().equals(buttons[i+3].getText())&&buttons[i].getText().equals(buttons[i+6].getText())&& buttons[i].getText().charAt(0)!='-')
            {
                return true;
            }
          i++;
        }
        return false;
    }
      public boolean checkdiagonals()
    {
           if(buttons[0].getText().equals(buttons[4].getText())&&buttons[0].getText().equals(buttons[8].getText())&& buttons[0].getText().charAt(0)!='-')
                return true;
           else if(buttons[2].getText().equals(buttons[4].getText())&&buttons[2].getText().equals(buttons[6].getText())&& buttons[2].getText().charAt(0)!='-')
          return true;   
           else 
               return false;
   }
       
 
  
    public static void main(String[] args) {
        JavaApplication123 jv = new JavaApplication123();
        jv.setSize(500,500);
        jv.setVisible(true);
        jv.setTitle("Tic Tac Toe Game");
        jv.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jv.setLocation(500, 200); 

        
    }
}