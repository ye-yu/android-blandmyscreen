package ap.yeyu.blandmyscreen.ui

import android.content.ContentResolver
import android.provider.Settings
import android.widget.Switch

object ConfigurationEventHandlers {

    var targetState = ColorType.MONOCHROME
    lateinit var contentResolver: ContentResolver

    /**
     * from adb shell: pm grant your.package.name android.permission.WRITE_SECURE_SETTINGS
     * */
    private const val DALTONIZER_IS_ENABLED = "accessibility_display_daltonizer_enabled"

    /**
     * DISABLED = -1
     * MONOCHROMACY = 0
     * PROTANOMALY = 11
     * CORRECT_DEUTERANOMALY = 12
     * TRITANOMALY= 13
     * */
    private const val DALTONIZER_TYPE = "accessibility_display_daltonizer"

    fun initContentResolver(contentResolver: ContentResolver) {
        this.contentResolver = contentResolver
    }

    fun configureInstantBlandSwitch(switch: Switch) {
        switch.isChecked = Settings.Secure.getString(contentResolver, DALTONIZER_IS_ENABLED).equals("1", true)
        switch.setOnCheckedChangeListener { _, state ->
            if (state) {
                Settings.Secure.putString(contentResolver, DALTONIZER_IS_ENABLED, "1")
                Settings.Secure.putString(contentResolver, DALTONIZER_TYPE, targetState.value.toString())
            } else {
                Settings.Secure.putString(contentResolver, DALTONIZER_IS_ENABLED, "0")
                Settings.Secure.putString(contentResolver, DALTONIZER_TYPE, ColorType.DISABLED.value.toString())
            }
        }
    }

    enum class ColorType(val value: Int) {
        DISABLED(-1),
        MONOCHROME(0),
        PROTANOMALY(11),
        DEUTERANOMALY(12),
        TRITANOMALY(13)
    }
}