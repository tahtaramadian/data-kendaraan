package com.example.demo.service;

import com.example.demo.constant.BahanBakar;
import com.example.demo.entity.DataKendaraan;
import com.example.demo.model.DataKendaraanDTO;
import com.example.demo.repository.DataKendaraanRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ListDataKendaraan {

    private final DataKendaraanRepository dataKendaraanRepository;

    public ListDataKendaraan(DataKendaraanRepository dataKendaraanRepository) {
        this.dataKendaraanRepository = dataKendaraanRepository;
    }

    public DataKendaraanDTO getDataKendaraanByNomorRegistrasiKendaraan(String nomorRegistrasiKendaraan) {
        DataKendaraan dataKendaraan = dataKendaraanRepository.findDataKendaraanByNomorRegistrasiKendaraan(nomorRegistrasiKendaraan);
        return constructDto(dataKendaraan);
    }

    public List<DataKendaraanDTO> findAllDataKendaraan() {
        List<DataKendaraan> dataKendaraans = dataKendaraanRepository.findAll();
        return dataKendaraans.stream()
                .map(this::constructDto)
                .collect(Collectors.toList());
    }

    private DataKendaraanDTO constructDto(DataKendaraan dataKendaraan) {
        if (dataKendaraan == null) {
            return null;
        }

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
