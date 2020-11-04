package com.debin.githubbrowser

import android.content.Context
import android.util.Log
import androidx.fragment.app.Fragment
import java.lang.ClassCastException

private const val TAG = "BaseFragment"

open class BaseFragment : Fragment() {

    var viewCommunicator: ViewCommunicator? = null

   interface ViewCommunicator {
       fun showProgress()
       fun hideProgress()
       fun hideKeyBoard()
   }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            viewCommunicator = getViewCommunicator(context)
        } catch (exception : ClassCastException) {
            Log.i(TAG, "$context must implement CommunicatorsInterface ")
        }

    }

   fun getViewCommunicator(context: Context)  = context as ViewCommunicator
}