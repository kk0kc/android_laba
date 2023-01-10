package com.example.androidlab

import android.content.Context

object Repository {

    var dataList: MutableList<MyItems> = mutableListOf()
        private set

    val songs: List<MyItems.Song> = listOf(
        MyItems.Song(id = 0, name = "Хочешь?", author = "Земфира", "https://avatars.yandex.net/get-music-content/5234929/e893dd2c.a.81431-2/m1000x1000", "not added"),
        MyItems.Song(id = 1, name = "Popstar", author = "Instasamka", "https://images.genius.com/98f860503d2a68583a8cd0c320df1c4a.1000x1000x1.png",
                        "Королева этих клубов, а, а, а\n" +
                    "На мне норковая шуба, а, а, а\n" +
                    "Я влетаю с ноги тупо, а, а, а\n" +
                    "Эти тусы меня любят, а, а, а\n" +
                    "Ты слышишь мой голос и улетаешь в ра-ай\n" +
                    "На мне сияет Prada и дьявол мой адвока-а-а-а-т\n" +
                    "Не мечта-ай, когда видишь мой сладкий за-а-а-д\n" +
                    "На губа-ах блестит lipstick от Jeffree Sta-a-a-r\n" +
                    "А, а, а, beach never stops, do dance\n" +
                    "А, а, а, мама пополняет баланс\n" +
                    "А, а, а, real peach never has a stress\n" +
                    "А, а, а... А, а, а\n" +
                    "А, а, а, beach never stops, do dance\n" +
                    "А, а, а, мама пополняет баланс, mommy\n" +
                    "А, а, а, real peach never has a stress\n" +
                    "А, а, а... А, а, а\n" +
                    "Очередь в клуб так ждёт мой лимузин, мой лимузин\n" +
                    "Мешаю в гримерке со Sprite'ом мой тусин, мой тусин\n" +
                    "Денег так много в кассе, я магазин, я магазин\n" +
                    "Лью на себя весь этот джин, этот джин, э-этот джин\n" +
                    "Ты слышишь мой голос и улетаешь в ра-ай\n" +
                    "На мне сияет Prada и дьявол мой адвока-а-а-а-т\n" +
                    "Не мечта-ай, когда видишь мой сладкий за-а-а-д\n" +
                    "На губа-ах блестит lipstick от Jeffree Sta-a-a-r\n" +
                    "А, а, а, beach never stops, do dance\n" +
                    "А, а, а, мама пополняет баланс\n" +
                    "А, а, а, real peach never has a stress\n" +
                    "А, а, а... А, а, а\n" +
                    "Ты слышишь мой голос и улетаешь в ра-ай\n" +
                    "На мне сияет Prada и дьявол мой адвока-а-а-а-т\n" +
                    "Не мечта-ай, когда видишь мой сладкий за-а-а-д\n"),
        MyItems.Song(id = 2, name = "P.I.M.P.", author = "50 Cent", "https://i.discogs.com/uFwniRoB2Rx1kUDfLBrY3lgE9rCLYijrl5-IsIeDJsI/rs:fit/g:sm/q:40/h:300/w:300/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTMxNjIz/MzUtMTU2MTM3NzIx/MC0xNzQ0LnBuZw.jpeg",
            "I don't know what you heard about me\n" +
                    "But a bitch can't get a dollar out of me\n" +
                    "No Cadillac, no perms, you can't see\n" +
                    "That I'm a motherfuckin' P I M P\n" +
                    "\n" +
                    "I don't know what you heard about me\n" +
                    "But a bitch can't get a dollar out of me\n" +
                    "No Cadillac, no perms, you can't see\n" +
                    "That I'm a motherfuckin' P I M P\n" +
                    "\n" +
                    "Now shorty, she in the club, she dancin' for dollars\n" +
                    "She got a thing for that Gucci, that Fendi, that Prada\n" +
                    "That BCBG, Burberry, Dolce and Gabana\n" +
                    "She feed them foolish fantasies, they pay her 'cause they wanna\n" +
                    "\n" +
                    "I spit a little G man, and my game got her\n" +
                    "A hour later, have that ass up in the Ramada\n" +
                    "Them trick niggas in her ear sayin' they think about her\n" +
                    "I got the bitch by the bar, tryin' to get a drink up out her\n" +
                    "\n" +
                    "She like my style, she like my smile, she like the way I talk\n" +
                    "She from the country, think she like me 'cause I'm from New York\n" +
                    "I ain't that nigga tryin' to holla 'cause I want some head\n" +
                    "I'm that nigga tryin' to holla 'cause I want some bread\n" +
                    "\n" +
                    "I could care less how she perform when she in the bed\n" +
                    "Bitch hit that track, catch a date, and come and pay the kid\n" +
                    "Look baby this is simple, you can't see\n" +
                    "You fuckin' with me, you fuckin' with a P I M P\n" +
                    "\n" +
                    "I don't know what you heard about me\n" +
                    "But a bitch can't get a dollar out of me\n" +
                    "No Cadillac, no perms, you can't see\n" +
                    "That I'm a motherfuckin' P I M P\n" +
                    "\n" +
                    "I don't know what you heard about me\n" +
                    "But a bitch can't get a dollar out of me\n" +
                    "No Cadillac, no perms, you can't see\n" +
                    "That I'm a motherfuckin' P I M P\n" +
                    "\n" +
                    "I'm 'bout my money you see, girl you can holla at me\n" +
                    "If you fuckin' with me, I'm a P I M P\n" +
                    "Not what you see on TV, no Cadillac, no greasy\n" +
                    "Head full of hair, bitch I'm a P I M P\n" +
                    "\n" +
                    "Come get money with me, if you curious to see\n" +
                    "How it feels to be with a P I M P\n" +
                    "Roll in the Benz with me, you could watch TV\n" +
                    "From the backseat of my V, I'm a P I M P\n" +
                    "\n" +
                    "Girl we could pop some champagne and we could have a ball\n" +
                    "We could toast to the good life, girl we could have it all\n" +
                    "We could really splurge girl, and tear up the mall\n" +
                    "If ever you needed someone, I'm the one you should call\n" +
                    "\n" +
                    "I'll be there to pick you up, if ever you should fall\n" +
                    "If you got problems, I can solve 'em, they big or they small\n" +
                    "That other nigga you be with ain't 'bout shit\n" +
                    "I'm your friend, your father, and confidant, bitch!\n" +
                    "\n" +
                    "I don't know what you heard about me\n" +
                    "But a bitch can't get a dollar out of me\n" +
                    "No Cadillac, no perms, you can't see\n" +
                    "That I'm a motherfuckin' P I M P\n" +
                    "\n" +
                    "I don't know what you heard about me\n" +
                    "But a bitch can't get a dollar out of me\n" +
                    "No Cadillac, no perms, you can't see\n" +
                    "That I'm a motherfuckin' P I M P\n" +
                    "\n" +
                    "I told you fools before, I stay with the tools\n" +
                    "I keep a Benz, some rims, and some jewels\n" +
                    "I holla at a hoe, till I got a bitch confused\n" +
                    "She got on Payless, me I got on gator shoes\n" +
                    "\n" +
                    "I'm shoppin' for chinchillas, in the summer they cheaper\n" +
                    "Man this hoe you can have her, when I'm done I ain't gonna keep her\n" +
                    "Man, bitches come and go, every nigga pimpin' know\n" +
                    "You sayin' it's secret, but you ain't gotta keep it on the low\n" +
                    "\n" +
                    "Bitch choose with me, I'll have you strippin' in the street\n" +
                    "Put my other hoes down, you get your ass beat\n" +
                    "Now nik my bottom bitch, she always come up with my bread\n" +
                    "The last nigga she was with, put stitches in her head\n" +
                    "\n" +
                    "Get your hoe out of pocket, I'll put a charge on a bitch\n" +
                    "'Cause I need 4 TVs and AMGs for the six\n" +
                    "Hoe make a pimp rich, I ain't payin' bitch\n" +
                    "Catch a date, suck a dick, shit, trick!\n" +
                    "\n" +
                    "I don't know what you heard about me\n" +
                    "But a bitch can't get a dollar out of me\n" +
                    "No Cadillac, no perms, you can't see\n" +
                    "That I'm a motherfuckin' P I M P\n" +
                    "\n" +
                    "I don't know what you heard about me\n" +
                    "But a bitch can't get a dollar out of me\n" +
                    "No Cadillac, no perms, you can't see\n" +
                    "That I'm a motherfuckin' P I M P\n" +
                    "\n" +
                    "Yeah, in Hollywoood they say, there's no b'ness like show b'ness\n" +
                    "In the hood they say, there's no b'ness like hoe b'ness, you know\n" +
                    "They say I talk a lil' fast, but if you listen a lil' faster\n" +
                    "I ain't gotta slow down for you to catch up, bitch! Ha ha ha, yea"),
        MyItems.Song(id = 3, name = "My Name Is", author = "Eminem", "https://www.eminem.pro/wp-content/uploads/2015/06/Eminem-My-name-is.jpg",
                        "Hi!\n" +
                    "My name is\n" +
                    "What?\n" +
                    "My name is\n" +
                    "Who?\n" +
                    "My name is\n" +
                    "Chika-chika\n" +
                    "Slim Shady\n" +
                    "Hi!\n" +
                    "My name is\n" +
                    "Huh?\n" +
                    "My name is\n" +
                    "What?\n" +
                    "My name is\n" +
                    "Chika-chika\n" +
                    "Slim Shady\n" +
                    "Hi!\n" +
                    "My name is\n" +
                    "What?\n" +
                    "Excuse me\n" +
                    "Can I have the attention of the class\n" +
                    "For one second\n" +
                    "Hi kids!\n" +
                    "Do you like violence?\n" +
                    "Wanna see me stick Nine inch Nails, through each one of my eyelids?\n" +
                    "Wanna copy me and do exactly like I did?\n" +
                    "Try acid and get fucked up worse that my life is?\n" +
                    "My brain's dead weight, I'm tryin' to get my head straight\n" +
                    "But I can't figure out which Spice Girl I want to impregnate\n" +
                    "And Dr. Dre said\n" +
                    "\"Slim Shady you a base-head!\"\n" +
                    "Uh-uh!\n" +
                    "\"So why's your face red? Man you wasted!\"\n" +
                    "Well since age twelve, I've felt like I'm someone else\n" +
                    "'Cause I hung my original self from the top bunk with a belt\n" +
                    "Got pissed off and ripped Pamela Lee's tits off\n" +
                    "And smacked her so hard I knocked her clothes backwards like Kris Kross\n" +
                    "I smoke a fat pound of grass and fall on my ass, faster than a fat bitch\n" +
                    "Who sat down too fast\n" +
                    "Come here, slut!\n" +
                    "\"Shady, wait a minute, that's my girl, dawg!\"\n" +
                    "I don't give a fuck, God sent me to piss the world off!\n" +
                    "Hi!\n" +
                    "My name is\n" +
                    "What?\n" +
                    "My name is\n" +
                    "Who?\n" +
                    "My name is\n" +
                    "Chika-chika\n" +
                    "Slim Shady\n" +
                    "Hi!\n" +
                    "My name is\n" +
                    "Huh?\n" +
                    "My name is\n" +
                    "What?\n" +
                    "My name is\n" +
                    "Chika-chika\n" +
                    "Slim Shady\n" +
                    "Hi!\n" +
                    "My name is\n" +
                    "What?\n" +
                    "My name is\n" +
                    "Who?\n" +
                    "My name is\n" +
                    "Chika-chika\n" +
                    "Slim Shady\n" +
                    "Hi!\n" +
                    "My name is\n" +
                    "Huh?\n" +
                    "My name is\n" +
                    "What?\n" +
                    "My name is\n" +
                    "Chika-chika\n" +
                    "Slim Shady\n" +
                    "My English teacher wanted to flunk me in Junior High\n" +
                    "Thanks a lot, next semester I'll be thirty five\n" +
                    "I smacked him in his face with an eraser\n" +
                    "Chased him with a stapler\n" +
                    "Stapled his nuts to a stack of papers\n" +
                    "Walked in the strip club, had my jacket zipped up\n" +
                    "Flashed the bartender, then stuck my dick in the tip cup\n" +
                    "Extraterrestrial, running over pedestrians in a space ship\n" +
                    "While they screamin' at me\n" +
                    "\"Let's just be friends!\"\n" +
                    "Ninety-nine percent of my life I was lied to\n" +
                    "I just found out my mom does more dope than I do\n" +
                    "I told her I'd grow up to be a famous rapper\n" +
                    "Make a record about doin' drugs and name it after her\n" +
                    "You know you blew up when the women rush your stands\n" +
                    "Try to touch your hands like some screamin' Usher fans\n" +
                    "This guy at White Castle asked for my autograph\n" +
                    "So I signed it\n" +
                    "\"Dear Dave, thanks for the support, asshole!\"\n" +
                    "Hi!\n" +
                    "My name is\n" +
                    "What?\n" +
                    "My name is\n" +
                    "Who?\n" +
                    "My name is\n" +
                    "Chika-chika\n" +
                    "Slim Shady\n" +
                    "Hi!\n" +
                    "My name is\n" +
                    "What?\n" +
                    "My name is\n" +
                    "Who?\n" +
                    "My name is\n" +
                    "Chika-chika\n" +
                    "Slim Shady\n" +
                    "Hi!\n" +
                    "My name is\n" +
                    "Huh?\n" +
                    "My name is\n" +
                    "Who?\n" +
                    "My name is\n" +
                    "Chika-chika\n" +
                    "Slim Shady\n" +
                    "Hi!\n" +
                    "My name is\n" +
                    "What?\n" +
                    "My name is\n" +
                    "Who?\n" +
                    "My name is\n" +
                    "Chika-chika\n" +
                    "Slim Shady\n" +
                    "Stop the tape!\n" +
                    "This kid needs to be locked away!\n" +
                    "Dr. Dre, don't just stand there, operate!\n" +
                    "I'm not ready to leave, it's too scary to die\n" +
                    "I'll have to be carried inside the cemetery and buried alive\n" +
                    "Am I comin' or goin'?\n" +
                    "I can barely decide\n" +
                    "I just drank a fifth of vodka\n" +
                    "Dare me to drive?\n" +
                    "All my life I was very deprived\n" +
                    "I ain't had a woman in years and my palms are too hairy to hide\n" +
                    "Clothes ripped like the Incredible Hulk\n" +
                    "I spit when I talk, I'll fuck anything that walks\n" +
                    "When I was little I used to get so hungry I would throw fits\n" +
                    "How you gonna breast feed me, Mom? You ain't got no tits!\n" +
                    "I lay awake and strap myself in the bed\n" +
                    "With a bulletproof vest on and shoot myself in the head\n" +
                    "I'm steamin' mad\n" +
                    "And by the way when you see my dad?\n" +
                    "Tell him that I slit his throat, in this dream I had\n" +
                    "Hi!\n" +
                    "My name is\n" +
                    "What?\n" +
                    "My name is\n" +
                    "Who?\n" +
                    "My name is\n" +
                    "Chika-chika\n" +
                    "Slim Shady\n" +
                    "Hi!\n" +
                    "My name is\n" +
                    "Huh?\n" +
                    "My name is\n" +
                    "What?\n" +
                    "My name is\n" +
                    "Chika-chika\n" +
                    "Slim Shady\n" +
                    "Hi!\n" +
                    "My name is\n" +
                    "Who?\n" +
                    "My name is\n" +
                    "Huh?\n" +
                    "My name is\n" +
                    "Chika-chika\n" +
                    "Slim Shady\n" +
                    "Hi!\n" +
                    "My name is\n" +
                    "Huh?\n" +
                    "My name is\n" +
                    "Who?\n" +
                    "My name is\n" +
                    "Chika-chika\n"),
        MyItems.Song(id = 4, name = "Твоя фигура", author = "Буерак", "https://images.genius.com/b2af063dc1633836408fce214c835289.1000x1000x1.jpg",
                        "Ремень на брюках затяну я туго.\n" +
                    "Говорить с тобой мне совсем неинтересно.\n" +
                    "Твоя милая фигура - очень грязная фигура.\n" +
                    "Ты словно для меня из рая слезла.\n" +
                    "Я хочу дышать спокойно - не выходит спокойно.\n" +
                    "Мои ясные мысли кровоточат очень больно.\n" +
                    "Рядом с тобой я сам не свой.\n" +
                    "Рядом с тобой я твой.\n" +
                    "Ремень затянул - пришлось ослабить.\n" +
                    "Язык не повернулся сказать тебе хватит.\n" +
                    "Твоя милая фигура совсем грязна.\n" +
                    "Ни из кого ни из рая тебя судьба мне принесла.\n" +
                    "Я хочу дышать спокойно - не выходит спокойно.\n" +
                    "Мои ясные мысли кровоточат очень больно.\n" +
                    "Рядом с тобой я сам не свой.\n" +
                    "Рядом с тобой я твой."),
        MyItems.Song(id = 5, name = "Location", author = "Playboi Carti", "https://images.genius.com/f180d9cec151b5769b927c3e59265467.1000x1000x1.png",
                        "La música de Harry Fraud\n" +
                    "Yeah, yeah, yeah, yeah, yeah\n" +
                    "Yeah, yeah, yeah, yeah, yeah\n" +
                    "Yeah, yeah, yeah, yeah\n" +
                    "Yeah, what, what\n" +
                    "You cannot hop in my car\n" +
                    "Bentley coupe riding with stars\n" +
                    "Yeah, what, what!\n" +
                    "I keep a Glock like a cop\n" +
                    "Ayy, yeah (yeah)\n" +
                    "She give the top in the drop\n" +
                    "Yeah, ayy\n" +
                    "Diamonds, they wet on my arms\n" +
                    "Tats on my neck and my arms\n" +
                    "Tats on my neck and my arms\n" +
                    "Diamonds, they wet on my arms\n" +
                    "Tats on my neck and my arms\n" +
                    "Diamonds, they wet on my arms\n" +
                    "Tats on my neck and my arms\n" +
                    "Yeah, yeah, yeah, yeah, what\n" +
                    "Yeah, what, what, yeah, yeah, yeah\n" +
                    "Yeah, yeah, yeah\n" +
                    "Tats on my neck and my arm\n" +
                    "Tats on my neck and my, uh (yeah)\n" +
                    "Uh, ooh\n" +
                    "In this bitch going crazy\n" +
                    "Uh, yeah\n" +
                    "I whip this shit like a baby\n" +
                    "Uh, yeah, yeah\n" +
                    "I fuck your bitch, she my baby, uh, yeah, yeah\n" +
                    "I treat your bitch like my lady, uh, uh\n" +
                    "Shawty bend back like the matrix\n" +
                    "Curge whip it up like the '80s\n" +
                    "I'm in the kitchen, go crazy\n" +
                    "I just want me a Mercedes\n" +
                    "Pull up, we totin' .380's, uh\n" +
                    "Pull up I sent the location, uh\n" +
                    "Pull up I sent the location, uh\n" +
                    "What, what!\n" +
                    "You cannot hop in my car\n" +
                    "Bentley coupe ridin' with stars\n" +
                    "Yeah, what, what\n" +
                    "I keep a Glock like a cop\n" +
                    "Ayy, yeah\n" +
                    "She give the top in the drop\n" +
                    "Yeah, ayy\n" +
                    "Diamonds, they wet on my arms\n" +
                    "Tats on my neck and my arms\n" +
                    "Tats on my neck and my arms\n" +
                    "Diamonds, they went on my arms\n" +
                    "Tats on my neck and my arms\n" +
                    "Diamonds, they went on my arms\n" +
                    "Tats on my neck and my arms\n" +
                    "Tats on my neck and my arm, tats on my neck and my arm, yeah, ayy\n" +
                    "Tats on my neck and my arm, tats on my neck and my arm, yeah, yeah\n" +
                    "Check, yeah, ayy, yeah, uh, yeah\n"),
        MyItems.Song(id = 6, name = "Witchblades", author = "Lil Peep, Lil Tracy", "https://i.scdn.co/image/ab67616d0000b273c73bd9b0e34b067d7d3bd7b9", "not added")

    )
    val advertisement: List<MyItems> = listOf(
        MyItems.Advertisement(
            "Lamoda",
            "https://cdn.forbes.ru/forbes-static/new/2022/02/cropped-lamoda-6213c12d9d803.jpg"
        ),
        MyItems.Advertisement(
            "Ozon",
            "https://static.tildacdn.com/tild3861-6339-4234-b534-616338663632/Frame_181.png"
        ),
        MyItems.Advertisement(
            "Sinergiya Universiteti",
            "https://upload.wikimedia.org/wikipedia/commons/1/13/%D0%A1%D0%98%D0%9D%D0%95%D0%A0%D0%93%D0%98%D0%AF_%D0%A3%D0%BD%D0%B8%D0%B2%D0%B5%D1%80%D1%81%D0%B8%D1%82%D0%B5%D1%82_%D0%9B%D0%BE%D0%B3%D0%BE%D1%82%D0%B8%D0%BF.png"
        )
    )

