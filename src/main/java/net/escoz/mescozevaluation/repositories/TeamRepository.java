package net.escoz.mescozevaluation.repositories;

import net.escoz.mescozevaluation.models.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
}
