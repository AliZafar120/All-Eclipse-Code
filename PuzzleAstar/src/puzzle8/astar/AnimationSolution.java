package puzzle8.astar;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Stack;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class AnimationSolution extends JFrame {

	private JPanel contentPane;
	private boolean ispuzzle8;
	private JLabel label_14 = new JLabel("New label");
	private JLabel label_13 = new JLabel("New label");
	private JLabel label_12 = new JLabel("New label");
	private JLabel label_11 = new JLabel("New label");
	private JLabel label_10 = new JLabel("New label");
	private JLabel label_9 = new JLabel("New label");
	private JLabel label_8 = new JLabel("New label");
	private JLabel label_7 = new JLabel("New label");
	private JLabel label_6 = new JLabel("New label");
	private JLabel label_5 = new JLabel("New label");
	private JLabel label_4 = new JLabel("New label");
	private JLabel label_3 = new JLabel("New label");
	private JLabel label_2 = new JLabel("New label");
	private JLabel label = new JLabel("New label");
	private JLabel lblNewLabel = new JLabel("New label");
	private JLabel label_1 = new JLabel("New label");
	private final JButton btnNextStep = new JButton("Solve it");
	private Stack<NodeStruct> the_sol = new Stack<NodeStruct>();
	private final JLabel lblMoves = new JLabel("Moves Remaining:");
	private final JLabel lblNewLabel_1 = new JLabel("");
	private ImageIcon back = new ImageIcon(getClass().getResource("back.png"));
	private final JButton btnNewButton = new JButton(back);
	

	/**
	 * Launch the application.
	 */
	public static void main(final NodeStruct sol, final boolean puzzle8) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AnimationSolution frame = new AnimationSolution(puzzle8,
							sol);
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					frame.setTitle("Solution");

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AnimationSolution(final boolean puzzle8, final NodeStruct soli) {
		NodeStruct curr = soli;
		while (curr.getFather() != null) {
			the_sol.push(curr);
			curr = curr.getFather();
		}
		the_sol.push(curr);

		ispuzzle8 = puzzle8;
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 358, 301);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));

		lblNewLabel.setBounds(35, 29, 46, 33);
		contentPane.add(lblNewLabel);
		label.setFont(new Font("Tahoma", Font.BOLD, 20));

		label.setBounds(91, 29, 46, 33);
		contentPane.add(label);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 20));

		label_1.setBounds(147, 29, 46, 33);
		contentPane.add(label_1);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 20));

		label_2.setBounds(203, 29, 46, 33);
		contentPane.add(label_2);
		label_3.setFont(new Font("Tahoma", Font.BOLD, 20));

		label_3.setBounds(35, 73, 46, 33);
		contentPane.add(label_3);
		label_4.setFont(new Font("Tahoma", Font.BOLD, 20));

		label_4.setBounds(91, 73, 46, 33);
		contentPane.add(label_4);
		label_5.setFont(new Font("Tahoma", Font.BOLD, 20));

		label_5.setBounds(147, 73, 46, 33);
		contentPane.add(label_5);
		label_6.setFont(new Font("Tahoma", Font.BOLD, 20));

		label_6.setBounds(203, 73, 46, 33);
		contentPane.add(label_6);
		label_7.setFont(new Font("Tahoma", Font.BOLD, 20));

		label_7.setBounds(35, 117, 46, 33);
		contentPane.add(label_7);
		label_8.setFont(new Font("Tahoma", Font.BOLD, 20));

		label_8.setBounds(91, 117, 46, 33);
		contentPane.add(label_8);
		label_9.setFont(new Font("Tahoma", Font.BOLD, 20));

		label_9.setBounds(147, 117, 46, 33);
		contentPane.add(label_9);
		label_10.setFont(new Font("Tahoma", Font.BOLD, 20));

		label_10.setBounds(203, 117, 46, 33);
		contentPane.add(label_10);
		label_11.setFont(new Font("Tahoma", Font.BOLD, 20));

		label_11.setBounds(35, 161, 46, 33);
		contentPane.add(label_11);
		label_12.setFont(new Font("Tahoma", Font.BOLD, 20));

		label_12.setBounds(91, 161, 46, 33);
		contentPane.add(label_12);
		label_13.setFont(new Font("Tahoma", Font.BOLD, 20));

		label_13.setBounds(147, 161, 46, 33);
		contentPane.add(label_13);
		label_14.setFont(new Font("Tahoma", Font.BOLD, 20));

		label_14.setBounds(203, 161, 46, 33);
		contentPane.add(label_14);
		btnNextStep.setBackground(UIManager.getColor("Button.light"));
		btnNextStep.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				//perfomeMove();
				btnNextStep.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {

						int delay = 1300; // milliseconds
						ActionListener taskPerformer = new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								NodeStruct curr;
								Object[] x;
								try {
									curr = the_sol.pop();
									x = curr.getArray();
									if (ispuzzle8) {
										lblNewLabel.setText(x[0].toString());
										label.setText(x[1].toString());
										label_1.setText(x[2].toString());
										label_3.setText(x[3].toString());
										label_4.setText(x[4].toString());
										label_5.setText(x[5].toString());
										label_7.setText(x[6].toString());
										label_8.setText(x[7].toString());
										label_9.setText(x[8].toString());
									}
									else
									{
										lblNewLabel.setText(x[0].toString());
										label.setText(x[1].toString());
										label_1.setText(x[2].toString());
										label_2.setText(x[3].toString());
										label_3.setText(x[4].toString());
										label_4.setText(x[5].toString());
										label_5.setText(x[6].toString());
										label_6.setText(x[7].toString());
										label_7.setText(x[8].toString());
										label_8.setText(x[9].toString());
										label_9.setText(x[10].toString());
										label_10.setText(x[11].toString());
										label_11.setText(x[12].toString());
										label_12.setText(x[13].toString());
										label_13.setText(x[14].toString());
										label_14.setText(x[15].toString());
									
									}
								} catch (Exception ex) {

								}
								lblNewLabel_1.setText(new Integer(the_sol.size()).toString());
							}
						};
						new Timer(delay, taskPerformer).start();
						btnNextStep.setEnabled(false);
					}
				});
			
			}
			
		});

		btnNextStep.setBounds(35, 228, 89, 23);

		contentPane.add(btnNextStep);
		lblMoves.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMoves.setBounds(134, 230, 145, 21);

		contentPane.add(lblMoves);
		lblNewLabel_1.setForeground(UIManager.getColor("MenuItem.disabledForeground"));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBackground(SystemColor.activeCaption);
		lblNewLabel_1.setEnabled(false);
		lblNewLabel_1.setBounds(286, 228, 46, 14);
		
		contentPane.add(lblNewLabel_1);
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				dispose();
			}
		});
		btnNewButton.setBounds(267, 84, 54, 55);
		
		contentPane.add(btnNewButton);

		setThem();

	}

	public void setThem() {
		if (ispuzzle8) {
			label_2.setVisible(false);
			label_6.setVisible(false);
			label_10.setVisible(false);
			label_14.setVisible(false);
			label_13.setVisible(false);
			label_11.setVisible(false);
			label_12.setVisible(false);
		}

		label_1.setText("");
		label_2.setText("");
		label_3.setText("");
		label_4.setText("");
		label_5.setText("");
		label_6.setText("");
		label_7.setText("");
		label_8.setText("");
		label_9.setText("");
		label_10.setText("");
		label_11.setText("");
		label_12.setText("");
		label_13.setText("");
		label_14.setText("");

		label.setText("");
		lblNewLabel.setText("");
		
	}

}
