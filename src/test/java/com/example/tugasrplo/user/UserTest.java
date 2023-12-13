package com.example.tugasrplo.user;

import com.example.tugasrplo.dto.request.LoginUserDto;
import com.example.tugasrplo.service.impl.ServiceUserImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserTest {

    @Autowired
    private ServiceUserImpl serviceUser;


    @Test
    void testLogin() {

        String username = "ahmadrendi";
        String password = "123";

        LoginUserDto loginUserDto = new LoginUserDto();

        loginUserDto.setUsername(username);
        loginUserDto.setPassword(password);

        String names = serviceUser.loginUser(loginUserDto);

        System.out.println(names);
    }
}
