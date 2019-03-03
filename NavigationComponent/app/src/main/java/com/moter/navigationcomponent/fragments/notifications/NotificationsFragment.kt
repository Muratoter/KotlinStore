package com.moter.navigationcomponent.fragments.notifications


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController

import com.moter.navigationcomponent.R
import kotlinx.android.synthetic.main.fragment_notifications.*


class NotificationsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_notifications, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        btnNotificationDetail.setOnClickListener {
            val navController=view.findNavController()
            navController.navigate(R.id.action_notificationsFragment_to_notificationDetailFragment)
        }
    }

}
