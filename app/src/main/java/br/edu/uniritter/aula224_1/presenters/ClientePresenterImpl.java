package br.edu.uniritter.aula224_1.presenters;

import java.util.List;

import br.edu.uniritter.aula224_1.database.Cliente;
import br.edu.uniritter.aula224_1.services.ClienteServices;

public class ClientePresenterImpl implements ClientePresenter.Presenter {
    private ClientePresenter.View view;

    public ClientePresenterImpl(ClientePresenter.View view) {
        this.view = view;
    }

    @Override
    public void getClientes() {
        try {
            ClienteServices services = ClienteServices.getInstance(view.getContext());
            services.getAll((clientes) -> {
                view.setClientes((List<Cliente>) clientes);
            });
        } catch (Exception e) {
            view.onErrorMessage(e.getMessage());
        }
    }

    @Override
    public void saveCliente(Cliente cliente) {
        try {
            ClienteServices.getInstance(view.getContext()).insert(cliente);
            view.onSucessMessage("Cliente salvo com sucesso!");
        } catch (Exception e) {
            view.onErrorMessage(e.getMessage());
        }

    }
}
