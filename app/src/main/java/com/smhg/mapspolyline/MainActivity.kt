package com.smhg.mapspolyline

import android.os.Bundle
import android.widget.Toast
import com.smhg.mapspolyline.databinding.ActivityMainBinding
import com.smhg.mapspolyline.manager.LocationManager
import com.smhg.mapspolyline.utils.BaseActivityBinding
import com.smhg.mapspolyline.utils.intentTo
import pub.devrel.easypermissions.AfterPermissionGranted
import pub.devrel.easypermissions.EasyPermissions

class MainActivity: BaseActivityBinding<ActivityMainBinding>() {

    companion object {
        private const val RC_LOCATION = 16
    }

    private val locationManager: LocationManager by lazy {
        LocationManager(this)
    }

    override fun inflateBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    @AfterPermissionGranted(value = RC_LOCATION)
    override fun onCreateBinding(savedInstanceState: Bundle?) {
        //Coding

        getPermission {
            with(binding) {
                btnMaps.setOnClickListener {
                    intentTo(MapsActivity::class.java)

                }
                btnUser.setOnClickListener {
                    intentTo(UserActivity::class.java)

                }
                btnPickerMaps.setOnClickListener {
                    intentTo(MapsPickerActivity::class.java)

                }
            }
        }
    }

    private fun getPermission(onResult: () -> Unit){
        val fineLocation = android.Manifest.permission.ACCESS_FINE_LOCATION
        val coarseLocation = android.Manifest.permission.ACCESS_COARSE_LOCATION
        if (EasyPermissions.hasPermissions(this, fineLocation, coarseLocation)) {
            Toast.makeText(this, "Granted..", Toast.LENGTH_SHORT).show()
            onResult.invoke()
        }else{
            EasyPermissions.requestPermissions(
                this,
                "Granted for location",
                RC_LOCATION,
                fineLocation, coarseLocation
            )
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions,grantResults,this)
    }
}