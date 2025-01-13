package ma.enset.tpjdbc2025.dao;

import java.util.List;

public interface Dao<E,U>{
List<E> findAll();
E findById(int id);
void create(E e);
void delete(U id);
void update(E e);
}
