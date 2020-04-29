package by.tms.rakhubovskiy.loginwebapp.repository;

import by.tms.rakhubovskiy.loginwebapp.entity.UserAccount;

import java.util.List;

public interface UserRepository {

    List<UserAccount> getUser();

    void addUser(String userName, String login, String password);

    UserAccount findUser(String login, String password);


}
