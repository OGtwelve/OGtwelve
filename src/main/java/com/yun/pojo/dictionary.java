package com.yun.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class dictionary {
    private int id;
    private String typeName;
    private int valueId;
    private String valueName;
    private int createdBy;
    private Date creationDate;

}
