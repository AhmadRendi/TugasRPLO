package com.example.tugasrplo.controller;

import com.example.tugasrplo.dto.request.SearchNasabah;
import com.example.tugasrplo.dto.respons.ResponseApI;
import com.example.tugasrplo.service.impl.ServiceTabunganImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:63342")
@RestController
@RequestMapping("/api/tabungan")
@AllArgsConstructor
@Slf4j
public class TabunganController {

    private ServiceTabunganImpl tabungan;

    @PostMapping("/get")
    public ResponseEntity<ResponseApI<?>> getTabungan(@RequestBody SearchNasabah searchNasabah) {
        log.info("sampai disini");
        return ResponseEntity.ok(tabungan.getTabungan(searchNasabah.getId()));
    }

}
