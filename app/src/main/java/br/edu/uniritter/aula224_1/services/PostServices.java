package br.edu.uniritter.aula224_1.services;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.snackbar.Snackbar;

import org.json.JSONException;
import org.json.JSONObject;

import br.edu.uniritter.aula224_1.models.Post;
import br.edu.uniritter.aula224_1.models.User;
import br.edu.uniritter.aula224_1.repositories.PostRepository;
import br.edu.uniritter.aula224_1.repositories.UserRepository;

public class PostServices {

    public static Post createPostFromJson(JSONObject json) throws ElementCreateException {

        User u = null;
        try {
            u = UserRepository.getInstance().getUser(json.getInt("userId"));

        return new Post(
                u,
                json.getInt("id"),
                json.getString("title"),
                json.getString("body"));
        } catch (JSONException e) {
            ElementCreateException exception = new ElementCreateException("Erro ao criar post: "+e.getMessage());
            throw exception;
        }
    }

    public static void loadPostFromRepository(Context context) {
        RequestQueue queue = Volley.newRequestQueue(context);
        String url2 = "https://jsonplaceholder.typicode.com/posts";
        JsonArrayRequest jarrRequest = new JsonArrayRequest(Request.Method.GET, url2,null,
                new Response.Listener<org.json.JSONArray>() {
                    @Override
                    public void onResponse(org.json.JSONArray response) {
                        PostRepository repo = PostRepository.getInstance();
                        for (int i = 0; i < response.length(); i++) {
                            try {
                                JSONObject obj = response.getJSONObject(i);
                                Post post = PostServices.createPostFromJson(obj);
                                repo.add(post);

                            } catch (ElementCreateException e) {
                                e.printStackTrace();
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        Toast.makeText(context, "Posts carregados: "+repo.getAll().size(), Toast.LENGTH_LONG).show();
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
