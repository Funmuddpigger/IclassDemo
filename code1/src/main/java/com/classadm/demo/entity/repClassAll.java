package com.classadm.demo.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 *
 * </p>
 *
 * @author mine
 * @since 2020-08-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class repClassAll implements Serializable {

    private static final long serialVersionUID = 1L;

    private String classId;

    private String classType;

    private String classState;

    private Integer classCapacity;

    private String classProperty;

    private String classNote;

}
