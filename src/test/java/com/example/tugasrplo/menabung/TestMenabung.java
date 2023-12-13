package com.example.tugasrplo.menabung;

import com.example.tugasrplo.dto.request.MenabungDTO;
import com.example.tugasrplo.dto.respons.ResponseApI;
import com.example.tugasrplo.entity.Menabung;
import com.example.tugasrplo.exception.NotFoundException;
import com.example.tugasrplo.repo.MenabungRepo;
import com.example.tugasrplo.service.impl.ServiceMenabungImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.nio.file.LinkOption;
import java.util.LinkedList;
import java.util.List;

@SpringBootTest
@Slf4j
public class TestMenabung {


    @Autowired
    private ServiceMenabungImpl menabung;


    private List<String> jenisSampah = new LinkedList<>(List.of("KORAN", "KERTAS", "DUPLEX", "KARDUS",
            "GELAS PLASTIK", "BOTOL PLASTIK", "PLASTIK NON BOTOL", "KACA", "KALENG", "BESI", " "));

    private void selectJenisSampah(String sampah){
        for(int i = 0; i < jenisSampah.size(); i++){
            if(jenisSampah.get(i) == (sampah)){
                log.info("ditemukan");
                break;
            }else if ((i == jenisSampah.size() - 1) && (jenisSampah.get(i).equals(" "))){
                throw new NotFoundException("tidak ditemukan");
            }
        }
    }


    @Test
    void testSelectjenisSampah() {
//        MenabungDTO dto = new MenabungDTO();
//        dto.setBerat(10);
//        dto.setJenisSampah("BES");
//        dto.setIdUser(1);
//        ResponseApI<?> menabung1 = menabung.menabung(dto);
//
//        System.out.println(menabung1.message());
    }
}
