package br.edu.uniritter.aula224_1.services;

import android.content.Context;

import androidx.room.Room;

import java.util.List;

import br.edu.uniritter.aula224_1.database.AppDatabase;
import br.edu.uniritter.aula224_1.database.Cliente;

public class ClienteServices {

    private static ClienteServices instance;
    private static AppDatabase db;
    private ClienteServices(Context context) {
        db = AppDatabase.getDatabase(context);
    }
    public static ClienteServices getInstance(Context context) {
        if (instance == null) {
            instance = new ClienteServices(context);
        }
        return instance;
    }

    public static List<Cliente> getAll() {
        return db.clienteDAO().getAll();
    }

    public static void insert(Cliente cliente) {
        db.clienteDAO().insertAll(cliente);
    }
}
