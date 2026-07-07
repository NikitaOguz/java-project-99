package hexlet.code.controller.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import hexlet.code.repository.UserRepository;
import hexlet.code.util.ModelGenerator;
import org.instancio.Instancio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashMap;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class AuthenticationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper om;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ModelGenerator modelGenerator;

    @BeforeEach
    void setUp() {
        userRepository.deleteAll();
    }

    @Test
    void testLoginSuccess() throws Exception {

        var password = "password123";

        var user = Instancio.of(modelGenerator.getUserModel()).create();
        user.setPasswordDigest(passwordEncoder.encode(password));
        userRepository.save(user);

        var data = new HashMap<String, String>();
        data.put("username", user.getEmail());
        data.put("password", password);

        var response = mockMvc.perform(post("/api/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(om.writeValueAsString(data)))
                .andExpect(status().isOk())
                .andReturn();

        var token = response.getResponse().getContentAsString();

        assertThat(token).isNotBlank();
    }

    @Test
    void testLoginWrongPassword() throws Exception {

        var password = "password123";

        var user = Instancio.of(modelGenerator.getUserModel()).create();
        user.setPasswordDigest(passwordEncoder.encode(password));
        userRepository.save(user);

        var data = new HashMap<String, String>();
        data.put("username", user.getEmail());
        data.put("password", "wrong-password");

        mockMvc.perform(post("/api/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(om.writeValueAsString(data)))
                .andExpect(status().isUnauthorized());
    }
}
