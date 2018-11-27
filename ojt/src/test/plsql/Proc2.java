package test.plsql;
 
import java.sql.*;
import java.io.*;
 
public class Proc2 {
 
    public Proc2(){ }
    
    public static void main(String[] args) {
        try{
            String driver="oracle.jdbc.driver.OracleDriver";
            String url="jdbc:oracle:thin:@127.0.0.1:1521:XE";
            String id = "soldesk";
            String password = "1234";
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url, id, password);
 
/*
CREATE or REPLACE PROCEDURE proc2(
    i_deptno IN number, -- �μ� ��ȣ
    o_count OUT number  -- ���� ��
)
IS
BEGIN
    SELECT count(*) INTO o_count FROM EMP
    WHERE deptno = i_deptno;
END;
/
 
*/
            CallableStatement cstmt = conn.prepareCall("{call proc2(?,?)}");
            
            cstmt.setInt(1, 10);
            // output �Ķ������ ����
            cstmt.registerOutParameter(2, java.sql.Types.INTEGER);
            cstmt.executeUpdate();
            
            // Output �Ķ���͸� �������� �κ�, output �Ķ���ʹ� 2��° 
            // ������ getInt(2)�� ���� �մϴ�.
            System.out.println("10�� �μ��� ������: " + cstmt.getInt(2));
        }catch(Exception e){
            System.out.println(e.toString());
        }
        System.out.println("���������� ����Ǿ����ϴ�.");
    }
}
 
 