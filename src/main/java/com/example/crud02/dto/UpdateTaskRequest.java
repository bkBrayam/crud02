package com.example.crud02.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateTaskRequest {

    private Integer id;
    private String task;
    private String description;
    private String status;
    private Date initialDate;
    private Date completionDay;
}
