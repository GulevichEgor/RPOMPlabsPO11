package com.example.mynotes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.fragment.app.Fragment;

public class FragmentAdd extends Fragment {

    private NotesDatabaseHelper dbHelper;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add, container, false);
        EditText editTextDescription = view.findViewById(R.id.editTextDescription);
        Button buttonAdd = view.findViewById(R.id.buttonAdd);
        dbHelper = new NotesDatabaseHelper(getContext());

        buttonAdd.setOnClickListener(v -> {
            String description = editTextDescription.getText().toString();
            if (!description.isEmpty()) {
                dbHelper.addNote(description);
                editTextDescription.setText("");
            }
        });
        return view;
    }
}