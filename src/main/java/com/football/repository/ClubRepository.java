package com.football.repository;


import com.football.entites.Club;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClubRepository extends JpaRepository<Club,Long> {
    @Query("select c from Club c where c.name like :kw")
    Page<Club> searchByName(@Param("kw") String keyword, Pageable pageable);
}
