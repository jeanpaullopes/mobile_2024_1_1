package br.edu.uniritter.aula224_1.services;

import android.content.Context;

import androidx.room.Room;

import java.util.List;
import java.util.concurrent.Executors;

import br.edu.uniritter.aula224_1.database.AppDatabase;
import br.edu.uniritter.aula224_1.database.Cliente;
import br.edu.uniritter.aula224_1.database.RoomSelectListListener;


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

    public static void getAll(RoomSelectListListener listener) {
        Executors.newSingleThreadExecutor().execute(() -> {
             List<Cliente> clientes = db.clienteDAO().getAll();
             if (listener != null) {
                 listener.onSelectAllComplete(clientes);
             }
        });
    }

    public static void insert(Cliente cliente) {
        Executors.newSingleThreadExecutor().execute(() -> {
            db.clienteDAO().insert(cliente);
        });
    }
    public static void update(Cliente cliente) {
        Executors.newSingleThreadExecutor().execute(() -> {
        db.clienteDAO().update(cliente);
        });
    }

    public static void delete(Cliente cliente) {
        Executors.newSingleThreadExecutor().execute(() -> {
            db.clienteDAO().delete(cliente);
        });
    }
}
