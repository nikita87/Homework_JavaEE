package by.tms.rakhubovskiy.loginwebapp.service;

import by.tms.rakhubovskiy.loginwebapp.entity.UserAccount;
import by.tms.rakhubovskiy.loginwebapp.repository.UserRepository;

import java.util.List;

    public class UserServiceImpl implements UserService {

        private final UserRepository userRepository;

        public UserServiceImpl(UserRepository userRepository) {
            this.userRepository = userRepository;
        }

        @Override
        public List<UserAccount> getUser() {
            List<UserAccount> usersList = userRepository.getUser();
            return usersList;
        }

        @Override
        public void addUser(String userName, String login, String password) {
            userRepository.addUser(userName, login, password);
        }

        @Override
        public UserAccount findUser(String login, String password) {
            List<UserAccount> usersList = userRepository.getUser();

            for (UserAccount ua: usersList) {
                if ((ua != null) && (ua.getLogin().equals(login)) && (ua.getPassword().equals(password)))
                    return ua;
            }
            return null;
        }
    }


