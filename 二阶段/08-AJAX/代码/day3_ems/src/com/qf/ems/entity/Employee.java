package com.qf.ems.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {
  private Integer id;
  private String name;
  private Integer sex;
  private Integer age;
  private Integer salary;
  private String photo;
  private Integer deptId;
  private String hobby;
  private Date createtime;
  private Date updatetime;
  private String photoname;
  private Department department;
}
