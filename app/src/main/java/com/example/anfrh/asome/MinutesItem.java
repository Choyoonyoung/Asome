package com.example.anfrh.asome;

public class MinutesItem {
    private  String minutes_title;
    private  String minutes_update_date;
    private  String minutes_st;

    public MinutesItem(String minutes_title, String minutes_update_date, String minutes_st) {
        this.minutes_title = minutes_title;
        this.minutes_update_date = minutes_update_date;
        this.minutes_st = minutes_st;
    }

    public String getMinutes_title() {
        return minutes_title;
    }

    public void setMinutes_title(String minutes_title) {
        this.minutes_title = minutes_title;
    }

    public String getMinutes_update_date() {
        return minutes_update_date;
    }

    public void setMinutes_update_date(String minutes_update_date) {
        this.minutes_update_date = minutes_update_date;
    }

    public String getMinutes_st() {
        return minutes_st;
    }

    public void setMinutes_st(String minutes_st) {
        this.minutes_st = minutes_st;
    }


}
