package hexlet.code.service;

import hexlet.code.dto.task.TaskStatusCreateDTO;
import hexlet.code.dto.task.TaskStatusDTO;
import hexlet.code.dto.task.TaskStatusUpdateDTO;

import java.util.List;

public interface TaskStatusService {

    TaskStatusDTO show(long id);

    List<TaskStatusDTO> index();

    TaskStatusDTO create(TaskStatusCreateDTO dto);

    TaskStatusDTO update(long id, TaskStatusUpdateDTO dto);

    void delete(long id);
}
