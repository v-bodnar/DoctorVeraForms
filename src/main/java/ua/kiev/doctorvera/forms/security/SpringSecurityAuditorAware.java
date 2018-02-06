package ua.kiev.doctorvera.forms.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import ua.kiev.doctorvera.forms.entities.User;
import ua.kiev.doctorvera.forms.repositories.UsersRepository;

import java.util.Optional;

/**
 * Created by volodymyr.bodnar on 6/23/2017.
 */
@Component
public class SpringSecurityAuditorAware implements AuditorAware<String> {
    private static Logger log = LoggerFactory.getLogger(SpringSecurityAuditorAware.class);

    @Autowired
    private UsersRepository usersRepository;

    public Optional<String> getCurrentAuditor() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated() || (authentication.getPrincipal() instanceof String && authentication.getPrincipal().equals("anonymousUser"))) {
            log.error("No authenticated user!");
        }
        User user = usersRepository.findByUsername(((JwtUser)authentication.getPrincipal()).getUsername()).get();
        return Optional.of(user.getUsername());

    }
}
