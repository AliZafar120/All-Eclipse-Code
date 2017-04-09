package A_Path_finder;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class GUI extends JFrame
{
	//panels
	private JPanel containerPanel;
	private JPanel contentPanel;
	private JPanel controlPanel;
	private JPanel mazePanel;
	
	//contentpane components
	private JButton button_Create_Maze;
	private JLabel label_row;
	private JLabel label_column;
	private JTextField textfield_Rows;
	private JTextField textfield_columns;
	
	
	//controlpanel components
	private JButton button_Source;
	private JButton button_Goal;
	private JButton button_Obstacles;
	private JButton button_Find;
	private JButton button_Reset;
	
	
	
	
	
	private int rows=0;
	private int columns=0;
	private int set_Start=0;
	private int set_End=0;
	private ArrayList<Integer>obstacles= new ArrayList<Integer>();
	
	boolean start_selectable;
	boolean end_selectable;
	boolean obstacle_selectable;
	boolean maze_creatable;
	
	
	public static GUI multipanelGUI = new GUI();
	private JButton[] buttonList;
	
	
	public static void main(String[] args) {
		GUI frame = new GUI();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setTitle("A* Path FInder");
	}
	
	public GUI(){
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 500);
		containerPanel= new JPanel();//contains all panels
		
		//initializing boolean values
		start_selectable=false;
		end_selectable=false;
		obstacle_selectable=false;
		maze_creatable=true;
				
		
		
		//content panel components
		contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
	
		
		textfield_Rows= new JTextField(10);
		textfield_Rows.setText("0");
		textfield_columns = new JTextField(10);
		textfield_columns.setText("0");
		
		
		
		label_row= new JLabel();
		label_column= new JLabel();
		label_row.setText("Enter number of rows");
		label_row.setBounds(150, 110, 200, 50);
		label_column.setText("Enter Number of Columns");
		//label_column.setBounds(150, 170, 200, 50);
		
		
		//adding label and text to row and columns
		contentPanel.add(label_row);
		contentPanel.add(textfield_Rows);
		contentPanel.add(label_column);
		contentPanel.add(textfield_columns);
		contentPanel.addMouseListener( new MousePosition());
		
		
		//maze create button button
		button_Create_Maze= new JButton("Create Maze");
		button_Create_Maze.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				 rows= Integer.parseInt(textfield_Rows.getText().toString());
				 columns= Integer.parseInt(textfield_columns.getText().toString());
				
				mazePanel= new JPanel();
				if(rows>=1 && columns>=1){
				buttonList= new JButton[rows*columns+1];
				mazePanel.setLayout(new GridLayout(rows,columns));
				 for (int i = 0; i < rows*columns; i++) {
				      JButton button = new JButton(Integer.toString(i + 1));
				      buttonList[i+1]=button;
				      buttonList[i+1].addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							if(start_selectable){
								set_Start=Integer.parseInt(button.getText().toString());
								button_Source.setText(""+set_Start);
								start_selectable=false;
								button.setBackground(Color.GREEN);
								button.setOpaque(true);
							}
							if(end_selectable){
								set_End= Integer.parseInt(button.getText().toString());
								button_Goal.setText(""+set_End);
								end_selectable=false;
								button.setBackground(Color.RED);
								button.setOpaque(true);
							}
							if(obstacle_selectable){
								int obstacle_number=Integer.parseInt(button.getText().toString());
								if(!obstacles.contains(obstacle_number)){
									obstacles.add(obstacle_number);
									
								}
								button.setBackground(Color.BLACK);
								button.setOpaque(true);
								
							}
							
						}
					});
				      
				      
				      mazePanel.add(buttonList[i+1]);
				      
				     
				    }
				}
				else mazePanel.add(new JLabel("Please Enter Valid rows(rows>0) and columns(columns>0)."));
				containerPanel.add(mazePanel);
				maze_creatable=false;
				revalidate();
				
			}
		});
		contentPanel.add(button_Create_Maze);
		
		
		
		
		//starting control panel
		controlPanel= new JPanel();
		
		//initializing components
		button_Source= new JButton("Source");
		button_Goal= new JButton("Goal");
		button_Obstacles= new JButton("Obstacles");
		button_Find= new JButton("Find");
		button_Reset= new JButton("Reset");
		
		button_Source.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(!maze_creatable && !start_selectable) {
					start_selectable=true;
					end_selectable=false;
					obstacle_selectable=false;
				}
			}
		});
		
		button_Goal.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				if(!maze_creatable && !end_selectable) {
					start_selectable=false;
					end_selectable=true;
					obstacle_selectable=false;
				}
				
			}
		});
		
		button_Obstacles.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				

				if(!maze_creatable && !end_selectable && !start_selectable) {
			
					if(obstacle_selectable)obstacle_selectable=false;
					else obstacle_selectable=true;
				}
				
			}
		});
		
		
		button_Find.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(set_Start!=0 && set_End!=0){
					Board mazeBoard= new Board(rows,columns);
					ArrayList<Block> boardObstacles= new ArrayList<Block>();
					for(int i=0;i<obstacles.size();i++){
						boardObstacles.add(new Block((obstacles.get(i)/columns)+1,obstacles.get(i)%columns));
					}
					mazeBoard.SetBoardStart((set_Start/columns)+1,set_Start%columns);
					mazeBoard.SetBoardEnd((set_End/columns)+1,set_End%columns);
					mazeBoard.SetObstacleBlocks(boardObstacles);
					mazeBoard.Solve_Board();
					ArrayList<Integer> solvedList=mazeBoard.getSolvedPath();
					for(int i=0;i<solvedList.size();i++){
						buttonList[solvedList.get(i)].setBackground(Color.BLUE);
						buttonList[solvedList.get(i)].setOpaque(true);
					}
					
				}
				
			}
		});
		
		
		
		//adding components to panel
		controlPanel.add(button_Source);
		controlPanel.add(button_Goal);
		controlPanel.add(button_Obstacles);
		controlPanel.add(button_Find);
		controlPanel.add(button_Reset);
		
		//starting maze panel

		containerPanel.add(contentPanel);
		containerPanel.add(controlPanel);
	
		
		setContentPane(containerPanel);
	
		
		
	}

}

class MousePosition extends MouseAdapter{
	
	// helper class to find out where to place items
	   public void mouseClicked(java.awt.event.MouseEvent e){
		   int x=e.getX();
		   int y= e.getY();
		   System.out.println("X is "+ x+"\n"+"Y is "+y);
	   }
	
	
}


