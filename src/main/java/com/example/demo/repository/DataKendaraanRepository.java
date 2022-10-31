package com.example.demo.repository;

import com.example.demo.entity.DataKendaraan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataKendaraanRepository extends JpaRepository<DataKendaraan, Long> {

    DataKendaraan findDataKendaraanByNomorRegistrasiKendaraan(String nomorRegistrasiKendaraaan);
}
