package com.example.tugasrplo.service.impl;

import com.example.tugasrplo.dto.respons.ClassResponseGetTabungan;
import com.example.tugasrplo.dto.respons.ResponseApI;
import com.example.tugasrplo.dto.respons.ResponseGetTabungan;
import com.example.tugasrplo.exception.NotFoundException;
import com.example.tugasrplo.repo.MenabungRepo;
import com.example.tugasrplo.repo.TabunganRepo;
import com.example.tugasrplo.service.ServiceTabungan;
import com.example.tugasrplo.service.ServiceUser;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@Repository
@AllArgsConstructor
public class ServiceTabunganImpl implements ServiceTabungan {


    private TabunganRepo repo;
    private ServiceUserImpl user;

    @Override
    public void saveTabungan(int saldo, int id) {
        try{
            user.getUserById(id);
            repo.updateTabungan(saldo, id);
        }catch (NotFoundException exception){
            throw new NotFoundException(exception.getMessage());
        }
    }

    @Override
    public ResponseApI<?> getTabungan(Integer userId) {
        ClassResponseGetTabungan responseGetTabungan = new ClassResponseGetTabungan();
        try{
            user.getUserById(userId);
            ResponseGetTabungan tabungan = repo.getTabungan(userId);
            responseGetTabungan.setName(tabungan.getNasabah());
            responseGetTabungan.setSaldo(tabungan.getSaldo());
            return ResponseApI.builder()
                    .code(HttpStatus.FOUND.value())
                    .data(responseGetTabungan)
                    .build();
        }catch (NotFoundException exception){
            return ResponseApI.builder()
                    .code(HttpStatus.NOT_FOUND.value())
                    .message(exception.getMessage())
                    .build();
        }
    }
}
