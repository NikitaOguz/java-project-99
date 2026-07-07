package hexlet.code.util;

import hexlet.code.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import hexlet.code.repository.UserRepository;

@Component
@RequiredArgsConstructor
public class UserUtils {

    private final UserRepository userRepository;

    public boolean isAuthor(long userId) {
        var user = userRepository.findById(userId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User with id " + userId + " not found"));

        var authentication = SecurityContextHolder.getContext().getAuthentication();
        return user.getEmail().equals(authentication.getName());
    }
}


