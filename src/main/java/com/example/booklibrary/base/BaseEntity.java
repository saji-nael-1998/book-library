package com.example.booklibrary.base;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;


@MappedSuperclass
public abstract class BaseEntity<T extends Serializable> implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private T id;
    private boolean isDeleted;
    @Column(updatable = false)
    private LocalDateTime createdDate;
    private LocalDateTime updateDate;
    private LocalDateTime deletedDate;
    public void setDeleted(boolean deleted) {
        if (isDeleted = deleted) {
            setDeletedDate(LocalDateTime.now());
        } else {
            setDeletedDate(null);
        }
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    public void setDeletedDate(LocalDateTime deletedDate) {
        this.deletedDate = deletedDate;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public LocalDateTime getDeletedDate() {
        return deletedDate;
    }
}
