import javax.swing.*;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.util.regex.*;

public class frame1 implements ActionListener{

    JFrame frame; 
    JButton button,next;  
    ImageIcon icon; 
    JLabel label, heading, input, display, language;
    JTextArea area;

    public frame1(){
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
        icon = new ImageIcon(getClass().getResource("dfa1.png"));
        Image image1 = icon.getImage();
        Image image2 = image1.getScaledInstance(300, 150,Image.SCALE_SMOOTH );
        icon = new ImageIcon(image2);
        label = new JLabel(icon);

        //add language
        language = new JLabel("L = {W : W has even number of a's}");
        language.setBounds(60,400,800,40);
        language.setFont(new Font("Arial", Font.BOLD, 20));

        //display the output
        display = new JLabel();
        display.setBounds(60,450,700,25);
        display.setFont(new Font("Arial", Font.ITALIC, 20));

        //next button
        next = new JButton("next");
        next.setBounds(750,500,100,25);
        
        //adding all the coponents to the frame
        frame.add(heading);
        frame.add(input);
        frame.add(area);
        frame.add(button);
        frame.add(next);
        frame.add(language);
        frame.add(display);
        frame.add(label);
        
        frame.setSize(900,600);
        frame.setVisible(true);
    }  
    public void actionPerformed(ActionEvent event){
       String text = area.getText();
       String regex = "^(|a{2})*$";
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
        new frame1();
          
    }
}

