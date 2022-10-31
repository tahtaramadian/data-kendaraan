package com.example.demo.controller;

import com.example.demo.model.DataKendaraanDTO;
import com.example.demo.service.CreateOrUpdateDataKendaraan;
import com.example.demo.service.DeleteDataKendaraan;
import com.example.demo.service.ListDataKendaraan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TestController {

    private final CreateOrUpdateDataKendaraan createOrUpdateDataKendaraan;

    private final ListDataKendaraan listDataKendaraan;

    private final DeleteDataKendaraan deleteDataKendaraan;

    public TestController(CreateOrUpdateDataKendaraan createOrUpdateDataKendaraan, ListDataKendaraan listDataKendaraan, DeleteDataKendaraan deleteDataKendaraan) {
        this.createOrUpdateDataKendaraan = createOrUpdateDataKendaraan;
        this.listDataKendaraan = listDataKendaraan;
        this.deleteDataKendaraan = deleteDataKendaraan;
    }


    @GetMapping("/signup")
    public String showSignUpForm(DataKendaraanDTO dto) {
        return "add-data-kendaraan";
    }

    @PostMapping("/addKendaraan")
    public String addDataKendaraan(DataKendaraanDTO dataKendaraanDTO, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-data-kendaraan";
        }

        createOrUpdateDataKendaraan.saveOrUpdate(dataKendaraanDTO);
        return "redirect:/index";
    }

    @GetMapping("/index")
    public String showUserList(Model model) {
        model.addAttribute("dataKendaraans", listDataKendaraan.findAllDataKendaraan());
        return "index";
    }

    @GetMapping("/edit/{nomorRegistrasiKendaraan}")
    public String showUpdateForm(@PathVariable("nomorRegistrasiKendaraan") String nomorRegistrasiKendaraan, Model model) {
        DataKendaraanDTO dataKendaraanDTO = listDataKendaraan.getDataKendaraanByNomorRegistrasiKendaraan(nomorRegistrasiKendaraan);
        if (dataKendaraanDTO == null) {
            return "index";
        }
        model.addAttribute("dataKendaraanDTO", dataKendaraanDTO);
        return "update-data-kendaraan";
    }

    @PostMapping("/update/{nomorRegistrasiKendaraan}")
    public String updateUser(@PathVariable("nomorRegistrasiKendaraan") String nomorRegistrasiKendaraan, DataKendaraanDTO dataKendaraanDTO,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            dataKendaraanDTO.setNomorRegistrasiKendaraan(nomorRegistrasiKendaraan);
            return "update-user";
        }

        createOrUpdateDataKendaraan.saveOrUpdate(dataKendaraanDTO);
        return "redirect:/index";
    }

    @GetMapping("/delete/{nomorRegistrasiKendaraan}")
    public String deleteUser(@PathVariable("nomorRegistrasiKendaraan") String nomorRegistrasiKendaraan, Model model) {
        DataKendaraanDTO dataKendaraanDTO = listDataKendaraan.getDataKendaraanByNomorRegistrasiKendaraan(nomorRegistrasiKendaraan);
        if (dataKendaraanDTO == null) {
            return "redirect:/index";
        }
        deleteDataKendaraan.deleteDataKendaraan(dataKendaraanDTO);
        return "redirect:/index";
    }
}
