package hexlet.code.service;

import hexlet.code.dto.label.LabelCreateDTO;
import hexlet.code.dto.label.LabelDTO;
import hexlet.code.dto.label.LabelUpdateDTO;

import java.util.List;

public interface LabelService {

    LabelDTO show(Long id);

    List<LabelDTO> showAll();

    LabelDTO create(LabelCreateDTO dto);

    LabelDTO update(long id, LabelUpdateDTO dto);

    void delete(long id);
}
