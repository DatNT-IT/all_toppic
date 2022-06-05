package com.example.FIS_project_training.enums;

import java.util.Random;

public enum NumberGenerator {
    ;
    private Random RAND;
    private String UPPER;
    private String DIGITS;

    NumberGenerator() {
    }

    NumberGenerator(Random RAND, String UPPER, String DIGITS) {
        this.RAND = RAND;
        this.UPPER = UPPER;
        this.DIGITS = DIGITS;
    }

    public Random getRAND() {
        return RAND;
    }

    public void setRAND(Random RAND) {
        this.RAND = RAND;
    }

    public String getUPPER() {
        return UPPER;
    }

    public void setUPPER(String UPPER) {
        this.UPPER = UPPER;
    }

    public String getDIGITS() {
        return DIGITS;
    }

    public void setDIGITS(String DIGITS) {
        this.DIGITS = DIGITS;
    }

    @Override
    public String toString() {
        return "NumberGenerator{" +
                "RAND=" + RAND +
                ", UPPER='" + UPPER + '\'' +
                ", DIGITS='" + DIGITS + '\'' +
                '}';
    }
}
