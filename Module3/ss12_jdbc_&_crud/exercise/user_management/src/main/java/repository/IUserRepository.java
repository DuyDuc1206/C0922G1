package repository;

import model.User;

import java.util.List;

public interface IUserRepository {
    List<User> selectAllUser();
    List<User> selectUserByCountry(String country);
    User selectUserById(int id);
    boolean insertUser(User user);
    boolean deleteUser(int id);
    boolean updateUser(User user);
}
