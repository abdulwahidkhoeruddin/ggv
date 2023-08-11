package com.enigma.ggv.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Time;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Entity
@Table(name = "m_film")
public class Film {
    @Id
    @GenericGenerator(strategy = "uuid2", name = "system-uuid")
    @GeneratedValue(generator = "system-uuid")
    private String id;

    private String nama;
    private String genre;
    private Time durasi;

    @ManyToOne
    @JoinColumn(name = "studio_id")
    private Studio studio;
}
