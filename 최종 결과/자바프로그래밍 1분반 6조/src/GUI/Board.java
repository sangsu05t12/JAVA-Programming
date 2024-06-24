package GUI;
import java.awt.*;
import javax.swing.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.border.LineBorder;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.table.DefaultTableModel;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Board {

	public JFrame frame;
	
	static public Operator o=null;
	private JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Board window = new Board(o);
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
	public Board(Operator _o) {
		o=_o;
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setTitle("여기 갈래?");
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 438, 397);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		RoundedButton btnNewButton_1 = new RoundedButton("글쓰기");
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBounds(22, 21, 92, 40);
		btnNewButton_1.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 18));
		btnNewButton_1.setBackground(new Color(255, 228, 225));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Write window = new Write(o);
				window.frame.setVisible(true);
				frame.dispose();
			}
		});
		
		frame.getContentPane().add(btnNewButton_1);
		
		RoundedButton btnNewButton_1_1 = new RoundedButton("메인");
		btnNewButton_1_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1_1.setBounds(317, 21, 92, 40);
		btnNewButton_1_1.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 19));
		btnNewButton_1_1.setBackground(new Color(255, 228, 225));
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainScreen window=new MainScreen(o);
				window.frame.setVisible(true);
				frame.dispose();
			}
		});
		frame.getContentPane().add(btnNewButton_1_1);
		
		
		String[] header= {"제목","글쓴이"};
		String[][] a=o.db.Reading();
		DefaultTableModel model = new DefaultTableModel(a, header);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 85, 387, 216);
		frame.getContentPane().add(scrollPane);
		table = new JTable();
		scrollPane.setViewportView(table);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String[] ti=new String[2];
				int row=table.getSelectedRow();
				ti=o.db.lookwriting(row);
				JOptionPane.showMessageDialog(null, ti[1],ti[0], JOptionPane.PLAIN_MESSAGE);
			}
		});
		table.setFillsViewportHeight(true);
		table.setModel(model);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Board.class.getResource("/img_adminMain/admin_main.PNG")));
		lblNewLabel.setBounds(0, 0, 422, 358);
		frame.getContentPane().add(lblNewLabel);
		
		
		frame.setLocationRelativeTo(null);

	}
}