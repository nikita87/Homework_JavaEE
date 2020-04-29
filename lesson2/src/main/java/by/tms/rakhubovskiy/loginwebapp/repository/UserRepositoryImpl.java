package by.tms.rakhubovskiy.loginwebapp.repository;


import by.tms.rakhubovskiy.loginwebapp.entity.UserAccount;
import by.tms.rakhubovskiy.loginwebapp.utils.DBUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UserRepositoryImpl implements UserRepository {

    private final String getUserQuery = "Select * from user_data";
    private final String addUserQuery = "INSERT INTO user_data (user_name, login, pass) VALUES (?, ?, ?)";


    @Override
    public List<UserAccount> getUser() {
        List<UserAccount> usersList = new ArrayList<>();
        try {
            Connection conn = DBUtils.connection();
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(getUserQuery);
            usersList.addAll(createUsersList(rs));
            DBUtils.returnConnection(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usersList;
    }

    @Override
    public void addUser(String userName, String login, String password) {
        try {
            Connection conn = DBUtils.connection();
            PreparedStatement prst = conn.prepareStatement(addUserQuery);
            prst.setString(1, userName);
            prst.setString(2, login);
            prst.setString(3, password);
            prst.executeUpdate();
            /*ResultSet rs = prst.getGeneratedKeys();
            if(rs.next())
            {
                pcGame.setId(rs.getLong(1));
            }*/
            DBUtils.returnConnection(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public UserAccount findUser(String login, String password) {
        List<UserAccount> usersList = new ArrayList<>();
        try {
            Connection conn = DBUtils.connection();
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(getUserQuery);
            usersList.addAll(createUsersList(rs));
            DBUtils.returnConnection(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (UserAccount ua: usersList) {
            if ((ua != null) && (ua.getLogin().equals(login)) && (ua.getPassword().equals(password)))
            return ua;
        }
        return null;
    }

    private List<UserAccount> createUsersList (ResultSet rs) throws SQLException {
        List<UserAccount> userAccountList = new ArrayList<>();
        while (rs.next()) {
            userAccountList.add(createUser(rs));
        }
        return userAccountList;
    }

    private UserAccount createUser(ResultSet rs) throws SQLException {
        UserAccount userAccount = new UserAccount();

        userAccount.setUserName(rs.getString(2));
        userAccount.setLogin(rs.getString(3));
        userAccount.setPassword(rs.getString(4));


        return userAccount;
    }
}

