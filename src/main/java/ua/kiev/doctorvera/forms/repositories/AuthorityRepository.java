package ua.kiev.doctorvera.forms.repositories;

import org.springframework.data.repository.CrudRepository;
import ua.kiev.doctorvera.forms.entities.Authority;

public interface AuthorityRepository extends CrudRepository<Authority, Long> {
}
