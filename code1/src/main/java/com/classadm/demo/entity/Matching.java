package com.classadm.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Matching {
    private int MatchingId;
    private String ClassSize;
    private int ClassMinCapacity;
    private int ClassMaxCapacity;

}
