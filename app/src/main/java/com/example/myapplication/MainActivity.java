package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.myapplication.adapter.UserAdapter;
import com.example.myapplication.model.User;
import com.example.myapplication.service.UserApiAdapter;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    Context context;
    private EditText etMail;
    private EditText etNombre;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etMail = (EditText)findViewById(R.id.etMail);
        etNombre = (EditText)findViewById(R.id.etNombre);
        listView = (ListView)findViewById(R.id.listView);

        context = this;
        Toast.makeText(this, "Inicio", Toast.LENGTH_LONG).show();
    }

    public void enviar(View view){

        String mail = etMail.getText().toString();
        String nombre = etNombre.getText().toString();

        if(!TextUtils.isEmpty(mail) && !TextUtils.isEmpty(nombre)) {
            UserApiAdapter.getUserService().postUser(mail, nombre).enqueue(new Callback<User>() {
                @Override
                public void onResponse(Call<User> call, Response<User> response) {
                    if(response.isSuccessful()) {
                        //showResponse(response.body().toString());
                        Log.i("", "post submitted to API." + response.body().toString());
                    }
                }

                @Override
                public void onFailure(Call<User> call, Throwable t) {
                    Log.e("", t.getMessage());
                }
            });
        }

        Call<ArrayList<User>> call = UserApiAdapter.getUserService().getUsers();
        call.enqueue(new UserCallback());
    }

    class UserCallback implements Callback<ArrayList<User>> {

        @Override
        public void onResponse(Call<ArrayList<User>> call, Response<ArrayList<User>> response) {

            if(response.isSuccessful()) {
                ArrayList<User> users = response.body();

                // Create the adapter to convert the array to views
                UserAdapter adapter = new UserAdapter(context, users);
                // Attach the adapter to a ListView
                ListView listView = (ListView) findViewById(R.id.listView);
                listView.setAdapter(adapter);
            }
        }

        @Override
        public void onFailure(Call<ArrayList<User>> call, Throwable t) {
            Toast.makeText(context, t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
        }
    }
}
