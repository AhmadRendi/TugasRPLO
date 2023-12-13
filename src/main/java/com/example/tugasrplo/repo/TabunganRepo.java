package com.example.tugasrplo.repo;

import com.example.tugasrplo.dto.respons.ResponseGetTabungan;
import com.example.tugasrplo.entity.Tabungan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface TabunganRepo extends JpaRepository<Tabungan, Integer> {


    @Modifying
    @Transactional
    @Query(value = "CALL update_tabungn(:saldoTambahan, :idUser)", nativeQuery = true)
    void updateTabungan(int saldoTambahan, int idUser);

    @Query(value = "CALL get_tabungan_by_id_user(:userId)", nativeQuery = true)
    ResponseGetTabungan getTabungan(@Param("userId") Integer userId);
}
