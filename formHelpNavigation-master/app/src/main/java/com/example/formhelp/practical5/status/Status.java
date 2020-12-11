package com.example.formhelp.practical5.status;

public class Status {
    private String status;
    private int iconWeather;
    private String degree_1;
    private String degree_2;
    private String date;

    public Status(String status, int iconWeather, String degree_1, String degree_2, String date) {
        this.status = status;
        this.iconWeather = iconWeather;
        this.degree_1 = degree_1;
        this.degree_2 = degree_2;
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getIconWeather() {
        return iconWeather;
    }

    public void setIconWeather(int iconWeather) {
        this.iconWeather = iconWeather;
    }

    public String getDegree_1() {
        return degree_1;
    }

    public void setDegree_1(String degree_1) {
        this.degree_1 = degree_1;
    }

    public String getDegree_2() {
        return degree_2;
    }

    public void setDegree_2(String degree_2) {
        this.degree_2 = degree_2;
    }
}
