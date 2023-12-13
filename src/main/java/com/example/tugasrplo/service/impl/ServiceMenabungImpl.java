package com.example.tugasrplo.service.impl;

import ch.qos.logback.core.rolling.helper.IntegerTokenConverter;
import com.example.tugasrplo.dto.request.MenabungDTO;
import com.example.tugasrplo.dto.respons.ResponseApI;
import com.example.tugasrplo.dto.respons.ResponseMenabung;
import com.example.tugasrplo.entity.Menabung;
import com.example.tugasrplo.entity.Tabungan;
import com.example.tugasrplo.entity.User;
import com.example.tugasrplo.exception.NotFoundException;
import com.example.tugasrplo.repo.MenabungRepo;
import com.example.tugasrplo.service.ServiceMenabung;
import com.example.tugasrplo.service.ServiceUser;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class ServiceMenabungImpl implements ServiceMenabung {

    private MenabungRepo repo;

    private ServiceUser user;

    private ServiceTabunganImpl tabungan;

    private String selectJenisSampah(String sampah){
        List<String> jenisSampah = new LinkedList<>(List.of("KORAN", "KERTAS", "DUPLEX", "KARDUS",
                "GELAS PLASTIK", "BOTOL PLASTIK", "PLASTIK NON BOTOL", "KACA", "KALENG", "BESI", " "));

        for (int i = 0; i < jenisSampah.size(); i++) {
                if (jenisSampah.get(i).equals(sampah)) {
                    return jenisSampah.get(i);
                } else if ((i == jenisSampah.size() - 1) && (jenisSampah.get(i).equals(" "))) {
                    throw new NotFoundException("Jenis Sampah Tidak Tersedia");
                }
            }
            return null;
    }

    private Integer harga(String sampah, int berat){
        List<String> jenisSampah = new LinkedList<>(List.of("KORAN", "KERTAS", "DUPLEX", "KARDUS",
                "GELAS PLASTIK", "BOTOL PLASTIK", "PLASTIK NON BOTOL", "KACA", "KALENG", "BESI", " "));

        List<Integer> hargaSampah = new LinkedList<>(List.of(2_500, 2_500, 5_000, 4_000, 1_000, 2_00, 3_000, 10_000, 2_000, 1_500));

        int k = 0;
        for (int i = 0; i < jenisSampah.size(); i++) {
            if (jenisSampah.get(i).equals(sampah)) {
                k = i;
                break;
            }
        }

        Integer temp = berat * hargaSampah.get(k);

        return temp;
    }

    private Menabung mapper(MenabungDTO dto){
        log.info("sampai disini");
        Menabung menabung = new Menabung();
        User user1 = user.getUserById(dto.getIdUser());
        menabung.setUser(user1);
        menabung.setJenisSampah(selectJenisSampah(dto.getJenisSampah()));
        menabung.setBerat(dto.getBerat());

        return menabung;
    }
    @Override
    public ResponseApI<?> menabung(MenabungDTO dto) {
        try{
            log.info("hello masuk");
            repo.save(mapper(dto));
            log.info(dto.getIdUser().toString());
            Integer totalHarga = harga(dto.getJenisSampah(), dto.getBerat());
            tabungan.saveTabungan(totalHarga, dto.getIdUser());
            ResponseMenabung menabung = new ResponseMenabung();
            menabung.setDebet(totalHarga);
            menabung.setBerat(dto.getBerat());
            menabung.setJenisSampah(dto.getJenisSampah());
            return ResponseApI.builder()
                    .code(HttpStatus.CREATED.value())
                    .data(menabung)
                    .message("BERHASIL MENABUNG")
                    .build();
        }catch (NotFoundException exception){
            return ResponseApI.builder()
                    .code(HttpStatus.NOT_FOUND.value())
                    .message(exception.getMessage())
                    .build();
        }
    }

}
