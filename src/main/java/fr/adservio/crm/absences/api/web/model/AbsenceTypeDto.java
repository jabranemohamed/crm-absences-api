package fr.adservio.crm.absences.api.web.model;

import javax.validation.constraints.NotNull;

public class AbsenceTypeDto {

    @NotNull
    private String libelle;

    private boolean enabled;

    @NotNull
    private boolean attachedFileRequired;
}
