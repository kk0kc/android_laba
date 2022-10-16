package com.example.androidlab

object SongRepository {
    val songs = arrayListOf(
        Song(id = 0, name = "Супермаркет", author = "Пошлая Молли", cover = "https://images.genius.com/21b9cd2fd4147a22bf3d629807ce1a28.920x1000x1.jpg",
            "Пожалуйста, не умиpай\nИли мне придётся тоже\nТы, конечно, сразу в рай\nА я не думаю, что тоже\nХочешь сладких апельсинов?\n" +
                "Хочешь вслух рассказов длинных?\nХочешь, я взорву все звёзды\nЧто мешают спать?\nПожалуйста, только живи\nТы же видишь: я живу тобою\n" +
                "Моей огромной любви\nХватит нам двоим с головою\nХочешь в море с парусами?\nХочешь музык новых самых?\nХочешь, я убью соседей\n Что мешают спать?\n" +
                "Хочешь солнце вместо лампы?\nХочешь за окошком Альпы?\nХочешь, я отдам все пeсни?\nПро тебя отдам все пeсни\nХочешь солнце вместо лампы?\n"+
                "Хочешь за окошком Альпы?\nХочешь, я отдам все пeсни?\nПро тебя отдам все пeсни я"),
        Song(id = 1, name = "Вишенка", author = "Кровосток", cover = "https://images.genius.com/2eb8ede08395273184af0c7dbbd62df2.1000x1000x1.jpg",
            "Пожалуйста, не умиpай\nИли мне придётся тоже\nТы, конечно, сразу в рай\nА я не думаю, что тоже\nХочешь сладких апельсинов?\n" +
                    "Хочешь вслух рассказов длинных?\nХочешь, я взорву все звёзды\nЧто мешают спать?\nПожалуйста, только живи\nТы же видишь: я живу тобою\n" +
                    "Моей огромной любви\nХватит нам двоим с головою\nХочешь в море с парусами?\nХочешь музык новых самых?\nХочешь, я убью соседей\n Что мешают спать?\n" +
                    "Хочешь солнце вместо лампы?\nХочешь за окошком Альпы?\nХочешь, я отдам все пeсни?\nПро тебя отдам все пeсни\nХочешь солнце вместо лампы?\n"+
                    "Хочешь за окошком Альпы?\nХочешь, я отдам все пeсни?\nПро тебя отдам все пeсни я"),
        Song(id = 2, name = "P.I.M.P.", author = "50 Cent", cover = "https://i1.sndcdn.com/artworks-000059808514-3ncxmb-t500x500.jpg",
            "Пожалуйста, не умиpай\nИли мне придётся тоже\nТы, конечно, сразу в рай\nА я не думаю, что тоже\nХочешь сладких апельсинов?\n" +
                    "Хочешь вслух рассказов длинных?\nХочешь, я взорву все звёзды\nЧто мешают спать?\nПожалуйста, только живи\nТы же видишь: я живу тобою\n" +
                    "Моей огромной любви\nХватит нам двоим с головою\nХочешь в море с парусами?\nХочешь музык новых самых?\nХочешь, я убью соседей\n Что мешают спать?\n" +
                    "Хочешь солнце вместо лампы?\nХочешь за окошком Альпы?\nХочешь, я отдам все пeсни?\nПро тебя отдам все пeсни\nХочешь солнце вместо лампы?\n"+
                    "Хочешь за окошком Альпы?\nХочешь, я отдам все пeсни?\nПро тебя отдам все пeсни я"),
        Song(id = 3, name = "My Name Is", author = "Eminem", cover = "https://upload.wikimedia.org/wikipedia/ru/4/4f/Eminem_-_My_Name_Is..._CD_cover.jpg",
            "Пожалуйста, не умиpай\nИли мне придётся тоже\nТы, конечно, сразу в рай\nА я не думаю, что тоже\nХочешь сладких апельсинов?\n" +
                    "Хочешь вслух рассказов длинных?\nХочешь, я взорву все звёзды\nЧто мешают спать?\nПожалуйста, только живи\nТы же видишь: я живу тобою\n" +
                    "Моей огромной любви\nХватит нам двоим с головою\nХочешь в море с парусами?\nХочешь музык новых самых?\nХочешь, я убью соседей\n Что мешают спать?\n" +
                    "Хочешь солнце вместо лампы?\nХочешь за окошком Альпы?\nХочешь, я отдам все пeсни?\nПро тебя отдам все пeсни\nХочешь солнце вместо лампы?\n"+
                    "Хочешь за окошком Альпы?\nХочешь, я отдам все пeсни?\nПро тебя отдам все пeсни я"),
        Song(id = 4, name = "Твоя фигура", author = "Буерак", cover = "https://images.genius.com/b2af063dc1633836408fce214c835289.1000x1000x1.jpg",
            "Пожалуйста, не умиpай\nИли мне придётся тоже\nТы, конечно, сразу в рай\nА я не думаю, что тоже\nХочешь сладких апельсинов?\n" +
                    "Хочешь вслух рассказов длинных?\nХочешь, я взорву все звёзды\nЧто мешают спать?\nПожалуйста, только живи\nТы же видишь: я живу тобою\n" +
                    "Моей огромной любви\nХватит нам двоим с головою\nХочешь в море с парусами?\nХочешь музык новых самых?\nХочешь, я убью соседей\n Что мешают спать?\n" +
                    "Хочешь солнце вместо лампы?\nХочешь за окошком Альпы?\nХочешь, я отдам все пeсни?\nПро тебя отдам все пeсни\nХочешь солнце вместо лампы?\n"+
                    "Хочешь за окошком Альпы?\nХочешь, я отдам все пeсни?\nПро тебя отдам все пeсни я"),
        Song(id = 5, name = "Location", author = "Playboi Carti", cover = "https://images.genius.com/f180d9cec151b5769b927c3e59265467.1000x1000x1.png",
            "Пожалуйста, не умиpай\nИли мне придётся тоже\nТы, конечно, сразу в рай\nА я не думаю, что тоже\nХочешь сладких апельсинов?\n" +
                    "Хочешь вслух рассказов длинных?\nХочешь, я взорву все звёзды\nЧто мешают спать?\nПожалуйста, только живи\nТы же видишь: я живу тобою\n" +
                    "Моей огромной любви\nХватит нам двоим с головою\nХочешь в море с парусами?\nХочешь музык новых самых?\nХочешь, я убью соседей\n Что мешают спать?\n" +
                    "Хочешь солнце вместо лампы?\nХочешь за окошком Альпы?\nХочешь, я отдам все пeсни?\nПро тебя отдам все пeсни\nХочешь солнце вместо лампы?\n"+
                    "Хочешь за окошком Альпы?\nХочешь, я отдам все пeсни?\nПро тебя отдам все пeсни я"),
        Song(id = 6, name = "Witchblades", author = "Lil Peep, Lil Tracy", cover = "https://media.pitchfork.com/photos/5929f495d7a71d1ea569af9c/1:1/w_450%2Cc_limit/040399b6.png",
            "Пожалуйста, не умиpай\nИли мне придётся тоже\nТы, конечно, сразу в рай\nА я не думаю, что тоже\nХочешь сладких апельсинов?\n" +
                    "Хочешь вслух рассказов длинных?\nХочешь, я взорву все звёзды\nЧто мешают спать?\nПожалуйста, только живи\nТы же видишь: я живу тобою\n" +
                    "Моей огромной любви\nХватит нам двоим с головою\nХочешь в море с парусами?\nХочешь музык новых самых?\nХочешь, я убью соседей\n Что мешают спать?\n" +
                    "Хочешь солнце вместо лампы?\nХочешь за окошком Альпы?\nХочешь, я отдам все пeсни?\nПро тебя отдам все пeсни\nХочешь солнце вместо лампы?\n"+
                    "Хочешь за окошком Альпы?\nХочешь, я отдам все пeсни?\nПро тебя отдам все пeсни я"),
        Song(id = 7, name = "All the good girls go to hell", author = "Billie Eilish", cover = "https://i1.sndcdn.com/artworks-000528017184-xyptgs-t500x500.jpg",
            "Пожалуйста, не умиpай\nИли мне придётся тоже\nТы, конечно, сразу в рай\nА я не думаю, что тоже\nХочешь сладких апельсинов?\n" +
                    "Хочешь вслух рассказов длинных?\nХочешь, я взорву все звёзды\nЧто мешают спать?\nПожалуйста, только живи\nТы же видишь: я живу тобою\n" +
                    "Моей огромной любви\nХватит нам двоим с головою\nХочешь в море с парусами?\nХочешь музык новых самых?\nХочешь, я убью соседей\n Что мешают спать?\n" +
                    "Хочешь солнце вместо лампы?\nХочешь за окошком Альпы?\nХочешь, я отдам все пeсни?\nПро тебя отдам все пeсни\nХочешь солнце вместо лампы?\n"+
                    "Хочешь за окошком Альпы?\nХочешь, я отдам все пeсни?\nПро тебя отдам все пeсни я\n ehfjsdh\n eehkdhg\nhsdkjfhdj")
    )
}
