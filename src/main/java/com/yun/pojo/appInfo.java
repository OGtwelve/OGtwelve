package com.yun.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class appInfo {
    private int id;
    private String softwareName;
    private String APKName;
    private double softWareSize;
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @JsonFormat(pattern =  "yyyy-MM-dd hh:mm:ss",timezone = "GMT+8")
    private Date updateDate;
    private int devId;
    private String appInfo;
    private int status;
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @JsonFormat(pattern =  "yyyy-MM-dd hh:mm:ss",timezone = "GMT+8")
    private Date onSaleDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @JsonFormat(pattern =  "yyyy-MM-dd hh:mm:ss",timezone = "GMT+8")
    private Date offSaleDate;
    private int categoryLevel3;
    private int downloads;
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @JsonFormat(pattern =  "yyyy-MM-dd hh:mm:ss",timezone = "GMT+8")
    private Date creationDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @JsonFormat(pattern =  "yyyy-MM-dd hh:mm:ss",timezone = "GMT+8")
    private Date modifyDate;
    private int categoryLevel1;
    private int categoryLevel2;
    private String logoLocPath;
    private int versionId;
    private int auditId;
    private List<appversion> appversions;
    private DevUser devUser;
    private dictionary dictionary;

    public appInfo(String softwareName, String APKName, double softWareSize, Date updateDate, int devId, String appInfo, int status, Date onSaleDate, Date offSaleDate, int categoryLevel3, int downloads, Date creationDate, Date modifyDate, int categoryLevel1, int categoryLevel2, String logoLocPath, int versionId, int auditId, DevUser devUser) {
        this.softwareName = softwareName;
        this.APKName = APKName;
        this.softWareSize = softWareSize;
        this.updateDate = updateDate;
        this.devId = devId;
        this.appInfo = appInfo;
        this.status = status;
        this.onSaleDate = onSaleDate;
        this.offSaleDate = offSaleDate;
        this.categoryLevel3 = categoryLevel3;
        this.downloads = downloads;
        this.creationDate = creationDate;
        this.modifyDate = modifyDate;
        this.categoryLevel1 = categoryLevel1;
        this.categoryLevel2 = categoryLevel2;
        this.logoLocPath = logoLocPath;
        this.versionId = versionId;
        this.auditId = auditId;
        this.devUser = devUser;
    }

    public appInfo(String softwareName, String APKName, double softWareSize, Date updateDate, int devId, String appInfo, int status, Date onSaleDate, Date offSaleDate, int categoryLevel3, int downloads, Date creationDate, Date modifyDate, int categoryLevel1, int categoryLevel2, String logoLocPath, int versionId, int auditId) {
        this.softwareName = softwareName;
        this.APKName = APKName;
        this.softWareSize = softWareSize;
        this.updateDate = updateDate;
        this.devId = devId;
        this.appInfo = appInfo;
        this.status = status;
        this.onSaleDate = onSaleDate;
        this.offSaleDate = offSaleDate;
        this.categoryLevel3 = categoryLevel3;
        this.downloads = downloads;
        this.creationDate = creationDate;
        this.modifyDate = modifyDate;
        this.categoryLevel1 = categoryLevel1;
        this.categoryLevel2 = categoryLevel2;
        this.logoLocPath = logoLocPath;
        this.versionId = versionId;
        this.auditId = auditId;
    }

    public appInfo(String softwareName, String APKName, double softWareSize, Date updateDate, int devId, String appInfo, int status, Date onSaleDate, Date offSaleDate, int categoryLevel3, int downloads, Date creationDate, Date modifyDate, int categoryLevel1, int categoryLevel2, String logoLocPath, int versionId, int auditId, List<appversion> appversions, DevUser devUser, com.yun.pojo.dictionary dictionary) {
        this.softwareName = softwareName;
        this.APKName = APKName;
        this.softWareSize = softWareSize;
        this.updateDate = updateDate;
        this.devId = devId;
        this.appInfo = appInfo;
        this.status = status;
        this.onSaleDate = onSaleDate;
        this.offSaleDate = offSaleDate;
        this.categoryLevel3 = categoryLevel3;
        this.downloads = downloads;
        this.creationDate = creationDate;
        this.modifyDate = modifyDate;
        this.categoryLevel1 = categoryLevel1;
        this.categoryLevel2 = categoryLevel2;
        this.logoLocPath = logoLocPath;
        this.versionId = versionId;
        this.auditId = auditId;
        this.appversions = appversions;
        this.devUser = devUser;
        this.dictionary = dictionary;
    }
}
