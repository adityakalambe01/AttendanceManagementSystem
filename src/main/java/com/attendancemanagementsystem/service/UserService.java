package com.attendancemanagementsystem.service;

import com.attendancemanagementsystem.customexceptions.UserException;
import com.attendancemanagementsystem.entity.User;
import com.attendancemanagementsystem.repository.FacultyRepository;
import com.attendancemanagementsystem.repository.StudentRepository;
import com.attendancemanagementsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    FacultyRepository facultyRepository;

    @Autowired
    StudentRepository studentRepository;

    public boolean checkUserIsPresent(User user){
        return userRepository.findByUsername(user.getUsername()) == null || userRepository.findByUserEmailId(user.getUserEmailId()) == null;
    }


    /*
    *
    * Add new User
    *
    * */
    public Boolean addNewUser(User newUser){
        try{
            if(new UserService().checkUserIsPresent(newUser)){
                throw new UserException("User already exists!");
            }
            userRepository.save(newUser);

        }catch(UserException e){
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    /*
    *
    * Delete User
    *
    * */
    public boolean deleteUser(Long userId){
        try{
            if(userRepository.existsById(userId)){
                userRepository.deleteById(userId);
            }else{
                throw new UserException("User not found");
            }
        }catch (UserException e){
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    /*
    *
    * Update existing user
    *
    * */
    public User updateExistingUser(long userId, User browserUser){
        User dbuser;
        try {
            dbuser = userRepository.findById(userId).get();
            dbuser.setUserRole(
                    browserUser.getUserRole()
            );
            dbuser.setUserEmailId(
                    browserUser.getUserEmailId()
            );
            dbuser.setUserPassword(
                    browserUser.getUserPassword()
            );
            dbuser.setUserFullName(
                    browserUser.getUserFullName()
            );
            userRepository.save(dbuser);
        }catch (Exception e){
            return browserUser;
        }
        return dbuser;
    }

    /*
    *
    * Get User by id
    *
    * */
    public User getUserById(Long userId){
        try{
            return userRepository.findById(userId).get();
        }catch (Exception e){
            return null;
        }
    }

    /*
    *
    * Get User by Name
    *
    * */
    public List<User> getUserByName(String name){
        return userRepository.findByUserFullNameContainingIgnoreCase(name);
    }

    /*
    *
    * Get User By Role
    *
    * */
    public List<User> getUserByRole(String role){
        return userRepository.findByUserRoleContainingIgnoreCase(role);
    }

    /*
    *
    * User Login
    *
    * */

    public User userLogin(User user){
        return userRepository.findByUserEmailId(user.getUserEmailId());
    }
}
