package com.example.BBP_Backend.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@Entity
@Data
@Table(name = "my_table")
public class MyTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tableId;

    @ManyToOne()
    @JoinColumn(name = "table_type_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private TableType tableTypeId;
    private int clubId;
    private int is_available;

    @OneToMany(mappedBy = "table")
    private List<BookingDetail> bookingDetails;
}