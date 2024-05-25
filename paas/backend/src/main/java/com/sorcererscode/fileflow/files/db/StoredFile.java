package com.sorcererscode.fileflow.files.db;

import com.sorcererscode.fileflow.common.entities.AuditedEntity;
import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter
@Setter
@Entity
@Table(name = "ff_stored_files")
@NoArgsConstructor
@AllArgsConstructor
public class StoredFile extends AuditedEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stored_file_seq")
    @SequenceGenerator(name = "stored_file_seq")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false, unique = true)
    private String slugId;

    @Column(nullable = false, unique = true)
    private String savedName;

    @Column(nullable = false)
    private String originalName;

    @Column(nullable = false)
    private String mimeType;

    @Column(nullable = false)
    private long fileSize;

    private String downloadUrl;

    @ManyToOne
    @JoinColumn(name = "folder_id")
    private StoredFolder folder;
}