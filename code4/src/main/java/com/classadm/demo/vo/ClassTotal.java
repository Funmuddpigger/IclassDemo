package com.classadm.demo.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Timestamp;

@Data
@EqualsAndHashCode(callSuper = false)
public class ClassTotal {
    private String ClassId;
    private int ClassUserId;
    private String ClassUserName;
    private Timestamp Classstarttime;
    private Timestamp Classendtime;
    private String ClassNote;
    private String ClassNoteType;

    public String getClassId() {
        return ClassId;
    }

    public String getClassNote() {
        return ClassNote;
    }

    public int getClassUserId() {
        return ClassUserId;
    }

    public String getClassNoteType() {
        return ClassNoteType;
    }

    public Timestamp getClassendtime() {
        return Classendtime;
    }

    public String getClassUserName() {
        return ClassUserName;
    }

    public Timestamp getClassstarttime() {
        return Classstarttime;
    }

}
