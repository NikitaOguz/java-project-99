package hexlet.code.util;

import hexlet.code.model.TaskStatus;
import hexlet.code.model.User;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ModelGeneratorTest {

    @Autowired
    private ModelGenerator modelGenerator;

    @Test
    void testUserModel() {
        User user = Instancio.of(modelGenerator.getUserModel()).create();

        assertThat(user).isNotNull();
        assertThat(user.getId()).isNull();
        assertThat(user.getEmail()).isNotBlank();
        assertThat(user.getFirstName()).isNotBlank();
        assertThat(user.getLastName()).isNotBlank();
    }

    @Test
    void testTaskStatusModel() {
        TaskStatus status = Instancio.of(modelGenerator.getTaskStatusModel()).create();

        assertThat(status).isNotNull();
        assertThat(status.getId()).isNull();
        assertThat(status.getName()).isNotBlank();
        assertThat(status.getSlug()).isNotBlank();
    }
}
