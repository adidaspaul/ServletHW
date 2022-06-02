package service;

import dl.ProjectsRepository;
import model.converter.ProjectsConverter;
import model.dto.ProjectsDto;

import java.util.List;
import java.util.stream.Collectors;

public class ProjectsService {

    private final ProjectsConverter converter;
    private final ProjectsRepository repository;

    public ProjectsService(ProjectsConverter converter, ProjectsRepository repository) {
        this.repository = repository;
        this.converter = converter;
    }

    public void save(ProjectsDto project) {
        Integer projectId = repository.save(converter.convert(project));
        project.setId(projectId);
    }

    public ProjectsDto findById(Integer id) {
        return converter.convert(repository.findById(id));
    }

    public ProjectsDto findByName(String name) {
        ProjectsDto project = converter.convert(repository.findByName(name));
        return project;
    }



    public void update(ProjectsDto project) {
        repository.update(converter.convert(project));
    }

    public List<ProjectsDto> findAll() {
        return repository.selectAll().stream().map(converter::convert).collect(Collectors.toList());
    }

    public void delete(Integer id) {
        repository.delete(id);
    }
}
