package studentManage;
 
 
import java.sql.*;
 
public class JDBC{
 
    public static void main(String[] args) throws Exception {
        try {
            // ע�� JDBC ����
            Class.forName("com.mysql.cj.jdbc.Driver");
 
            // ������
             
            Connection conn = DriverManager.getConnection("jdbc:conn-local://localhost:3306/text");
            // ִ�в�ѯ
            Statement stmt = conn.createStatement();
            String sql = "SELECT id, name, url FROM text";
            ResultSet rs = stmt.executeQuery(sql);
 
            // չ����������ݿ�
            while (rs.next()) {
                // ͨ���ֶμ���
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String url = rs.getString("url");
 
                // �������
                System.out.print("ID: " + id);
                System.out.print("  NAME " + name);
                System.out.print("  URL: " + url);
                System.out.print("\n");
            }
            // �ͷ���Դ
            rs.close();
            stmt.close();
            conn.close();
 
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
 
    }
}
 
 