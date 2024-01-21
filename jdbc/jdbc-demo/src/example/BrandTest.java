package example;
import com.alibaba.druid.pool.DruidDataSource;
import pojo.Brand;
import java.util.*;
import org.junit.Test;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BrandTest {
    @Test
    public void testSelectAll() throws Exception{
        DruidDataSource dataSource = new DruidDataSource();

        // Set database connection properties
        dataSource.setUrl("jdbc:mysql:///db1");
        dataSource.setUsername("root");
        dataSource.setPassword("1234");

        // Set other optional properties
        dataSource.setInitialSize(5);  // Initial number of connections
        dataSource.setMinIdle(5);      // Minimum number of idle connections
        dataSource.setMaxActive(20);    // Maximum number of active connections
        dataSource.setMaxWait(60000);   // Maximum wait time for a connection from the pool
        Connection conn = dataSource.getConnection();

        String sql = "select * from tb_brand";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        List <Brand> brands = new ArrayList<>();
        Brand brand = null;
        while(rs.next()){
            int id = rs.getInt("id");
            String brandName = rs.getString("brand_name");
            String companyName = rs.getString("company_name");
            int ordered = rs.getInt("ordered");
            String description = rs.getString("description");
            int status = rs.getInt("status");

            brand = new Brand();
            brand.setId(id);
            brand.setBrand_name(brandName);
            brand.setCompany_name(companyName);
            brand.setDescription(description);
            brand.setOrdered(ordered);
            brand.setStatus(status);

            brands.add(brand);
        }
        System.out.println(brands);
        rs.close();
        pstmt.close();
        conn.close();

    }

    @Test
    public void testAddAll() throws Exception {

        String brandName = "testBrandName";
        String companyName = "testCompanyName";
        int ordered = 1;
        String description = "Test Description";
        int status = 1;
        DruidDataSource dataSource = new DruidDataSource();

        // Set database connection properties
        dataSource.setUrl("jdbc:mysql:///db1");
        dataSource.setUsername("root");
        dataSource.setPassword("1234");

        // Set other optional properties
        dataSource.setInitialSize(5);  // Initial number of connections
        dataSource.setMinIdle(5);      // Minimum number of idle connections
        dataSource.setMaxActive(20);    // Maximum number of active connections
        dataSource.setMaxWait(60000);   // Maximum wait time for a connection from the pool
        Connection conn = dataSource.getConnection();

        String sql = "insert into tb_brand(brand_name, company_name, ordered, description, status) values(?,?,?,?,?);";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,brandName);
        pstmt.setString(2,companyName);
        pstmt.setInt(3,ordered);
        pstmt.setString(4,description);
        pstmt.setInt(5,status);

        int count = pstmt.executeUpdate();
        System.out.println(count);
        pstmt.close();
        conn.close();
    }

    @Test
    public void testUpdate() throws Exception {

        String brandName = "testBrandName";
        String companyName = "testCompanyName";
        int ordered = 1;
        String description = "Test Description";
        int status = 100;
        int id = 4;
        DruidDataSource dataSource = new DruidDataSource();

        // Set database connection properties
        dataSource.setUrl("jdbc:mysql:///db1");
        dataSource.setUsername("root");
        dataSource.setPassword("1234");

        // Set other optional properties
        dataSource.setInitialSize(5);  // Initial number of connections
        dataSource.setMinIdle(5);      // Minimum number of idle connections
        dataSource.setMaxActive(20);    // Maximum number of active connections
        dataSource.setMaxWait(60000);   // Maximum wait time for a connection from the pool
        Connection conn = dataSource.getConnection();

        String sql = "update tb_brand\n"
                    +"set brand_name = ?,\n"
                    +"company_name = ?,\n"
                    +"ordered = ?,\n"
                    +"description = ?,\n"
                    +"status = ?\n"
                    +"where id = ?";

        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,brandName);
        pstmt.setString(2,companyName);
        pstmt.setInt(3,ordered);
        pstmt.setString(4,description);
        pstmt.setInt(5,status);
        pstmt.setInt(6,id);



        int count = pstmt.executeUpdate();
        System.out.println(count);
        pstmt.close();
        conn.close();
    }

}
