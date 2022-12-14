package com.example.springdataauditing.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
@Data
@Entity
@Table(name = "employee_table")
@EntityListeners(AuditingEntityListener.class)
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "MM/dd/yyyy")
    private Date doj;
    private String dept;
    private double salary;
    @CreatedDate
    private Date createDate;
    @LastModifiedDate
    private Date lastModifieddate;
    @CreatedBy
    private String createdBy;
    @LastModifiedBy
    private String modifiedBy;


}
