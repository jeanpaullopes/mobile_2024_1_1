package br.edu.uniritter.aula224_1.database;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

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

    @Insert
    void insert(Cliente cliente);
    // insert into Cliente (fantasia, razao, cnpj, telefone, email) values (cliente.nomeFatasia, 'Razao', '12345678901234', '51999999999')

    @Delete
    void delete(Cliente cliente);

    @Update
    void update(Cliente cliente);

}
