package springboot.mission.basic.infra;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import springboot.mission.basic.controller.dto.UserPrincipalDTO;
import springboot.mission.basic.repository.UserRepository;
import springboot.mission.basic.service.UserService;

@Primary
@Service
public class CommunityUserDetailsService implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public CommunityUserDetailsService(
            @Autowired UserRepository userRepository,
            @Autowired PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .map(userEntity -> {
                    userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
                    return new UserPrincipalDTO(userEntity);
                })
                .orElseThrow(() -> new UsernameNotFoundException(String.format("username %s not found", username)));
    }
}
