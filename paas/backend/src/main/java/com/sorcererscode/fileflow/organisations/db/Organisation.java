package com.sorcererscode.fileflow.organisations.db;

import com.sorcererscode.fileflow.common.entities.AuditedEntity;
import com.sorcererscode.fileflow.users.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ff_organisations")
public class Organisation extends AuditedEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ff_organisation_seq")
    @SequenceGenerator(name = "ff_organisation_seq")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @Column
    private String address;

    @ManyToOne
    @JoinColumn(name = "maintainer_id", referencedColumnName = "id")
    private User maintainer;
}