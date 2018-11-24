package co.vladanjovanovic.kroontask.ui

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import co.vladanjovanovic.kroontask.R
import dagger.android.support.DaggerAppCompatActivity

class HomeActivity : DaggerAppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        navController = Navigation.findNavController(this, R.id.nav_fragment)
    }
}
