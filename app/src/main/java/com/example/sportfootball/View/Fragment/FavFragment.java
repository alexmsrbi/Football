package com.example.sportfootball.View.Fragment;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sportfootball.Adapter.FavAdapter;
import com.example.sportfootball.Database.AppDatabase;
import com.example.sportfootball.Database.FootballData;
import com.example.sportfootball.MainActivity;
import com.example.sportfootball.MainContact;
import com.example.sportfootball.Presenter.PresenterDao;
import com.example.sportfootball.R;

import java.util.List;

public class FavFragment extends Fragment implements MainContact.delete {

    private RecyclerView recyclerView;
    private Adapter adapter;
    private AppDatabase appDatabase;
    private PresenterDao presenterDao;
    private FavAdapter favAdapter;
    Context context;

    public FavFragment() {

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_favorite, container, false);
        return view;
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.fragmentfav_rv);
        presenterDao = new PresenterDao(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        appDatabase = AppDatabase.iniDb(getContext());
        readData(appDatabase);
    }

    private void readData(AppDatabase database) {
        List list;
        list = database.dao().getData();
        favAdapter = new FavAdapter(context, list, this);
        recyclerView.setAdapter(favAdapter);
    }

    @Override
    public void successDel() {
        Toast.makeText(getContext(), "Removed from Favorite", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(getContext(), MainActivity.class)); //CARA JADIIN FAVFRAGMENT ACTIVITY GIMANA? BIAR SETELAH DIHAPUS TETEP BISA DI HALAMAN ITU?
    }

    @Override
    public void deleteData(final FootballData item) {
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(getContext(), android.R.style.Theme_Material_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(context);
        }
        builder.setTitle("Remove Data").setMessage("Are you sure want to remove?")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        presenterDao.deleteData(appDatabase, item);
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert).show();
    }
}
