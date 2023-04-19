package com.developer.firebaseregister.fragment

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.developer.firebaseregister.R
import com.google.firebase.auth.FirebaseAuth

class BlankFragment : Fragment() {


    private lateinit var auth: FirebaseAuth
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        auth= FirebaseAuth.getInstance()


         Handler(Looper.getMainLooper()).postDelayed({
             val user=auth.uid

             if (user!=null){


                 findNavController().navigate(R.id.signInFragment)



             }else{

                findNavController().navigate(R.id.signInFragment)



             }
         },10000)



        return inflater.inflate(R.layout.fragment_blank, container, false)
    }
//

}