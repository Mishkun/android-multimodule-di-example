package com.example.feature1.api

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.core.findDependencies
import com.example.feature1.R
import com.example.feature1.internal.di.Feature1ComponentImpl

class Feature1Fragment : Fragment() {

    private lateinit var logger: Feature1Logger

    private lateinit var captionProvider: Feature1CaptionProvider

    private var caption: TextView? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)

        val component = Feature1ComponentImpl(findDependencies())
        logger = component.feature1Logger
        captionProvider = component.feature1CaptionProvider
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.feature1_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val root = view as ViewGroup
        caption = root.findViewById<TextView>(R.id.feature1_text).apply {
            text = captionProvider.caption.also {
                logger.log("Feature1 created with caption $it")
            }
        }

        root.findViewById<View>(R.id.feature1_update_caption).setOnClickListener {
            caption?.text = captionProvider.caption
        }

        root.findViewById<View>(R.id.feature1_crash).setOnClickListener {
            AlertDialog.Builder(activity)
                .setTitle("This will crash app")
                .setMessage("We'll try to find obviously unavailable Dependencies in parents hierarchy so app will crash. See log in Logcat.")
                .setPositiveButton("OK") { _, _ -> findDependencies<UnavailableDependencies>() }
                .setNegativeButton("CANCEL") { dialog, _ -> dialog.dismiss() }
                .create()
                .show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        caption = null
    }
}

internal class UnavailableDependencies
