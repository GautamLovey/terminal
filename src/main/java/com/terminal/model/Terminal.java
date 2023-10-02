package com.terminal.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Terminal {
    @Id //@GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "terminalKey")
    String terminalId;
    @Size(min=3, max=20)
    String terminalName;
    @Size(min=3, max=20)
    String country;
    @Size(min=4, max=30)
    String itemType;
    String terminalDescription;
    @Max(5)
    Integer capacity;
    String status;
    @Size(min=5,max=25)
    String harborLocation;
    @Max(5)
    Integer availableCapacity;
}
