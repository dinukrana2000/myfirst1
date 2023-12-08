package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // java class as a table
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "info") // change the table name User to info

public class User {
    @Id // primary key
        // @Column(name = "ID")
    private int id;
    // @Column(name = "NAME")
    private String name;
    // @Column(name = "ADDRESS")
    private String address;

}
