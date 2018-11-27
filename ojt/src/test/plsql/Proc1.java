package test.plsql;
 
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
 
public class Proc1 {
 
    public Proc1(){ }
    
    public static void main(String[] args) {
        String driver="oracle.jdbc.driver.OracleDriver";
        String url="jdbc:oracle:thin:@127.0.0.1:1521:XE";
        String id = "soldesk";
        String password = "1234";
        
        Connection con = null;
        
        // PL/SQL ó��
        //--------------------------------
        CallableStatement cstmt = null;
        //--------------------------------
        try{
            Class.forName(driver);
            con = DriverManager.getConnection(url, id, password);
 
            // call ����� ���ν����� ȣ���մϴ�.
            cstmt = con.prepareCall("{call proc1(?,?)}");
            
            // ���ν����� �Ѱ��� �μ� ����
            cstmt.setInt(1, 10);
            cstmt.setFloat(2, 1.5f);
            cstmt.executeUpdate();
            
            System.out.print("���� ó�� �Ϸ�");
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{ cstmt.close(); }catch(Exception e){}
            try{ con.close(); }catch(Exception e){}    
        }
        System.out.println("���������� ����Ǿ����ϴ�.");
    }
}
 
 