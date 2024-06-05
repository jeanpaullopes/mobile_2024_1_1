package br.edu.uniritter.aula224_1.presenters;

import android.content.Context;

import java.util.List;

import br.edu.uniritter.aula224_1.database.Cliente;

public interface ClientePresenter {
    interface View {
        void setClientes(List<Cliente> clientes);
        Context getContext();
        void onErrorMessage(String message);
        void onSucessMessage(String message);
    }
    interface Presenter {
        public void getClientes();
        void saveCliente(Cliente cliente);
    }

}
