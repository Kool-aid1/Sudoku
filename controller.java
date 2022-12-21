 
import java.awt.CardLayout;
import javax.swing.*;
import java.awt.*;

public class controller extends JPanel{
    
    private static controller instance;

    JPanel cardLayout; //create panel of cards
    
    //Panels for pages
    login loginPanel;
    Main mainPanel;
    createAcc createAccPanel;
    sudokuPage sudokuPanel;
    ticTacToePage ticTacToePanel;

    public controller(){
        setSize(500,500);
        cardLayout = new JPanel(new CardLayout());

        loginPanel = new login();
        mainPanel = new Main();
        createAccPanel = new createAcc();
        sudokuPanel = new sudokuPage();
        ticTacToePanel = new ticTacToePage();

        cardLayout.add(loginPanel, "Login");
        cardLayout.add(mainPanel, "Main Page");
        cardLayout.add(createAccPanel, "Create Account");
        cardLayout.add(sudokuPanel, "Sudoku");
        cardLayout.add(ticTacToePanel, "Tic Tac Toe");

        add(cardLayout);
        setVisible(true);
    }

    private static void displayPanel(){
        JFrame title = new JFrame("Game Center");
        instance = new controller();
        title.getContentPane().add(instance);
        title.setSize(550,500);
        title.setVisible(true);
    }

    public void changeCard(String cards){
        CardLayout card = (CardLayout)(cardLayout.getLayout());
        card.show(cardLayout, cards);
    }

    public static controller getInstance(){
        return instance;
    }
    
    public static void main(String[] args){
        displayPanel();
    }
}