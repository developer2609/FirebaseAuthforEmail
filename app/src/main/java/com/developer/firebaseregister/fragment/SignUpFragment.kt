package com.developer.firebaseregister.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.developer.firebaseregister.R
import com.developer.firebaseregister.databinding.ActivityMainBinding
import com.developer.firebaseregister.databinding.FragmentSignInBinding
import com.developer.firebaseregister.databinding.FragmentSignUpBinding
import com.google.firebase.auth.FirebaseAuth

class SignUpFragment : Fragment() {
   private lateinit var binding: FragmentSignUpBinding
   private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentSignUpBinding.inflate(layoutInflater)


        auth= FirebaseAuth.getInstance()

        binding.cardSecond.setOnClickListener {
            val email=binding.edtEmailLayout.text.toString()
            val password=binding.edtPassword.text.toString()
            val confirmPassword=binding.edtPasswordEt.text.toString()


            if (email.isNotEmpty() && password.isNotEmpty() && confirmPassword.isNotEmpty()){
                if (password==confirmPassword){
                    auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener {
                        if (it.isSuccessful){
                          findNavController().navigate(R.id.signInFragment)
                        }else{
                    Toast.makeText(requireContext(), it.exception.toString(), Toast.LENGTH_SHORT).show()

                        }
                    }

                }else{
                    Toast.makeText(requireContext(), "password error", Toast.LENGTH_SHORT).show()
                }
            }else{

                    Toast.makeText(requireContext(), "password error", Toast.LENGTH_SHORT).show()
            }
        }



        return binding.root
    }


}