package service.impl;

import model.User;
import repository.IUserRepository;
import repository.impl.UserRepository;
import service.IUserService;

import java.util.List;

public class UserService implements IUserService {
    IUserRepository userRepository = new UserRepository();
    @Override
    public List<User> selectAllUser() {
        return userRepository.selectAllUser();
    }

    @Override
    public List<User> selectUserByCountry(String country) {
        return userRepository.selectUserByCountry(country);
    }
    @Override
    public User selectUserById(int id){
        return userRepository.selectUserById(id);
    }

    @Override
    public boolean insertUser(User user) {
        return userRepository.insertUser(user);
    }

    @Override
    public boolean deleteUser(int id) {
        return false;
    }

    @Override
    public boolean updateUser(User user) {
        return userRepository.updateUser(user);
    }
}
