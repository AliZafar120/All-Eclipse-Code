package Eight_Puzzle_Game;

import java.awt.EventQueue;
import java.awt.SystemColor;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class GUI extends JFrame
{
	

	private JPanel contentPane;
	private ImageIcon eight = new ImageIcon(getClass().getResource("8.png"));
	private ImageIcon exit_icon = new ImageIcon(getClass().getResource("exit2.png"));
	private ImageIcon fifteen = new ImageIcon(getClass().getResource("15.jpg"));
	private ImageIcon solve = new ImageIcon(getClass().getResource("cuve.jpg"));
	private ImageIcon clear = new ImageIcon(getClass().getResource("reset.jpg"));
	private JLabel eight_label = new JLabel("");
	private JLabel fifteen_label = new JLabel("");
	private JButton exit_button = new JButton(exit_icon);
	// group of buttons --only one at a time
	private ButtonGroup eight_or_fif = new ButtonGroup();
	private final JButton solve_button = new JButton(solve);
	private JTextField textField;
	private JTextField textField_1;
	private JRadioButton rbutton8 = new JRadioButton("8-puzzle");
	private JRadioButton rbutton15 = new JRadioButton("15-puzzle");
	private final JTextField textField_2 = new JTextField();
	private final JTextField textField_3 = new JTextField();
	private final JTextField textField_4 = new JTextField();
	private final JTextField textField_5 = new JTextField();
	private final JTextField textField_6 = new JTextField();
	private final JTextField textField_7 = new JTextField();
	private final JTextField textField_8 = new JTextField();
	private final JTextField textField_9 = new JTextField();
	private final JTextField textField_10 = new JTextField();
	private final JTextField textField_11 = new JTextField();
	private final JTextField textField_12 = new JTextField();
	private final JTextField textField_13 = new JTextField();
	private final JTextField textField_14 = new JTextField();
	private final JTextField textField_15 = new JTextField();
	private JRadioButton rdbtnOutOfRowcolumn = new JRadioButton(
			"Out of Row-Column");
	private final JRadioButton misplacedButton = new JRadioButton(
			"Misplaced Tiles");
	private final JRadioButton euclideanButton = new JRadioButton("Euclidean");
	private final JRadioButton manhattanButton = new JRadioButton(
			"Manhattan-Taxicab Metric");
	private final JRadioButton linearCoflictButton = new JRadioButton(
			"Linear Conflict");
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final JLabel lblChooseOneHeuristic = new JLabel(
			"Choose one heuristic:");
	private final JLabel lblProvideTheInitial = new JLabel(
			"Provide the initial state:");
	private final int MISPLACED = 0;
	private final int MANHATTAN = 1;
	private final int EUCLIDEAN = 2;
	private final int LINEAR_CONFLICT = 3;
	private final int OUT_OF_ROW_COL = 4;
	private final int PUZZLE8_LEN = 9;
	private final int PUZZLE15_LEN = 16;
	private JButton resetButton = new JButton(clear);
	private final JTextField goal2 = new JTextField();
	private final JTextField goal3 = new JTextField();
	private final JTextField goal4 = new JTextField();
	private final JTextField goal8 = new JTextField();
	private final JTextField goal6 = new JTextField();
	private final JTextField goal7 = new JTextField();
	private final JLabel lblProvideTheGoal = new JLabel("Provide the goal state:");
	private final JTextField goal11 = new JTextField();
	private final JTextField goal10 = new JTextField();
	private final JTextField goal16 = new JTextField();
	private final JTextField goal15 = new JTextField();
	private final JTextField goal14 = new JTextField();
	private final JTextField goal12 = new JTextField();
	private JTextField goal1;
	private JTextField goal5;
	private JTextField goal9;
	private JTextField goal13;
	private Object[] numbers, goal;
	private boolean PUZZLE8;
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
	
				try {
				
					GUI welcome_frame= new GUI();
					welcome_frame.setLocationRelativeTo(null);
					welcome_frame.setVisible(true);
					welcome_frame.setTitle("8 puzzle Solver");
					
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				
			}
		});
	}
	
	
	
	public GUI(){
		textField_15.setBounds(139, 148, 35, 34);
		textField_15.setColumns(10);
		textField_14.setBounds(98, 148, 36, 34);
		textField_14.setColumns(10);
		textField_13.setBounds(57, 148, 35, 34);
		textField_13.setColumns(10);
		textField_12.setBounds(15, 148, 35, 34);
		textField_12.setColumns(10);
		textField_11.setBounds(139, 108, 35, 34);
		textField_11.setColumns(10);
		textField_10.setBounds(98, 108, 35, 34);
		textField_10.setColumns(10);
		textField_9.setBounds(57, 108, 35, 34);
		textField_9.setColumns(10);
		textField_8.setBounds(15, 108, 35, 34);
		textField_8.setColumns(10);
		textField_7.setBounds(139, 68, 35, 34);
		textField_7.setColumns(10);
		textField_6.setBounds(98, 68, 35, 34);
		textField_6.setColumns(10);
		textField_5.setBounds(57, 68, 35, 34);
		textField_5.setColumns(10);
		textField_4.setBounds(15, 68, 35, 34);
		textField_4.setColumns(10);
		textField_3.setBounds(139, 28, 35, 34);
		textField_3.setColumns(10);
		textField_2.setBounds(98, 28, 35, 34);
		textField_2.setColumns(10);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 500);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		getContentPane().setBackground(SystemColor.gray);
		contentPane.setLayout(null);
		textField_1 = new JTextField();
		textField_1.setBounds(57, 28, 35, 34);
		textField_1.setColumns(10);

		contentPane.add(textField_1);

		contentPane.add(textField_2);

		contentPane.add(textField_3);

		contentPane.add(textField_4);

		contentPane.add(textField_5);

		contentPane.add(textField_6);

		contentPane.add(textField_7);

		contentPane.add(textField_8);

		contentPane.add(textField_9);

		contentPane.add(textField_10);

		contentPane.add(textField_11);

		contentPane.add(textField_12);

		contentPane.add(textField_13);

		contentPane.add(textField_14);
		
	}

}
