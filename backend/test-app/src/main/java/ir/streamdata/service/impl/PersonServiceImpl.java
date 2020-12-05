package ir.streamdata.service.impl;

import ir.streamdata.model.dto.PersonDto;
import ir.streamdata.model.entity.base.Person;
import ir.streamdata.mapper.DtoMapper;
import ir.streamdata.mapper.EntityMapper;
import ir.streamdata.repository.GenderRepository;
import ir.streamdata.repository.PersonRepository;
import ir.streamdata.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonServiceImpl implements PersonService, EntityMapper<Person, PersonDto>, DtoMapper<PersonDto, Person> {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private GenderRepository genderRepository;


    public Integer save(PersonDto personDto) {
        Person person = convertToEntity(personDto);
        return save(person).getId();
    }

    @Transactional(readOnly = true)
    public List<PersonDto> list() {
        List<Person> personList = personRepository.findAll();
        return personList.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Transactional
    public Person save(Person person) {
        return personRepository.save(person);
    }


    @Override
    public Person convertToEntity(PersonDto personDto) {
        Person person = new Person();
        person.setFirstName(personDto.getFirstName());
        person.setLastName(personDto.getLastName());
        person.setBirthDate(personDto.getBirthDate());
        person.setNationalCode(personDto.getNationalCode());
        person.setFatherName(personDto.getFatherName());
        person.setGender(genderRepository.getOne(personDto.getGender().getId()));
        return person;
    }

    @Override
    public PersonDto convertToDto(Person person) {
        PersonDto personDto = new PersonDto();
        personDto.setFirstName(person.getFirstName());
        personDto.setLastName(person.getLastName());
        personDto.setNationalCode(person.getNationalCode());
        personDto.setFatherName(person.getFatherName());
        personDto.setBirthDate(person.getBirthDate());
        //personDto.setGender(new GenderDto(person.getGender()));
        return personDto;
    }
}
