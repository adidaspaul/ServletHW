package service;

import dl.Repository;
import model.converter.ClientsConverter;
import model.dao.ClientsDao;
import model.dto.ClientsDto;

import java.util.List;
import java.util.stream.Collectors;

public class ClientsService {

    private final ClientsConverter converter;
    private final Repository<ClientsDao> repository;

    public ClientsService(ClientsConverter converter, Repository <ClientsDao> repository) {
        this.repository = repository;
        this.converter = converter;
    }

    public void save(ClientsDto client) {
        repository.save(converter.convert(client));
    }

    public ClientsDto findById(Integer id) {
        return converter.convert(repository.findById(id));
    }


    public void update(ClientsDto client) {
        repository.update(converter.convert(client));
    }

    public List<ClientsDto> findAll() {
        return repository.selectAll().stream().map(converter::convert).collect(Collectors.toList());
    }
}
