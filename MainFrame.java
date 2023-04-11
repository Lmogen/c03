 package studentManage;
 
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class MainFrame extends JFrame {
 
	private JPanel contentPane;
	// ����main�����ſ��Ե�������
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MainFrame() {
		// ���ô�С���ɸı�
		setResizable(false);
		// ���ñ���
		setTitle("ѧ������ϵͳ");
		// ����������ҳ�棬���е���ҳ��رյ�ʱ�򣬳����ֱ���˳�
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// setBounds(int x,int y,int width,int height);
		// x �� y �Ǵ��ڴ�ʱ��λ��
		// width �� height �Ǵ��ڴ��Ⱥ͸߶�
		setBounds(100, 100, 450, 350);
		// setLocationRelativeTo(c)
		// ���ô�������� c ��λ�ã��� c Ϊ�ջ��� null ʱ��Ĭ��Ϊ���������Ļ����
		setLocationRelativeTo(null);
		// ʵ����һ�� pane
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ѧ������ϵͳ");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("����", Font.BOLD, 25));
		lblNewLabel.setBounds(140, 10, 163, 44);
		contentPane.add(lblNewLabel);
		
		JButton addButton = new JButton("���ѧ��");
		// addActionListener ע�������
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// �����´��ڿɼ�
				new AddFrame().setVisible(true);
			}
		});
	
		addButton.setFont(new Font("����", Font.PLAIN, 18));
		addButton.setBounds(167, 64, 114, 37);
		contentPane.add(addButton);
		
		JButton changeButton = new JButton("�޸���Ϣ");
		changeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ͬ��
				new ChangeFrame().setVisible(true);
			}
		});
		changeButton.setFont(new Font("����", Font.PLAIN, 18));
		changeButton.setBounds(167, 121, 114, 37);
		contentPane.add(changeButton);
		
		JButton deleteButton = new JButton("ɾ��ѧ��");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ͬ��
				new DeleteFrame().setVisible(true);
			}
		});
		deleteButton.setFont(new Font("����", Font.PLAIN, 18));
		deleteButton.setBounds(167, 180, 114, 37);
		contentPane.add(deleteButton);
		
		JButton queryButton = new JButton("��ѯ��Ϣ");
		queryButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ͬ��
				new SearchFrame().setVisible(true);
			}
		});
		queryButton.setFont(new Font("����", Font.PLAIN, 18));
		queryButton.setBounds(167, 240, 114, 37);
		contentPane.add(queryButton);
	}
}
 