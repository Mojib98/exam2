package service;

import models.BaseModel;

public interface Service<T extends BaseModel> {
    void add();
    void show();
    void delete();
    void modify(T t);
}
