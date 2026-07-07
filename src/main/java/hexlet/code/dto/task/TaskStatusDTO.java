package hexlet.code.dto.task;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class TaskStatusDTO {

    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String slug;

    private LocalDate createdAt;
}
