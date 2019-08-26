package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.myapplication.model.User;
import com.example.myapplication.service.UserAdapter;
import com.example.myapplication.service.UserService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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

        Call<ArrayList<User>> call = UserAdapter.getUserService().getUsers();
        call.enqueue(new UserCallback());
    }

    private void poblarUsers() {


    }

    class UserCallback implements Callback<ArrayList<User>> {

        @Override
        public void onResponse(Call<ArrayList<User>> call, Response<ArrayList<User>> response) {

            if(response.isSuccessful()) {
                ArrayList<User> users = response.body();
                int a = 0;
            }
        }

        @Override
        public void onFailure(Call<ArrayList<User>> call, Throwable t) {
            Toast.makeText(context, t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
        }
    }
}
