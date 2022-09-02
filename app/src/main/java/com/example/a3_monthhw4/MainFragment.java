package com.example.a3_monthhw4;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class MainFragment extends Fragment implements OnItemClick {

    private ArrayList<Country> countryArrayList;
    private CountryAdapter adapter;
    private RecyclerView recyclerView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loadData();
        recyclerView = view.findViewById(R.id.recycler);
        adapter = new CountryAdapter(countryArrayList, this::openNewActivity);
        recyclerView.setAdapter(adapter);

    }

    private void loadData() {
        countryArrayList = new ArrayList<>();
        countryArrayList.add(new Country("Europa", R.drawable.ic_ceu,1));
        countryArrayList.add(new Country("Asia", R.drawable.ic_cas,2));
        countryArrayList.add(new Country("North America", R.drawable.ic_cna,3));
        countryArrayList.add(new Country("South America", R.drawable.ic_csa,4));
        countryArrayList.add(new Country("Africa", R.drawable.ic_caf,5));
        countryArrayList.add(new Country("Oceania", R.drawable.ic_coc,6));
    }


    @Override
    public void openNewActivity(Country country) {
        Bundle bundle = new Bundle();
        bundle.putInt(getString(R.string.key), country.getKeyId());
        Fragment fragment = new SecondFragment();
        fragment.setArguments(bundle);
        requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).addToBackStack(null).commit();

    }
}