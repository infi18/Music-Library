/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.snaik10.domain;

import java.time.LocalDateTime;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

/**
 *
 * @author siddhi
 */
public class AbstractEntityAuditListener {

    @PrePersist
    private void prePresist(AbstractEntity at) {
        at.setCreateTimeStamp(LocalDateTime.now());
    }

    @PreUpdate
    private void preUpdate(AbstractEntity at) {
        at.setUpdateTimeStamp(LocalDateTime.now());
    }
}
