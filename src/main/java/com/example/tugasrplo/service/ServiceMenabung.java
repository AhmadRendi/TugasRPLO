package com.example.tugasrplo.service;

import com.example.tugasrplo.dto.request.MenabungDTO;
import com.example.tugasrplo.dto.respons.ResponseApI;
import com.example.tugasrplo.entity.Menabung;

public interface ServiceMenabung {

    ResponseApI<?> menabung(MenabungDTO dto);

}
