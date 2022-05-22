package service;

import dl.DevelopersRepository;
import dl.Repository;
import model.converter.DevelopersConverter;
import model.dao.DevelopersDao;
import model.dto.DevelopersDto;

import java.util.List;
import java.util.stream.Collectors;

public class DevelopersService {

    private final DevelopersConverter converter;
    private final DevelopersRepository repository;

    public DevelopersService(DevelopersConverter converter, DevelopersRepository repository) {
        this.repository = repository;
        this.converter = converter;
    }

    public void save(DevelopersDto developers) {
        repository.save(converter.convert(developers));
    }

    public DevelopersDto findById(Integer id) {

        return converter.convert(repository.findById(id));
    }

    public DevelopersDto findByName(String name) {
    DevelopersDto dev = converter.convert(repository.findByName(name));
        return dev;
    }



    public void update(DevelopersDto developers) {
        repository.update(converter.convert(developers));
    }

    public List<DevelopersDto> findAll() {
        return repository.selectAll().stream().map(converter::convert).collect(Collectors.toList());
    }
}
