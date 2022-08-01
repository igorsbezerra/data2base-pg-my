package dev.igor.data2base.repository.rh;

import dev.igor.data2base.model.rh.Rh;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RhRepository extends JpaRepository<Rh, Long> {
}
