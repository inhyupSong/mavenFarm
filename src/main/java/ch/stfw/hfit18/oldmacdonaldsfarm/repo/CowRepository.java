package ch.stfw.hfit18.oldmacdonaldsfarm.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ch.stfw.hfit18.oldmacdonaldsfarm.model.Cow;

@Repository
public interface CowRepository extends CrudRepository<Cow, Long> {
}