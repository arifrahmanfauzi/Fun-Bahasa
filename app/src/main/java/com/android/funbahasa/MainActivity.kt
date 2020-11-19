package com.android.funbahasa

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentContainer
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.FragmentNavigator
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.android.funbahasa.dashboard.DashboardFragment
import com.android.funbahasa.saved.SavedFragment
import com.android.funbahasa.liked.LikedFragment
import com.android.funbahasa.profile.ProfileFragment
import com.bumptech.glide.Glide
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.mikhaellopez.circularimageview.CircularImageView
//import kotlinx.android.synthetic.main.activity_dashboard.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.dashboard_fragment.*
import kotlinx.android.synthetic.main.profile_fragment.*

class MainActivity : AppCompatActivity() {
    private val fragmentDashboard = DashboardFragment()
    private val fragmentSaved = SavedFragment()
    private val likedFragment = LikedFragment()
    private val profileFragment = ProfileFragment()

    private lateinit var communicator: Communicator
    private lateinit var mAauth:FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /* Bottom Navigation */
        val navView:BottomNavigationView = findViewById(R.id.bottomnav)
//        val navController = findNavController(R.id.nav_host_fragment)
//        val appBarConfiguration = AppBarConfiguration(setOf(
//            R.id.navigation_dashboard, R.id.navigation_saved, R.id.navigation_liked, R.id.navigation_profile
//        ))
//        navView.setupWithNavController(navController)

//        setupActionBarWithNavController(navController,appBarConfiguration)

//        bottomnav.setOnNavigationItemSelectedListener{
//            when(it.itemId){
//                R.id.fragment_dashboard -> {
//                    Toast.makeText(this, "Home selected"+R.id.fragment_dashboard, Toast.LENGTH_SHORT).show()}
//                R.id.navigation_saved -> {  Toast.makeText(this, "Home selected"+R.id.fragment_dashboard, Toast.LENGTH_SHORT).show();replaceFragment(fragmentSaved); return@setOnNavigationItemSelectedListener true}
//                R.id.navigation_liked -> {  Toast.makeText(this, "Home selected"+R.id.fragment_dashboard, Toast.LENGTH_SHORT).show(); replaceFragment(likedFragment); return@setOnNavigationItemSelectedListener true}
//                R.id.navigation_profile -> {  Toast.makeText(this, "Home selected"+R.id.fragment_dashboard, Toast.LENGTH_SHORT).show(); replaceFragment(profileFragment); return@setOnNavigationItemSelectedListener true}
//            }
//            false
//        }

        bottomnav.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.navigation_dashboard -> replaceFragment(fragmentDashboard)
                R.id.navigation_saved -> replaceFragment(fragmentSaved)
                R.id.navigation_liked -> replaceFragment(likedFragment)
                R.id.navigation_profile -> replaceFragment(profileFragment)
            }
                true
        }
        replaceFragment(fragmentDashboard)
        /* End Bottom Navigation */

        mAauth = FirebaseAuth.getInstance()
        var user_name = findViewById<TextView>(R.id.user_name)
        var signOut = findViewById<Button>(R.id.button_signout)
        var sign_out = findViewById<ImageButton>(R.id.signout)
        var image_profile = findViewById<CircularImageView>(R.id.image_profile)
        val user = mAauth.currentUser   //get google user
        val currentUser = mAauth.currentUser

        val bundle = Bundle()
        var name = currentUser?.displayName

//        bundle.putString("message", textView.text.toString())
        bundle.putString("message", name)
//        passDataCom(currentUser?.displayName.toString())
//        id_google.text = currentUser?.uid
//        email.text = currentUser?.email
//        user_name.text = currentUser?.displayName
//        Glide.with(this).load(currentUser?.photoUrl).into(image_profile)
        //handling Logic user empty or not

        Handler().postDelayed({
            if (user == null){
                val loginIntent = Intent(this, LoginActivity::class.java)
                startActivity(loginIntent)
                finish()
            }
        },2000)

//        signOut.setOnClickListener {
//            mAauth.signOut()
//            logout()
//            val loginIntent = Intent(this, LoginActivity::class.java)
//            startActivity(loginIntent)
//            finish()
//        }
//        signout.setOnClickListener {
//            mAauth.signOut()
//            logout()
//            val loginIntent = Intent(this, LoginActivity::class.java)
//            startActivity(loginIntent)
//            finish()
//        }
    }

    /**
     *
     * @param fragment Fragment
     */
    private fun replaceFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.nav_host_fragment, fragment)
        fragmentTransaction.commit()
    }
    private fun logout() {
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        val googleSignInClient = GoogleSignIn.getClient(this, gso)
        googleSignInClient.signOut()
    }

//    override fun passDataCom(string: String) {
//        val bundle = Bundle()
//
////        bundle.putString("message", textView.text.toString())
//        bundle.putString("message", string)
//        val transaction = this.supportFragmentManager.beginTransaction()
//        fragmentDashboard.arguments = bundle
//
//
//        transaction.replace(R.id.nav_host_fragment, fragmentDashboard)
//        transaction.commit()
//    }
}