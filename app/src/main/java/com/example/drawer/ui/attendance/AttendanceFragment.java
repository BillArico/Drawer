package com.example.drawer.ui.attendance;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.drawer.R;
import com.example.drawer.databinding.FragmentAttendanceBinding;
import com.example.drawer.databinding.FragmentHomeBinding;

public class AttendanceFragment extends Fragment {

    private AttendanceViewModel attendanceViewModel;
    private FragmentAttendanceBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        attendanceViewModel =
                new ViewModelProvider(this).get(AttendanceViewModel.class);

        binding = FragmentAttendanceBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textAttendance;
        attendanceViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
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