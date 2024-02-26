import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.regex.*;

public class frame5 implements ActionListener{

    JFrame frame; 
    JButton button,next;  
    ImageIcon icon; 
    JLabel label, heading, input, display, language, language1;
    JTextArea area;

    public frame5(){
        //create a new frame
        frame = new JFrame("String Processing");
       
        //DFA string Processing heading
        heading = new JLabel("DFA String Processing");
        heading.setBounds(300,30,400,50);
        heading.setFont(new Font("Arial", Font.BOLD, 30));

        //take input string to validate
        input = new JLabel("Enter the string to process");
        input.setBounds(50,120,300,40);
        input.setFont(new Font("Arial", Font.BOLD, 20));
        area = new JTextArea();
        area.setBounds(330,130,220,25);

        //add button
        button = new JButton("Validate");
        button.setBounds(570,130,100,25);
        button.addActionListener(this);

        //add image
        icon = new ImageIcon(getClass().getResource("dfa5.png"));
        Image image1 = icon.getImage();
        Image image2 = image1.getScaledInstance(400, 200,Image.SCALE_SMOOTH );
        icon = new ImageIcon(image2);
        label = new JLabel(icon);

        //add language
        language = new JLabel("L = { (wbab| w belongs to (a,b)*) }");
        language.setBounds(60,400,800,40);
        language.setFont(new Font("Arial", Font.BOLD, 20));
        language1 = new JLabel("To accept a string ending with bab"); 
        language1.setBounds(58,440,800,40);
        language1.setFont(new Font("Arial", Font.BOLD, 20));

        //display the output
        display = new JLabel();
        display.setBounds(60,500,700,25);
        display.setFont(new Font("Arial", Font.ITALIC, 20));

        //next button
       // next = new JButton("next");
       // next.setBounds(750,500,100,25);
        
        //adding all the coponents to the frame
        frame.add(heading);
        frame.add(input);
        frame.add(area);
        frame.add(button);
       // frame.add(next);
        frame.add(language);
        frame.add(language1);
        frame.add(display);
        frame.add(label);
        
        frame.setSize(900,600);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
       /* next.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent ev){
                 frame.dispose();
                 frame2 f = new frame2();
                 f.setVisible(true);   
           }
         });    */
    }  
  
    public void actionPerformed(ActionEvent event){
       String text = area.getText();
       String regex = "^[ab]*bab$";
       Pattern pattern = Pattern.compile(regex);
       Matcher matcher = pattern.matcher(text);
       boolean isMatch = matcher.matches();
       if(isMatch){
        display.setText("The string "+ text +" is accepted");
       }
       else{
        display.setText("The string "+ text +" is rejected");
       }
    }
    public static void main(String[] args){
        new frame4();
          
    }

    public void setVisible(boolean b) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setVisible'");
    }

}
