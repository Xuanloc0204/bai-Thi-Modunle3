package dao;

import model.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserDAO {
    public void insertUser(User user) throws SQLException;

    public User selectUser(int MaPhong);

    public List<User> selectAllUsers();

    public boolean deleteUser(int MaPhong) throws SQLException;

    public boolean updateUser(User user) throws SQLException;

    User getUserById(int MaPhong);

    void insertUserStore(User user) throws SQLException;
}
