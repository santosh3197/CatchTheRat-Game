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


  public void mouseClicked(MouseEvent me)
  {

    
  // Create a beep sound when clicked to notify

  Toolkit.getDefaultToolkit().beep();


  // Also print it!
i++;
  System.out.println("Caught!");
if(i>=4)
{
long endTime = System.currentTimeMillis();
long elapsedMilliSeconds= endTime - startTime;
double elapsedSeconds = elapsedMilliSeconds / 1000.0;
System.out.println("Caught 5 times in: "+elapsedSeconds+" seconds");
//Thread.sleep(5000);
if(elapsedSeconds<=15)
{
System.out.print("\n win ");
}
else 
System.out.print("\n loose");
System.exit(0);
}
  
  }


 });


 // Maximize the frame

 setExtendedState(MAXIMIZED_BOTH);


 }


 public static void main(String args[])
 {

long startTime = System.currentTimeMillis();
 // Create Scanner object
//CatchTheRat r=new CatchTheRat(startTime);
 Scanner s=new Scanner(System.in);


 // Let the user enter his capability of catching the rat!

 System.out.println("Enter the speed");


 // Read the input

 int k=s.nextInt();


 // Create the frame and send the value of k

new CatchTheRat(k);
 }

} 
