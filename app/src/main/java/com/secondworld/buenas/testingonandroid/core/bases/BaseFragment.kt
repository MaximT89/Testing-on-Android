package com.secondworld.buenas.testingonandroid.core.bases

import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.annotation.StringRes
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import com.google.android.material.snackbar.Snackbar
import com.secondworld.buenas.testingonandroid.R
import com.secondworld.buenas.testingonandroid.core.extension.log
import com.secondworld.buenas.testingonandroid.core.navigation.BackNavigationUi
import com.secondworld.buenas.testingonandroid.core.navigation.Navigator
import java.lang.IllegalArgumentException
import kotlin.reflect.full.isSubclassOf

typealias Inflate<T> = (LayoutInflater, ViewGroup?, Boolean) -> T

abstract class BaseFragment<B : ViewBinding, VM : ViewModel>(private val inflate: Inflate<B>) :
    Fragment(), Navigator, BackNavigationUi {

    private var _viewBinding: B? = null
    protected val binding get() = checkNotNull(_viewBinding)
    protected abstract val viewModel: VM
    protected var toolbar: Toolbar? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _viewBinding = inflate.invoke(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        toolbar = activity?.findViewById(R.id.toolbar)
        toolbar?.title = title()

        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(showBack())

        toolbar?.setNavigationOnClickListener { requireActivity().onBackPressed() }

        initView()
        listenerBundleArguments()
        initObservers()
        initCallbacks()
    }

    open fun customBackPressed(
        needCheck: Boolean = false,
        successBack: () -> Unit = {},
        cancelBack: () -> Unit = {}
    ) {
        requireActivity()
            .onBackPressedDispatcher
            .addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    if (needCheck) {
                        alertDialog(
                            positive = {
                                log("positive")
                                if (isEnabled) {
                                    isEnabled = false
                                    requireActivity().onBackPressed()
                                    successBack.invoke()
                                }
                            },
                            negative = {
                                log("negative")
                                cancelBack.invoke()
                            })
                    } else {
                        if (isEnabled) {
                            isEnabled = false
                            requireActivity().onBackPressed()
                        }
                    }
                }
            })
    }

    fun alertDialog(positive: () -> Unit = {}, negative: () -> Unit = {}) {
        val builder = AlertDialog.Builder(requireActivity())
        builder.setTitle("Предупреждение")
        builder.setMessage("Вы уверены что хотите закончить тестирование")
        builder.setPositiveButton("Да") { _, _ -> positive.invoke() }
        builder.setNegativeButton("Нет") { _, _ -> negative.invoke() }
        builder.show()
    }

    /**
     * На всех экранах отображаем кнопку назад, кроме стартового экрана
     */
    override fun showBack(): Boolean {
        return true
    }

    /**
     * На каждом фрагменте обязательно нужно переопределить title, который отображается в actionBar
     */
    abstract fun title(): String

    inline fun <reified T> readArguments(
        key: String,
        ifExist: (data: T) -> Unit = {},
        notExist: () -> Unit = {},
    ) {
        if (arguments?.get(key) != null) {

            val data = if (T::class.isSubclassOf(Parcelable::class)) {
                arguments?.getParcelable(key)
            } else {
                when (T::class) {
                    Boolean::class -> arguments?.getBoolean(key)
                    Int::class -> arguments?.getInt(key)
                    String::class -> arguments?.getString(key)
                    Long::class -> arguments?.getLong(key)
                    Short::class -> arguments?.getShort(key)
                    else -> throw IllegalArgumentException("readArguments unknown argument")
                }
            }

            ifExist.invoke(data as T)
            arguments?.remove(key)
        } else {
            notExist.invoke()
        }
    }

    fun readResultAndShowSnackbar(
        result: Boolean,
        positiveMess: String,
        negativeMess: String,
        positiveResult: () -> Unit = {},
        negativeResult: () -> Unit = {},
    ) {
        if (result) {
            positiveResult.invoke()
            showSnackbar(positiveMess)
        } else {
            negativeResult.invoke()
            showSnackbar(negativeMess)
        }
    }

    open fun listenerBundleArguments() = Unit
    open fun initCallbacks() = Unit

    abstract fun initView(): Unit?
    abstract fun initObservers()

    fun showSnackbar(message: String) {
        Snackbar.make(requireActivity(), binding.root, message, Snackbar.LENGTH_LONG).show()
    }

    fun string(@StringRes id: Int) = requireActivity().getString(id)

    override fun navigateTo(resId: Int, args: Bundle?, navOptions: NavOptions?) =
        findNavController().navigate(resId, args, navOptions)

    override fun navigateTo(resId: Int, args: Bundle?) = findNavController().navigate(resId, args)

    override fun navigateTo(resId: Int) = findNavController().navigate(resId)

    protected infix fun <T> LiveData<T>.observe(block: (T) -> Unit) {
        observe(this@BaseFragment.viewLifecycleOwner) { t -> block.invoke(t) }
    }

    override fun onDestroy() {
        super.onDestroy()
        _viewBinding = null
    }
}