package fr.adservio.crm.absences.api.repositories;

import fr.adservio.crm.absences.api.domain.Absence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AbsenceRepository extends JpaRepository<Absence,Long> {
}
