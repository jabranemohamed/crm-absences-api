package fr.adservio.crm.absences.api.services.impl;

import fr.adservio.crm.absences.api.domain.AbsenceType;
import fr.adservio.crm.absences.api.repositories.AbsenceTypeRepository;
import fr.adservio.crm.absences.api.services.AbsenceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AbsenceTypeServiceImpl implements AbsenceTypeService {

    @Autowired
    private AbsenceTypeRepository absenceTypeRepository;

    @Override
    public List<AbsenceType> findAllAbsenceType() {
        return absenceTypeRepository.findAll();
    }

    @Override
    public Optional<AbsenceType> findAbsenceTypeById(Long typeId) {
        return absenceTypeRepository.findById(typeId);
    }

    @Override
    public void removeAbsenceTypeById(Long typeId) {
         absenceTypeRepository.deleteById(typeId);
    }

    @Override
    public void update(AbsenceType absenceType) {
        absenceTypeRepository.save(absenceType);
    }

    @Override
    public AbsenceType createAbsenceType(AbsenceType absenceType) {
        return absenceTypeRepository.save(absenceType);
    }
}
