package br.edu.uniritter.aula224_1.adapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.edu.uniritter.aula224_1.R;
import br.edu.uniritter.aula224_1.models.User;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {
    private List<User> users;
    public UserAdapter(List<User> users) {
        this.users = users;
    }
    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.user_view_holder, null);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = this.users.get(position);

        View view = holder.getView();
        view.setOnClickListener((v)->{
            Toast.makeText(v.getContext(), "Clicou no usuário " + user.getName(), Toast.LENGTH_LONG).show();
        });
        TextView tv = view.findViewById(R.id.tvUserUsername);
        tv.setText(user.getUsername());
        ((TextView) view.findViewById(R.id.tvUserUsername)).setText(user.getUsername());
        ((TextView) view.findViewById(R.id.tvUserName)).setText(user.getName());
        ((TextView) view.findViewById(R.id.tvUserEmail)).setText(user.getEmail());
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
