package fr.adservio.crm.absences.api.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * POJO which represente a group absence request Model.
 * It can contains multiple absence.
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
public class Absence {

    @Id
    @Column(unique = true, nullable = false)
    private long id;

    @Column
    private String demandeObject;

    @Column
    private String comments;

    /**
     * The applicant identifier
     */
    @Column
    private Long applicantId;

    /**
     * The approver identifier
     */
    @Column
    private Long approverId;

    @Column
    private Date approvedAt;

    @Column
    private Date createdAt;

    @OneToMany(mappedBy = "absence")
    @JsonManagedReference
    private List<AbsenceLine> absenceLines;

    @OneToMany(mappedBy = "absence")
    private List<UploadedFile> uploadedFilesList;



}
