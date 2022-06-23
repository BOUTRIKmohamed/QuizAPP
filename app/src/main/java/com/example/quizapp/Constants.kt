package com.example.quizapp

object Constants{
    const val User_Name:String = "user_name"
    const val Total_questions: String ="total_questions "
    const val CORRECT_ANSWERS :String ="correct_answers "
    fun getQuestions(): ArrayList<Question>{
        val questionsList = ArrayList<Question>()
        val que1 = Question(
            1,
            "Que veut dire NFT ?",
            "non façable token",
            "non transmissible token",
            "non fungible token",
            "non countefeithing token",
            3
        )
        questionsList.add(que1)
        val que2 = Question(
            2,
            "Quel est le nom de l'artiste qui a créé les NFTS les plus chers",
            "Mike Whitney",
            "matt hall ",
            "john watkinson",
            "Mike Winkelmann",
            4
        )
        questionsList.add(que2)
        val que3 = Question(
            3,
            "quel est le surnom de cet artiste ?",
            "beeple",
            "beple",
            "bepple",
            "beelpe",
            1
        )
        questionsList.add(que3)
        val que4 = Question(
            4,
            "Quelle est l'oeuvre d'art qui a pas été créée par Beeple ",
            "Cryptopunks",
            "The first 5000",
            "Human one",
            "The merge",
            1
        )
        questionsList.add(que4)
        val que5 = Question(
            5,
            "C'est quoi RARIBLE",
            "un oeuvre d'art numérique",
            "marché NFT",
            "un jeu NFT",
            "une cryptomonaie utilisée pour acheter des NFTs",
            2
        )
        questionsList.add(que5)
        val que6 = Question(
            6,
            "Quelle est la valeur du NFT le plus cher",
            "90",
            "98",
            "92",
            "95",
            3
        )
        questionsList.add(que6)
        val que7 = Question(
            7,
            "Quelle est la blockchain de NFT",
            "ethereum",
            "Zcash",
            "Bitcoin",
            "Monero",
            1
        )
        questionsList.add(que7)
        val que8 = Question(
            8,
            "Est-ce que vous avez aimé le projet ",
            "Je m'ennuyais ",
            "Pas mal",
            "sujet mal choisi",
            "presque Parfait",
            4
        )
        questionsList.add(que8)

        return questionsList
    }


}