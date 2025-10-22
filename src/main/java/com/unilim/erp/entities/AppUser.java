package com.unilim.erp.entities;


import com.unilim.erp.domain.UserRole;
import com.unilim.erp.domain.UserStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "app_user")
@Getter
@Setter
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String passwordHash;

    @Column(nullable=false)
    private String displayName;

    @Column
    private String phone;

    @Enumerated(EnumType.STRING)
    @Column(nullable=false)
    private UserRole role;

    @Enumerated(EnumType.STRING)
    @Column(nullable=false)
    private UserStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="department_id")
    private Department department;

    @Column(nullable = false,updatable = false)
    private Instant createdAt = Instant.now();
    public AppUser() {
    }

    public AppUser(String email, String passwordHash, String displayName, String phone, UserRole role, UserStatus status, Department department) {
        this.email = email;
        this.passwordHash = passwordHash;
        this.displayName = displayName;
        this.phone = phone;
        this.role = role;
        this.status = status;
        this.department = department;
    }







}
