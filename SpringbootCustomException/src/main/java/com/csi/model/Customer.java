package com.csi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer {

    @Id
    @GeneratedValue
    private int custId;
    private String custName;
    private String custAddress;
    private long custContactNumber;
    private double custAccountBalance;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date custDOB;
    private String custEmailId;
    private String custPassword;

}
