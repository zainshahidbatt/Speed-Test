package com.example.speedtest.models;


import static com.example.speedtest.utils.LogUtils.LOGE;

public class DataInfo {
    private long date;
    private double ping;
    private double download;
    private double upload;

    public DataInfo() {
        this.date = 1577833200000L;
        this.ping = 0;
        this.download = 0;
        this.upload = 0;
    }

    public DataInfo(long date, double ping, double download, double upload) {
        this.date = date;
        this.ping = ping;
        this.download = download;
        this.upload = upload;
        LOGE("TAG", "value added");
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public double getPing() {
        return ping;
    }

    public void setPing(double ping) {
        this.ping = ping;
    }

    public double getDownload() {
        return download;
    }

    public void setDownload(double download) {
        this.download = download;
    }

    public double getUpload() {
        return upload;
    }

    public void setUpload(double upload) {
        this.upload = upload;
    }
}
