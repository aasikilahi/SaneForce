package com.example.saneforceapplication.ui.map;

import android.location.Location;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.saneforceapplication.R;
import com.example.saneforceapplication.api.APIClient;
import com.example.saneforceapplication.api.APIInterface;
import com.example.saneforceapplication.api.ListDataResponse;
import com.example.saneforceapplication.api.Request;
import com.example.saneforceapplication.databinding.FragmentMapBinding;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MapFragment extends Fragment implements OnMapReadyCallback {

    public GoogleMap mMap;
    public ArrayList<LatLng> locationArrayList;
    Location location;
    SupportMapFragment supportMapFragment;
    APIInterface restApi;
    List<ListDataResponse> listDataResponse;
    LatLng position;
    View root;
    private FragmentMapBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        try {
            binding = FragmentMapBinding.inflate(inflater, container, false);
            root = binding.getRoot();
            restApi = APIClient.getAPIClient().create(APIInterface.class);

//            supportMapFragment = (SupportMapFragment) getActivity().getSupportFragmentManager().findFragmentById(R.id.map);
//            supportMapFragment.getMapAsync((OnMapReadyCallback) getContext());

        } catch (Exception e) {

        }
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng myPos = new LatLng(location.getLatitude(), location.getLongitude());
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(myPos));
        restApi.getData(Request.createAuthJsonString()).enqueue(new Callback<List<ListDataResponse>>() {
            @Override
            public void onResponse(Call<List<ListDataResponse>> call, Response<List<ListDataResponse>> response) {
                listDataResponse = response.body();
                for (int i = 0; i < listDataResponse.size(); i++) {
                    position = new LatLng(Location.convert(listDataResponse.get(i).getLat()), Location.convert(listDataResponse.get(1).getLong()));
                    locationArrayList.add(position);
                    mMap.addMarker(new MarkerOptions().position(locationArrayList.get(i)).title(listDataResponse.get(i).getName()));
                }
            }

            @Override
            public void onFailure(Call<List<ListDataResponse>> call, Throwable t) {

            }
        });

    }
}