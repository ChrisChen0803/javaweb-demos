package druid;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class druidDemo {
    public static void main(String[] args){
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
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = dataSource.getConnection();

            // Create a SQL statement
            statement = connection.createStatement();

            // Execute a SELECT query
            String query = "SELECT * FROM users";
            resultSet = statement.executeQuery(query);

            // Process the result set
            while (resultSet.next()) {
                // Retrieve data from the result set
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");

                // Perform operations with the retrieved data
                System.out.println("ID: " + id + ", Name: " + name);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the data source when done
            dataSource.close();
        }

        /*System.out.println(System.getProperty("user.dir"));
        Properties prop = new Properties();
        File file = new File("C:/Users/Chris/IdeaProjects/jdbc/jdbc-demo/src/druid/druid.properties");
        prop.load(new FileInputStream(file));
        *//*DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
        Connection connection = dataSource.getConnection();*/

    }
}
