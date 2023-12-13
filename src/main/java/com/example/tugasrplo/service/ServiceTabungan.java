package com.example.tugasrplo.service;

import com.example.tugasrplo.dto.respons.ResponseApI;
import com.example.tugasrplo.dto.respons.ResponseGetTabungan;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface ServiceTabungan {

    void saveTabungan(int saldo, int id);

    ResponseApI<?> getTabungan(Integer userId);
}
