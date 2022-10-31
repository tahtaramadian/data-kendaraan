package com.example.demo.service;

import com.example.demo.entity.DataKendaraan;
import com.example.demo.model.DataKendaraanDTO;
import com.example.demo.repository.DataKendaraanRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class DeleteDataKendaraan {

    private final DataKendaraanRepository dataKendaraanRepository;


    public DeleteDataKendaraan(DataKendaraanRepository dataKendaraanRepository) {
        this.dataKendaraanRepository = dataKendaraanRepository;
    }

    public void deleteDataKendaraan(DataKendaraanDTO dto) {
        DataKendaraan dataKendaraan = constructEntity(dto);
        dataKendaraanRepository.delete(dataKendaraan);
    }

    private DataKendaraan constructEntity(DataKendaraanDTO dto) {
        DataKendaraan dataKendaraan = new DataKendaraan();
        dataKendaraan.setNamaPemilik(dto.getNamaPemilik());
        dataKendaraan.setAlamat(dto.getAlamat());
        dataKendaraan.setNomorRegistrasiKendaraan(dto.getNomorRegistrasiKendaraan());
        dataKendaraan.setMerkKendaraan(dto.getMerkKendaraan());
        dataKendaraan.setTahunPembuatan(dto.getTahunPembuatan());
        dataKendaraan.setKapasitasSilinder(dto.getKapasitasSilinder());
        dataKendaraan.setWarnaKendaraan(dto.getWarnaKendaraan());
        dataKendaraan.setBahanBakar(dto.getBahanBakar().getName());
        return dataKendaraan;
    }
}
