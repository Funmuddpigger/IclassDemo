package com.classadm.demo.mapper;


import com.classadm.demo.entity.Audit;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;


@Mapper
@Repository
public interface AuditMapper {

    List<Audit> gainAudit(int audit_number);

    void addRecord(String class_id, int user_id, String class_master, Timestamp class_goTime, Timestamp class_backTime, String class_note, String class_statue);

    void deleteAudit(String class_id, Timestamp class_goTime, Timestamp class_backTime);

    void updateAudit(String class_id, Timestamp class_goTime, Timestamp class_backTime, int audit_number);

}
