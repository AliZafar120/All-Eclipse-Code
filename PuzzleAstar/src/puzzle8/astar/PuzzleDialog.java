package puzzle8.astar;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;

@SuppressWarnings("serial")
public class PuzzleDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private ImageIcon error = new ImageIcon(getClass().getResource("error.png"));

	/**
	 * Launch the application.
	 */
	public static void main(int x) {
		try {
			// parametr=-1 means nothing
			PuzzleDialog dialog = new PuzzleDialog(x);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			dialog.setTitle("Error");
			dialog.setLocationRelativeTo(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public PuzzleDialog(int arg) {
		setBounds(100, 100, 263, 183);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.activeCaption);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		SpringLayout sl_contentPanel = new SpringLayout();
		contentPanel.setLayout(sl_contentPanel);
		{
			lblNewLabel = new JLabel("New label");
			contentPanel.add(lblNewLabel);
		}
		{
			lblNewLabel_1 = new JLabel("New label");
			sl_contentPanel.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 0, SpringLayout.NORTH, contentPanel);
			sl_contentPanel.putConstraint(SpringLayout.WEST, lblNewLabel_1, 36, SpringLayout.WEST, contentPanel);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JButton btnOk = new JButton("OK");
			sl_contentPanel.putConstraint(SpringLayout.WEST, lblNewLabel, 0, SpringLayout.WEST, btnOk);
			sl_contentPanel.putConstraint(SpringLayout.SOUTH, lblNewLabel, -14, SpringLayout.NORTH, btnOk);
			sl_contentPanel.putConstraint(SpringLayout.WEST, btnOk, 86,
					SpringLayout.WEST, contentPanel);
			sl_contentPanel.putConstraint(SpringLayout.SOUTH, btnOk, -10,
					SpringLayout.SOUTH, contentPanel);
			btnOk.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {
					dispose();
				}
			});
			contentPanel.add(btnOk);
		}
		if (arg == 0) {//no puzzle specified
			lblNewLabel_1.setText("You must specify a puzzle!");
			lblNewLabel.setText("");
			lblNewLabel.setIcon(error);
		}
		else if(arg==1)
		{// no heuristic specified
			lblNewLabel_1.setText("You must specify a heuristic!");
			lblNewLabel.setText("");
			lblNewLabel.setIcon(error);
		}
		else if(arg==2)// wrong initial state
		{
			lblNewLabel_1.setText("  Not valid initial state.");
			lblNewLabel.setText("");
			lblNewLabel.setIcon(error);
		}
		else if(arg==3)// wrong goal state
		{
			lblNewLabel_1.setText("      Not valid goal state.");
			lblNewLabel.setText("");
			lblNewLabel.setIcon(error);
		}
		else if(arg==4)// not solvable configuration
		{
			lblNewLabel_1.setText("No solution for this configuration");
			lblNewLabel.setText("");
			lblNewLabel.setIcon(error);
		}
		
		else if(arg==5)// not solvable configuration
		{
			lblNewLabel_1.setText("  JVM is out of memory!");
			lblNewLabel.setText("");
			lblNewLabel.setIcon(error);
		}
	}

}
