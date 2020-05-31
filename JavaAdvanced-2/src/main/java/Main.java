import userInfo.User;
import userInfo.UserDao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {

        UserDao emp = new UserDao(ConnectionUtils.connect());
        emp.readAll().stream().forEach(x-> System.out.println(x ));
        System.out.println("**********************************************************************************\n");

        List<User> listof = new ArrayList<>();
        listof.add(new User("Tanya",18));
        listof.add(new User("Sasha",20));
        listof.add(new User("Zheka",15));
        listof.add(new User("Denys",13));


        listof.forEach(employee -> {
            try {
                emp.insert(employee);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });

        emp.readAll().stream().forEach(x-> System.out.println(x ));
        User emplo = emp.read(2);
        System.out.println(emplo);
        emplo.setName(emplo.getName()+"DeZhuk");
        emp.update(emplo);

        emplo = emp.read(2);
        System.out.println(emplo);
        emp.delete(2);
        emp.readAll().stream().forEach(x-> System.out.println(x ));


    }
}
