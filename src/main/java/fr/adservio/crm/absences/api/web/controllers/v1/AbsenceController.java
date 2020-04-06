package fr.adservio.crm.absences.api.web.controllers.v1;

import fr.adservio.crm.absences.api.domain.Absence;
import fr.adservio.crm.absences.api.services.AbsenceService;
import fr.adservio.crm.absences.api.web.model.AbsenceDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/v1/absences")
@Api(value = "absences", description = "Provides a simple, api interface to absence entities")
public class AbsenceController {

    @Autowired
    private final AbsenceService absenceService;

    @Autowired
    private ModelMapper modelMapper;

    @SneakyThrows
    @ApiOperation(value = "Create absences")
    @PostMapping(value = "/create")
    public ResponseEntity createAbsence(@Validated @RequestBody AbsenceDto absenceDto) {
        Absence absence = convertToEntity(absenceDto);
        Absence createdAbsence = absenceService.createNewAbsence(absence);
        return ResponseEntity.created(new URI("/v1/absences/" + createdAbsence.getId())).build();
    }

    @SneakyThrows
    @ApiOperation(value = "Get an absences by id")
    @GetMapping(value = "/{absenceId}")
    public ResponseEntity getAbsenceById(@PathVariable(value = "absenceId") Long absenceId) {
        Absence absence = absenceService.findAbsenceById(absenceId)
                .orElseThrow(() -> new fr.adservio.crm.absences.api.web.controllers.errors.ResourceNotFound("Invalid absence id :" + absenceId));
        return ResponseEntity
                .ok()
                .eTag(Long.toString(absenceId))
                .location(new URI("/v1/absences/" + absenceId))
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(absence);
    }

    @ApiOperation(value = "Update an existing absence")
    @PutMapping(value= "/{absenceId}")
    public ResponseEntity updateAbsence(@PathVariable(value = "absenceId") Long absenceId) {
        return ResponseEntity.ok().build();
    }

    private Absence convertToEntity(AbsenceDto absenceDto) {
        return  modelMapper.map(absenceDto, Absence.class);
    }
}
