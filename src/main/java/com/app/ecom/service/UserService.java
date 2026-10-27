package com.app.ecom.service;

import com.app.ecom.repository.UserRepository;
import com.app.ecom.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    //private List<User> userList = new ArrayList<>();
   // private Long nextId = 1L;

    public List<User> fetchAllUsers(){
        return userRepository.findAll();
    }

    public void  addUser( User user){
       // user.setId(nextId++);
        //userList.add(user);
        userRepository.save(user);
        /*return userList;
         */
    }

    public Optional<User> fetchUser(Long id) {
        //removed for loop and used java 8 streams
      // return userList.stream().filter(user -> user.getId().equals(id)).findFirst();
        return userRepository.findById(id);
    }

    public boolean updateUser(Long id, User updatedUser){
        return userRepository.findById(id)
                .map(existingUser -> {
                    existingUser.setFirstName(updatedUser.getFirstName());
                    existingUser.setLastName(updatedUser.getLastName());
                    return true;
                }).orElse(false);
    }
}
