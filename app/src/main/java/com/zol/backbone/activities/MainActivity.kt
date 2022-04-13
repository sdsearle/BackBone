package com.zol.backbone.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil.setContentView
import androidx.fragment.app.*
import androidx.navigation.fragment.NavHostFragment
import com.smartrent.common.ui.extension.replace
import com.zol.backbone.R
import com.zol.backbone.coordinator.FragmentCoordinator
import com.zol.backbone.databinding.ActivityMainBinding
import com.zol.backbone.fragments.ExampleFragment
import com.zol.backbone.fragments.HelloFragment
import com.zol.backbone.viewmodels.BaseViewModel
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : MVVMActivity<ActivityMainBinding, BaseViewModel>() {

    @Inject
    lateinit var fragmentCoordinator: FragmentCoordinator

    override val layoutID: Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*supportFragmentManager.registerFragmentLifecycleCallbacks(object :
                                                                      FragmentManager.FragmentLifecycleCallbacks() {
            override fun onFragmentResumed(
                fm: FragmentManager,
                f: Fragment
            ) {
                super.onFragmentResumed(fm, f)
                Timber.d("ZOL nav Controller start")
                if (f is NavHostFragment && f.navController.currentDestination?.label == HelloFragment.tag) {
                    fragmentCoordinator.start((f as NavHostFragment).navController, null)
                }

            }
        }, true)*/


    }

    override fun onResume() {
        super.onResume()
        val fragment = NavHostFragment.create(R.navigation.navigation_fragment)

        Timber.d("ZOL Fragment replacing")
        supportFragmentManager.replace(
            R.id.content,
            false,
            HelloFragment.tag,
            R.anim.anim_enter_rtl,
            R.anim.anim_exit_rtl,
            R.anim.anim_enter_ltr,
            R.anim.anim_exit_ltr
        ) {
            fragment
        }
    }

}