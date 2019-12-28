import java.sql.*;
class MysqlCon{  
public static void main(String args[]){  
try{  
Class.forName("com.mysql.jdbc.Driver");  
Connection con=DriverManager.getConnection(  
"jdbc:mysql://hotst:3306/test_chinese?useUnicode=yes&characterEncoding=UTF-8","root","***");
//here sonoo is database name, root is username and password
Statement stmt1 = con.createStatement();
stmt1.executeUpdate("insert into emp(name) value ('喜歡');");
Statement stmt=con.createStatement();
ResultSet rs=stmt.executeQuery("select * from emp");
while(rs.next())
System.out.println(rs.getString(1));
con.close();  
}catch(Exception e){ System.out.println(e);}  
}  
} 
