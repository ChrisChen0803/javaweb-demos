package project;
import java.util.*;
import pojo.Account;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class jdbcDemo {
    public static void main(String[] args)throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        String url="jdbc:mysql://127.0.0.1:3306/db1";
        String username="root";
        String password = "1234";
        Connection conn = DriverManager.getConnection(url,username,password);
        String sql="update users set password = '12'";
        String sql1="select * from users";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql1);
        List <Account> list = new ArrayList<>();
        while(rs.next()){
            Account account = new Account();

            int id = rs.getInt( "id");
            String name = rs.getString("name");
            double money = rs.getDouble( "money");
            System.out.println(id);
            System.out.println(name);
            System.out.println(money);

            account.setId(id);
            account.setName(name);
            account.setMoney(money);

            list.add(account);

        }
        System.out.println(list.get(0));
//        try{
//            conn.setAutoCommit(false);
//            int count = stmt.executeUpdate(sql);
//            System.out.println(count);
//            conn.commit();
//        }
//        catch (Exception throwables){
//            conn.rollback();
//            throwables.printStackTrace();
//        }
        stmt.close();
        conn.close();
    }
}
