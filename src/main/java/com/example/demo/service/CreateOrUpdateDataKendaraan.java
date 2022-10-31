package com.example.demo.service;

import com.example.demo.constant.BahanBakar;
import com.example.demo.entity.DataKendaraan;
import com.example.demo.model.DataKendaraanDTO;
import com.example.demo.repository.DataKendaraanRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class CreateOrUpdateDataKendaraan {

    private final DataKendaraanRepository dataKendaraanRepository;


    public CreateOrUpdateDataKendaraan(DataKendaraanRepository dataKendaraanRepository) {
        this.dataKendaraanRepository = dataKendaraanRepository;
    }

    public DataKendaraanDTO saveOrUpdate(DataKendaraanDTO dto) {
        DataKendaraan dataKendaraan = constructEntity(dto);
        return constructDto(dataKendaraanRepository.save(dataKendaraan));
    }

    private DataKendaraan constructEntity(DataKendaraanDTO dto) {
        DataKendaraan dataKendaraan = new DataKendaraan();
        dataKendaraan.setNomorRegistrasiKendaraan(dto.getNomorRegistrasiKendaraan());
        dataKendaraan.setNamaPemilik(dto.getNamaPemilik());
        dataKendaraan.setAlamat(dto.getAlamat());
        dataKendaraan.setMerkKendaraan(dto.getMerkKendaraan());
        dataKendaraan.setTahunPembuatan(dto.getTahunPembuatan());
        dataKendaraan.setKapasitasSilinder(dto.getKapasitasSilinder());
        dataKendaraan.setWarnaKendaraan(dto.getWarnaKendaraan());
        dataKendaraan.setBahanBakar(dto.getBahanBakar().getName());
        return dataKendaraan;
    }

    private DataKendaraanDTO constructDto(DataKendaraan dataKendaraan) {
        return DataKendaraanDTO.builder()
                .nomorRegistrasiKendaraan(dataKendaraan.getNomorRegistrasiKendaraan())
                .namaPemilik(dataKendaraan.getNamaPemilik())
                .alamat(dataKendaraan.getAlamat())
                .merkKendaraan(dataKendaraan.getMerkKendaraan())
                .tahunPembuatan(dataKendaraan.getTahunPembuatan())
                .kapasitasSilinder(dataKendaraan.getKapasitasSilinder())
                .warnaKendaraan(dataKendaraan.getWarnaKendaraan())
                .bahanBakar(BahanBakar.fromString(dataKendaraan.getBahanBakar()))
                .build();
    }
}
