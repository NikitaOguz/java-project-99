package hexlet.code.service;

import hexlet.code.dto.task.TaskStatusCreateDTO;
import hexlet.code.dto.task.TaskStatusDTO;
import hexlet.code.dto.task.TaskStatusUpdateDTO;
import hexlet.code.exception.ResourceNotFoundException;
import hexlet.code.mapper.TaskStatusMapper;
import hexlet.code.repository.TaskStatusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskStatusServiceImpl implements TaskStatusService {

    private final TaskStatusRepository taskStatusRepository;
    private final TaskStatusMapper taskStatusMapper;

    @Override
    public TaskStatusDTO show(long id) {
        var taskStatus = taskStatusRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("TaskStatus not found"));
        return taskStatusMapper.map(taskStatus);
    }

    @Override
    public List<TaskStatusDTO> index() {
        return taskStatusRepository.findAll()
                .stream()
                .map(taskStatusMapper::map)
                .toList();
    }

    @Override
    public TaskStatusDTO create(TaskStatusCreateDTO dto) {
        var status = taskStatusMapper.map(dto);
        taskStatusRepository.save(status);
        return taskStatusMapper.map(status);
    }

    @Override
    public TaskStatusDTO update(long id, TaskStatusUpdateDTO dto) {
        var status = taskStatusRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("TaskStatus not found"));

        taskStatusMapper.update(dto, status);
        taskStatusRepository.save(status);

        return taskStatusMapper.map(status);
    }

    @Override
    public void delete(long id) {
        var status = taskStatusRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("TaskStatus not found"));

        taskStatusRepository.delete(status);
    }
}
