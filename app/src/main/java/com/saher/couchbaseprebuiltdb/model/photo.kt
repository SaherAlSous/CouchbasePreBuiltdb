package com.saher.couchbaseprebuiltdb.model

data class photo(
    var id: String,
    val owner: String,
    val secret: String,
    val server: String,
    val farm: Int,
    val title: String,
    val ispublic: Int,
    val isfriend: Int,
    val isfamily: Int,
    val url_s: String,
    val height_s: Int,
    val width_s: Int
)


val photos: List<photo> = listOf(
    photo("51334404495","131209910@N02","a0b873fda8","65535",66,"Evening mood...",1,0,0,"https://live.staticflickr.com/65535/51334404495_a0b873fda8_m.jpg",125,24),
    photo("51333393876","134230993@N02","570648e7a0","65535",66,"Blue denim...",1,0,0,"https://live.staticflickr.com/65535/51333393876_570648e7a0_m.jpg",180,240),
    photo("51331253286","39652177@N04","07494972e6","65535",66,"Great blue heron",1,0,0,"https://live.staticflickr.com/65535/51331253286_07494972e6_m.jpg",189,240),
    photo("51334670830","109417155@N07","350f9804f4","65535",66,"Morning Glow",1,0,0,"https://live.staticflickr.com/65535/51334670830_350f9804f4_m.jpg",160,240),
    photo("51335509500","23608933@N00","db884c88e5","65535",66,"Greenland - The Jewel of the Arctic!",1,0,0,"https://live.staticflickr.com/65535/51335509500_db884c88e5_m.jpg",164,240),
    photo("51334262546","125883508@N02","8e155a12f6","65535",66,"",1,0,0,"https://live.staticflickr.com/65535/51334262546_8e155a12f6_m.jpg",170,240),
    photo("51334006948","130224143@N02","7f2cf416db","65535",66,"_M3A1571-1585-Web",1,0,0,"https://live.staticflickr.com/65535/51334006948_7f2cf416db_m.jpg",131,2400),
    photo("51334711984","16618681@N00","1758b117d7","65535",66,"Chiesetta di San Valentino",1,0,0,"https://live.staticflickr.com/65535/51334711984_1758b117d7_m.jpg",160,240),
    photo("51334046468","150637634@N06","b362c5c3e2","65535",66,"FQ97. Avant l'orage. Before the storm (In explore 25/07/2021)",1,0,0,"https://live.staticflickr.com/65535/51334046468_b362c5c3e2_m.jpg",160,240),
    photo("51333258064","52803008@N07","d66f3a26f7","65535",66,"Thaipusam 'Street'",1,0,0,"https://live.staticflickr.com/65535/51333258064_d66f3a26f7_m.jpg",171,240),
    photo("51333258064","52803008@N07","d66f3a26f7","65535",66,"Thaipusam 'Street'",1,0,0,"https://live.staticflickr.com/65535/51333258064_d66f3a26f7_m.jpg",171,240),
    photo("51334517974","92164756@N03","68ee63ec1b","65535",66,"ask the Mountains..",1,0,0,"https://live.staticflickr.com/65535/51334517974_68ee63ec1b_m.jpg",160,240),
    photo("51333591918","126542062@N08","16f1758279","65535",66,"dreamland",1,0,0,"https://live.staticflickr.com/65535/51333591918_16f1758279_m.jpg",148,240),
    photo("51333156717","97978797@N03","82f0fb71aa","65535",66,"Tagpfauenauge",1,0,0,"https://live.staticflickr.com/65535/51333156717_82f0fb71aa_m.jpg",160,240)
)

