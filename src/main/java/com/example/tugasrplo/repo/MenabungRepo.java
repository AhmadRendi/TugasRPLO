package com.example.tugasrplo.repo;

import com.example.tugasrplo.entity.Menabung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MenabungRepo extends JpaRepository<Menabung, Integer> {

    @Modifying
    @Query(value = "CALL menabung(:idUser, :beratSampah, :jenisSampah)", nativeQuery = true)
    void saved(@Param("idUser") int idUser  , @Param("beratSampah") int beratSampah, @Param("jenisSampah") String jenisSampah);
}
