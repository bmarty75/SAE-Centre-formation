package com.unilim.erp.entities;

import com.unilim.erp.domain.ResourceSheetStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "resource_sheet")
@Getter
@Setter
public class ResourceSheet{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="department_id")
    private Department department;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="ue_id")
    private Ue ue;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="ec_id")
    private Ec ec;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="sae_id")
    private Sae sae;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ResourceSheetStatus status = ResourceSheetStatus.DRAFT;

    @Column(nullable = false)
    private String objectives;

    @Column(nullable=false)
    private String prerequisites;

    @Column(nullable=false)
    private String modalities;

    @Column(name = "hours_cm", nullable = false)
    private int hoursCm;

    @Column(name = "hours_td", nullable = false)
    private int hoursTd;

    @Column(name = "hours_tp", nullable = false)
    private int hoursTp;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "responsible_id")
    private AppUser responsible;

    @Column(name = "archivable_year")
    private Integer archivableYear;

    @Version
    @Column(nullable=false)
    private int version;

    @Column(name = "created_at",nullable=false)
    private Instant createdAt = Instant.now();

    @Column(name = "updated_at",nullable=false)
    private Instant updatedAt = Instant.now();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "resource_sheet_competency", joinColumns = @JoinColumn(name = "resource_sheet_id"),
            inverseJoinColumns = @JoinColumn(name = "competency_id")
    )
    private Set<Competency> competencies = new LinkedHashSet<>();

    @PreUpdate
    protected void onUpdate() {
        updatedAt = Instant.now();
    }

}



