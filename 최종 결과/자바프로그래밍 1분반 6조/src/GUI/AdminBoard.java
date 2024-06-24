package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;

public class AdminBoard {

	public JFrame frame;
	private JButton btnNewButton_1;
	static public Operator o=null;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminBoard window = new AdminBoard(o);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public class RoundedButton extends JButton {
	      public RoundedButton() { super(); decorate(); } 
	      public RoundedButton(String text) { super(text); decorate(); } 
	      public RoundedButton(Action action) { super(action); decorate(); } 
	      public RoundedButton(Icon icon) { super(icon); decorate(); } 
	      public RoundedButton(String text, Icon icon) { super(text, icon); decorate(); } 
	      protected void decorate() { setBorderPainted(false); setOpaque(false); }
	      @Override 
	      protected void paintComponent(Graphics g) {
	         Color c=new Color(255, 182, 193); //배경색 결정
	         Color o=new Color(255,255,255); //글자색 결정
	         int width = getWidth(); 
	         int height = getHeight(); 
	         Graphics2D graphics = (Graphics2D) g; 
	         graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); 
	         if (getModel().isArmed()) { graphics.setColor(c.darker()); } 
	         else if (getModel().isRollover()) { graphics.setColor(c.brighter()); } 
	         else { graphics.setColor(c); } 
	         graphics.fillRoundRect(0, 0, width, height, 10, 10); 
	         FontMetrics fontMetrics = graphics.getFontMetrics(); 
	         Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds(); 
	         int textX = (width - stringBounds.width) / 2; 
	         int textY = (height - stringBounds.height) / 2 + fontMetrics.getAscent(); 
	         graphics.setColor(o); 
	         graphics.setFont(getFont()); 
	         graphics.drawString(getText(), textX, textY); 
	         graphics.dispose(); 
	         super.paintComponent(g); 
	         }
	      }

	/**
	 * Create the application.
	 */
	public AdminBoard(Operator _o) {
		o=_o;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.getContentPane().setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		frame.setBounds(100, 100, 453, 423);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		btnNewButton_1 = new RoundedButton("삭제");
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] ti=new String[2];
				int row=table.getSelectedRow();
				ti=o.db.lookwriting(row);
				o.db.removewriting(ti[0]);
				AdminBoard window = new AdminBoard(o);
				window.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton_1.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 18));
		btnNewButton_1.setBackground(new Color(255, 228, 225));
		btnNewButton_1.setBounds(27, 315, 103, 39);
		frame.getContentPane().add(btnNewButton_1);
		
		RoundedButton btnNewButton_1_1 = new RoundedButton("뒤로가기");
		btnNewButton_1_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminMain window = new AdminMain(o);
				window.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton_1_1.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 17));
		btnNewButton_1_1.setBackground(new Color(255, 228, 225));
		btnNewButton_1_1.setBounds(310, 315, 103, 39);
		frame.getContentPane().add(btnNewButton_1_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 20, 386, 285);
		frame.getContentPane().add(scrollPane);
		
		String[][] a=o.db.Reading();
		String[] header= {"제목","글쓴이"};
		table = new JTable();
		table.setModel(new DefaultTableModel(
			a, header
		));
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(AdminBoard.class.getResource("/img_adminMain/admin_main.PNG")));
		lblNewLabel.setBounds(0, 0, 437, 384);
		frame.getContentPane().add(lblNewLabel);
		frame.setLocationRelativeTo(null);
	}
}
