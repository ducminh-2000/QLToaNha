package com.example.qltoanha.models.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="tbl_phong_su_dung")
@Getter
@Setter
public class PhongSuDung {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name="giam_gia")
    private int giamGia;

    @Column(name = "ghi_chu")
    private String ghiChu;

    @Column(name="ngay_bat_dau")
    private String ngayBatDau;

    @ManyToOne(targetEntity = Phong.class)
    @JoinColumn(name = "ma_phong")
    private Phong phong;
    
    @ManyToOne(targetEntity = HopDong.class)
    @JoinColumn(name = "ma_hop_dong")
    private HopDong hopDong;

    @OneToMany(targetEntity = DichVuSuDung.class,mappedBy = "phongSuDung",cascade = CascadeType.ALL)
    private List<DichVuSuDung> dsDichVuSuDung;

}