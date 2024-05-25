package com.sorcererscode.fileflow.organisations.db;

import com.sorcererscode.fileflow.users.User;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrganisationRepository extends JpaRepository<Organisation, Long> {
    List<Organisation> findByMaintainer(User maintainer, PageRequest pageable);
}