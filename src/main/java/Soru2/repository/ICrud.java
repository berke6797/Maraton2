package Soru2.repository;

import java.util.List;

public interface ICrud <T>{
    void save(T t);
    void update(T t);
    void delete(int id);
    List<T> getAll();
}
