package com.example.demo.repo;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface UserRepo extends JpaRepository<User,Integer> {
    @Query(value = "SELECT * FROM INFO WHERE ID=?1",nativeQuery = true)
    User getUsersById(String userId);



    @Query(value = "SELECT * FROM  INFO WHERE ID=?1 AND ADDRESS=?2",nativeQuery = true)
    User getUsersByIdAndAddress(String userId,String address);

    //@Modifying use when update query run
    @Modifying
    @Query(value = "UPDATE INFO SET NAME=?2 WHERE ID=?1",nativeQuery = true)
    int updateUserById(String ID,String NAME);

    @Modifying
    @Query(value = "DELETE FROM INFO WHERE ADDRESS=?1",nativeQuery = true)
    int deleteUserByAddress(String address);

}
