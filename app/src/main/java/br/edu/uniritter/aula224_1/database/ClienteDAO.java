package br.edu.uniritter.aula224_1.database;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ClienteDAO {

    @Query("SELECT * FROM Cliente")
    List<Cliente> getAll();

    @Query("SELECT * FROM Cliente WHERE id = :id")
    Cliente getById(int id);

    @Query("SELECT * FROM Cliente WHERE cnpj = :cnpj")
    Cliente getByCnpj(String cnpj);

    @Query("SELECT * FROM Cliente WHERE fantasia like :fantasia")
    List<Cliente> getByLikeFantasia(String fantasia);

    @Insert
    void insertAll(Cliente... clientes);

    @Delete
    void delete(Cliente cliente);

}
