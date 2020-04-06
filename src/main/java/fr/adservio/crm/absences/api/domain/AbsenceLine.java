package fr.adservio.crm.absences.api.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

/**
 * It represent one line of absence inside an absence Request.
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
public class AbsenceLine {

    @Id
    @Column(unique = true, nullable = false)
    private Long id;

    @OneToOne
    private AbsenceType absenceType;

    @Column
    private String description;

    @Column
    private Date startDate;

    @Column
    private Date endDate;

    @Column
    private int duration;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    private Absence absence;


}
