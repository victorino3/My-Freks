package com.vicvilian.schoolagenda.ui.About;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vicvilian.schoolagenda.R;

import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AboutFragment #newInstance} factory method to
 * create an instance of this fragment.
 */
public class AboutFragment extends Fragment {

    public AboutFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        String description = "This app was build by Victorino Gomes as school project the big goal" +
                "of this application is to help students to have continuously alert to submit their project " +
                "before the limit time and have more responsibility about yours task or project ";
        Element version = new Element();
        version.setTitle("version 1.0");
        return new AboutPage(getActivity())
                .setDescription(description)
                .addGroup("Get in Touch")
                .addEmail("victorinogomes1@gmail.com","Send a email")
                .addGroup("Social Media")
                .addInstagram("gomes_victorino","Instagram")
                .addFacebook("Victorino Josue J. Gomes","Facebook")
                .addGitHub("victorino3","GitHub")
                .addItem(version)
                .create();
    }
}