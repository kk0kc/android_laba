package com.example.androidlab
import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.androidlab.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null

    private val permission = registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
        if (isGranted) {
            launcher.launch(null)
        } else {
            if (!shouldShowRequestPermissionRationale(Manifest.permission.CAMERA)) {
                openSettings()
            }
        }
    }

    private val launcher = registerForActivityResult(PickImage(this)) { result ->
        binding?.iv?.setImageBitmap(result)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }

        binding?.run {
            btn.setOnClickListener {
                permission.launch(Manifest.permission.CAMERA)
            }
        }
    }

    private fun openSettings() {
        val appSettingsIntent = Intent(
            Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
            Uri.fromParts("package", packageName, null)
        )

        if (packageManager.resolveActivity(appSettingsIntent, PackageManager.MATCH_DEFAULT_ONLY) == null) {
            Toast.makeText(this, "Доступ к камере запрещен", Toast.LENGTH_LONG).show()
        } else {
            binding?.run {
                Snackbar.make(
                    root.rootView,
                    "Нет доступа к камере и галерее",
                    Snackbar.LENGTH_LONG
                )
                    .setAction(
                        "Открыть настройки"
                    ) {
                        startActivity(appSettingsIntent)
                    }
                    .show()
            }
        }
    }
}