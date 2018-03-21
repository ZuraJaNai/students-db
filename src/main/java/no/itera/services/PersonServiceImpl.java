package no.itera.services;

import no.itera.dao.PersonDao;
import no.itera.model.Attachment;
import no.itera.model.Person;
import no.itera.model.PersonInputData;
import no.itera.model.SearchPerson;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonDao personDao;


    @Override
    public Iterable<Person> getAll() {
        return personDao.findAll();
    }

    @Override
    public Page getAll(PageRequest pageRequest) {
        return personDao.findAll(pageRequest);
    }

    @Override
    public Person getById(int id) {
        return personDao.findOne(id);
    }


    @Override
    public boolean isPersonExists(Person person) {
        return personDao.exists(person.getId());
    }

    @Override
    public boolean addPerson(PersonInputData person) {
        personDao.save(new Person(person));
        return true;
    }

    @Override
    public boolean deletePerson(int id) {
            personDao.delete(id);
            return true;
    }

    @Override
    public void updatePerson(int id, PersonInputData person) {
        Person tempPerson = this.getById(id);

        if(StringUtils.isNoneEmpty(person.getLastName())){
            tempPerson.setLastName(person.getLastName());
        }
        if(StringUtils.isNoneEmpty(person.getFirstName())){
            tempPerson.setFirstName(person.getFirstName());
        }
        if(StringUtils.isNoneEmpty(person.getPatronymic())){
            tempPerson.setPatronymic(person.getPatronymic());
        }
        if(StringUtils.isNoneEmpty(person.getEmail())){
            tempPerson.setEmail(person.getEmail());
        }
        if(StringUtils.isNoneEmpty(person.getYearOfStudy())){
            tempPerson.setYearOfStudy(person.getYearOfStudy());
        }
        if(person.getInternshipBegin() != null){
            tempPerson.setInternshipBegin(person.getInternshipBegin().toString());
        }
        if(person.getInternshipEnd() != null){
            tempPerson.setInternshipEnd(person.getInternshipEnd().toString());
        }
        if(person.getPracticeBegin() != null){
            tempPerson.setPracticeBegin(person.getPracticeBegin().toString());
        }
        if(person.getPracticeEnd() != null){
            tempPerson.setPracticeEnd(person.getPracticeEnd().toString());
        }
        if(person.getJobBegin() != null){
            tempPerson.setJobBegin(person.getJobBegin().toString());
        }
        if(person.getJobEnd() != null){
            tempPerson.setJobEnd(person.getJobEnd().toString());
        }
        tempPerson.setComment(person.getComment());
        personDao.save(tempPerson);
    }

    @Override
    public void updateAttachments(int id, Attachment attachment) {
        Person person = this.getById(id);
        person.addAttachment(attachment);
        personDao.save(person);
    }

    @Override
    public void deleteAll() {
            personDao.deleteAll();
    }


    public List<Person> findAllPersons(SearchPerson filter) {
//
//        List<Person> persons = personDao.findAll((root, query, cb) -> {
//
//            List<Predicate> predicates = new ArrayList<>();
//
//            if (StringUtils.isNoneEmpty(filter.getLastName())) {
//                predicates.add(cb.like(cb.lower(root.get("lastName")),
//                        filter.getLastName().toLowerCase() + "%"));
//            }
//
//            if (StringUtils.isNoneEmpty(filter.getFirstName())) {
//                predicates.add(cb.like(cb.lower(root.get("firstName")),
//                         "%" +filter.getFirstName().toLowerCase() + "%"));
//            }
//
//            if (StringUtils.isNoneEmpty(filter.getPatronymic())) {
//                predicates.add(cb.like(cb.lower(root.get("patronymic")),
//                        "%" + filter.getPatronymic().toLowerCase() + "%"));
//            }
//
//            if (StringUtils.isNoneEmpty(filter.getEmail())) {
//                predicates.add(cb.like(cb.lower(root.get("email")),
//                        "%" + filter.getEmail().toLowerCase() + "%"));
//            }
//
//            if (StringUtils.isNoneEmpty(filter.getYearOfStudy())) {
//                predicates.add(cb.like(cb.lower(root.get("yearOfStudy")),
//                        "%" + filter.getYearOfStudy().toLowerCase() + "%"));
//            }
//
//            if(filter.getInternshipBegin() != null){
//                if(!predicates.add(cb.and(cb.isNull(root.get("internshipEnd")),
//                        cb.ge(filter.getInternshipBegin(), (root.get("intenrshipBegin")))));
//            }
//
//
//            return cb.and(predicates.toArray(new Predicate[0]));
//        });
//        return persons;
        return new ArrayList<>();
    }



}
