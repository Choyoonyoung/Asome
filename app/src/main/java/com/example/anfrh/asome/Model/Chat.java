package com.example.anfrh.asome.Model;

import android.graphics.Bitmap;

public class Chat {
    private String user_no, room_no; //메시지에서 내 고유번호, 방 고유번호
    private String message, action; //메시지 내용, 메시지 종류(text, img, map)
    private String timestamp, read_check;//메시지 보낸시간, 읽음 여부
    private boolean is_me;//내가 보낸 메시지인가
    private Bitmap my_image_bitmap;//내가 보낸 이미지 메시지일 경우 그 이미지의 비트맵
    private Double latitude;//지도 메시지의 위도
    private Double longitude;//지도 메시지의 경도;

    //기본 텍스트 담을 구조체, 남이 보낸 이미지 담을 구조체
    public Chat(String user_no, String room_no, String timestamp, String message, boolean is_me, String action, String read_check) {
        this.user_no = user_no;
        this.timestamp = timestamp;
        this.room_no = room_no;
        this.message = message;
        this.is_me = is_me;
        this.action = action;
        this.read_check = read_check;
    }

    //내가 보낸 이미지 담을 구조체
    public Chat(String user_no, String room_no, String timestamp, String message, boolean is_me, String action, String read_check, Bitmap my_image_bitmap) {
        this.user_no = user_no;
        this.room_no = room_no;
        this.timestamp = timestamp;
        this.message = message;
        this.is_me = is_me;
        this.action = action;
        this.read_check = read_check;
        this.my_image_bitmap = my_image_bitmap;
    }

    //지도 메시지 담을 구조체
    public Chat(String user_id, String timestamp, String message, boolean is_me, String type, Double latitude, Double longitude, String read_check) {
        this.user_no = user_id;
        this.timestamp = timestamp;
        this.is_me = is_me;
        this.message = message;
        this.action = type;
        this.latitude = latitude;
        this.longitude = longitude;
        this.read_check = read_check;
    }

    //소켓 열때 보내는 메시지 구조체
    public Chat(String user_no, String room_no) {
        this.user_no = user_no;
        this.room_no = room_no;

    }

    public String getUser_no() {
        return user_no;
    }

    public void setUser_no(String user_no) {
        this.user_no = user_no;
    }

    public String getRoom_no() {
        return room_no;
    }

    public void setRoom_no(String room_no) {
        this.room_no = room_no;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getRead_check() {
        return read_check;
    }

    public void setRead_check(String read_check) {
        this.read_check = read_check;
    }

    public boolean getIs_me() {
        return is_me;
    }

    public void setIs_me(boolean is_me) {
        this.is_me = is_me;
    }

    public Bitmap getMy_image_bitmap() {
        return my_image_bitmap;
    }

    public void setMy_image_bitmap(Bitmap my_image_bitmap) {
        this.my_image_bitmap = my_image_bitmap;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}
