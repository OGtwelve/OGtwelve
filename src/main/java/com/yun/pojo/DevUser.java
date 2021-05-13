package com.yun.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class DevUser {
    private int id;
    private String devCode;
    private String devPassword;
    private String devName;
    private String devEmail;
    private String devInfo;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date creationDate;
}
