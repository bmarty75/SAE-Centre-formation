package com.unilim.erp.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "tac_entry")
@Getter
@Setter
public class Tac {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String observation;

    @Column(columnDefinition = "TEXT")
    private String origine;

    @Column(columnDefinition = "TEXT")
    private String thematique;

    @Column(columnDefinition = "TEXT")
    private String correction;

    @Column(name = "analyse_causes", columnDefinition = "TEXT")
    private String analyseCauses;

    @Column(columnDefinition = "TEXT")
    private String action;

    private LocalDate echeance;

    @Column(columnDefinition = "TEXT")
    private String statut;

    @Column(columnDefinition = "TEXT")
    private String commentaire;

    public Tac() {
    }

    public Tac(
            Department department,
            LocalDate date,
            String observation,
            String origine,
            String thematique,
            String correction,
            String analyseCauses,
            String action,
            LocalDate echeance,
            String statut,
            String commentaire
    ) {
        this.department = department;
        this.date = date;
        this.observation = observation;
        this.origine = origine;
        this.thematique = thematique;
        this.correction = correction;
        this.analyseCauses = analyseCauses;
        this.action = action;
        this.echeance = echeance;
        this.statut = statut;
        this.commentaire = commentaire;
    }
}
