package com.jobs.portal.repository;

import com.jobs.portal.modal.OrganisationModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganisationRepo extends JpaRepository<OrganisationModel,Long> {


//    OrganisationModel findByUsernameAndPassword(String username, String password);

    OrganisationModel findByEmailAndPassword(String email, String password);

    OrganisationModel findByOrganisationName(String orgName);
}
