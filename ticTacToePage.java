import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class ticTacToePage extends JPanel implements ActionListener{

    private JLabel game;
    private JButton back, newGame, 
                    button1, button2, button3, 
                    button4, button5, button6, 
                    button7, button8, button9;

    public ticTacToePage(){

        JPanel main = new JPanel();
        JPanel title = new JPanel();
        JPanel topRow = new JPanel();
        JPanel midRow = new JPanel();
        JPanel botRow = new JPanel();
        JPanel players = new JPanel();
        JPanel controls = new JPanel();

        game = new JLabel("Tic Tac Toe");
        title.add(game);

        //buttons to chose which square to set x/o
        button1 = new JButton(" ");
        button1.addActionListener(this);
        button1.setPreferredSize(new Dimension(100,100));

        button2 = new JButton(" ");
        button2.addActionListener(this);
        button2.setPreferredSize(new Dimension(100,100));

        button3 = new JButton(" ");
        button3.addActionListener(this);
        button3.setPreferredSize(new Dimension(100,100));

        button4 = new JButton(" ");
        button4.addActionListener(this);
        button4.setPreferredSize(new Dimension(100,100));

        button5 = new JButton(" ");
        button5.addActionListener(this);
        button5.setPreferredSize(new Dimension(100,100));

        button6 = new JButton(" ");
        button6.addActionListener(this);
        button6.setPreferredSize(new Dimension(100,100));

        button7 = new JButton(" ");
        button7.addActionListener(this);
        button7.setPreferredSize(new Dimension(100,100));

        button8 = new JButton(" ");
        button8.addActionListener(this);
        button8.setPreferredSize(new Dimension(100,100));

        button9 = new JButton(" ");
        button9.addActionListener(this);
        button9.setPreferredSize(new Dimension(100,100));

        //control buttons
        back = new JButton("Back");
        back.addActionListener(this);
        newGame = new JButton("New Game");

        topRow.add(button1);    topRow.add(button2);    topRow.add(button3);
        midRow.add(button4);    midRow.add(button5);    midRow.add(button6);
        botRow.add(button7);    botRow.add(button8);    botRow.add(button9);

        controls.add(back);
        controls.add(newGame);

        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
        main.add(title);
        main.add(topRow);
        main.add(midRow);
        main.add(botRow);
        main.add(controls);

        add(main);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent e){
        
        if(e.getSource() == back){
            controller.getInstance().changeCard("Main Page");
        }
        
        if(e.getSource() == button1){
            button1.setText("X");
        }
       
    }
}


