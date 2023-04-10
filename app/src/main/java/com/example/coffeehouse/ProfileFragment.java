package com.example.coffeehouse;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


public class ProfileFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        RecyclerView profileList = requireActivity().findViewById(R.id.rv_profile_fragment);
        profileList.setLayoutManager(new GridLayoutManager(getActivity(), 1));

        ProfileSettings userProfile = new ProfileSettings("ikrom.hasanbav.27@gmail.ocm");
        userProfile.setPhoneNumber("+796529145");
        userProfile.setName("Икром");
        userProfile.setAddress("Проспект мира, дом 18");

        ProfileListAdapter profileListAdapter = new ProfileListAdapter(userProfile);

        profileList.setAdapter(profileListAdapter);
    }

    public static class ProfileListAdapter extends
            RecyclerView.Adapter<ProfileListAdapter.ViewHolder> {
        private final ProfileSettings profileSettings;

        public ProfileListAdapter(ProfileSettings profileSettings){
            this.profileSettings = profileSettings;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_profile, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            switch (position) {
                case 0:
                    drawName(holder, profileSettings);
                    break;
                case 1:
                    drawPhoneNumber(holder, profileSettings);
                    break;
                case 2:
                    drawEmail(holder, profileSettings);
                    break;
                case 3:
                    drawAddress(holder, profileSettings);
                    break;
            }
        }

        @Override
        public int getItemCount() {
            return 4;
        }

        private void drawName(@NonNull ViewHolder holder, ProfileSettings profile){
            holder.title.setText(R.string.title_name);
            holder.itemIcon.setImageResource(R.drawable.ic_profile);
            holder.description.setText(profile.getName());
        }

        private void drawPhoneNumber(@NonNull ViewHolder holder, ProfileSettings profile){
            holder.title.setText(R.string.title_phone_number);
            holder.itemIcon.setImageResource(R.drawable.ic_phone);
            holder.description.setText(profile.getPhoneNumber());
        }

        private void drawEmail(@NonNull ViewHolder holder, ProfileSettings profile){
            holder.title.setText(R.string.title_email);
            holder.itemIcon.setImageResource(R.drawable.ic_email);
            holder.description.setText(profile.getEmail());
        }

        private void drawAddress(@NonNull ViewHolder holder, ProfileSettings profile){
            holder.title.setText(R.string.title_address);
            holder.itemIcon.setImageResource(R.drawable.ic_address);
            holder.description.setText(profile.getAddress());
        }

        public static class ViewHolder extends RecyclerView.ViewHolder {
            public ImageView itemIcon;
            public TextView title;
            public TextView description;
            public ImageButton editIcon;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                itemIcon = itemView.findViewById(R.id.bg_icon_profile);
                title = itemView.findViewById(R.id.item_profile_title);
                description = itemView.findViewById(R.id.item_profile_description);
                editIcon = itemView.findViewById(R.id.item_profile_edit);
            }
        }
    }
}