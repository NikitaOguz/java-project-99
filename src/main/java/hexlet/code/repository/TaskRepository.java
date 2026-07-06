package hexlet.code.repository;

import hexlet.code.model.Label;
import hexlet.code.model.Task;
import hexlet.code.model.TaskStatus;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long>,
        JpaSpecificationExecutor<Task> {

    @EntityGraph(attributePaths = {
            "taskStatus",
            "assignee",
            "labels"
    })
    Optional<Task> findByName(String name);

    boolean existsByAssigneeId(Long assigneeId);

    boolean existsByTaskStatus(@NotNull TaskStatus taskStatus);

    boolean existsByLabelsContaining(Label label);

    @Override
    @EntityGraph(attributePaths = {
            "taskStatus",
            "assignee",
            "labels"
    })
    Optional<Task> findById(Long id);

    @Override
    @EntityGraph(attributePaths = {
            "taskStatus",
            "assignee",
            "labels"
    })
    List<Task> findAll(@Nullable Specification<Task> spec);
}
