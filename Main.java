import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Main extends JPanel implements ActionListener{
 private JLabel welcome, logoLabel;
 private JButton playSudoku, playTicTacToe, logout;
 private ImageIcon logo;

    public Main(){
        //creating welcome label
        JPanel main =  new JPanel();
        JPanel title = new JPanel();
        JPanel sudoku = new JPanel();
        JPanel ticTacToe = new JPanel();
        JPanel logoutPanel = new JPanel();
        JPanel logoPanel = new JPanel();


        //Title of main page
        welcome = new JLabel("Game Center");
        welcome.setFont(new Font("Arial", Font.BOLD, 40));
        welcome.setForeground(Color.BLACK);


        //logo of page
        logo = new ImageIcon("/Users/kennyly/testProject/myApp/photos/gameCenterLogo.jpg");
        logoLabel = new JLabel(logo);
        
        //Sudoku button
        playSudoku = new JButton("Sudoku");
        playSudoku.addActionListener(this);
        playSudoku.setPreferredSize(new Dimension(150, 35));

        //Tic Tac Toe button
        playTicTacToe = new JButton("Tic Tac Toe");
        playTicTacToe.addActionListener(this);
        playTicTacToe.setPreferredSize(new Dimension(150, 35));

        //logout button
        logout = new JButton("Log Out");
        logout.addActionListener(this);
        logout.setPreferredSize(new Dimension(150, 35));

        //for formatting of page
        title.add(welcome);
        logoPanel.add(logoLabel);
        sudoku.add(playSudoku);
        ticTacToe.add(playTicTacToe);
        logoutPanel.add(logout);

        //added to main panel
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
        
        main.add(logoPanel);
        main.add(title);
        main.add(sudoku);
        main.add(ticTacToe);
        main.add(logoutPanel);

        add(main);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //sudoku button to send to sudoku page
        if(e.getSource() == playSudoku){
            controller.getInstance().changeCard("Sudoku");
        }
        //tic tac toe button to send to tic tac toe page
        if(e.getSource() == playTicTacToe){
            controller.getInstance().changeCard("Tic Tac Toe");
        }
        if(e.getSource() == logout){
            controller.getInstance().changeCard("Login");
        }
    }
} 