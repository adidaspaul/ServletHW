package service;

import dl.DevelopersRepository;
import model.converter.DevelopersConverter;
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

    public void save(DevelopersDto developer) {
        Integer devId = repository.save(converter.convert(developer));
        developer.setId(devId);
    }

    public DevelopersDto findById(Integer id) {

        return converter.convert(repository.findById(id));
    }

    public DevelopersDto findByName(String name) {
    DevelopersDto dev = converter.convert(repository.findByName(name));
        return dev;
    }



    public void update(DevelopersDto developer) {
        repository.update(converter.convert(developer));
    }

    public List<DevelopersDto> findAll() {
        return repository.selectAll()
                .stream()
                .map(converter::convert)
                .collect(Collectors.toList());
    }

    public void delete(Integer id){
        repository.delete(id);
    }
}
