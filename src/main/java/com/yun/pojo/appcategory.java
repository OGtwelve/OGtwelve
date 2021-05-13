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
public class appcategory {

    private int id;
    private String categoryCode;
    private String categoryName;
    private int parentId;
    private int createBy;
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @JsonFormat(pattern =  "yyyy-MM-dd hh:mm:ss",timezone = "GMT+8")
    private Date creationTime;
    private int modifyBy;
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @JsonFormat(pattern =  "yyyy-MM-dd hh:mm:ss",timezone = "GMT+8")
    private Date modifyDate;

}
