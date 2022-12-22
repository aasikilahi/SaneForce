package com.example.saneforceapplication.ui.doctorlist;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.saneforceapplication.api.APIClient;
import com.example.saneforceapplication.api.APIInterface;
import com.example.saneforceapplication.api.ListDataResponse;
import com.example.saneforceapplication.api.Request;
import com.example.saneforceapplication.databinding.FragmentDoctorBinding;
import com.example.saneforceapplication.databinding.FragmentGalleryBinding;
import com.example.saneforceapplication.ui.doctorlist.adapter.DoctorListAdapter;
import com.example.saneforceapplication.ui.gallery.ActivityGallery;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DoctorListFragment extends Fragment {
    FragmentDoctorBinding binding;
    APIInterface restApi;
    List<ListDataResponse> listDataResponse;
    DoctorListAdapter doctorListAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentDoctorBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        restApi = APIClient.getAPIClient().create(APIInterface.class);
        binding.progressBar.setVisibility(View.VISIBLE);
        restApi.getData(Request.createAuthJsonString()).enqueue(new Callback<List<ListDataResponse>>() {
            @Override
            public void onResponse(Call<List<ListDataResponse>> call, Response<List<ListDataResponse>> response) {
                binding.progressBar.setVisibility(View.GONE);
                listDataResponse = response.body();
                doctorListAdapter = new DoctorListAdapter(listDataResponse, getContext());
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
                linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
                binding.recycleList.setLayoutManager(linearLayoutManager);
                binding.recycleList.setAdapter(doctorListAdapter);
            }

            @Override
            public void onFailure(Call<List<ListDataResponse>> call, Throwable t) {
                binding.progressBar.setVisibility(View.GONE);
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}