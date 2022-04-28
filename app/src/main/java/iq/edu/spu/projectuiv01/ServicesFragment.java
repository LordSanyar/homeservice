package iq.edu.spu.projectuiv01;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ServicesFragment extends Fragment {
    ImageButton maintenanceImageButton, renovationRestorationImageButton;

    public ServicesFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_services, container, false);
        initViews(view);
        maintenanceImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent categoriesIntent = new Intent(getContext(), ServicesCategoriesActivity.class);
                startActivity(categoriesIntent);
            }
        });
        renovationRestorationImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent categoriesIntent = new Intent(getContext(), ServicesCategoriesActivity.class);
                startActivity(categoriesIntent);
            }
        });
        return view;
    }

    private void initViews(View view) {
        maintenanceImageButton = view.findViewById(R.id.services_maintenance_image_button);
        renovationRestorationImageButton = view.findViewById(R.id.services_restoration_renovation_image_button);
    }
}