    fun generateList(size: Int) {
        val list = dataList
        var k = 0
        for (i in 0 until size) {
            if (i % 6 == 0) {
                k = 0
                val item =
                    advertisement[(advertisement.indices).random()] as MyItems.Advertisement
                val newItem = item.copy()
                list.add(newItem)
            } else {
                val song =
                    (songs[k] as MyItems.Song)
                var newItem = song.copy()
                newItem.name =newItem.name
                list.add(newItem)
            }
            k++
        }
        dataList = list

    }

    fun addItem(position: Int, song: MyItems.Song) {
        val list = dataList.toMutableList()
        if (position >= dataList.size - 1) {
            list.add(song)
        } else {
            list.add(position, song)
            for ( i in position .. dataList.size) {
                if(list[i] is MyItems.Advertisement && i%6 != 0) {
                    list[i] = list[i-1].also {
                        list[i-1] = list[i]
                    }
                }
            }
        }
        dataList = list
    }

    fun deleteItem(context: Context, position: Int) {
        val list = dataList.toMutableList()
        list.removeAt(position)
        for (i in position until dataList.size - 2) {
            if (list[i] is MyItems.Advertisement && i % 6 != 0) {
                list[i] = list[i + 1].also {
                    list[i + 1] = list[i]
                }
            }
            if (list[list.size - 1] is MyItems.Advertisement) {
                list.removeAt(list.size - 1)
            }
        }
        dataList = list
    }
}