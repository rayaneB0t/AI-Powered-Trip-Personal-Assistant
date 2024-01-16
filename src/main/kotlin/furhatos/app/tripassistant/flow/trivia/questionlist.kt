package furhatos.app.tripassistant.flow.trivia


// list of question murphy can ask while idle format question,descriptions or facts, answer, wrong answers(options)
val questionsEnglish = mutableListOf(
    Question("Which city is known as 'The City of Light' and why?",
        "Paris is often referred to as 'The City of Light' (La Ville Lumière), both because of its leading role during the Age of Enlightenment and more literally because Paris was one of the first large European cities to use gas street lighting on a grand scale on its boulevards and monuments.",
        answer = listOf("Paris"),
        alternatives = listOf(listOf("London"), listOf("New York"))),

    Question("In which country would you find the ancient Inca city of Machu Picchu?",
        "Machu Picchu is a 15th-century Inca citadel located in the Eastern Cordillera of southern Peru on a 2,430-meter mountain ridge. It is located in the Cusco Region, Urubamba Province, Machupicchu District.",
        answer = listOf("Peru"),
        alternatives = listOf(listOf("Brazil"), listOf("Chile"))),

    Question("What is the official language of Brazil?",
        "While Brazil is in South America, its official language is Portuguese, not Spanish. This is due to Brazil's colonization by Portugal.",
        answer = listOf("Portuguese"),
        alternatives = listOf(listOf("Spanish"), listOf("English"))),

    Question("Which famous monument was a gift from France to the United States?",
        "The Statue of Liberty was a gift of friendship from the people of France to the United States and is recognized as a universal symbol of freedom and democracy.",
        answer = listOf("Statue of Liberty"),
        alternatives = listOf(listOf("Eiffel Tower"), listOf("London Bridge"))),

    Question("What currency is used in Japan?",
        "The official currency of Japan is the Yen, denoted by ¥. It's one of the most traded currencies in the world.",
        answer = listOf("Yen", "¥"),
        alternatives = listOf(listOf("Dollar"), listOf("Euro"))),
    Question("Which city is known as the 'Venice of the North'?",
        "Amsterdam is often referred to as the 'Venice of the North' because of its beautiful canals that criss-cross the city, its impressive architecture, and more than 1,500 bridges.",
        answer = listOf("Amsterdam"),
        alternatives = listOf(listOf("Venice"), listOf("Bruges"))),

    Question("What is the largest desert in the world?",
        "The Sahara Desert is the largest hot desert in the world, and the third largest desert overall, after Antarctica and the Arctic, which are cold deserts.",
        answer = listOf("Sahara Desert", "Sahara"),
        alternatives = listOf(listOf("Arabian Desert"), listOf("Gobi Desert"))),

    Question("Where can you find the world's longest wall?",
        "The Great Wall of China is the longest wall in the world, stretching over 13,000 miles from east to west of China.",
        answer = listOf("Great Wall of China", "China"),
        alternatives = listOf(listOf("Berlin Wall"), listOf("Hadrian's Wall"))),

    Question("Which country is known as the land of a thousand lakes?",
        "Finland is known as the land of a thousand lakes, though it actually has around 188,000 lakes.",
        answer = listOf("Finland"),
        alternatives = listOf(listOf("Canada"), listOf("Sweden"))),

    Question("In which city would you find the famous landmark, the Colosseum?",
        "The Colosseum, also known as the Flavian Amphitheatre, is an oval amphitheatre in the centre of the city of Rome, Italy.",
        answer = listOf("Rome", "Italy"),
        alternatives = listOf(listOf("Athens"), listOf("Paris"))),

    Question("Which island country is known for its unique species of animals, like lemurs?",
        "Madagascar is famous for its unique wildlife and biodiversity, especially known for lemurs which are endemic to the island.",
        answer = listOf("Madagascar"),
        alternatives = listOf(listOf("Galapagos Islands"), listOf("Sri Lanka"))),

    Question("What is the capital city of Australia?",
        "Canberra is the capital city of Australia. It's a city known for its outdoor spaces, cultural institutions, and national monuments.",
        answer = listOf("Canberra"),
        alternatives = listOf(listOf("Sydney"), listOf("Melbourne"))),

    Question("Which Asian city is famous for its vibrant street food scene and floating markets?",
        "Bangkok, the capital city of Thailand, is renowned for its vibrant street food scene and picturesque floating markets.",
        answer = listOf("Bangkok", "Thailand"),
        alternatives = listOf(listOf("Hanoi"), listOf("Singapore"))),

    Question("Where would you find the ancient city of Petra?",
        "Petra, famous for its rock-cut architecture and water conduit system, is a historical and archaeological city in southern Jordan.",
        answer = listOf("Jordan"),
        alternatives = listOf(listOf("Egypt"), listOf("Turkey"))),

    Question("What mountain is known as 'Sagarmatha' in Nepal?",
        "Mount Everest, the Earth's highest mountain above sea level, is known as 'Sagarmatha' in Nepal.",
        answer = listOf("Mount Everest", "Everest"),
        alternatives = listOf(listOf("K2"), listOf("Kangchenjunga")))
)

