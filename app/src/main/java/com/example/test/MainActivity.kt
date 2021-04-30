package com.example.test

import android.Manifest
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.TedPermission
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list = ArrayList<Item>()
        list.add(Item("Real-time Risk Info & Weather",1))
        list.add(Item("Emergency Contact",2))
        list.add(Item("Contact RBG",3))
        list.add(Item("Alarm Setting",4))
        list.add(Item("Language Setting",5))
        list.add(Item("Medical Aid",6))
        list.add(Item("Reporting risk",7))
        list.add(Item("Announcement",8))
        list.add(Item("Risk List",9))

        val mAdapter = CustomRecyclerViewAdapter(this, list)
        main_recyclerview.adapter =mAdapter

        tedPermission()
    }

    private fun tedPermission() {
        val permissionListener = object : PermissionListener {
            override fun onPermissionGranted() {}
            override fun onPermissionDenied(deniedPermissions: ArrayList<String>?) {
               // makeSnackBar("설정에서 권한을 허가 해주세요.")
                Toast.makeText(applicationContext, "설정에서 권한을 허가해주세요.",Toast.LENGTH_SHORT).show()
                finish()
            }
        }

        TedPermission.with(this)
                .setPermissionListener(permissionListener)
                .setRationaleMessage("서비스 사용을 위해서 몇가지 권한이 필요합니다.")
                .setDeniedMessage("[설정] > [권한] 에서 권한을 설정할 수 있습니다.")
                .setPermissions(
                        Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.ACCESS_COARSE_LOCATION
                )
                .check()
    }
}