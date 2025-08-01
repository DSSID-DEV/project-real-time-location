package com.sistemas.dssid.real_time_location.repositories.queries;

public class QueriesCollaborator {

    public static final String COLLABORATER_ALREADY_REGISTERED = "select count(collaborator.id) > 0 from Collaborator collaborator where collaborator.cpf = :cpf";
}
