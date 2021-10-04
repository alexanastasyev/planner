package app.alexanastasyev.planner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.content.ContextCompat
import androidx.navigation.findNavController
import app.alexanastasyev.planner.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var toggle: ActionBarDrawerToggle
    private lateinit var binding: ActivityMainBinding

    fun setActionBarTitle(title: String) {
        supportActionBar?.title = title
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        configureMenu()
        configureActionBar()
    }

    private fun configureMenu() {
        toggle = ActionBarDrawerToggle(this, binding.drawerLayout, R.string.open, R.string.close)
        toggle.drawerArrowDrawable.color = ContextCompat.getColor(applicationContext, R.color.brown_grey)
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setOnMenuItemClickListener()
    }

    private fun configureActionBar() {

    }

    private fun setOnMenuItemClickListener() {
        binding.navView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.menuItemCreateNote -> openCreateNoteScreen()
                R.id.menuItemHome -> openHomeScreen()
            }
            true
        }
    }

    private fun openHomeScreen() {
        binding.navHostFragment.findNavController().popBackStack()
        binding.navHostFragment.findNavController().navigate(R.id.homeScreen)
        hideMenu()
    }

    private fun openCreateNoteScreen() {
        binding.navHostFragment.findNavController().popBackStack()
        binding.navHostFragment.findNavController().navigate(R.id.createNoteScreen)
        hideMenu()
    }

    private fun hideMenu() {
        binding.drawerLayout.closeDrawers()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}