package fr.adservio.crm.absences.api.web.model;

import fr.adservio.crm.absences.api.domain.AbsenceLine;
import fr.adservio.crm.absences.api.domain.UploadedFile;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

public class AbsenceDto {

    @NotNull
    private String demandeObject;

    private String comments;

    @NotNull
    private Long applicantId;

    @NotNull
    private Long approverId;

    private Date approvedAt;

    private Date createdAt;

    @NotNull
    private List<AbsenceLine> absenceLines;

    private List<UploadedFile> uploadedFilesList;
}
