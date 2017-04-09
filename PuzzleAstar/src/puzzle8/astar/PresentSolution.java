package puzzle8.astar;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.TextArea;
import java.awt.Font;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;

@SuppressWarnings("serial")
public class PresentSolution extends JFrame {

	private JPanel contentPane;
	private TextArea textArea = new TextArea();
	private TextArea textArea_1 = new TextArea();
	private  JButton btnShowMe = new JButton("Show me");

	//private 
	
	/**
	 * Launch the application.
	 */

	
	public static void main(final NodeStruct fin, final Graph g,final double x,final boolean puzzle8,final int one_dim) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PresentSolution frame = new PresentSolution(fin, g,x,puzzle8,one_dim);
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					frame.setTitle("Solution and Statistics");
				
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public void printSolution(NodeStruct fin, NodeStruct ini, StringBuilder sb,int one_dim) {
		if (fin == null)
			return;
		else
			printSolution(fin.getFather(), ini, sb,one_dim);
		sb.append(fin.printNode(one_dim));

	}

	public PresentSolution(final NodeStruct solution, Graph g,double elapsed,final boolean puzzle8,int one_dim) {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 400);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		textArea.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 12));
		textArea.setEditable(false);
		textArea_1.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 12));
		textArea_1.setEditable(false);
		textArea.setBounds(26, 46, 171, 241);

		contentPane.add(textArea);

		StringBuilder sb = new StringBuilder();
		sb.append("----Solution Steps----\n");
		printSolution(solution, g.getInitial(), sb,one_dim);
		textArea.setText(sb.toString());

		textArea_1.setBounds(232, 46, 171, 241);
		contentPane.add(textArea_1);
		sb = new StringBuilder();
		sb.append("----Statistics----\n");
		makeStat(g, sb,elapsed);
		textArea_1.setText(sb.toString());
		
		
		JButton btnOk = new JButton("OK");
		btnOk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				dispose();
				
			}
		});
		btnOk.setBounds(108, 314, 89, 23);
		contentPane.add(btnOk);
		
		btnShowMe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				AnimationSolution.main(solution,puzzle8);

			}
		});
		btnShowMe.setBounds(232, 314, 89, 23);
		
		contentPane.add(btnShowMe);

	}

	public void makeStat(Graph g, StringBuilder sb,double elapsed) {
		sb.append("Moves Required:" + g.getMoves()+"\n");
		sb.append("Search space size:" + g.getGraph().size()+"\n");
		sb.append("Elapsed Time:" + elapsed+" seconds\n");
	}
}
