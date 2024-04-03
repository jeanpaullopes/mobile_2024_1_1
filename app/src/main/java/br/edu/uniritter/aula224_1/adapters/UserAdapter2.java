package br.edu.uniritter.aula224_1.adapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.edu.uniritter.aula224_1.R;
import br.edu.uniritter.aula224_1.models.User;

public class UserAdapter2 extends RecyclerView.Adapter<UserAdapter2.UserViewHolder> {
    private List<User> users;
    public UserAdapter2(List<User> users) {
        this.users = users;
    }
    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.user_view_holder2, null);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = this.users.get(position);

        View view = holder.getView();
        ((Button) view.findViewById(R.id.buttonVH)).setOnClickListener((v)->{
            Toast.makeText(v.getContext(), "Clicou no botão do usuário " + user.getName(), Toast.LENGTH_LONG).show();
        });
        ((Button) view.findViewById(R.id.buttonVH)).setText(user.getUsername());
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    class UserViewHolder extends RecyclerView.ViewHolder {
        private View view;
        public UserViewHolder(View itemView) {
            super(itemView);
            this.view = itemView;
        }

        public View getView() {
            return view;
        }
    }
}
