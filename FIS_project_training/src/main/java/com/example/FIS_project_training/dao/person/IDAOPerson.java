package com.example.FIS_project_training.dao.person;

import com.example.FIS_project_training.model.Evidence;
import com.example.FIS_project_training.model.Person;

public interface IDAOPerson {
    public void createPerson(Person person) ;

    public Person deletePersonById(String id);

    public Person updatePerson(Person person);

}
