import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

//import javax.swing.event.DocumentEvent;
//import javax.swing.event.DocumentListener;

public class ticTacToePage extends JPanel implements ActionListener{

    private JLabel game, prompt, winsX, winsO;
    private JButton back, newGame;
    private JButton button_panel = new JButton();
    private JButton[] buttons = new JButton[9];
    Random r = new Random(); //simulate which player will go up
    boolean player; //to check which player's turn it is
    int count; //track the number of steps
    int xWins;
    int oWins;

    public ticTacToePage(){

        JPanel main = new JPanel();
        JPanel title = new JPanel();
        JPanel players = new JPanel();
        JPanel playerPoints = new JPanel();
        JPanel player_X = new JPanel();
        JPanel player_O = new JPanel();
        JPanel gameControls = new JPanel();
        JPanel buttonLayout = new JPanel();

        game = new JLabel("Tic Tac Toe");
        title.add(game);

        prompt = new JLabel("Player");
        prompt.setFont(new Font("Arial", Font.PLAIN, 30));
        players.add(prompt);

        //tuan licks dick
        winsX = new JLabel("X Wins:");
        winsX.setFont(new Font("Arial", Font.PLAIN, 30));
        player_X.add(winsX);
        
        winsO = new JLabel("O Wins:");
        winsO.setFont(new Font("Arial", Font.PLAIN, 30));
        player_O.add(winsO);


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
        newGame.addActionListener(this);

        buttonLayout.setLayout(new BoxLayout(buttonLayout, BoxLayout.X_AXIS));
        buttonLayout.add(back);
        buttonLayout.add(newGame);

        players.setLayout(new FlowLayout(FlowLayout.CENTER));
        players.add(prompt);
        //players.add(buttonLayout);

        playerPoints.setLayout(new BoxLayout(playerPoints, BoxLayout.Y_AXIS));
        playerPoints.add(player_X);
        playerPoints.add(player_O);
        //formatting
        gameControls.add(button_panel);
        gameControls.add(playerPoints);

        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
        //main.add(title);
        main.add(gameControls);
        main.add(players);
        main.add(buttonLayout);

        add(main);
        setVisible(true);

        startGame();
    }
    /*
     * Which player goes first when game is loaded
     */
    public void startGame(){
        for(int i = 0; i < 9; i++){ //restart game
            buttons[i].setText(" "); //empty each tile
            buttons[i].setEnabled(true); //allow player to click on buttons
            buttons[i].setBackground(null);
            count = 0;
        }
        
        int player_turn = r.nextInt(100);//set a random number between 1-100
        if(player_turn % 2 == 0){ //if there is no remainder
            player = true;
            prompt.setText("X turn");
        }
        else{
            player = false;
            prompt.setText("O turn");
        }
    }
    /*
     * Check if a player has won
     * or any winning conditions
     */
    public void check(){

        if((buttons[0].getText() == "X") && 
           (buttons[1].getText() == "X") &&
           (buttons[2].getText() == "X")) {
            X(0, 1, 2); //gets the top row
           }
        if((buttons[3].getText() == "X") && 
           (buttons[4].getText() == "X") &&
           (buttons[5].getText() == "X")){
            X(3, 4, 5); // gets the second row
        }
        if((buttons[6].getText() == "X") && 
           (buttons[7].getText() == "X") &&
           (buttons[8].getText() == "X")){
            X(6, 7, 8); // gets the last row
        }

        if((buttons[0].getText() == "X") &&
           (buttons[3].getText() == "X") &&
           (buttons[6].getText() == "X")) {
            X(0, 3, 6); // gets the left column
        }
        if((buttons[1].getText() == "X") &&
           (buttons[4].getText() == "X") &&
           (buttons[7].getText() == "X")) {
            X(1, 4, 7); // gets the middle column
        }
        if((buttons[2].getText() == "X") &&
           (buttons[5].getText() == "X") &&
           (buttons[8].getText() == "X")) {
            X(2, 5, 8); // gets the right column
        }

        if((buttons[0].getText() == "X") &&
           (buttons[4].getText() == "X") &&
           (buttons[8].getText() == "X")) {
            X(0, 4, 8); // for left diagonal
        }
        if((buttons[2].getText() == "X") &&
           (buttons[4].getText() == "X") &&
           (buttons[6].getText() == "X")) {
            X(2, 4, 6); // for right diagonal
        }

        if((buttons[0].getText() == "O") && 
           (buttons[1].getText() == "O") &&
           (buttons[2].getText() == "O")) {
            O(0, 1, 2); //gets the top row
           }
        if((buttons[3].getText() == "O") && 
           (buttons[4].getText() == "O") &&
           (buttons[5].getText() == "O")){
            O(3, 4, 5); // gets the second row
        }
        if((buttons[6].getText() == "O") && 
           (buttons[7].getText() == "O") &&
           (buttons[8].getText() == "O")){
            O(6, 7, 8); // gets the last row
        }

        if((buttons[0].getText() == "O") &&
           (buttons[3].getText() == "O") &&
           (buttons[6].getText() == "O")) {
            O(0, 3, 6); // gets the left column
        }
        if((buttons[1].getText() == "O") &&
           (buttons[4].getText() == "O") &&
           (buttons[7].getText() == "O")) {
            O(1, 4, 7); // gets the middle column
        }
        if((buttons[2].getText() == "O") &&
           (buttons[5].getText() == "O") &&
           (buttons[8].getText() == "O")) {
            O(2, 5, 8); // gets the right column
        }
        
        if((buttons[0].getText() == "O") &&
           (buttons[4].getText() == "O") &&
           (buttons[8].getText() == "O")) {
            O(0, 4, 8); // for left diagonal
        }
        if((buttons[2].getText() == "O") &&
           (buttons[4].getText() == "O") &&
           (buttons[6].getText() == "O")) {
            O(2, 4, 6); // for right diagonal
        }
        /*
         * check to see if there is a tie
         */
        if(count == 9){
            prompt.setText("Match is tied!");
            buttons[0].setBackground(Color.GRAY);
            buttons[1].setBackground(Color.GRAY);
            buttons[2].setBackground(Color.GRAY);
            buttons[3].setBackground(Color.GRAY);
            buttons[4].setBackground(Color.GRAY);
            buttons[5].setBackground(Color.GRAY);
            buttons[6].setBackground(Color.GRAY);
            buttons[7].setBackground(Color.GRAY);
            buttons[8].setBackground(Color.GRAY);
        }   
    }
    /*
     * Player using 'X' wins
     * highligh the specific grid in red
     */
    public void X(int x, int y, int z){

        buttons[x].setBackground(Color.RED);
        buttons[y].setBackground(Color.RED);
        buttons[z].setBackground(Color.RED);
        
        prompt.setText("Player X won the game");
        xWins++;
        winsX.setText("X Wins: "+ xWins);

        //Set buttons disabled after win
        for(int i = 0; i < 9; i++){
            buttons[i].setEnabled(false);
        }
    }
    /*
     * Player using 'O' wins
     * highlight the specific grid in green
     */
    public void O(int x, int y, int z){

        buttons[x].setBackground(Color.GREEN);
        buttons[y].setBackground(Color.GREEN);
        buttons[z].setBackground(Color.GREEN);

        prompt.setText("Player O won the game");
        oWins++; 
        winsO.setText("O Wins: "+ oWins);
        //Set buttons disabled after win
        for(int i = 0; i < 9; i++){
            buttons[i].setEnabled(false);
        }
    }

    public void actionPerformed(ActionEvent e){
        
        if(e.getSource() == back){
            controller.getInstance().changeCard("Main Page");
            startGame();
        }

        if(e.getSource()== newGame){
            startGame();
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

                        prompt.setText("O's turn");// let the user know to swap turns
                        count++;
                        check();
                    }
                }
                else { //if it is not player1
                    if(buttons[i].getText() == " ") //check if there is any text assigned to the button
                    {
                        buttons[i].setForeground(new Color(0,204,102));//set to light green for player 2
                        buttons[i].setText("O");// set to X
                        player = true;

                        prompt.setText("X's turn");// let the user know to swap turns
                        count++;
                        check();
                    }
                }
            } 
        }
       
    }
}


