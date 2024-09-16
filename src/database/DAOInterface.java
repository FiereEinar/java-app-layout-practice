package database;

public interface DAOInterface<T> {
  void add(T t);

  void remove(int id);

  void update(int id, T t);
}
