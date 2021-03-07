package com.bitingbit.news.mobileapp.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bitingbit.news.mobileapp.R


class UserProfileFragment : Fragment() {
    companion object {
        fun newInstance(message: String): UserProfileFragment {

            val f = UserProfileFragment()
            val bdl = Bundle(1)

            bdl.putString(EXTRA_MESSAGE, message)
            f.setArguments(bdl)

            return f
        }
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

    @SuppressLint("UseRequireInsteadOfGet")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view: View? = inflater.inflate(R.layout.user_profile, container, false);

        val message = requireArguments().getString(EXTRA_MESSAGE)

        var userProfileView: TextView = view!!.findViewById(R.id.userprofile)
        userProfileView.setText(Html.fromHtml(message))

        return view
    }

}