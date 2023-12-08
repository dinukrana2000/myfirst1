package com.example.demo.service;

import com.example.demo.dto.Userdto;
import com.example.demo.entity.User;
import com.example.demo.repo.UserRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ModelMapper modelMapper;

    public Userdto saveUser(Userdto userdto) {
        userRepo.save(modelMapper.map(userdto, User.class));
        return userdto;
    }

    public List<Userdto> getAllUsers() {

        List<User> userList = userRepo.findAll();
        return modelMapper.map(userList, new TypeToken<List<Userdto>>() {
        }.getType());
    }

    public Userdto updateUser(Userdto userdto) {
        userRepo.save(modelMapper.map(userdto, User.class));
        return userdto;
    }

    public boolean deleteUser(Userdto userdto) {
        userRepo.delete(modelMapper.map(userdto, User.class));
        return true;

    }

    // user(info table) id> user details
    // select * from info where id= 1
    public Userdto getUsersById(String userId) {
        User user = userRepo.getUsersById(userId);

        return modelMapper.map(user, Userdto.class);
    }

    // user(info table) id,address> user details
    // select * from info where id=1 and address="colombo"

    public Userdto getUsersByIdAndAddress(String userId, String address) {
        User user = userRepo.getUsersByIdAndAddress(userId, address);

        return modelMapper.map(user, Userdto.class);
    }

    // update table info set name="saman" where id=1
    public Userdto updateUserById(String ID, String NAME) {
        int user = userRepo.updateUserById(ID, NAME);
        return modelMapper.map(user, Userdto.class);
    }

    // delete from info where address="colombo"
    public boolean deleteUserByAddress(String address) {

        return true;
    }

}
