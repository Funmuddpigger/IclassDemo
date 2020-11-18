package com.classadm.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Audit {
    private String ClassId;
    private int UserId;
    private String UserName;
    private Timestamp ClassGoTime;
    private Timestamp ClassBackTime;
    private String ClassNote;

}
