package studentManage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
 
public  class SQLHelp {
 
	public static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
	//public static final String DB_URL = "jdbc:mysql://localhost:3306/niit?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
	public static final String DB_URL = "jdbc:mysql://localhost:3306/cjlu?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
	public static final String username = "root";
	public static final String password = "123456";
	
	private Connection connection = null;
	private PreparedStatement pStatement = null;
	private ResultSet rSet = null;
	
	// ��������
	// ��̬��ʼ���飨ִֻ��һ�Σ�
	static {
		try {
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// �������ݿ�
	public void  connectDB() {
		try {
			connection = DriverManager.getConnection(DB_URL,username,password);
			System.out.println("���ݿ����ӳɹ�");
		} catch (SQLException e) {
			System.out.println("���ݿ�����ʧ��");
			e.printStackTrace();
		}
	}
	
	// �ر���Դ
	public void close() {
		if(rSet != null) {
			try {
				rSet.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(pStatement != null) {
			try {
				pStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public  void addStudent(int id, String nameString, String genderString, String dobString, int batch) throws SQLException {
		
		// try finally �����Ƿ��׳��쳣����ִ�� finally �е����
		try {
			// �����ӵ����ݿ�
			connectDB();
			
			// sql ���
			// ��̬ sql �����Ҫ�����ַ���ƴ��
			// ��̬ sql ���
			String addsql = "insert into student values(?, ?, ?, ?, ?)";
			
			pStatement = connection.prepareStatement(addsql);
			
			pStatement.setInt(1, id);
			pStatement.setString(2, nameString);
			pStatement.setString(3, genderString);
			pStatement.setString(4, dobString);
			pStatement.setInt(5, batch);
						
			pStatement.executeUpdate();
			
		} finally {
			
			close();
			
		}
		
	}
	
	public void changeStudent(int id, String nameString, String genderString, String dobString, int batch) throws SQLException {
					
		try {
			connectDB();
			
			String changesql = "update student set name = ?, gender = ?, dob = ?, batch = ? where id = ?";
					
			pStatement = connection.prepareStatement(changesql);
 
			pStatement.setString(1, nameString);
			pStatement.setString(2, genderString);
			pStatement.setString(3, dobString);
			pStatement.setInt(4, batch);
			pStatement.setInt(5, id);
					
			pStatement.executeUpdate();
			
		} finally {
			close();
		}	
 
	}
 
	public void deletestudent(int id) throws SQLException {
				
		try {
			
			connectDB();
			
			String deleteString = "delete from student where id = ?";
 
			pStatement = connection.prepareStatement(deleteString);
			
			pStatement.setInt(1, id);
			
			pStatement.execute();
 
		} finally {
			close();
		}
		
	}
	
	public Student queryStudent(int id) throws SQLException {
		try {
			connectDB();
			
			String querysql = "select * from student where id = ?";
			pStatement = connection.prepareStatement(querysql);
			pStatement.setInt(1, id);
			// ���ַ���ִ��
			// execute()	������ʹ�ã�����true��false
			// executeQuery() ר�����ڲ�ѯ�����ؽ����
			// executeUpdate() ר������ɾ��������
			rSet = pStatement.executeQuery();
			
			if(rSet.next()) {
				
				String nameString = rSet.getString(2);
				String genderString = rSet.getString(3);
				String dobString = rSet.getString(4);
				int batchString = rSet.getInt(5);
				
				// ��ѯ��ѧ����Ϣ���ؽ����
				return new Student(nameString, genderString, dobString, batchString);
			} else {
				// û�в�ѯ��ѧ����Ϣ������null
				return null;
			}
 
		} finally {
			close();
		}
 
	}
 
}
 
 