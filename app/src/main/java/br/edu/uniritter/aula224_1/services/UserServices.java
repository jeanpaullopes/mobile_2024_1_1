package br.edu.uniritter.aula224_1.services;

import android.content.Context;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import br.edu.uniritter.aula224_1.R;
import br.edu.uniritter.aula224_1.models.User;
import br.edu.uniritter.aula224_1.repositories.UserRepository;

public class UserServices {

    public static User createUserFromJson(JSONObject json) {
        User user = new User();
        try {
            user.setId(json.getInt("id"));
            user.setName(json.getString("name"));
            user.setUsername(json.getString("username"));
            user.setEmail(json.getString("email"));
            user.setPhone(json.getString("phone"));
            user.setWebsite(json.getString("website"));
        } catch (Exception e) {
            return null;
        }
        return user;
    }

    public static void loadUsersToRepository(Context context) {
        RequestQueue queue = Volley.newRequestQueue(context);
        String url2 = "https://jsonplaceholder.typicode.com/users";
        JsonArrayRequest jarrRequest = new JsonArrayRequest(Request.Method.GET, url2,null,
                new Response.Listener<org.json.JSONArray>() {
                    @Override
                    public void onResponse(org.json.JSONArray response) {
                        UserRepository repo = UserRepository.getInstance();
                        for (int i = 0; i < response.length(); i++) {
                            try {
                                JSONObject obj = response.getJSONObject(i);
                                User user = UserServices.createUserFromJson(obj);
                                if (user != null) {
                                    repo.addUser(user);
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }
                });
        queue.add(jarrRequest);
    }
}
