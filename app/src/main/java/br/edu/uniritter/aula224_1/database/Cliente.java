package br.edu.uniritter.aula224_1.database;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity
public class Cliente {
    @PrimaryKey(autoGenerate = true)
    public int id;
    @ColumnInfo(name = "fantasia")
    public String nomeFantasia;
    @ColumnInfo(name = "razao")
    public String razaoSocial;
    @ColumnInfo(name = "cnpj")
    public String cnpj;
    @ColumnInfo(name = "telefone")
    public String telefone;
    @ColumnInfo(name = "email")
    public String email;

}
