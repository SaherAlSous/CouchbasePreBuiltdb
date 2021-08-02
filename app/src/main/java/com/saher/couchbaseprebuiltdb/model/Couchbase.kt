package com.saher.couchbaseprebuiltdb.model

import android.content.Context
import com.couchbase.lite.*

class Couchbase() {

    //Initialize the db
   fun initializeAndCreateDb(context: Context) {
        CouchbaseLite.init(context)
    }

}
