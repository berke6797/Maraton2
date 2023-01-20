package Soru1.service;

public interface ICrud <T>{
    void create(T t);
    void read();
    void update(T t);
    void delete(int id);

}
