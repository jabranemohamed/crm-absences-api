package fr.adservio.crm.absences.api.services.impl;

import fr.adservio.crm.absences.api.domain.Absence;
import fr.adservio.crm.absences.api.repositories.AbsenceRepository;
import fr.adservio.crm.absences.api.repositories.AbsenceTypeRepository;
import fr.adservio.crm.absences.api.services.AbsenceService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class AbsenceServiceImpl implements AbsenceService {

    @Autowired
    private AbsenceRepository absenceRepository;


    @Override
    public Absence createNewAbsence(Absence absence) {
        return absenceRepository.save(absence);
    }

    @Override
    public Optional<Absence> findAbsenceById(Long absenceId) {
        return absenceRepository.findById(absenceId);
    }
}
