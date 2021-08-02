package com.saher.couchbaseprebuiltdb

import android.app.Application
import com.saher.couchbaseprebuiltdb.model.Couchbase

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        val context= applicationContext
        val couchbase = Couchbase()
        //initialize couchbase
        couchbase.initializeAndCreateDb(context)
    }
}