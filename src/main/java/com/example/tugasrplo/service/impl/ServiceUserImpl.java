package com.example.tugasrplo.service.impl;

import com.example.tugasrplo.dto.request.LoginUserDto;
import com.example.tugasrplo.dto.respons.ResponseLoginUser;
import com.example.tugasrplo.entity.User;
import com.example.tugasrplo.exception.NotFoundException;
import com.example.tugasrplo.repo.UserRepo;
import com.example.tugasrplo.service.ServiceUser;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

//@RequiredArgsConstructor
@AllArgsConstructor
@Service
@Slf4j
public class ServiceUserImpl implements ServiceUser {

    private UserRepo userRepo;

    @Override
    public String loginUser(LoginUserDto loginUserDto) {
        log.info("masuk");
        ResponseLoginUser loginUser = userRepo.loginUser(loginUserDto.getUsername(), loginUserDto.getPassword());
        if (loginUser == null){
            throw new NotFoundException("USERNAME ATAU PASSWORD SALAH");
        }
        return "Berhasil";
    }


    @Override
    public User getUserById(Integer id) {
        User ids = userRepo.getUserById(id);
        if(ids != null){
            return userRepo.getUserById(id);
        }
        throw new  NotFoundException("NASABAH TIDAK DITEKUKAN");
    }
}
