package fr.adservio.crm.absences.api.repositories;

import fr.adservio.crm.absences.api.domain.AbsenceType;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * CRUD interface for AbsenceType entity
 * @author adservio
 * @version 0.1
 */

public interface AbsenceTypeRepository extends JpaRepository<AbsenceType,Long> {
}
