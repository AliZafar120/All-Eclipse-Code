package puzzle8.astar;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class WelcomeScreen extends JFrame {

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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WelcomeScreen frame = new WelcomeScreen();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
					frame.setTitle("Puzzle Solver");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public boolean goalRight() throws Exception {
		int[] temp = new int[goal.length + 1];
		int spaces=0;
		for (int i = 0; i < temp.length; ++i)
			temp[i] = 0;

		for (int i = 0; i < goal.length; ++i) {
			int x = 0;
			if (!goal[i].toString().equals(" ")) {
				
				x = new Integer(goal[i].toString());

				if (x >= goal.length || x < 1)
					return false;
				temp[x]++;
				if (temp[x] > 1)
					return false;
			} else {
				++spaces;
				temp[0]++;
				if (temp[0] > 1)
					return false;
			}

		}
	
		if(spaces>1)
			return false;
		return true;
	}

	public boolean stateRight() throws Exception {
		int[] temp = new int[numbers.length + 1];
		int spaces=0;
		for (int i = 0; i < temp.length; ++i)
			temp[i] = 0;

		for (int i = 0; i < numbers.length; ++i) {
			int x = 0;

			if (!numbers[i].toString().equals(" ")) {
				
				x = new Integer(numbers[i].toString());

				if (x >= numbers.length || x < 1)
					return false;
				temp[x]++;
				if (temp[x] > 1)
					return false;
			} else {
				++spaces;
				temp[0]++;
				if (temp[0] > 1)
					return false;
			}

		}
		if(spaces>1)
			return false;
		return true;
	}

	/**
	 * Create the frame.
	 */
	public WelcomeScreen() {
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		getContentPane().setBackground(SystemColor.activeCaption);
		contentPane.setLayout(null);
		fifteen_label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				setCursor(Cursor.getDefaultCursor());
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				rbutton15.doClick();
				textField_3.setVisible(true);
				textField_7.setVisible(true);
				textField_11.setVisible(true);
				textField_15.setVisible(true);
				textField_12.setVisible(true);
				textField_13.setVisible(true);
				textField_14.setVisible(true);

				goal4.setVisible(true);
				goal8.setVisible(true);
				goal12.setVisible(true);
				goal13.setVisible(true);
				goal14.setVisible(true);
				goal15.setVisible(true);
				goal16.setVisible(true);
			}
		});
		fifteen_label.setBounds(15, 217, 151, 154);

		fifteen_label.setIcon(fifteen);
		contentPane.add(fifteen_label);
		eight_label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				setCursor(Cursor.getDefaultCursor());
			}
			@SuppressWarnings("deprecation")
			@Override
			public void mouseEntered(MouseEvent e) {
				setCursor(Cursor.HAND_CURSOR);
				
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				rbutton8.doClick();
				textField_3.setVisible(false);
				textField_7.setVisible(false);
				textField_11.setVisible(false);
				textField_15.setVisible(false);
				textField_12.setVisible(false);
				textField_13.setVisible(false);
				textField_14.setVisible(false);

				goal4.setVisible(false);
				goal8.setVisible(false);
				goal12.setVisible(false);
				goal13.setVisible(false);
				goal14.setVisible(false);
				goal15.setVisible(false);
				goal16.setVisible(false);
				
			}
		});
		eight_label.setBounds(449, 217, 151, 154);
		eight_label.setIcon(eight);
		contentPane.add(eight_label);
		rbutton15.setBackground(SystemColor.activeCaption);
		rbutton15.setBounds(52, 385, 81, 23);
		rbutton15.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			
					textField_3.setVisible(true);
					textField_7.setVisible(true);
					textField_11.setVisible(true);
					textField_15.setVisible(true);
					textField_12.setVisible(true);
					textField_13.setVisible(true);
					textField_14.setVisible(true);

					goal4.setVisible(true);
					goal8.setVisible(true);
					goal12.setVisible(true);
					goal13.setVisible(true);
					goal14.setVisible(true);
					goal15.setVisible(true);
					goal16.setVisible(true);
				

			}
		});
		rbutton15.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		contentPane.add(rbutton15);
		rbutton8.setBackground(SystemColor.activeCaption);
		rbutton8.setBounds(486, 385, 73, 23);
		rbutton8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			
					textField_3.setVisible(false);
					textField_7.setVisible(false);
					textField_11.setVisible(false);
					textField_15.setVisible(false);
					textField_12.setVisible(false);
					textField_13.setVisible(false);
					textField_14.setVisible(false);

					goal4.setVisible(false);
					goal8.setVisible(false);
					goal12.setVisible(false);
					goal13.setVisible(false);
					goal14.setVisible(false);
					goal15.setVisible(false);
					goal16.setVisible(false);
				
			}
		});
		rbutton8.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		contentPane.add(rbutton8);
		eight_or_fif.add(rbutton8);
		eight_or_fif.add(rbutton15);
		exit_button.setBackground(Color.WHITE);
		exit_button.setBounds(352, 357, 53, 51);
		exit_button.setToolTipText("Exit ");
		exit_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				dispose();
			}
		});
		contentPane.add(exit_button);
		solve_button.setBackground(SystemColor.activeCaption);
		solve_button.setBounds(208, 357, 46, 51);
		solve_button.setToolTipText("Solve the puzzle!");
		solve_button.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				int evretiko = MISPLACED, one_dim = 0;
				Graph sol;

				if (!misplacedButton.isSelected()
						&& !euclideanButton.isSelected()
						&& !manhattanButton.isSelected()
						&& !linearCoflictButton.isSelected()
						&& !rdbtnOutOfRowcolumn.isSelected()) {
					// parameter=1 means no selection of heuristic
					PuzzleDialog.main(1);
					return;
				} else if (!rbutton8.isSelected() && !rbutton15.isSelected()) {
					// parameter=0 means no selection of puzzle
					PuzzleDialog.main(0);
					return;
				} else {

					if (misplacedButton.isSelected())
						evretiko = MISPLACED;
					else if (euclideanButton.isSelected())
						evretiko = EUCLIDEAN;
					else if (manhattanButton.isSelected())
						evretiko = MANHATTAN;
					else if (linearCoflictButton.isSelected())
						evretiko = LINEAR_CONFLICT;
					else if (rdbtnOutOfRowcolumn.isSelected())
						evretiko = OUT_OF_ROW_COL;

					if (rbutton8.isSelected()) {
						PUZZLE8 = true;
						one_dim = 3;
						numbers = new Object[PUZZLE8_LEN];
						goal = new Object[PUZZLE8_LEN];
						goal[0] = new String(goal1.getText());
						goal[1] = new String(goal2.getText());
						goal[2] = new String(goal3.getText());
						goal[3] = new String(goal5.getText());
						goal[4] = new String(goal6.getText());
						goal[5] = new String(goal7.getText());
						goal[6] = new String(goal9.getText());
						goal[7] = new String(goal10.getText());
						goal[8] = new String(goal11.getText());

						for (int u = 0; u < goal.length; ++u) {
							if (goal[u].toString().length() == 0) {
								goal[u] = new String(" ");
							}
						}
						boolean right_or_not = false;
						try {
							right_or_not = goalRight();
							if (!right_or_not){
								PuzzleDialog.main(3);
								return;
							}
						} catch (Exception ex) {
							// ex.printStackTrace();
							PuzzleDialog.main(3);
							return;
						}

						numbers[0] = new String(textField.getText());
						numbers[1] = new String(textField_1.getText());
						numbers[2] = new String(textField_2.getText());
						numbers[3] = new String(textField_4.getText());
						numbers[4] = new String(textField_5.getText());
						numbers[5] = new String(textField_6.getText());
						numbers[6] = new String(textField_8.getText());
						numbers[7] = new String(textField_9.getText());
						numbers[8] = new String(textField_10.getText());
						for (int u = 0; u < numbers.length; ++u) {
							if (numbers[u].toString().length() == 0) {
								numbers[u] = new String(" ");
							}
						}

						try {
							right_or_not = stateRight();
							if (!right_or_not) {
								throw new Exception();
							}

						} catch (Exception ex) {
							// ex.printStackTrace();
							PuzzleDialog.main(2);
							return;
						}

					} else if (rbutton15.isSelected()) {
						PUZZLE8 = false;
						one_dim = 4;
						numbers = new Object[PUZZLE15_LEN];
						goal = new Object[PUZZLE15_LEN];
						goal[0] = new String(goal1.getText());
						goal[1] = new String(goal2.getText());
						goal[2] = new String(goal3.getText());
						goal[3] = new String(goal4.getText());
						goal[4] = new String(goal5.getText());
						goal[5] = new String(goal6.getText());
						goal[6] = new String(goal7.getText());
						goal[7] = new String(goal8.getText());
						goal[8] = new String(goal9.getText());
						goal[9] = new String(goal10.getText());
						goal[10] = new String(goal11.getText());
						goal[11] = new String(goal12.getText());
						goal[12] = new String(goal13.getText());
						goal[13] = new String(goal14.getText());
						goal[14] = new String(goal15.getText());
						goal[15] = new String(goal16.getText());

						for (int u = 0; u < goal.length; ++u) {
							if (goal[u].toString().length() == 0) {
								goal[u] = new String(" ");
							}
						}
						boolean right_or_not = false;
						try {
							right_or_not = goalRight();
							if (!right_or_not){
								PuzzleDialog.main(3);
								return;
							}
						} catch (Exception ex) {
							// ex.printStackTrace();
							PuzzleDialog.main(3);
							return;
						}

						numbers[0] = new String(textField.getText());
						numbers[1] = new String(textField_1.getText());
						numbers[2] = new String(textField_2.getText());
						numbers[3] = new String(textField_3.getText());
						numbers[4] = new String(textField_4.getText());
						numbers[5] = new String(textField_5.getText());
						numbers[6] = new String(textField_6.getText());
						numbers[7] = new String(textField_7.getText());
						numbers[8] = new String(textField_8.getText());
						numbers[9] = new String(textField_9.getText());
						numbers[10] = new String(textField_10.getText());
						numbers[11] = new String(textField_11.getText());
						numbers[12] = new String(textField_12.getText());
						numbers[13] = new String(textField_13.getText());
						numbers[14] = new String(textField_14.getText());
						numbers[15] = new String(textField_15.getText());
						for (int u = 0; u < numbers.length; ++u) {
							if (numbers[u].toString().length() == 0) {
								numbers[u] = new String(" ");
							}
						}

						try {
							right_or_not = stateRight();
							if (!right_or_not) {
								throw new Exception();
							}

						} catch (Exception ex) {
							// ex.printStackTrace();
							PuzzleDialog.main(2);
							return;
						}

					}
				}
				// 4 means wait for the solution
				
				double start, finish, elapsed_in_nan, elapsed_in_sec;
				sol = new Graph(numbers, goal, evretiko, PUZZLE8, one_dim);
				setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
				start = System.nanoTime();
				NodeStruct soluti=sol.aStar();
				finish = System.nanoTime();
				setCursor(Cursor.getDefaultCursor());
				elapsed_in_nan = finish - start;
				elapsed_in_sec = elapsed_in_nan * Math.pow(10, -9);
			
				
				if(soluti==null)
					PuzzleDialog.main(4);
				else{
					if(!soluti.isNull())
					PresentSolution.main(soluti,sol,elapsed_in_sec,PUZZLE8,one_dim);
				}
			
				
			}
		});

		contentPane.add(solve_button);

		textField = new JTextField();
		textField.setBounds(15, 28, 35, 34);
		contentPane.add(textField);
		textField.setColumns(10);

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

		contentPane.add(textField_15);
		buttonGroup.add(misplacedButton);
		misplacedButton.setBackground(SystemColor.activeCaption);
		misplacedButton.setBounds(208, 34, 135, 23);
		misplacedButton
				.setToolTipText("");

		contentPane.add(misplacedButton);
		buttonGroup.add(euclideanButton);
		euclideanButton.setBackground(SystemColor.activeCaption);
		euclideanButton.setBounds(208, 60, 91, 23);

		contentPane.add(euclideanButton);
		buttonGroup.add(manhattanButton);
		manhattanButton.setBackground(SystemColor.activeCaption);
		manhattanButton.setBounds(208, 86, 186, 23);

		contentPane.add(manhattanButton);
		buttonGroup.add(linearCoflictButton);
		linearCoflictButton.setBackground(SystemColor.activeCaption);
		linearCoflictButton.setBounds(208, 114, 120, 23);

		contentPane.add(linearCoflictButton);
		lblChooseOneHeuristic.setBounds(212, 5, 120, 14);
		lblChooseOneHeuristic
				.setToolTipText("Choose the Heiristic function.This function will guide the search through the search space.");
		lblChooseOneHeuristic.setForeground(SystemColor.desktop);
		lblChooseOneHeuristic.setFont(new Font("Tahoma", Font.BOLD, 11));

		contentPane.add(lblChooseOneHeuristic);
		lblProvideTheInitial.setBounds(15, 5, 135, 14);
		lblProvideTheInitial.setFont(new Font("Tahoma", Font.BOLD, 11));

		contentPane.add(lblProvideTheInitial);
		goal2.setBounds(474, 28, 35, 34);
		goal2.setColumns(10);

		contentPane.add(goal2);
		goal3.setBounds(519, 28, 35, 34);
		goal3.setColumns(10);

		contentPane.add(goal3);
		goal4.setBounds(564, 28, 35, 34);
		goal4.setColumns(10);

		contentPane.add(goal4);
		goal8.setBounds(564, 68, 35, 34);
		goal8.setColumns(10);

		contentPane.add(goal8);
		goal6.setBounds(474, 68, 35, 34);
		goal6.setColumns(10);

		contentPane.add(goal6);
		goal7.setBounds(519, 69, 35, 33);
		goal7.setColumns(10);

		contentPane.add(goal7);
		lblProvideTheGoal.setBounds(424, 5, 135, 14);
		lblProvideTheGoal.setFont(new Font("Tahoma", Font.BOLD, 11));

		contentPane.add(lblProvideTheGoal);
		goal11.setBounds(519, 108, 35, 34);
		goal11.setColumns(10);

		contentPane.add(goal11);
		goal10.setBounds(474, 108, 35, 34);
		goal10.setColumns(10);

		contentPane.add(goal10);
		goal16.setBounds(564, 148, 35, 34);
		goal16.setColumns(10);

		contentPane.add(goal16);
		goal15.setBounds(519, 148, 35, 34);
		goal15.setColumns(10);

		contentPane.add(goal15);
		goal14.setBounds(474, 149, 35, 33);
		goal14.setColumns(10);

		contentPane.add(goal14);
		goal12.setBounds(564, 108, 35, 34);
		goal12.setColumns(10);

		contentPane.add(goal12);
		buttonGroup.add(rdbtnOutOfRowcolumn);
		rdbtnOutOfRowcolumn.setBackground(SystemColor.activeCaption);
		rdbtnOutOfRowcolumn.setBounds(208, 140, 163, 23);
		contentPane.add(rdbtnOutOfRowcolumn);

		goal1 = new JTextField();
		goal1.setColumns(10);
		goal1.setBounds(429, 28, 35, 34);
		contentPane.add(goal1);

		goal5 = new JTextField();
		goal5.setColumns(10);
		goal5.setBounds(429, 68, 35, 34);
		contentPane.add(goal5);

		goal9 = new JTextField();
		goal9.setColumns(10);
		goal9.setBounds(429, 108, 35, 34);
		contentPane.add(goal9);

		goal13 = new JTextField();
		goal13.setColumns(10);
		goal13.setBounds(429, 148, 35, 34);
		contentPane.add(goal13);
		resetButton.setToolTipText("Clear all");
		resetButton.setBackground(SystemColor.activeCaption);
		
		
		resetButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				rbutton15.doClick();
				misplacedButton.doClick();
				
				
				textField_3.setVisible(true);
				textField_7.setVisible(true);
				textField_11.setVisible(true);
				textField_12.setVisible(true);
				textField_13.setVisible(true);
				textField_14.setVisible(true);
				textField_15.setVisible(true);
				
				goal13.setVisible(true);
				goal14.setVisible(true);
				goal15.setVisible(true);
				goal16.setVisible(true);
				goal12.setVisible(true);
				goal8.setVisible(true);
				goal4.setVisible(true);
				
				
				clear();
				
			}
		});
		resetButton.setBounds(275, 357, 53, 51);
		contentPane.add(resetButton);

	}
	public void clear(){
		goal1.setText("");
		goal2.setText("");
		goal3.setText("");
		goal4.setText("");
		goal5.setText("");
		goal6.setText("");
		goal7.setText("");
		goal8.setText("");
		goal9.setText("");
		goal10.setText("");
		goal11.setText("");
		goal12.setText("");
		goal13.setText("");
		goal14.setText("");
		goal15.setText("");
		
		textField.setText("");
		textField_1.setText("");
		textField_2.setText("");
		textField_3.setText("");
		textField_4.setText("");
		textField_5.setText("");
		textField_6.setText("");
		textField_7.setText("");
		textField_8.setText("");
		textField_9.setText("");
		textField_10.setText("");
		textField_11.setText("");
		textField_12.setText("");
		textField_13.setText("");
		textField_14.setText("");
		textField_15.setText("");

	}
}
