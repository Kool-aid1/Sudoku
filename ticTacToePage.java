import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class ticTacToePage extends JPanel implements ActionListener{

    private JLabel game, prompt;
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
        JPanel buttonLayout = new JPanel();

        game = new JLabel("Tic Tac Toe");
        title.add(game);

        prompt = new JLabel("Player");
        prompt.setFont(new Font("Arial", Font.PLAIN, 30));
        //players.add(prompt);

        //buttons to chose which square to set x/o
        button_panel.setLayout(new GridLayout(3,3));
        //button_panel.setBackground(new Color(0,255,255));//make color to cyan

        for(int i = 0; i < 9; i++){//to fill the 9 buttons for tic tac toe
            buttons[i] = new JButton(" ");// fill each button
            button_panel.add(buttons[i]);// add/push the button
            buttons[i].setFont(new Font("Comic Sans MS",Font.BOLD,50));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
            buttons[i].setPreferredSize(new Dimension(100,100));
        }


        //control buttons
        back = new JButton("Back");
        back.addActionListener(this);
        newGame = new JButton("New Game");

        buttonLayout.setLayout(new BoxLayout(buttonLayout, BoxLayout.X_AXIS));
        buttonLayout.add(back);
        buttonLayout.add(newGame);

        players.setLayout(new BoxLayout(players, BoxLayout.Y_AXIS));
        players.add(prompt);
        players.add(buttonLayout);

        //formatting
        controls.add(button_panel);
        controls.add(players);
        //controls.add(back);
        //controls.add(newGame);

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
        
        for(int i = 0; i < 9; i++) //check each of the nine buttons
        {
            if(e.getSource() == buttons[i]) { //
                if(player)//check to see whose turn it is
                {
                    if(buttons[i].getText() == " ") //check if there is any text assigned to the button
                    {
                        buttons[i].setForeground(new Color(153,0,0));//set to dark red for player 1
                        buttons[i].setText("X");// set to X
                        player = false;

                        prompt.setText("O turn");// let the user know to swap turns

                        //check();
                    }
                }
                else { //if it is not player1
                    if(buttons[i].getText() == " ") //check if there is any text assigned to the button
                    {
                        buttons[i].setForeground(new Color(0,204,102));//set to light green for player 2
                        buttons[i].setText("O");// set to X
                        player = true;

                        prompt.setText("X turn");// let the user know to swap turns
                        
                        //check();
                    }
                }
            } 
        }
       
    }


}


