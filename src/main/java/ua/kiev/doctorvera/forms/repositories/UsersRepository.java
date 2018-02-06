package ua.kiev.doctorvera.forms.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ua.kiev.doctorvera.forms.entities.User;

import java.util.Optional;

/**
 * Created by Vova on 6/20/2017.
 */
public interface UsersRepository extends CrudRepository<User, Long> {
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    Optional<User> findByUsername(String username);
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    Optional<User> findOneByUsernameAndPassword(String username, String password);
}
