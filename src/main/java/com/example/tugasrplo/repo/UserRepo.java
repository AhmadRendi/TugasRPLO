package com.example.tugasrplo.repo;

import com.example.tugasrplo.dto.respons.ResponseLoginUser;
import com.example.tugasrplo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

    @Query(value = "CALL loginUser(:username_user, :password_user)", nativeQuery = true)
    ResponseLoginUser loginUser(@Param("username_user") String username_user, @Param("password_user") String password_user);
    User getUserById(Integer id);
}
