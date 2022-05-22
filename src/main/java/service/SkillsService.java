package service;

import dl.Repository;
import model.converter.SkillsConverter;
import model.dao.SkillsDao;
import model.dto.SkillsDto;
import java.util.List;
import java.util.stream.Collectors;

public class SkillsService {

    private final SkillsConverter converter;
    private final Repository<SkillsDao> repository;

    public SkillsService(SkillsConverter converter, Repository <SkillsDao> repository) {
        this.repository = repository;
        this.converter = converter;
    }

    public void save(SkillsDto skills) {

        repository.save(converter.convert(skills));
    }

    public SkillsDto findById(Integer id) {
        return converter.convert(repository.findById(id));
    }



    public void update(SkillsDto skills) {
        repository.update(converter.convert(skills));
    }

    public List<SkillsDto> findAll() {
        return repository.selectAll().stream().map(converter::convert).collect(Collectors.toList());
    }
}

