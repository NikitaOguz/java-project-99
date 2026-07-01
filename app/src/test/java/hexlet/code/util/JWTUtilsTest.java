package hexlet.code.util;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtEncoder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class JWTUtilsTest {

    @Autowired
    private JWTUtils jwtUtils;

    @MockBean
    private JwtEncoder jwtEncoder;

    @Test
    void testGenerateToken() {
        Jwt jwt = Jwt.withTokenValue("token")
                .header("alg", "none")
                .claim("sub", "user@test.com")
                .build();

        when(jwtEncoder.encode(any())).thenReturn(jwt);

        String token = jwtUtils.generateToken("user@test.com");

        assertEquals("token", token);
        verify(jwtEncoder).encode(any());
    }
}
