package userInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    static String READ_ALL = "select * from user";
    static String CREATE = "insert into User(`name`,`age`) values (?,?)";
    static String READ_BY_ID = "select * from User where id=?";
    static String UPDATE_BY_ID = "update User set name=? ,age=? where id=?";
    static String DELETE_BY_ID = "delete from User where id=?";


    private Connection con;
    private PreparedStatement rpp;

    public UserDao(Connection con) {
        this.con = con;
    }
    public void insert(User user) throws SQLException {
        rpp = con.prepareStatement(CREATE);
        rpp.setString(1,user.getName());
        rpp.setInt(2,user.getAge());
        rpp.executeUpdate();
    }

    public User read(int id) throws SQLException {
        rpp = con.prepareStatement(READ_BY_ID);
        rpp.setInt(1,id);
        ResultSet res =rpp.executeQuery();
        res.next();
        return UserMapper.map(res);
    }

    public void update(User user) throws SQLException {
        rpp = con.prepareStatement(UPDATE_BY_ID);
        rpp.setString(1,user.getName());
        rpp.setInt(2,user.getAge());
        rpp.setInt(3,user.getId());
        rpp.executeUpdate();
    }
    public void delete(int id) throws SQLException {
        rpp = con.prepareStatement(DELETE_BY_ID);
        rpp.setInt(1,id);
        rpp.executeUpdate();
    }

    public List<User>  readAll() throws SQLException {
        List<User> list = new ArrayList<>();
        rpp = con.prepareStatement(READ_ALL);
        ResultSet res = rpp.executeQuery();
        while(res.next()){
            list.add(UserMapper.map(res));
        }
        return list;
    }
}
