import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class TMain 
{
	public static void main(String[] args)
	{
		final JFrame window = new JFrame("Tic Tac Toe");
		window.setLocationRelativeTo(null);
		window.setSize(500,200);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Font font = new Font("Verdana", Font.PLAIN, 24);
		class ClickListener implements ActionListener //the AI mode
		{
			public void actionPerformed(ActionEvent event)
			{
				window.setVisible(false);
				TicTacToe start = new TicTacToe();
				start.setAI(1);
			}
		}
		class ClickListener1 implements ActionListener //the player vs player mode
		{
			public void actionPerformed(ActionEvent event)
			{
				window.setVisible(false);
				TicTacToe start = new TicTacToe();
				start.setAI(0);
			}
		}
		ClickListener listener=new ClickListener();
		ClickListener1 listener1=new ClickListener1();
		window.setLayout(new GridLayout(1,2));
		JButton button = new JButton("Play vs Computer");
		JButton button1 = new JButton("Play vs Human");
		button.setFont(font);
		button1.setFont(font);
		window.add(button);
		window.add(button1);
		button.addActionListener(listener);
		button1.addActionListener(listener1);
		window.setVisible(true);
	}
}
