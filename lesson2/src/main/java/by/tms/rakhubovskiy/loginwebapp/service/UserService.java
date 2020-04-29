package by.tms.rakhubovskiy.loginwebapp.service;

import by.tms.rakhubovskiy.loginwebapp.entity.UserAccount;

import java.util.List;

public interface UserService {

    List<UserAccount> getUser();

    void addUser(String userName, String login, String password);

    UserAccount findUser(String login, String password);
}
