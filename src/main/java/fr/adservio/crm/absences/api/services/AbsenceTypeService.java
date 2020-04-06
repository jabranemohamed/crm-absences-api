package fr.adservio.crm.absences.api.services;

import fr.adservio.crm.absences.api.domain.AbsenceType;

import java.util.List;
import java.util.Optional;

/**
 * Central Service to handle all absence type buisness logic
 */
public interface AbsenceTypeService {

    List<AbsenceType> findAllAbsenceType();

    Optional<AbsenceType> findAbsenceTypeById(Long typeId);

    void removeAbsenceTypeById(Long typeId);

    void update(AbsenceType absenceType);

    AbsenceType createAbsenceType(AbsenceType absenceType);
}
