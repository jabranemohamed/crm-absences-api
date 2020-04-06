package fr.adservio.crm.absences.api.web.controllers.v1;

import fr.adservio.crm.absences.api.domain.AbsenceType;
import fr.adservio.crm.absences.api.services.AbsenceTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/v1/absencesTypes")
@Api(value = "absencesTypes", description = "Provides a simple, api interface to absence type entities")
public class AbsenceTypeController {

    @Autowired
    private final AbsenceTypeService absenceTypeService;

    @ApiOperation(value = "Get a paginated response listing the absence type.")
    @GetMapping(value = "/", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity getAllAbsenceType() {
        List<AbsenceType> allAbsenceType = absenceTypeService.findAllAbsenceType();
        try {
            return ResponseEntity
                    .ok()
                    .location(new URI("/v1/absencesTypes/"))
                    .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                    .body(allAbsenceType);
        } catch (URISyntaxException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @SneakyThrows
    @ApiOperation(value = "Get a specific absence type object identified by his id.")
    @GetMapping(value = "/{typeId}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity getAbsenceTypeById(@Validated @PathVariable(value = "typeId") Long typeId) {
        AbsenceType atFound = absenceTypeService.findAbsenceTypeById(typeId)
                .orElseThrow(() -> new fr.adservio.crm.absences.api.web.controllers.errors.ResourceNotFound("Invalid absence type id :" + typeId));
        return ResponseEntity
                .ok()
                .eTag(Long.toString(typeId))
                .location(new URI("/v1/absencesTypes/" + typeId))
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(atFound);
    }


    @ApiOperation(value = "Delete Absence type by Id.")
    @DeleteMapping(value = "/{typeId}")
    public ResponseEntity removeById(@Validated @PathVariable(value = "typeId") Long typeId) {
        if (!absenceTypeService.findAbsenceTypeById(typeId).isPresent())
            throw new fr.adservio.crm.absences.api.web.controllers.errors.ResourceNotFound("Invalid absence type id : " + typeId);
        absenceTypeService.removeAbsenceTypeById(typeId);
        return ResponseEntity.noContent().build();
    }

    @ApiOperation(value = "Disable a absence type. If a absence type is enabled this endpoint will disable him ")
    @PostMapping(value = "/{typeId}/disable")
    public ResponseEntity disableAbsenceTypeById(@Validated @PathVariable(value = "typeId") Long typeId) {
        AbsenceType absenceType = absenceTypeService.findAbsenceTypeById(typeId)
                .orElseThrow(() -> new fr.adservio.crm.absences.api.web.controllers.errors.ResourceNotFound("Invalid absence type id :" + typeId));
        if (absenceType.isEnabled()) {
            absenceType.setEnabled(false);
            absenceTypeService.update(absenceType);
        }
        return ResponseEntity.noContent().build();
    }

    @ApiOperation(value = "Enable a Absence type. If an absence type is disabled this endpoint will enable him ")
    @PostMapping(value = "/{typeId}/enable")
    public ResponseEntity enableAbsenceTypeById(@Validated @PathVariable(value = "typeId") Long typeId) {
        AbsenceType absenceType = absenceTypeService.findAbsenceTypeById(typeId)
                .orElseThrow(() -> new fr.adservio.crm.absences.api.web.controllers.errors.ResourceNotFound("Invalid absence type id :" + typeId));
        if (!absenceType.isEnabled()) {
            absenceType.setEnabled(true);
            absenceTypeService.update(absenceType);
        }
        return ResponseEntity.noContent().build();
    }

    @SneakyThrows
    @ApiOperation(value = "Create a new absence type.")
    @PostMapping(value = "/create")
    public ResponseEntity createAbsenceType(@RequestBody AbsenceType absenceType) {
        AbsenceType createdType = absenceTypeService.createAbsenceType(absenceType);
        return ResponseEntity.created(new URI("/v1/absencesTypes/" + createdType.getId())).build();
    }

    @ApiOperation(value = "Update an absence type.")
    @PostMapping(value = "/{typeId}/typeDetailsUpdate")
    public ResponseEntity updateAbsenceType(@PathVariable(value = "typeId") Long typeId, @Validated @RequestBody AbsenceType absenceType) {
        AbsenceType foundObject = absenceTypeService.findAbsenceTypeById(typeId)
                .orElseThrow(() -> new fr.adservio.crm.absences.api.web.controllers.errors.ResourceNotFound("Invalid absence type id :" + typeId));
        absenceType.setId(typeId);
        absenceTypeService.update(absenceType);
        return ResponseEntity.ok().build();
    }


}
