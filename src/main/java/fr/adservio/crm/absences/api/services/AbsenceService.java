package fr.adservio.crm.absences.api.services;

import fr.adservio.crm.absences.api.domain.Absence;

import java.util.Optional;

/**
 * Central Service to handle all absence type buisness logic
 */
public interface AbsenceService {

    Absence createNewAbsence(Absence absence);

    Optional<Absence> findAbsenceById(Long absenceId);
}
