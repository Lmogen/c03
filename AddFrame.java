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

 
public class AddFrame extends JFrame {
 
	private JPanel contentPane;
	private JTextField idField;
	private JTextField nameField;
	private JTextField genderField;
	private JTextField dobField;
	private JTextField batchField;
 
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddFrame frame = new AddFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
 
	 
	public AddFrame() {
		// ��ǰ������
		setResizable(false);
		setTitle("���ѧ��");
		// ����ط������ѧ��ֻ����������һ���֣����Ե��ر��ⲿ�ֵ�ʱ�򣬳���ֱ���˳���ֻ�ǹرոò��ֳ���
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
		
		JLabel TitleLabel = new JLabel("��������ѧ������Ϣ��");
		TitleLabel.setFont(new Font("����", Font.BOLD, 20));
		TitleLabel.setBounds(71, 34, 220, 45);
		panel.add(TitleLabel);
		
		JLabel idLabel = new JLabel("ѧ�ţ�");
		idLabel.setFont(new Font("����", Font.PLAIN, 16));
		idLabel.setBounds(71, 105, 50, 30);
		panel.add(idLabel);
		
		idField = new JTextField();
		idField.setBounds(143, 99, 240, 45);
		panel.add(idField);
		idField.setColumns(10);
		
		JLabel nameLabel = new JLabel("������");
		nameLabel.setFont(new Font("����", Font.PLAIN, 16));
		nameLabel.setBounds(71, 160, 50, 30);
		panel.add(nameLabel);
		
		nameField = new JTextField();
		nameField.setColumns(10);
		nameField.setBounds(143, 154, 240, 45);
		panel.add(nameField);
		
		JLabel genderLabel = new JLabel("�Ա�");
		genderLabel.setFont(new Font("����", Font.PLAIN, 16));
		genderLabel.setBounds(71, 215, 50, 30);
		panel.add(genderLabel);
		
		genderField = new JTextField();
		genderField.setColumns(10);
		genderField.setBounds(143, 209, 240, 45);
		panel.add(genderField);
		
		JLabel dobLabel = new JLabel("�������ڣ�");
		dobLabel.setFont(new Font("����", Font.PLAIN, 16));
		dobLabel.setBounds(41, 270, 80, 30);
		panel.add(dobLabel);
		
		dobField = new JTextField();
		dobField.setColumns(10);
		dobField.setBounds(143, 264, 240, 45);
		panel.add(dobField);
		
		JLabel batchLabel = new JLabel("�༶��");
		batchLabel.setFont(new Font("����", Font.PLAIN, 16));
		batchLabel.setBounds(71, 325, 50, 30);
		panel.add(batchLabel);
		
		batchField = new JTextField();
		batchField.setColumns(10);
		batchField.setBounds(143, 319, 240, 45);
		panel.add(batchField);
		
		JButton addButton = new JButton("���");
		// ����������¼�
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ��ȡ������
				// getText() �����ַ������͵�
				// Integer.parseInt ��������ת��
				int id = Integer.parseInt(idField.getText());
 
				String nameString = nameField.getText();
 
				String genderString = genderField.getText();
 
				String dobfieldString = dobField.getText();
 
				int batch = Integer.parseInt(batchField.getText());
				// ���һ��ѧ������Ϣ�������޸�
				System.out.println(id + "\t" + nameString + "\t" + genderString + "\t" + dobfieldString + "\t" + batch);
				// SQLHelp ���Լ�д��һ��������
				SQLHelp sqlHelp = new SQLHelp();
				try {
					// �������ѧ����Ϣ�ķ���
					sqlHelp.addStudent(id, nameString, genderString, dobfieldString, batch);
					// �����Ի�����ʾ�û���ӳɹ�
					JOptionPane.showMessageDialog(AddFrame.this, "��ӳɹ���");
				} catch (SQLException e1) {
					// ���ﲶ��һ���쳣����Ϊѧ����ѧ����Ψһ�ģ����Ե�ѧ���Ѿ����ڵ�ʱ����ʾ�û�����ѧ����Ϣ�Ѵ���
					// �쳣����Ϊ 23000
					if(e1.getSQLState().equals("23000")) {
						JOptionPane.showMessageDialog(AddFrame.this, "���ʧ��!��ѧ���Ѵ���");
					}
					e1.printStackTrace();
				}
 
			}
		});
		addButton.setFont(new Font("����", Font.PLAIN, 18));
		addButton.setBounds(182, 389, 97, 33);
		panel.add(addButton);
	}
}
 