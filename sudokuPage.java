import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class sudokuPage extends JPanel implements ActionListener{

    private JLabel game, prompt;
    private JButton back, newGame;
    //private JButton buttonPanel = new JButton();
    //private JButton[] buttons = new JButton[81];

    public sudokuPage(){

        JPanel main = new JPanel();
        JPanel title = new JPanel();
        JPanel gameControls = new JPanel();
        JPanel buttonLayout = new JPanel();

        JPanel sudokuGrid = new JPanel(new GridLayout(9,0));
        sudokuGrid.setPreferredSize(new Dimension(400,400));
        for(int i = 0; i < 81; ++i){
            JTextField field = new JTextField();
            field.setHorizontalAlignment(JTextField.CENTER);
            sudokuGrid.add(field);
        }

        game = new JLabel("Sudoku");
        title.add(game);

        /* beginning setup with buttons but decided textfield easier to use
        buttonPanel.setLayout(new GridLayout(9,9));

        for(int i = 0; i < 81; i++){//to fill the 9 buttons for tic tac toe
            buttons[i] = new JButton("8");// fill each button
            buttonPanel.add(buttons[i]);// add/push the button
            buttons[i].setFont(new Font("Arial",Font.BOLD,20));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
            buttons[i].setPreferredSize(new Dimension(40,40));
            buttons[i].setBorder(new LineBorder(Color.black));
        }
        */
        back = new JButton("Back");
        back.addActionListener(this);
        newGame = new JButton("New Game");
        newGame.addActionListener(this);

        buttonLayout.setLayout(new BoxLayout(buttonLayout, BoxLayout.X_AXIS));
        buttonLayout.add(back);
        buttonLayout.add(newGame);

        gameControls.add(sudokuGrid);

        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
        main.add(title);
        main.add(gameControls);
        main.add(buttonLayout);

        add(main);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent e){

        if(e.getSource() == back){
            controller.getInstance().changeCard("Main Page");
        }
    }
}



