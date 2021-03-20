package com.example.rxroomretrofit.recyclerViewPack;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rxroomretrofit.MainViewModel;
import com.example.rxroomretrofit.R;
import com.example.rxroomretrofit.Retrofit.Data;
import com.example.rxroomretrofit.Retrofit.GetFirstData;
import com.example.rxroomretrofit.Retrofit.RetrofitHolder;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.TestOnly;

import java.lang.reflect.GenericArrayType;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolder> {

    ArrayList<Data> data = new ArrayList<>();

    TextView userName;
    TextView userEmail;

    @NonNull
    @NotNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recui , parent , false);
        MyViewHolder myViewHolder = new MyViewHolder(v);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull MyViewHolder holder, int position) {

        Data userData = data.get(position);

        userEmail = holder.email;
        userName = holder.name;


        userEmail.setText("Email : " + userData.getEmail());
        userName.setText("Name : " + userData.getFirst_name() + " " +  userData.getLast_name());

    }


    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        TextView email;

        ImageView imageView;

        @SuppressLint("SetTextI18n")
        public MyViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.user_imgv);
            name = itemView.findViewById(R.id.name);
            email = itemView.findViewById(R.id.email);
        }
    }

    public ArrayList<Data> getData() {
        return data;
    }

    public void setData(ArrayList<Data> data) {
        this.data = data;
    }
}
