package studentManage;
 
import java.awt.EventQueue;
import java.awt.Font;
 
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
 
public class ChangeFrame extends JFrame {
 
	private JPanel contentPane;
	private JTextField idField;
	private JTextField nameField;
	private JTextField genderField;
	private JTextField dobField;
	private JTextField batchField;
	private JTextField searchField;
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangeFrame frame = new ChangeFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
 
	public ChangeFrame() {
		setResizable(false);
		setTitle("修改信息");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 470);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("请输入要修改的学生的学号：");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 16));
		lblNewLabel.setBounds(71, 0, 208, 29);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("学号：");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(71, 105, 50, 30);
		panel.add(lblNewLabel_1);
		
		idField = new JTextField();
		idField.setEditable(false);
		idField.setBounds(143, 99, 240, 45);
		panel.add(idField);
		idField.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("姓名：");
		lblNewLabel_1_1.setFont(new Font("宋体", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(71, 160, 50, 30);
		panel.add(lblNewLabel_1_1);
		
		nameField = new JTextField();
		nameField.setColumns(10);
		nameField.setBounds(143, 154, 240, 45);
		panel.add(nameField);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("性别：");
		lblNewLabel_1_1_1.setFont(new Font("宋体", Font.PLAIN, 16));
		lblNewLabel_1_1_1.setBounds(71, 215, 50, 30);
		panel.add(lblNewLabel_1_1_1);
		
		genderField = new JTextField();
		genderField.setColumns(10);
		genderField.setBounds(143, 209, 240, 45);
		panel.add(genderField);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("出生日期：");
		lblNewLabel_1_1_1_1.setFont(new Font("宋体", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1.setBounds(41, 270, 80, 30);
		panel.add(lblNewLabel_1_1_1_1);
		
		dobField = new JTextField();
		dobField.setColumns(10);
		dobField.setBounds(143, 264, 240, 45);
		panel.add(dobField);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("班级：");
		lblNewLabel_1_1_1_2.setFont(new Font("宋体", Font.PLAIN, 16));
		lblNewLabel_1_1_1_2.setBounds(71, 325, 50, 30);
		panel.add(lblNewLabel_1_1_1_2);
		
		batchField = new JTextField();
		batchField.setColumns(10);
		batchField.setBounds(143, 319, 240, 45);
		panel.add(batchField);
		
		JButton changeButton = new JButton("修改");
		changeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int id = Integer.parseInt(searchField.getText());
				
				String nameString = nameField.getText();
				
				String gendeString = genderField.getText();
				
				String dobString = dobField.getText();
				
				int batch = Integer.parseInt(batchField.getText());
				
				SQLHelp sqlHelp = new SQLHelp();
				
				try {
					sqlHelp.changeStudent(id, nameString, gendeString, dobString, batch);
					
					JOptionPane.showMessageDialog(ChangeFrame.this, "修改成功！");
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(ChangeFrame.this, "修改失败！");
					e.printStackTrace();
				}
					
			}
		});
		changeButton.setFont(new Font("宋体", Font.PLAIN, 18));
		changeButton.setBounds(182, 389, 97, 33);
		panel.add(changeButton);
		
		searchField = new JTextField();
		searchField.setBounds(71, 39, 208, 45);
		panel.add(searchField);
		searchField.setColumns(10);
		
		JButton searchButton = new JButton("查找");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				
				int id = Integer.parseInt(searchField.getText());
				
				try {
					
					SQLHelp sqlHelp = new SQLHelp();
					
					Student student = sqlHelp.queryStudent(id);
					
					if(student != null) {
						
						// id 是直接读入的，所以就不需要从数据库中读出了
						idField.setText(String.valueOf(id));
						nameField.setText(student.getName());
						genderField.setText(student.getGender());
						dobField.setText(student.getDob());
						batchField.setText(String.valueOf(student.getBatch()));
						
					} else {
						JOptionPane.showMessageDialog(ChangeFrame.this, "无此用户");
					}
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		searchButton.setFont(new Font("宋体", Font.PLAIN, 18));
		searchButton.setBounds(289, 42, 97, 39);
		panel.add(searchButton);
	}
}
 
 