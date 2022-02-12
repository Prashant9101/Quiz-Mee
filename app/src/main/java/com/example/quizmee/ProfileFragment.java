package com.example.quizmee;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.quizmee.databinding.FragmentProfileBinding;
import com.example.quizmee.databinding.FragmentWalletBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

import static android.content.ContentValues.TAG;


public class ProfileFragment extends Fragment {

    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    FragmentProfileBinding binding;

    FirebaseFirestore database;
    user User;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding=FragmentProfileBinding.inflate(getLayoutInflater());



        binding.update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=binding.umail.getText().toString();
                String username=binding.uusername.getText().toString();
                String pass=binding.upass.getText().toString();
                DocumentReference documentReference=FirebaseFirestore.getInstance()
                        .collection("Users").document(FirebaseAuth.getInstance().getUid());

                Map<String ,Object> map=new HashMap<>();
                map.put("email",email);
                map.put("name",username);
                map.put("pass",pass);
                 documentReference.update(map)
                         .addOnSuccessListener(new OnSuccessListener<Void>() {
                             @Override
                             public void onSuccess(Void unused) {
                                 Toast.makeText(getActivity(), "Yay,Profile Updated", Toast.LENGTH_SHORT).show();
                                 binding.umail.setText("");
                                 binding.upass.setText("");
                                 binding.uusername.setText("");
                             }
                         })
                         .addOnFailureListener(new OnFailureListener() {
                             @Override
                             public void onFailure(@NonNull @NotNull Exception e) {
                                 Toast.makeText(getActivity(), "Upadte Failed", Toast.LENGTH_SHORT).show();
                             }
                         });




//                        .update("email",).addOnCompleteListener(new OnCompleteListener<Void>() {
//                    @Override
//                    public void onComplete(@NonNull @NotNull Task<Void> task) {
//                        if (task.isSuccessful()){
//                            Toast.makeText(getActivity(), "Value Updated", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                });

            }
        });


        return binding.getRoot();
    }




}