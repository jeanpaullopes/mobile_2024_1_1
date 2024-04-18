package br.edu.uniritter.aula224_1.repositories;

import java.util.List;

public interface RepostoryInterface {
    public Object get(int id);
    public void add(Object obj);
    public void remove(int id);
    public boolean contains(int id);
    public List<Object> getAll();
}
