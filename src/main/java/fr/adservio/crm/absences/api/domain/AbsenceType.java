package fr.adservio.crm.absences.api.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * It represent an absence type in CRM
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
public class AbsenceType {

    @Id
    @Column(unique = true, nullable = false)
    private long id;

    @Column(unique = true, nullable = false)
    private String libelle;

    @Column
    private boolean enabled;

    @Column
    private boolean attachedFileRequired;


}
