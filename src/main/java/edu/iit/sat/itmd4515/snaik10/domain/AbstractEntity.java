/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.snaik10.domain;

import java.time.LocalDateTime;
import java.util.Objects;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Version;

/**
 *
 * @author siddhi
 */
@MappedSuperclass
@EntityListeners(AbstractEntityAuditListener.class)
abstract class AbstractEntity {

    @Id    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Version
    private Integer Version;

    private LocalDateTime createTimeStamp;
    private LocalDateTime updateTimeStamp;

    /**
     * Get the value of Version
     *
     * @return the value of Version
     */
    public Integer getVersion() {
        return Version;
    }

    /**
     * Set the value of Version
     *
     * @param Version new value of Version
     */
    public void setVersion(Integer Version) {
        this.Version = Version;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreateTimeStamp() {
        return createTimeStamp;
    }

    public void setCreateTimeStamp(LocalDateTime createTimeStamp) {
        this.createTimeStamp = createTimeStamp;
    }

    public LocalDateTime getUpdateTimeStamp() {
        return updateTimeStamp;
    }

    public void setUpdateTimeStamp(LocalDateTime updateTimeStamp) {
        this.updateTimeStamp = updateTimeStamp;
    }

    @Override
    public int hashCode() {

        return 18;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AbstractEntity other = (AbstractEntity) obj;

        if ((this.id == null) || (other.id == null)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    //To String Method for printing values
    @Override
    public String toString() {
        return "AbstractEntity{" + "id=" + id + ", createTimeStamp=" + createTimeStamp + ", updateTimeStamp=" + updateTimeStamp + '}';
    }

}
