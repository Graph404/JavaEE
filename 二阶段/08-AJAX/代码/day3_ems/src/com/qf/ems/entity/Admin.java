package com.qf.ems.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Admin {
  private Integer id;
  private String username;
  private String pwd;
  private String email;
  private String truename;
  private String salt;
}
