/**
 * Created by Spencer Searle on 4/1/22.
 */

package com.zol.backbone.fragments

import android.os.Bundle
import com.zol.backbone.R
import com.zol.backbone.databinding.FragmentHelloBinding
import com.zol.backbone.viewmodels.BaseViewModel
import com.zol.backbone.viewmodels.HelloViewModel
import timber.log.Timber

class HelloFragment() :
    MVVMFragment<FragmentHelloBinding, HelloViewModel>() {
    override val layoutID: Int = R.layout.fragment_hello

        companion object{
            const val tag = "HelloFragment"
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.d("ZOL Fragment Created")
        viewModel = HelloViewModel()
    }
}