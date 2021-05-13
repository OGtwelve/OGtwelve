package com.yun.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class appversion {
    private int id;
    private int appId;
    private String versionNo;
    private String versionInfo;
    private int publishStatus;
    private String downloadLink;
    private double versionSize;
    private int createBy;
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @JsonFormat(pattern =  "yyyy-MM-dd hh:mm:ss",timezone = "GMT+8")
    private Date creationDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @JsonFormat(pattern =  "yyyy-MM-dd hh:mm:ss",timezone = "GMT+8")
    private Date modifyDate;
    private String apkLocPath;
    private String apkFileName;

    private appInfo appInfo;

    private dictionary dictionary;

    public appversion(int appId, String versionNo, String versionInfo, int publishStatus, String downloadLink, double versionSize, int createBy, Date creationDate, Date modifyDate, String apkLocPath, String apkFileName, com.yun.pojo.appInfo appInfo) {
        this.appId = appId;
        this.versionNo = versionNo;
        this.versionInfo = versionInfo;
        this.publishStatus = publishStatus;
        this.downloadLink = downloadLink;
        this.versionSize = versionSize;
        this.createBy = createBy;
        this.creationDate = creationDate;
        this.modifyDate = modifyDate;
        this.apkLocPath = apkLocPath;
        this.apkFileName = apkFileName;
        this.appInfo = appInfo;
    }

    public appversion(int appId, String versionNo, String versionInfo, int publishStatus, String downloadLink, double versionSize, int createBy, Date creationDate, Date modifyDate, String apkLocPath, String apkFileName, com.yun.pojo.appInfo appInfo, com.yun.pojo.dictionary dictionary) {
        this.appId = appId;
        this.versionNo = versionNo;
        this.versionInfo = versionInfo;
        this.publishStatus = publishStatus;
        this.downloadLink = downloadLink;
        this.versionSize = versionSize;
        this.createBy = createBy;
        this.creationDate = creationDate;
        this.modifyDate = modifyDate;
        this.apkLocPath = apkLocPath;
        this.apkFileName = apkFileName;
        this.appInfo = appInfo;
        this.dictionary = dictionary;
    }
}
