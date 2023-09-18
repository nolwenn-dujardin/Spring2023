package sample.data.jpa.service;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import sample.data.jpa.domain.RDV;

@Transactional
public interface RDVDAO extends JpaRepository<RDV, Long> {
}
