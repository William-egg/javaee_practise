import com.example.javaee_practise.utilts.jdbc;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class test01 {
    @Test
    public void  test01() {
        System.out.println("Hello World");
    }
    @Test
    public void test02() throws SQLException {
        jdbc myjdbc = new jdbc();
        Connection connection = myjdbc.getConnection();
        String sql = "select * from userInfo";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            String username = resultSet.getString("username");
            String password = resultSet.getString("password");
            System.out.println("Username: " + username + ", Password: " + password);
        }
    }
}
