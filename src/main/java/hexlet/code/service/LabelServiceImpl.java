package hexlet.code.service;

import hexlet.code.dto.label.LabelCreateDTO;
import hexlet.code.dto.label.LabelDTO;
import hexlet.code.dto.label.LabelUpdateDTO;
import hexlet.code.exception.ResourceNotFoundException;
import hexlet.code.mapper.LabelMapper;
import hexlet.code.repository.LabelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LabelServiceImpl implements LabelService {

    private final LabelMapper labelMapper;
    private final LabelRepository labelRepository;

    @Override
    public LabelDTO show(Long id) {
        var label = labelRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Label not found"));

        return labelMapper.map(label);
    }

    @Override
    public List<LabelDTO> showAll() {
        return labelRepository.findAll()
                .stream()
                .map(labelMapper::map)
                .toList();
    }

    @Override
    public LabelDTO create(LabelCreateDTO dto) {
        var label = labelMapper.map(dto);
        labelRepository.save(label);
        return labelMapper.map(label);
    }

    @Override
    public LabelDTO update(long id, LabelUpdateDTO dto) {
        var label = labelRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Label not found"));

        labelMapper.update(dto, label);
        labelRepository.save(label);

        return labelMapper.map(label);
    }

    @Override
    public void delete(long id) {
        var label = labelRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Label not found"));

        labelRepository.delete(label);
    }
}
