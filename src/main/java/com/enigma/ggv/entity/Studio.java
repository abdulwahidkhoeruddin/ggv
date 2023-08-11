package com.enigma.ggv.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Entity
@Table(name = "m_studio")
public class Studio {
    @Id
    @GenericGenerator(strategy = "uuid2", name = "system-uuid")
    @GeneratedValue(generator = "system-uuid")
    private String id;

    private String nama;

    @Column(name = "tanggal_tayang")
    private Date tanggalTayang;

//    @Column(name = "jam_tayang")
//    private Time jamTayang;

//    @ManyToOne
//    @JoinColumn(name = "harga_id")
//    private Harga harga;


}
