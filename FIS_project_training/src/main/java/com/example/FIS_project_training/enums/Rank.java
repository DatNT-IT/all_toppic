package com.example.FIS_project_training.enums;

public enum Rank {
    TRAINEE, JUNIOR, SENIOR, INSPECTOR, CHIEF_INSPECTOR;
    private int code;

    Rank() {
    }

    Rank(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Rank{" +
                "code=" + code +
                '}';
    }
}
