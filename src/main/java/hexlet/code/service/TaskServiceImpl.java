package hexlet.code.service;

import hexlet.code.dto.task.TaskCreateDTO;
import hexlet.code.dto.task.TaskDTO;
import hexlet.code.dto.task.TaskParamsDTO;
import hexlet.code.dto.task.TaskUpdateDTO;
import hexlet.code.exception.ResourceNotFoundException;
import hexlet.code.mapper.TaskMapper;
import hexlet.code.repository.TaskRepository;
import hexlet.code.specification.TaskSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;
    private final TaskSpecification specBuilder;

    @Override
    public TaskDTO show(Long id) {
        return taskMapper.map(taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found")));
    }

    @Override
    public List<TaskDTO> index(TaskParamsDTO params) {
        var spec = specBuilder.build(params);

        return taskRepository.findAll(spec)
                .stream()
                .map(taskMapper::map)
                .toList();
    }

    @Override
    public TaskDTO create(TaskCreateDTO dto) {
        var task = taskMapper.map(dto);
        taskRepository.save(task);
        return taskMapper.map(task);
    }

    @Override
    public TaskDTO update(long id, TaskUpdateDTO dto) {
        var task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found"));

        taskMapper.update(dto, task);
        taskRepository.save(task);

        return taskMapper.map(task);
    }

    @Override
    public void delete(Long id) {
        var task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found"));

        taskRepository.delete(task);
    }
}
