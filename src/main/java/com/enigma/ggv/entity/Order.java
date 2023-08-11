package com.enigma.ggv.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Entity
@Table(name = "t_order")
public class Order {
    @Id
    @GenericGenerator(strategy = "uuid2", name = "system-uuid")
    @GeneratedValue(generator = "system-uuid")
    private String id;

//    @Column(name = "nomor_order")
//    private String nomorOrder;

    @ManyToOne
    @JoinColumn(name = "film_id")
    private Film film;

    @Column(name = "jumlah_tiket")
    private Integer jumlahTiket;

    @Column(name = "harga_bayar")
    private Integer hargaBayar;

    @Column(name = "biaya_layanan")
    private Integer biayaLayanan;

    //Total bayar ada di respon order
}
