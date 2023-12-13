package com.example.tugasrplo.service;

import com.example.tugasrplo.dto.request.LoginUserDto;
import com.example.tugasrplo.entity.User;

public interface ServiceUser {

    String loginUser(LoginUserDto loginUserDto);

    User getUserById(Integer id);

}
