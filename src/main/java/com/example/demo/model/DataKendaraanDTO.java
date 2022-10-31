package com.example.demo.model;

import com.example.demo.constant.BahanBakar;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class DataKendaraanDTO {

    private String nomorRegistrasiKendaraan;

    private String namaPemilik;

    private String alamat;

    private String merkKendaraan;

    private Integer tahunPembuatan;

    private String kapasitasSilinder;

    private String warnaKendaraan;

    private BahanBakar bahanBakar;
}
