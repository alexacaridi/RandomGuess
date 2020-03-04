/*ch.14 GUI based version of the RandomGuess2 application from ch.5
Filename: RandomGuessGUI.java
Alexa 3/3/2020 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RandomGuessGUI extends JFrame implements ActionListener
{
    //instance objects /variables/constants for this class
    JLabel title = new JLabel("Random Guess Game");
    JLabel instructions = new JLabel("Please enter a number between 1 and 10:");
    JTextField input = new JTextField(3);
    JLabel compResult = new JLabel("");
    JLabel summary = new JLabel("");

    JButton button = new JButton("Play Game");

    //constructor for the RandomGuessGUI class
    public RandomGuessGUI()
    {
        //use JFrame constructor to construct THIS object
        super("Random Guess");
        setBounds(550, 250, 300, 180);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //layout manager for the GUI
        setLayout(new FlowLayout());

        //add instance objects to the frame
        add(title);
        add(instructions);
        add(input);
        add(compResult);
        add(button);
        add(summary);

        //add the listener method to the button
        button.addActionListener(this);
    }

    //actionPerformed method details what should happen when the ActionListener button is clicked on
    @Override
    public void actionPerformed(ActionEvent e)
    {
        playGame(); //run a method that will generate the results of the game
    }

    //method that handles the actual game RandomGuess2 (copy and past from RandomGuess2 file)
    public void playGame()
    {
        //variables and constants
        int userGuess;
        int compNum;
        String msg;

        //input
        userGuess = Integer.parseInt(input.getText());
        
        //calculation phase
        compNum = (1+(int)(Math.random()*10));

        if(userGuess == compNum)
        {
            msg = "YOU WON!";
        }
        else
        {
            if(userGuess > compNum)
            {
                msg = "Your guess is too high!";
            }
            else
            {
                msg = "Your guess is too low!";
            }
        }

        //output phase
        compResult.setText("Computer's number is: " + compNum);
        summary.setText(msg);
    }

    //main method to start the application which in turn creates an object from the RandomGuessGUI class
    public static void main(String[] args)
    {
        RandomGuessGUI game = new RandomGuessGUI();
        game.setVisible(true);
    }
}