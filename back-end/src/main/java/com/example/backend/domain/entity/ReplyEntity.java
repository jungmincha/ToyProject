package com.example.backend.domain.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import lombok.Data;


@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "reply")
public class ReplyEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="rid")
    private Long rid;

    @Column(nullable = false)
    private String rname;

    @Column(columnDefinition="TEXT" , nullable = false)
    private String rcontent;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime rdate;

    @Column(nullable = false)
    private Long bid;//외래키

    public void setBid(Long bid) {
        this.bid = bid;
    }


}