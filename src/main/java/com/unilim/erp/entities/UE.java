package com.unilim.erp.entities;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ue")
@Setter
@Getter
public class Ue {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;

    @Column(nullable = false, length = 50)
    private String code;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private int semester;

    @Column(columnDefinition = "TEXT")
    private String objectifs;

    public Ue() {
    }

    public Ue(Department department, String code, String title, int semester, String objectifs) {
        this.department = department;
        this.code = code;
        this.title = title;
        this.semester = semester;
        this.objectifs = objectifs;
    }
}