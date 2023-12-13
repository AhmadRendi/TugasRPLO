package com.example.tugasrplo.tabungan;

import com.example.tugasrplo.service.impl.ServiceTabunganImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TabunganTest {


    @Autowired
    private ServiceTabunganImpl serviceTabungan;


    @Test
    void testTabungan() {
        serviceTabungan.saveTabungan(10, 10);
    }
}
