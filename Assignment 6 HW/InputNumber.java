//Parth Barot
 


import javax.swing.JOptionPane;

public class InputNumber
{
   public static void main(String[] args)
   {
      double number;
      String input;
         
         
      input = JOptionPane.showInputDialog(" Input a number ");
      number = Double.parseDouble(input);
         
                
      if (number > 0)
         JOptionPane.showMessageDialog(null,"Positive number " + number );
                  
      if (number <0)
         JOptionPane.showMessageDialog(null,"nagative number" +  number);
              
      if (number == 0)
         JOptionPane.showMessageDialog(null," the number is equalant to zero");
         
      System.exit(0);
         
         
   }
}