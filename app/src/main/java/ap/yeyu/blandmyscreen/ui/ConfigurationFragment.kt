package ap.yeyu.blandmyscreen.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ap.yeyu.blandmyscreen.R

object ConfigurationFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val root = inflater.inflate(R.layout.configuration_page, container, false)
        bindWidgets(root)
        return root
    }

    private fun bindWidgets(root: View) {
        ConfigurationEventHandlers.configureInstantBlandSwitch(
            root.findViewById(
                ConfigurationViews.INSTANT_BLAND_BUTTON
            )
        )
    }
}