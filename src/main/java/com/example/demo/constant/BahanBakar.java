package com.example.demo.constant;

import lombok.Getter;

@Getter
public enum BahanBakar {

    MERAH("Merah"),
    HITAM("Hitam"),
    BIRU("Biru"),
    ABUABU("Abu-abu");

    private String name;

    BahanBakar(String name) {
        this.name = name;
    }

    public static BahanBakar fromString(String bahanBakar) {
        if (bahanBakar == null) {
            return null;
        }

        for (BahanBakar bb : BahanBakar.values()) {
            if (bb.getName().equalsIgnoreCase(bahanBakar)) {
                return bb;
            }
        }

        return null;
    }
}
