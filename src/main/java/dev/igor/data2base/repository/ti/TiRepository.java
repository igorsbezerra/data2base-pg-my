package dev.igor.data2base.repository.ti;

import dev.igor.data2base.model.ti.Ti;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TiRepository extends JpaRepository<Ti, Long> {
}
