package com.example.saneforceapplication.ui.doctorlist.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.saneforceapplication.api.ListDataResponse;
import com.example.saneforceapplication.databinding.AdapterDoctorListBinding;

import java.util.List;

public class DoctorListAdapter extends RecyclerView.Adapter<DoctorListAdapter.DoctorListViewHolder> {
    List<ListDataResponse> listDataResponses;
    Context context;

    public DoctorListAdapter(List<ListDataResponse> listDataResponses, Context context) {
        this.listDataResponses = listDataResponses;
        this.context = context;
    }


    @NonNull
    @Override
    public DoctorListAdapter.DoctorListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        AdapterDoctorListBinding binding = AdapterDoctorListBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new DoctorListViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull DoctorListAdapter.DoctorListViewHolder holder, int position) {
        holder.binding.category.setText(listDataResponses.get(position).getCategory());
        holder.binding.name.setText(listDataResponses.get(position).getName());
        holder.binding.mobile.setText(listDataResponses.get(position).getMobile());
        holder.binding.townCode.setText(listDataResponses.get(position).getTownCode());
        holder.binding.speciality.setText(listDataResponses.get(position).getSpecialty());
        holder.binding.drDesign.setText(listDataResponses.get(position).getDrDesig());
        holder.binding.address.setText(listDataResponses.get(position).getHosAddr());
    }

    @Override
    public int getItemCount() {
        return listDataResponses.size();
    }

    public class DoctorListViewHolder extends RecyclerView.ViewHolder {
        AdapterDoctorListBinding binding;

        public DoctorListViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = AdapterDoctorListBinding.bind(itemView);
        }
    }
}
