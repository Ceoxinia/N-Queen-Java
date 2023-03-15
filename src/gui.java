import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.ListSelectionModel;

public class gui {

	private JFrame frame;
	private JTextField boardsize;
	private ChessBoard chessBoard;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gui window = new gui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public gui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 626, 606);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 0));
		panel.setBounds(0, 0, 626, 578);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel chessPanel = new JPanel();
		chessPanel.setBackground(new Color(255, 255, 0));
		chessPanel.setBounds(32, 28, 286, 251);
		panel.add(chessPanel);
		chessPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JTextPane Statistics = new JTextPane();
		Statistics.setBounds(39, 326, 581, 218);
		panel.add(Statistics);
		
		JLabel statsText = new JLabel("Statistics");
		statsText.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		statsText.setBounds(42, 298, 61, 16);
		panel.add(statsText);
		
		boardsize = new JTextField();
		boardsize.setBounds(441, 69, 130, 26);
		panel.add(boardsize);
		boardsize.setColumns(10);
		
		JButton enterSize = new JButton("Enter");
		enterSize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int n =Integer.parseInt(boardsize.getText());
				chessBoard = new ChessBoard(n);
				chessPanel.add(chessBoard);
				frame.validate();
			}
		});
		enterSize.setBounds(526, 101, 81, 29);
		panel.add(enterSize);
		
		JLabel boardText = new JLabel("Board size :");
		boardText.setBounds(345, 74, 72, 16);
		panel.add(boardText);
		
		JLabel algoText = new JLabel("Algorithme :");
		algoText.setBounds(345, 161, 81, 16);
		panel.add(algoText);
		
		JButton enterAlgorithm = new JButton("Enter");
		enterAlgorithm.setBounds(526, 188, 81, 29);
		enterAlgorithm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			chessBoard.placeQueen(1,2);
				
			}
		});
	
		panel.add(enterAlgorithm);
		
		JList listofAlgos = new JList();
		listofAlgos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listofAlgos.setBounds(441, 151, 130, 26);
		panel.add(listofAlgos);
	}
}
