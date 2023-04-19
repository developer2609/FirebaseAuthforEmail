package com.developer.firebaseregister.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.developer.firebaseregister.R
import com.developer.firebaseregister.databinding.FragmentSignInBinding
import com.google.firebase.auth.FirebaseAuth

class SignInFragment : Fragment() {
    private lateinit var binding: FragmentSignInBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentSignInBinding.inflate(layoutInflater)

        auth= FirebaseAuth.getInstance()


        binding.signUp.setOnClickListener {
            findNavController().navigate(R.id.signUpFragment)
        }

             binding.btnLogin.setOnClickListener {
                 val email=binding.edtUserName.text.toString()
                 val password=binding.editPasswort.text.toString()


                 if (email.isNotEmpty() && password.isNotEmpty()){
                     auth.signInWithEmailAndPassword(email,password).addOnCompleteListener {
                         if (it.isSuccessful){
                          findNavController().navigate(R.id.blankFragment)

                             binding.editPasswort.text.clear()
                             binding.edtUserName.text.clear()
                         }else{
                             Toast.makeText(requireContext(), "passwor or email error", Toast.LENGTH_SHORT).show()
                         }

                         }
                     }else{

                             Toast.makeText(requireContext(), "passwor or email error", Toast.LENGTH_SHORT).show()
                 }
                 }











        return binding.root
    }

}