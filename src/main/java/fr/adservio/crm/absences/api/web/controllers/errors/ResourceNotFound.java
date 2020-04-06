package fr.adservio.crm.absences.api.web.controllers.errors;

public class ResourceNotFound extends RuntimeException {
    public ResourceNotFound(String exception) {
        super(exception);
    }
}
