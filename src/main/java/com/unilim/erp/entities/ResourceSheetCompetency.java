package com.unilim.erp.entities;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "resource_sheet_competency")
public class ResourceSheetCompetency {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resource_sheet_id")
    private ResourceSheet resourceSheet;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "competency_id")
    private Competency competency;

    public ResourceSheetCompetency() {
    }

    public ResourceSheetCompetency(ResourceSheet resourceSheet, Competency competency) {
        this.resourceSheet = resourceSheet;
        this.competency = competency;
    }
}
