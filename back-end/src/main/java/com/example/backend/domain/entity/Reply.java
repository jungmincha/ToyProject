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

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

 @Entity
 @Table(name = "reply")
 @NoArgsConstructor(access = AccessLevel.PROTECTED)
 @EntityListeners(AuditingEntityListener.class)
 @Getter 
public class Reply {

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

    @Builder
    public Reply(Long rid, String rname, String rcontent , Long bid) {
        this.rid = rid;
        this.rname = rname;
        this.rcontent = rcontent;
        this.bid = bid;
    
}

}