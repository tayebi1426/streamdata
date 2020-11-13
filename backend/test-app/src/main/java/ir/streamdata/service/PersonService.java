package ir.streamdata.service;

import ir.streamdata.dto.PersonDto;

import java.util.List;

public interface PersonService {

    Integer save(PersonDto personDto);

    List<PersonDto> list();
}
