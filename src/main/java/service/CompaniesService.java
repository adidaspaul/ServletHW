package service;

import dl.CompaniesRepository;
import model.converter.CompaniesConverter;
import model.dto.CompaniesDto;

import java.util.List;
import java.util.stream.Collectors;

public class CompaniesService {


    private final CompaniesConverter converter;
    private final CompaniesRepository repository;

    public CompaniesService(CompaniesConverter converter, CompaniesRepository repository) {
        this.repository = repository;
        this.converter = converter;
    }

    public void save(CompaniesDto company) {
        Integer companyId = repository.save(converter.convert(company));
        company.setId(companyId);
    }

    public CompaniesDto findById(Integer id) {
        return converter.convert(repository.findById(id));
    }

    public CompaniesDto findByName(String name) {
        return converter.convert(repository.findByName(name));
    }

    public void update(CompaniesDto company) {
        repository.update(converter.convert(company));
    }

    public void delete(Integer id) {
        repository.delete(id);
    }

    public List<CompaniesDto> findAll() {
        return repository.selectAll().stream().map(converter::convert).collect(Collectors.toList());
    }
}
