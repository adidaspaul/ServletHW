package service;

import dl.ClientsRepository;
import dl.Repository;
import model.converter.ClientsConverter;
import model.dao.ClientsDao;
import model.dto.ClientsDto;

import java.util.List;
import java.util.stream.Collectors;

public class ClientsService {

    private final ClientsConverter converter;
    private final ClientsRepository repository;

    public ClientsService(ClientsConverter converter, ClientsRepository repository) {
        this.repository = repository;
        this.converter = converter;
    }

    public void save(ClientsDto client) {
        Integer clientId= repository.save(converter.convert(client));
        client.setId(clientId);
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

    public ClientsDto findByName(String name) {
        return converter.convert(repository.findByName(name));
    }

    public void delete(Integer id) {
        repository.delete(id);
    }
}
