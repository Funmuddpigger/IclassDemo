package com.classadm.demo.service;

import com.classadm.demo.entity.Audit;
import java.util.Date;
import java.util.List;

public interface AuditService {
    List<Audit> gainAudit(int audit_number);

   void proceedAudit(String class_id, int user_id, String user_name, Date class_stackTime, Date class_endTime, String class_note, boolean pass, String class_property, int audit_number);
}
