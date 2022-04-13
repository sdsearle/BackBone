/**
 * Created by Spencer Searle on 4/1/22.
 */

package com.zol.backbone.fragments

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.util.TypedValue
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.setMargins
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.google.android.material.snackbar.Snackbar
import com.zol.backbone.viewmodels.BaseViewModel
import javax.inject.Inject
import com.zol.backbone.BR

abstract class MVVMFragment<B : ViewDataBinding, VM : BaseViewModel> : BaseFragment() {

    /*
     * Workaround for R8 tripping over MVVMActivity_MembersInjector not being in common-ui module and
     * instead being in middle modules
     */
    @Suppress("LateinitVarOverridesLateinitVar")
    @Inject
    override lateinit var appContext: Context

    protected abstract val layoutID: Int
    protected lateinit var binding: B
    protected lateinit var viewModel: VM

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        super.onCreateView(inflater, container, savedInstanceState)

        binding = DataBindingUtil.inflate(inflater, layoutID, container, false)

        if (this::viewModel.isInitialized){
            binding.lifecycleOwner = this

            binding.setVariable(BR.vm, viewModel)

            return binding.root
        }

        return null
    }
}