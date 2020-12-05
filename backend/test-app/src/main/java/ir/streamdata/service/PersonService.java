package ir.streamdata.service;

import ir.streamdata.model.dto.PersonDto;

import java.util.List;

public interface PersonService {

    Integer save(PersonDto personDto);

    List<PersonDto> list();
}
