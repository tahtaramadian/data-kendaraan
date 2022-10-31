package com.example.demo.controller;

import com.example.demo.model.DataKendaraanDTO;
import com.example.demo.service.CreateOrUpdateDataKendaraan;
import com.example.demo.service.DeleteDataKendaraan;
import com.example.demo.service.ListDataKendaraan;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dataKendaraan")
public class DataKendaraanController {

    private final CreateOrUpdateDataKendaraan saveDataKendaraan;

    private final ListDataKendaraan listDataKendaraan;

    private final DeleteDataKendaraan deleteDataKendaraan;

    public DataKendaraanController(CreateOrUpdateDataKendaraan createOrUpdateDataKendaraan, ListDataKendaraan listDataKendaraan, DeleteDataKendaraan deleteDataKendaraan) {
        this.saveDataKendaraan = createOrUpdateDataKendaraan;
        this.listDataKendaraan = listDataKendaraan;
        this.deleteDataKendaraan = deleteDataKendaraan;
    }

    @GetMapping(path = "/get")
    public DataKendaraanDTO getDataKendaraanByNomorRegistrasiKendaraan(String nomorRegistrasiKendaraan) {
        return listDataKendaraan.getDataKendaraanByNomorRegistrasiKendaraan(nomorRegistrasiKendaraan);
    }

    @PostMapping(path = "/saveOrUpdate")
    public DataKendaraanDTO saveOrUpdateDataKendaraan(@RequestBody DataKendaraanDTO dto) {
        return saveDataKendaraan.saveOrUpdate(dto);
    }

    @DeleteMapping(path = "/delete/{nomorRegistrasiKendaraan}")
    public String deleteDataKendaraan(@PathVariable(value = "nomorRegistrasiKendaraan") String nomorRegistrasiKendaraan) {
        String result;
        DataKendaraanDTO dto = listDataKendaraan.getDataKendaraanByNomorRegistrasiKendaraan(nomorRegistrasiKendaraan);
        if (dto == null) {
            result = "nomorRegistrasiKendaraan " + nomorRegistrasiKendaraan + " tidak ditemukan.";
            return result;
        }

        result = "id " + nomorRegistrasiKendaraan + " berhasil dihapus.";
        deleteDataKendaraan.deleteDataKendaraan(dto);
        return result;
    }

}
