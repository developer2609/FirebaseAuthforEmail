package com.developer.firebaseregister

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.developer.firebaseregister.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthProvider

class MainActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private val TAG = "Mainactivity"
    lateinit var storedVerificationId:String
    lateinit var resendToken: PhoneAuthProvider.ForceResendingToken
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        auth= FirebaseAuth.getInstance()



    }
}