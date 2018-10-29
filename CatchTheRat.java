import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;
import java.awt.event.WindowAdapter;
class CatchTheRat extends JFrame
{
long startTime=System.currentTimeMillis();
int i=0;
JFrame fr=(JFrame) SwingUtilities.getWindowAncestor(this);
// The Rat

JLabel lb;


// Move it randomly!

Random r;


 public CatchTheRat(int k)
 {

 // Set frame properties

 setTitle("Catch The Rat");
 setLayout(new FlowLayout());
 setDefaultCloseOperation(EXIT_ON_CLOSE);
 setVisible(true);


 // Set the background (just for a good look)

 setContentPane(new JLabel(new ImageIcon("background.jpg")));


 // Set layout to the content pane
 getContentPane().setLayout(new FlowLayout());


 // Create the rat

 lb=new JLabel(new ImageIcon("rat.png"));


 // Add the rat

 getContentPane().add(lb);


 // Create Random object

 r=new Random();


 // Create a timer and call it for every k seconds

 new Timer(k,new ActionListener(){


  public void actionPerformed(ActionEvent ae)
  {
  

  // Move the rat randomly, subtract 75, so that the rat should not meet the edges
  
  lb.setLocation(r.nextInt(getWidth()-75),r.nextInt(getHeight()-75));


  }


 }).start();


 // Add mouselistener, notify when user clicks it!

 lb.addMouseListener(new MouseAdapter(){

