package com.example.FIS_project_training.dao.storage;

import com.example.FIS_project_training.model.Person;
import com.example.FIS_project_training.model.Storage;

public interface IDAOStorage {
    public void createStorage(Storage storage) ;

    public Storage deleteStorageById(String id);

    public Storage updateStorage(Storage storage);
}
