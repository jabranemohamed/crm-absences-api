package fr.adservio.crm.absences.api.repositories;

import fr.adservio.crm.absences.api.domain.AbsenceType;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Repositories Initialization Service
 */

@RequiredArgsConstructor
@Service
public class InitializeRepositoriesService {

    @Autowired
    private final AbsenceTypeRepository absenceTypeRepository;

    /**
     * Initialize Absence types repository if it's empty
     * This List was original taken from Salesforce current setup
     * and it can be changed later via the UI
     */
    public void initializeAbsencesTypes() {
        if (absenceTypeRepository.findAll().size() == 0) {
            List<AbsenceType> listAbsences = new ArrayList<>();
            listAbsences.add(new AbsenceType().builder().libelle("Autres").id(1).enabled(true).attachedFileRequired(false).build());
            listAbsences.add(new AbsenceType().builder().libelle("Congés Maternités").id(2).enabled(true).attachedFileRequired(true).build());
            listAbsences.add(new AbsenceType().builder().libelle("Décès").id(3).enabled(true).build());
            listAbsences.add(new AbsenceType().builder().libelle("CP").id(4).enabled(true).build());
            listAbsences.add(new AbsenceType().builder().libelle("Mariage").enabled(true).id(5).build());
            listAbsences.add(new AbsenceType().builder().libelle("Congés Paternités").id(6).enabled(true).build());
            listAbsences.add(new AbsenceType().builder().libelle("Congés Sans Solde").id(7).enabled(true).build());
            listAbsences.add(new AbsenceType().builder().libelle("RTT Salarié").id(8).enabled(true).build());
            listAbsences.add(new AbsenceType().builder().libelle("Maladie").id(9).enabled(true).attachedFileRequired(true).build());
            listAbsences.add(new AbsenceType().builder().libelle("Mise à pied").id(10).enabled(true).build());
            listAbsences.add(new AbsenceType().builder().libelle("Accident du trajet").id(11).enabled(true).attachedFileRequired(true).build());
            listAbsences.add(new AbsenceType().builder().libelle("RTT Employeur").id(12).enabled(true).build());
            listAbsences.add(new AbsenceType().builder().libelle("Naissance").id(13).enabled(true).build());
            listAbsences.add(new AbsenceType().builder().libelle("Injustifiée").id(14).enabled(true).build());
            absenceTypeRepository.saveAll(listAbsences);
        }
    }
}
