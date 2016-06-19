import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TicTacToe implements ActionListener 
{
    private int[][] CMB = new int[][] {   // combinations of possible winning scenarios
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, //horizontal wins
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, //vertical wins
            {0, 4, 8}, {2, 4, 6}            //diagonal wins
        };
    private JFrame window = new JFrame("Tic Tac Toe");
    private JButton buttons[] = new JButton[9];
    private int trncnt = 0; //variable that keeps track of whose turn it is
    private String turn = ""; // X or O, depending on whose turn it is
    private boolean win = false;
	private static int ai;
    
    public void setAI(int x) //sets the game to AI mode
    {
    	ai=x;
    }
    public TicTacToe()
    {
    	window.setLocationRelativeTo(null);
    	window.setSize(500,500);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(new GridLayout(3,3));
        for(int i=0; i<=8; i++) // add the 9 buttons to the grid
        {
            buttons[i] = new JButton();
            window.add(buttons[i]);
            buttons[i].addActionListener(this);
        }
        window.setVisible(true);
    }
    public void actionPerformed(ActionEvent event) 
    {
    	if(ai==1) //if chosen to play against the computer
    	{
    		trncnt++;
            Font font = new Font("Verdana", Font.PLAIN, 60);
            int checker=0;
            turn = "<html><font color = blue>X</font></html>";
            JButton clicked = (JButton)event.getSource(); // get the clicked button from the player
            clicked.setFont(font);
            clicked.setText(turn);
            clicked.setEnabled(false);  
            for(int i=0; i<=7; i++) // check if he won
            {
                if( buttons[CMB[i][0]].getText().equals(buttons[CMB[i][1]].getText()) && 
                    buttons[CMB[i][1]].getText().equals(buttons[CMB[i][2]].getText()) && 
                    buttons[CMB[i][0]].getText() != "")
                {
                    win = true;
                }
            }
            
            if(win == true) // print winner
            {
                if(turn.equals("X"))
            		JOptionPane.showMessageDialog(null, "The player wins the game!");
                else
                    JOptionPane.showMessageDialog(null, "The computer wins the game!");	
                System.exit(0);
            } 
            else if(trncnt == 5 && win == false) // print that the game was a tie
            {
                JOptionPane.showMessageDialog(null, "The game was tie!");
                System.exit(0);
            }
            turn = "<html><font color = red>O</font></html>"; // AI's turn
            for(int i=0; i<=7; i++) //check if either X or O is in position to win and negate or fulfil that
            {
                if( buttons[CMB[i][0]].getText().equals(buttons[CMB[i][1]].getText())  && 
                	buttons[CMB[i][0]].getText() != "" &&
                    buttons[CMB[i][2]].isEnabled())
                {
                	buttons[CMB[i][2]].setFont(font);
                   	buttons[CMB[i][2]].setText(turn);
                   	buttons[CMB[i][2]].setEnabled(false);
                   	checker=1;
                   	break;
                }
                else if(buttons[CMB[i][0]].getText().equals(buttons[CMB[i][2]].getText())  &&
                		buttons[CMB[i][0]].getText() != "" &&
                        buttons[CMB[i][1]].isEnabled())
                {
                   	buttons[CMB[i][1]].setFont(font);
                   	buttons[CMB[i][1]].setText(turn);
                   	buttons[CMB[i][1]].setEnabled(false);
                   	checker=1;
                   	break;
                }
                else if(buttons[CMB[i][2]].getText().equals(buttons[CMB[i][1]].getText())  &&
                		buttons[CMB[i][1]].getText() != "" &&
                		buttons[CMB[i][0]].isEnabled())
                {
                	buttons[CMB[i][0]].setFont(font);
                   	buttons[CMB[i][0]].setText(turn);
                   	buttons[CMB[i][0]].setEnabled(false);
                   	checker=1;
                   	break;
                }
            }
            if(checker==0)
            {
            	if(buttons[4].isEnabled()) // get the middle position if available
                {
                	buttons[4].setFont(font);
                   	buttons[4].setText(turn);
                   	buttons[4].setEnabled(false);
                }
                else if(!buttons[4].isEnabled() && 
                		(buttons[0].getText().equals("") || buttons[2].getText().equals("") || buttons[6].getText().equals("") || buttons[8].getText().equals("")) && 
                		!((buttons[0].getText().equals("<html><font color = blue>X</font></html>") && buttons[8].getText().equals("<html><font color = blue>X</font></html>")) || 
                		(buttons[2].getText().equals("<html><font color = blue>X</font></html>") && buttons[6].getText().equals("<html><font color = blue>X</font></html>"))))
                {	// if not available, and unless a special circumstance is fulfiled, get some of the corner buttons
                	if(buttons[1].getText().equals(buttons[3].getText()) && buttons[0].isEnabled() && !buttons[1].getText().equals(""))
                	{
                		buttons[0].setFont(font);
                       	buttons[0].setText(turn);
                       	buttons[0].setEnabled(false);
                	}
                	else if(buttons[1].getText().equals(buttons[5].getText()) && buttons[2].isEnabled() && !buttons[1].getText().equals(""))
                	{
                		buttons[2].setFont(font);
                       	buttons[2].setText(turn);
                       	buttons[2].setEnabled(false);
                	}
                	else if(buttons[3].getText().equals(buttons[7].getText()) && buttons[6].isEnabled() && !buttons[3].getText().equals(""))
                	{
                		buttons[6].setFont(font);
                       	buttons[6].setText(turn);
                       	buttons[6].setEnabled(false);
                	}
                	else if(buttons[5].getText().equals(buttons[7].getText()) && buttons[8].isEnabled() && !buttons[5].getText().equals(""))
                	{
                		buttons[8].setFont(font);
                       	buttons[8].setText(turn);
                       	buttons[8].setEnabled(false);
                	}
                	else if(buttons[6].getText().equals(buttons[5].getText()) && buttons[8].isEnabled() && !buttons[6].getText().equals(""))
                	{
                		buttons[8].setFont(font);
                       	buttons[8].setText(turn);
                       	buttons[8].setEnabled(false);
                	}
                	else if(buttons[8].getText().equals(buttons[1].getText()) && buttons[2].isEnabled() && !buttons[8].getText().equals(""))
                	{
                		buttons[2].setFont(font);
                       	buttons[2].setText(turn);
                       	buttons[2].setEnabled(false);
                	}
                	else if(buttons[2].getText().equals(buttons[3].getText()) && buttons[0].isEnabled() && !buttons[2].getText().equals(""))
                	{
                		buttons[0].setFont(font);
                       	buttons[0].setText(turn);
                       	buttons[0].setEnabled(false);
                	}
                	else if(buttons[0].getText().equals(buttons[7].getText()) && buttons[6].isEnabled() && !buttons[0].getText().equals(""))
                	{
                		buttons[6].setFont(font);
                       	buttons[6].setText(turn);
                       	buttons[6].setEnabled(false);
                	}
                	else if(buttons[0].isEnabled())
                	{
                		buttons[0].setFont(font);
                       	buttons[0].setText(turn);
                       	buttons[0].setEnabled(false);
                	}
                	else if(buttons[2].isEnabled())
                	{
                		buttons[2].setFont(font);
                       	buttons[2].setText(turn);
                       	buttons[2].setEnabled(false);
                	}
                	else if(buttons[6].isEnabled())
                	{
                		buttons[6].setFont(font);
                       	buttons[6].setText(turn);
                       	buttons[6].setEnabled(false);
                	}
                	else if(buttons[8].isEnabled())
                	{
                		buttons[8].setFont(font);
                       	buttons[8].setText(turn);
                       	buttons[8].setEnabled(false);
                	}
                }
                else // if all fails get one of the others
                {
                	if(buttons[1].isEnabled())
                	{
                		buttons[1].setFont(font);
                       	buttons[1].setText(turn);
                       	buttons[1].setEnabled(false);
                	}
                	else if(buttons[3].isEnabled())
                	{
                		buttons[3].setFont(font);
                       	buttons[3].setText(turn);
                       	buttons[3].setEnabled(false);
                	}
                	else if(buttons[5].isEnabled())
                	{
                		buttons[5].setFont(font);
                       	buttons[5].setText(turn);
                       	buttons[5].setEnabled(false);
                	}
                	else if(buttons[7].isEnabled())
                	{
                		buttons[7].setFont(font);
                       	buttons[7].setText(turn);
                       	buttons[7].setEnabled(false);
                	}
                }
            }
             
            for(int i=0; i<=7; i++) //check if AI won
            {
                if( buttons[CMB[i][0]].getText().equals(buttons[CMB[i][1]].getText()) && 
                    buttons[CMB[i][1]].getText().equals(buttons[CMB[i][2]].getText()) && 
                    buttons[CMB[i][0]].getText() != "")
                {
                    win = true;
                }
            }
            
            if(win == true)
            {
                if(turn.equals("<html><font color = blue>X</font></html>"))
            		JOptionPane.showMessageDialog(null, "The player wins the game!");
                else
                    JOptionPane.showMessageDialog(null, "The computer wins the game!");	
                System.exit(0);
            } 
            else if(trncnt == 5 && win == false)
            {
                JOptionPane.showMessageDialog(null, "The game was tie!");
                System.exit(0);
            } 
    	}
    	else // player vs player mode
    	{
    		trncnt++;
    		Font font = new Font("Verdana", Font.PLAIN, 60);
            JButton clicked = (JButton)event.getSource(); 
            clicked.setFont(font);
            if(trncnt % 2 == 0)
            {
                turn = "O";
                clicked.setText("<html><font color = red>"+turn+"</font></html>");
            }
            else 
            {
                turn = "X";
                clicked.setText("<html><font color = blue>"+turn+"</font></html>");
            }
            
            clicked.setEnabled(false); //disable the clicked button
                       
            for(int i=0; i<=7; i++) //check if someone won
            {
                if( buttons[CMB[i][0]].getText().equals(buttons[CMB[i][1]].getText()) && 
                    buttons[CMB[i][1]].getText().equals(buttons[CMB[i][2]].getText()) && 
                    buttons[CMB[i][0]].getText() != "") // check if any combination has a winner
                {
                    win = true;
                    turn=buttons[CMB[i][0]].getText();
                }
            }
            if(win == true)
            {
            	 if(turn.equals("<html><font color = blue>X</font></html>")) // X won
            		 JOptionPane.showMessageDialog(null,"X wins the game!");
            	 else
            		 JOptionPane.showMessageDialog(null,"O wins the game!"); // O won
                 System.exit(0);
            } 
            else if(trncnt == 9 && win == false) //if everyone played (9 turns) its a tie
            {
                JOptionPane.showMessageDialog(null, "The game was tie!");
                System.exit(0);
            } 
    	}
    }
}