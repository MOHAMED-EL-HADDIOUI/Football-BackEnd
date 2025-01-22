package com.football.repository;

import com.football.entites.Club;
import com.football.entites.Competition;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CompetitionRepository extends JpaRepository<Competition,String> {
    @Query("select c from Competition c where c.name like :kw")
    Page<Competition> searchByName(@Param("kw") String keyword, Pageable pageable);
}
