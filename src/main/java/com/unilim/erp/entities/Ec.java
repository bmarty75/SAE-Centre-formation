package com.unilim.erp.entities;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ec")
@Setter
@Getter
public class Ec {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ue_id")
    private Ue ue;

    @Column(nullable = false)
    private String title;

    @Column(name = "cm_hours", precision = 5, scale = 2)
    private Double cmHours = 0.0;

    @Column(name = "td_hours", precision = 5, scale = 2)
    private Double tdHours = 0.0;

    @Column(name = "tp_hours", precision = 5, scale = 2)
    private Double tpHours = 0.0;

    @Column(name = "cm_hours_alt", precision = 5, scale = 2)
    private Double cmHoursAlt;

    @Column(name = "td_hours_alt", precision = 5, scale = 2)
    private Double tdHoursAlt;

    @Column(name = "tp_hours_alt", precision = 5, scale = 2)
    private Double tpHoursAlt;

    public Ec() {
    }

    public Ec(Ue ue, String title, Double cmHours, Double tdHours, Double tpHours) {
        this.ue = ue;
        this.title = title;
        this.cmHours = cmHours;
        this.tdHours = tdHours;
        this.tpHours = tpHours;
    }
}
