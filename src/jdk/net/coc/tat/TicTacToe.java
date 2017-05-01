package jdk.net.coc.tat;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class TicTacToe extends JFrame implements ActionListener {

	private static JPanel pnlMain, pnlButtons;
	private static JButton[] btnField;
	private static JLabel lblTitle, lblPlayers;
	private static Dimension d1;

	private static char[][] field1;
	private static boolean[][] field2;
	private static boolean turn = true;

	public TicTacToe() {
		field1 = new char[3][3];
		field2 = new boolean[3][3];

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				field2[i][j] = false;
			}
		}

		d1 = new Dimension(40, 40);

		pnlMain = new JPanel();
		pnlMain.setLayout(new BoxLayout(pnlMain, BoxLayout.Y_AXIS));

		pnlButtons = new JPanel();
		pnlButtons.setLayout(new GridLayout(3, 3, 10, 10));
		pnlButtons.setPreferredSize(new Dimension(150, 150));

		lblTitle = new JLabel("Tic Tac Toe");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTitle.setAlignmentX(CENTER_ALIGNMENT);

		lblPlayers = new JLabel();
		lblPlayers.setFont(new Font("Tahoma", Font.ITALIC, 10));

		btnField = new JButton[9];

		for (int i = 0; i < 9; i++) {
			btnField[i] = new JButton("");
			btnField[i].setSize(d1);
			btnField[i].setPreferredSize(d1);
			btnField[i].setMinimumSize(d1);
			btnField[i].setMaximumSize(d1);
			btnField[i].addActionListener(this);
			pnlButtons.add(btnField[i]);
		}

		this.add(pnlMain);

		pnlMain.add(lblTitle);

		pnlMain.add(Box.createVerticalStrut(10));

		pnlMain.add(pnlButtons);

		pnlMain.add(lblPlayers);

		this.setTitle("Tic Tac Toe");
		this.setSize(300, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public void actionPerformed( ActionEvent e ) {
		if (turn) {

			for (int i = 0; i < 9; i++) {
				if (e.getSource() == btnField[i]) {
					if (!field2[i / 3][i % 3]) {
						field1[i / 3][i % 3] = 'X';
						field2[i / 3][i % 3] = true;

						refreshGUI();

						checkIfWon();

						turn = false;
					} else {
						JOptionPane.showMessageDialog(null, "This field is not vacant!\nPlease, choose another one...");
					}
				}

			}
		} else {
			for (int i = 0; i < 9; i++) {
				if (e.getSource() == btnField[i]) {
					field1[i / 3][i % 3] = 'O';
					field2[i / 3][i % 3] = true;

					refreshGUI();

					checkIfWon();

					turn = true;

				}

			}
		}
	}

	public static void refreshGUI() {
		for (int i = 0; i < 9; i++) {
			btnField[i].setText(field1[i / 3][i % 3] + "");
		}
	}

	public static void checkIfWon() {
		for (int i = 0; i < 3; i++) {
			if (((field1[i][0] == field1[i][1]) && (field1[i][2] == field1[i][1]) && (field1[i][0] == field1[i][2]))
			        && (field1[i][0] == 'O'))
			{

				end('O');
			}

			if (((field1[0][i] == field1[1][i]) && (field1[2][i] == field1[1][i]) && (field1[0][i] == field1[2][i]))
			        && (field1[0][i] == 'O'))
			{

				end('O');
			}
		}
		if (((field1[0][0] == field1[1][1]) && (field1[1][1] == field1[2][2]) && (field1[0][0] == field1[2][2]))
		        && (field1[0][0] == 'O'))
		{

			end('O');
		}
		if (((field1[0][2] == field1[1][1]) && (field1[1][1] == field1[2][0]) && (field1[0][2] == field1[2][0]))
		        && (field1[0][2] == 'O'))
		{

			end('O');
		}

		for (int i = 0; i < 3; i++) {

			if (((field1[i][0] == field1[i][1]) && (field1[i][2] == field1[i][1]) && (field1[i][0] == field1[i][2]))
			        && (field1[i][0] == 'X'))
			{
				end('X');
			}

			if (((field1[0][i] == field1[1][i]) && (field1[2][i] == field1[1][i]) && (field1[0][i] == field1[2][i]))
			        && (field1[0][i] == 'X'))
			{
				end('X');
			}

		}
		if (((field1[0][0] == field1[1][1]) && (field1[1][1] == field1[2][2]) && (field1[0][0] == field1[2][2]))
		        && (field1[0][0] == 'X'))
		{
			end('X');
		}
		if (((field1[0][2] == field1[1][1]) && (field1[1][1] == field1[2][0]) && (field1[0][2] == field1[2][0]))
		        && (field1[0][2] == 'X'))
		{
			end('X');
		}
	}

	public static void end( char side ) {
		JOptionPane.showMessageDialog(null, side + " won!");
	}

	public static void main( String[] args ) {
		new TicTacToe();

	}
}