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

    public String getClassNote() {
        return ClassNote;
    }

    public String getClassId() {
        return ClassId;
    }

    public Timestamp getClassGoTime() {
        return ClassGoTime;
    }

    public String getUserName() {
        return UserName;
    }

    public Timestamp getClassBackTime() {
        return ClassBackTime;
    }

    public int getUserId() {
        return UserId;
    }
}
