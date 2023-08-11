package com.enigma.ggv.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class OrderResponse {
    private String kodeOrder;
    private String namaStudio;
    private String namaFilm;
    private String jamTayang;
    private Integer jumlahTiket;
    private Integer hargaBayar;
    private Integer biayaLayanan;
    private Integer totalBayar;
}
