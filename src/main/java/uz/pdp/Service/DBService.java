package uz.pdp.Service;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import uz.pdp.model.ApiResult;
import uz.pdp.model.User;

import java.sql.*;

@RequiredArgsConstructor
public class DBService {
    private final String url;
    private final String user;
    private final String password;

    public Connection connect() {
        Connection conn = null;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public ApiResult register(User user) {
        try {
            Connection connection = connect();
            CallableStatement callableStatement = connection.prepareCall("{Call sing_up(?,?,?)}");
            callableStatement.setString(1, user.getName());
            callableStatement.setString(2, user.getUsername());
            callableStatement.setString(3, user.getPassword());
            callableStatement.registerOutParameter(1, Types.BOOLEAN);
            callableStatement.registerOutParameter(2, Types.VARCHAR);
            callableStatement.execute();
            return ApiResult.builder()
                    .success(callableStatement.getBoolean(1))
                    .message(callableStatement.getString(2))
                    .build();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public User login(String username, String password) {

        try (Connection connect = connect()) {
            PreparedStatement preparedStatement = connect.prepareStatement("Select * FROM users WHere user_name = ? and password = ?");
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (!resultSet.next()) {
                return null;
            }
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            username = resultSet.getString(3);
            return User.builder()
                    .id(id)
                    .name(name)
                    .username(username)
                    .build();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
