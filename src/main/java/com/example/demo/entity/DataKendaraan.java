package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "vehicle_data")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class DataKendaraan {

    @Id
    @Column(name = "nomor_registrasi_kendaraan")
    private String nomorRegistrasiKendaraan;

    @Column(name = "nama_pemilik")
    private String namaPemilik;

    @Column(name = "alamat")
    private String alamat;

    @Column(name = "merk_kendaraan")
    private String merkKendaraan;

    @Column(name = "tahun_pembuatan", length = 4)
    private Integer tahunPembuatan;

    @Column(name = "kapasitas_silinder")
    private String kapasitasSilinder;

    @Column(name = "warna_kendaraan")
    private String warnaKendaraan;

    @Column(name = "bahan_bakar")
    private String bahanBakar;
}
