package com.sorcererscode.fileflow.files.db;

import com.sorcererscode.fileflow.common.entities.AuditedEntity;
import com.sorcererscode.fileflow.organisations.db.Organisation;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ff_stored_folder")
public class StoredFolder extends AuditedEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stored_folder_seq")
    @SequenceGenerator(name = "stored_folder_seq")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false, unique = true)
    private String folderName;

    @ManyToOne
    @JoinColumn(name = "organisation_id")
    private Organisation organisation;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private StoredFolder parent;
}