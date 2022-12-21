import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class ticTacToePage extends JPanel implements ActionListener{

    private JLabel game;
    private JButton back, newGame;
    private JButton button_panel = new JButton();
    private JButton[] buttons = new JButton[9];
    Random r = new Random();
    boolean player;
                    

    public ticTacToePage(){

        JPanel main = new JPanel();
        JPanel title = new JPanel();
        JPanel players = new JPanel();
        JPanel controls = new JPanel();

        game = new JLabel("Tic Tac Toe");
        title.add(game);

        //buttons to chose which square to set x/o
        button_panel.setLayout(new GridLayout(3,3));
        //button_panel.setBackground(new Color(0,255,255));//make color to cyan

        for(int i = 0; i < 9; i++){//to fill the 9 buttons for tic tac toe
            buttons[i] = new JButton(" ");// fill each button
            button_panel.add(buttons[i]);// add/push the button
            buttons[i].setFont(new Font("Comic Sans MS",Font.BOLD,120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
            buttons[i].setPreferredSize(new Dimension(100,100));
        }

        //control buttons
        back = new JButton("Back");
        back.addActionListener(this);
        newGame = new JButton("New Game");

        //formatting
        controls.add(button_panel);
        controls.add(back);
        controls.add(newGame);

        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
        main.add(title);
        main.add(controls);

        add(main);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent e){
        
        if(e.getSource() == back){
            controller.getInstance().changeCard("Main Page");
        }
        
        /*if(e.getSource() == newGame){
            ticTacToePage t = new ticTacToePage();    
        }*/
       
    }
}


