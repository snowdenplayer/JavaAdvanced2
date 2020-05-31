package applicationInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AppDao {
    static String READ_ALL = "select * from app";
    static String CREATE = "insert into app(`name`,`year`) values (?,?)";
    static String READ_BY_ID = "select * from app where id=?";
    static String UPDATE_BY_ID = "update app set name=? ,year=? where id=?";
    static String DELETE_BY_ID = "delete from app where id=?";

    private Connection con;
    private PreparedStatement prp;


    public void insert(Application app) throws SQLException {
        prp = con.prepareStatement(CREATE);
        prp.setString(1,app.getName());
        prp.setInt(2,app.getYear());
        prp.executeUpdate();
    }
    public Application read(int id) throws SQLException {
        prp = con.prepareStatement(READ_BY_ID);
        prp.setInt(1,id);
        ResultSet res = prp.executeQuery();
        res.next();
        return AppMapper.map(res);
    }

    public void update(Application app) throws SQLException {
        prp = con.prepareStatement(UPDATE_BY_ID);
        prp.setString(1,app.getName());
        prp.setInt(2,app.getYear());
        prp.setInt(3,app.getId());
        prp.executeUpdate();
    }

    public void delete(int id) throws SQLException {
        prp = con.prepareStatement(DELETE_BY_ID);
        prp.setInt(1,id);
        prp.executeUpdate();
    }

    public List<Application> readAll() throws SQLException {
        List<Application> list = new ArrayList<>();
        prp = con.prepareStatement(READ_ALL);
        ResultSet set = prp.executeQuery();
        while(set.next()){
            list.add(AppMapper.map(set));
        }
        return list;
    }

}
