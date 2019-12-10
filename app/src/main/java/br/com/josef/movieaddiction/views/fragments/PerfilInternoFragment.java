package br.com.josef.movieaddiction.views.fragments;


import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.io.InputStream;

import br.com.josef.movieaddiction.R;
import br.com.josef.movieaddiction.vielmodel.FavoritoViewModel;
import de.hdodenhof.circleimageview.CircleImageView;
import pl.aprilapps.easyphotopicker.EasyImage;

//import org.jetbrains.annotations.NotNull;
// TODO: 07/12/2019  KOTLIN

/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilInternoFragment extends Fragment {

    private static final int PERMISSION_CODE = 100;
    private CircleImageView imageViewProfile;
    private EasyImage easyImage;
    private FirebaseUser user;
    private TextView nomeUser;
    private TextView emailUser;
    private TextView contadorFavoritos;
    private int totalKeyInt;
    private String totalKeyString;
    private FavoritoViewModel viewModel;




    public PerfilInternoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_perfil_interno, container, false);

//        nome = view.findViewById(R.id.);
        nomeUser = view.findViewById(R.id.tv_fragment_perfil_nome_usuario_id);
        emailUser = view.findViewById(R.id.tv_fragment_perfil_email_usuario_id);
//        todo:fazer essa logica
        contadorFavoritos = view.findViewById(R.id.tv_fragment_perfil_qtd_filmes_favoritados_id);
        imageViewProfile = view.findViewById(R.id.item_foto_profile_id);
        viewModel = ViewModelProviders.of(this).get(FavoritoViewModel.class);

        //pegandoContagemLista();
        mostrandoContagemLista();

        user = FirebaseAuth.getInstance().getCurrentUser();

        if (user != null) {
            //nomeUser.setText("Olá " +  user.getDisplayName() + "!");
            nomeUser.setText("Olá Movie Addicted!");
            emailUser.setText(user.getEmail());}

        //  imageViewProfile.setImageURI(user.getPhotoUrl());

        imageViewProfile.setOnClickListener(v -> {


            int permissionCamera = ContextCompat
                    .checkSelfPermission(getContext(), Manifest.permission.CAMERA);

            int permissionStorage = ContextCompat
                    .checkSelfPermission(getContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE);

            if (permissionCamera == PackageManager.PERMISSION_GRANTED && permissionStorage == PackageManager.PERMISSION_GRANTED) {
                easyImage = new EasyImage.Builder(getContext()).build();
                easyImage.openCameraForImage(this);
            } else {
                ActivityCompat.requestPermissions(getActivity(),
                        new String[]{
                                Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        PERMISSION_CODE);


            }
        });
        return view;

    }

//    private void pegandoContagemLista() {
//        Bundle bundle = this.getArguments();
//        if (bundle != null) {
//            totalKeyInt = bundle.getInt(TOTAL_KEY);
//        }
//    }

    private void mostrandoContagemLista() {


        viewModel.contaFilme();
        viewModel.getFilmeCont().observe(this, integer -> {
                    totalKeyInt = integer;
            totalKeyString = Integer.toString(totalKeyInt);
            if(totalKeyInt == 1){
            contadorFavoritos.setText("Você tem " + totalKeyString + " filme favoritado!");
                } else {
                contadorFavoritos.setText("Você tem " + totalKeyString + " filmes favoritados!");
            }

            }

        );


    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == PERMISSION_CODE) {
            easyImage.openCameraForImage(this);
        }
    }


//    @Override
//    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        easyImage.handleActivityResult(requestCode, resultCode, data, getActivity(), new DefaultCallback() {
//            @Override
//            public void onMediaFilesPicked(@NotNull MediaFile[] mediaFiles, @NotNull MediaSource mediaSource) {
//                for (MediaFile mediaFile : mediaFiles){
//                    try {
//                        InputStream stream = new FileInputStream(mediaFile.getFile());
//                        salvarImageFirebase(stream);
//                    } catch (FileNotFoundException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//
//            @Override
//            public void onCanceled(@NotNull MediaSource source) {
//                super.onCanceled(source);
//            }
//
//            @Override
//            public void onImagePickerError(@NotNull Throwable error, @NotNull MediaSource source) {
//                super.onImagePickerError(error, source);
//                Toast.makeText(getContext(),"Ocorreu um erro ao carregar a foto",Toast.LENGTH_LONG).show();
//            }
//        });
//    }


    private void salvarImageFirebase(InputStream stream) {
        StorageReference storage = FirebaseStorage
                .getInstance()
                .getReference()
                .child(user.getUid() + "/image/profile");

        UploadTask uploadTask = storage.putStream(stream);

        uploadTask.addOnCompleteListener(task -> {

            if (task.isSuccessful()) {
                storage.getDownloadUrl()
                        .addOnSuccessListener(uri -> {
                            Picasso.get()
                                    .load(uri)
                                    .rotate(90)
                                    .into(imageViewProfile);
                        });
            }
        });
    }

}