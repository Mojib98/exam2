package repository;

import models.BaseModel;

import java.sql.SQLException;

public interface Repository <T extends BaseModel> {
    void add(T t) throws SQLException;
   T show(int id) throws SQLException;
    void delete(int id) throws SQLException;
    void modify(T t);
}
