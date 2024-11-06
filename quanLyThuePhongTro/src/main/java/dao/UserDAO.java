package dao;

import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements IUserDAO{
    private String jdbcURL = "jdbc:mysql://localhost:3306/quanlyphongtro";
    private String jdbcUsername = "root";
    private String jdbcPassword = "123456";

    private static final String INSERT_USERS_SQL = "INSERT INTO users (TenNguoiThue, SoDienThoai, NgayBatDau, MaHinhThucThanhToan, GhiChu) VALUES (?, ?, ?, ?, ?);";
    private static final String SELECT_USER_BY_ID = "select id,name,email,country from users where id =?";
    private static final String SELECT_ALL_USERS = "select * from users";
    private static final String DELETE_USERS_SQL = "delete from users where id = ?;";
    private static final String UPDATE_USERS_SQL = "update users set name = ?,email= ?, country =? where id = ?;";

    public UserDAO() {
    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public void insertUser(User user) throws SQLException {
        System.out.println(INSERT_USERS_SQL);
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setString(1, user.getTenNguoiThue());
            preparedStatement.setString(2, user.getSoDienThoai());
            preparedStatement.setString(3, user.getNgayBatDau());
            preparedStatement.setInt(4, user.getMaHinhThucThanhToan());
            preparedStatement.setString(5, user.getGhiChu());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }


    public User selectUser(int maPhong) {
        User user = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
            preparedStatement.setInt(1, maPhong);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String tenNguoiThue = rs.getString("TenNguoiThue");
                String soDienThoai = rs.getString("SoDienThoai");
                String ngayBatDau = rs.getString("NgayBatDau");
                int maHinhThucThanhToan = rs.getInt("MaHinhThucThanhToan");
                String ghiChu = rs.getString("GhiChu");
                user = new User(tenNguoiThue, soDienThoai, ngayBatDau, maHinhThucThanhToan, ghiChu);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return user;
    }

    public List<User> selectAllUsers() {

        List<User> users = new ArrayList<>();
        try (Connection connection = getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int maPhong = rs.getInt("MaPhong");
                String tenNguoiThue = rs.getString("TenNguoiThue");
                String soDienThoai = rs.getString("SoDienThoai");
                String ngayBatDau = rs.getString("NgayBatDau");
                int maHinhThucThanhToan = rs.getInt("MaHinhThucThanhToan");
                String ghiChu = rs.getString("GhiChu");
                users.add(new User(maPhong, tenNguoiThue, soDienThoai, ngayBatDau, maHinhThucThanhToan, ghiChu));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return users;

    }

    @Override
    public boolean deleteUser(int MaPhong) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
            statement.setInt(1, MaPhong);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
            statement.setInt(1, user.getMaPhong());
            statement.setString(2, user.getTenNguoiThue());
            statement.setString(3, user.getNgayBatDau());
            statement.setInt(4, user.getMaHinhThucThanhToan());
            statement.setString(5, user.getGhiChu());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    @Override
    public User getUserById(int MaPhong) {
        User user = null;
        String query = "{CALL get_user_by_id(?)}";
        try (Connection connection = getConnection();
             CallableStatement callableStatement = connection.prepareCall(query)) {
            callableStatement.setInt(1, MaPhong);
            ResultSet rs = callableStatement.executeQuery();

            while (rs.next()) {
                String TenNguoiThue = rs.getString("TenNguoiThue");
                String SoDienThoai = rs.getString("SoDienThoai");
                String NgayBatDau = rs.getString("NgayBatDau");
                int MaHinhThucThanhToan = rs.getInt("MaHinhThucThanhToan");
                String GhiChu = rs.getString("GhiChu");
                user = new User(MaPhong, TenNguoiThue, SoDienThoai, NgayBatDau, MaHinhThucThanhToan, GhiChu);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return user;
    }

    @Override
    public void insertUserStore(User user) throws SQLException {
        String query = "{CALL insert_user(?,?,?,?,?)}";

        try (Connection connection = getConnection();
             CallableStatement callableStatement = connection.prepareCall(query)) {
            callableStatement.setString(1, user.getTenNguoiThue());
            callableStatement.setString(2, user.getSoDienThoai());
            callableStatement.setString(3, user.getNgayBatDau());
            callableStatement.setInt(4, user.getMaHinhThucThanhToan());
            callableStatement.setString(5, user.getGhiChu());
            System.out.println(callableStatement);
            callableStatement.executeUpdate();
        }catch (SQLException e){
            printSQLException(e);
        }
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

}
