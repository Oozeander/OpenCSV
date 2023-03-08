package org.example.model;

public enum Gender {
    MALE("Homme"), FEMALE("Femme");

    private final String fr;

    Gender(String fr) {
        this.fr = fr;
    }

    public String getFr() {
        return fr;
    }
}
