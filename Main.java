import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;

public class Main extends JPanel implements ActionListener{
 private JLabel welcome;
 private JButton playSudoku, playTicTacToe;
 
    public Main(){
        //creating welcome label
        JPanel main =  new JPanel();
        JPanel title = new JPanel();
        JPanel sudoku = new JPanel();
        JPanel ticTacToe = new JPanel();


        welcome = new JLabel("Game Center");
        welcome.setFont(new Font("Arial", Font.BOLD, 40));
        welcome.setForeground(Color.BLACK);

        playSudoku = new JButton("Sudoku");
        playSudoku.addActionListener(this);
        playSudoku.setPreferredSize(new Dimension(150, 35));

        playTicTacToe = new JButton("Tic Tac Toe");
        playTicTacToe.addActionListener(this);
        playTicTacToe.setPreferredSize(new Dimension(150, 35));

        title.add(welcome);
        sudoku.add(playSudoku);
        ticTacToe.add(playTicTacToe);

        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
        main.add(title);
        main.add(sudoku);
        main.add(ticTacToe);

        add(main);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == playSudoku){
            controller.getInstance().changeCard("Sudoku");
        }
        if(e.getSource() == playTicTacToe){
            controller.getInstance().changeCard("Tic Tac Toe");
        }
        
    }
} 