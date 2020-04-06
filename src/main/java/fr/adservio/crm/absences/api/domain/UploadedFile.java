package fr.adservio.crm.absences.api.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

/**
 * Entity to represent an uploaded file in absence request
 *
 * @author adservio
 * @version 0.1
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class UploadedFile {

    @Id
    @Column(unique = true, nullable = false)
    private long id;

    @Column(unique = true, nullable = false)
    private String libelle;

    @Column(nullable = false)
    private String path;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    private Absence absence;
}
