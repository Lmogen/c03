package studentManage;
 
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
 
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
 
public class SearchFrame extends JFrame {
 
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
					SearchFrame frame = new SearchFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
  
	public SearchFrame() {
		setResizable(false);
		setTitle("��ѯ��Ϣ");
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
		
		JLabel lblNewLabel = new JLabel("������Ҫ���ҵ�ѧ����ѧ�ţ�");
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 16));
		lblNewLabel.setBounds(71, 0, 208, 29);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ѧ�ţ�");
		lblNewLabel_1.setFont(new Font("����", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(71, 105, 50, 30);
		panel.add(lblNewLabel_1);
		
		idField = new JTextField();
		idField.setEditable(false);
		idField.setBounds(143, 99, 240, 45);
		panel.add(idField);
		idField.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("������");
		lblNewLabel_1_1.setFont(new Font("����", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(71, 160, 50, 30);
		panel.add(lblNewLabel_1_1);
		
		nameField = new JTextField();
		nameField.setColumns(10);
		nameField.setBounds(143, 154, 240, 45);
		panel.add(nameField);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("�Ա�");
		lblNewLabel_1_1_1.setFont(new Font("����", Font.PLAIN, 16));
		lblNewLabel_1_1_1.setBounds(71, 215, 50, 30);
		panel.add(lblNewLabel_1_1_1);
		
		genderField = new JTextField();
		genderField.setColumns(10);
		genderField.setBounds(143, 209, 240, 45);
		panel.add(genderField);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("�������ڣ�");
		lblNewLabel_1_1_1_1.setFont(new Font("����", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1.setBounds(41, 270, 80, 30);
		panel.add(lblNewLabel_1_1_1_1);
		
		dobField = new JTextField();
		dobField.setColumns(10);
		dobField.setBounds(143, 264, 240, 45);
		panel.add(dobField);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("�༶��");
		lblNewLabel_1_1_1_2.setFont(new Font("����", Font.PLAIN, 16));
		lblNewLabel_1_1_1_2.setBounds(71, 325, 50, 30);
		panel.add(lblNewLabel_1_1_1_2);
		
		batchField = new JTextField();
		batchField.setColumns(10);
		batchField.setBounds(143, 319, 240, 45);
		panel.add(batchField);
		
		searchField = new JTextField();
		searchField.setBounds(71, 39, 208, 45);
		panel.add(searchField);
		searchField.setColumns(10);
		
		JButton searchButton = new JButton("����");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				// 1.����Ҫ��ѯ��ѧ�������id
				// ��Ϊѧ����ѧ����Ψһ�ģ��������Ǹ���ѧ�Ų�ѯ��ֻ����һ������
				// ת��һ����������
				int id = Integer.parseInt(searchField.getText());
				
				// 2.ִ��JDBC���
				try {
					SQLHelp sqlHelp = new SQLHelp();
					
					Student student = sqlHelp.queryStudent(id);
					
					// 3.����ѯ�����ı�����
					// ǰ����ѧ������
					if(student != null) {
						idField.setText(String.valueOf(id));
						nameField.setText(student.getName());
						genderField.setText(student.getGender());
						dobField.setText(student.getDob());
						batchField.setText(String.valueOf(student.getBatch()));
					} else {
						// ��ʱѧ�������ڣ���ʾ�û��������ڸ�ѧ��
						JOptionPane.showMessageDialog(SearchFrame.this, "�޴�ѧ��");
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}
		});
		searchButton.setFont(new Font("����", Font.PLAIN, 18));
		searchButton.setBounds(289, 42, 97, 39);
		panel.add(searchButton);
	}
}
  