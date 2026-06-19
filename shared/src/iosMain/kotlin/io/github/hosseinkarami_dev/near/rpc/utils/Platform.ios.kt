package io.github.hosseinkarami_dev.near.rpc.utils

import platform.UIKit.UIAlertAction
import platform.UIKit.UIAlertActionStyle
import platform.UIKit.UIAlertController
import platform.UIKit.UIAlertControllerStyle
import platform.UIKit.UIApplication

actual fun isAndroid() = false
actual fun isIos() = true
actual fun isDynamicColorSupported() = false

actual fun showPlatformMessage(message: String, cancelMessage: String) {
    val alert = UIAlertController.alertControllerWithTitle(
        title = null, message = message, preferredStyle = UIAlertControllerStyle.MIN_VALUE
    )

    alert.addAction(
        UIAlertAction.actionWithTitle(
            cancelMessage, UIAlertActionStyle.MIN_VALUE, null
        )
    )

    UIApplication.sharedApplication.keyWindow?.rootViewController?.presentViewController(
        alert, animated = true, completion = null
    )
}