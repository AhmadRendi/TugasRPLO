package com.example.tugasrplo.controller;

import com.example.tugasrplo.dto.request.MenabungDTO;
import com.example.tugasrplo.dto.respons.ResponseApI;
import com.example.tugasrplo.service.impl.ServiceMenabungImpl;
import com.example.tugasrplo.service.impl.ServiceTabunganImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http://localhost:63342")
@RestController
@RequestMapping("/api")
@AllArgsConstructor
@Slf4j
public class MenabungController {

    private ServiceMenabungImpl menabung;

    @PostMapping("/ge")
    public ResponseEntity<ResponseApI<?>> tambahTabungan(@RequestBody MenabungDTO dto){
        return ResponseEntity.ok(menabung.menabung(dto));
    }
}
