package furhatos.app.tripassistant.flow.nlu

import furhatos.app.tripassistant.flow.trivia.QuestionSet
import furhatos.nlu.EnumEntity
import furhatos.nlu.EnumItem
import furhatos.nlu.Intent
import furhatos.nlu.WildcardEntity
import furhatos.nlu.common.Number
import furhatos.nlu.common.Time
import furhatos.nlu.wikidata.City
import furhatos.util.Language

class AboutAtlasLocation : Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf(
            "Where is Atlas located?",
            "Tell me about Atlas's office",
            "Can you give me information about your location?",
            "What is special about the place where Atlas is?",
            "Describe the surroundings of Atlas's location",
            "What can I find near Atlas's location?",
            "Is there anything interesting around where Atlas operates?"
            // ... more examples can be added
        )
    }
}


class AtlasOfficeInfo : Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf(
            "What part of the office am I in?",
            "Can you guide me through Atlas's office?",
            "Where in the Atlas office are we right now?",
            "Tell me more about this area of the office",
            "Explain the layout of the Atlas office",
            "What facilities are available here in Atlas's office?"
            // ... more examples can be added
        )
    }
}

class AboutAtlas : Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf(
            "What can you tell me about Atlas?",
            "How can Atlas help me with travel planning?",
            "What services does Atlas provide?",
            "Explain how Atlas works",
            "What makes Atlas different from other travel assistants?",
            "How can Atlas enhance my travel experience?"
            // ... more examples can be added
        )
    }
}


class Absolutely: Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf(
            "Ask away",
            "i am interested",
            "tell me facts",
            "nice I want to know it",
            "Yeah sure ask away"
        )
    }
}

class WhatsNew : Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf(
            "I was wondering if you could tell me about the latest news from the National robotarium",
            "Hello I was wondering if you could tell me about the latest news from this building",
            "could you tell me about the latest news from the National robotarium",
            "any recent news",
            "any recent update about robotarium",
            "any interesting updates about the robotarium",
            "any recent updates about this building",
            "whats latest updates in here"
        )
    }
}

class AnswerOption : EnumEntity {

    var correct: Boolean = false

    // Every entity and intent needs an empty constructor.
    constructor() {
    }

    // Since we are overwriting the value, we need to use this custom constructor
    constructor(correct: Boolean, value: String) {
        this.correct = correct
        this.value = value
    }

    override fun getEnumItems(lang: Language): List<EnumItem> {
        return QuestionSet.current.options;
    }
}

class RequestRepeatQuestion : Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf(
            "what was the question",
            "can you repeat the question",
            "what was the question again",
            "can you please repeat the question"
        )
    }
}

class RequestRepeatOptions : Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf(
            "what are the options",
            "can you repeat the options",
            "what was the options"
        )
    }
}

class DontKnow : Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf(
            "I don't know",
            "don't know",
            "no idea",
            "I have no idea"
        )
    }
}

class NotInterested : Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf(
            "no i dont want",
            "no im not",
            "im not interested",
            "maybe later",
            "no I'm not interested"
        )
    }
}

class AllRight() : Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf("it's all right", "it's okay", "I am just typing my name", "I am looking for the email" ,"I am slow", "I am entering my details", "I found the options", "I am good", "I am typing", "I am almost done", "Let me check", "I will check", "I need to check my emails", "I will check my emails", "hold on a second", "I am checking", "I need to check", "fine")
    }
}

class playgame : Intent(){
    override fun getExamples(lang: Language): List<String> {
        return listOf("can we play a game","I am bored","Do you have any games","can we play something i dont have anything to do","play a game maybe","can you ask me some questions","can you give another question","can you ask another question","question please","ask another question","another question","quest","can you ask another fact")}}

class Appreciate : Intent(){
    override fun getExamples(lang: Language): List<String> {
        return listOf("Appreciate","Cheers mate","Wow that is interesting","Wow that's really good Murphy","that's a fun fact","cool","that was awesome","interesting","i love you","love","lovely","amazing")}}

class MyName : Intent(){
    override fun getExamples(lang: Language): List<String> {
        return listOf("Loo","Bathroom", "toilet", "Where is the closest bathroom?", "Which way is the toilet?", "Do you have a toilet?", "Where is the closest toilet?", "Which way is the showers?", "is there a bathroom around here?", "yes I need the way to the" )
    }
}

class Alright : Intent(){
    override fun getExamples(lang: Language): List<String> {
        return listOf("alright","Fine","ok","good","fine","its ok","no worries","no issues","cheers")}}

class DateTime : Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf(
            "What day is today?",
            "Tell me the date today",
            "date",
            "time",
            "what time",
            "what date",
            "what is the time now",
            "whats is todays date")
    }
}

class Weather : Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf(
            "could you tell me what is today's temperature",
            "What is todays weather",
            "weather",
            "can i know the weather",
            "is it too rainy",
            "raining outside",
            "forecast",
            "isnt it too cold aint it",
            "drizzly",
            "is it sunny",
            "windy",
            "foggy",
            "can you tell me what is the temperature here"

        )
}}

class GoodBye : Intent(){
    override fun getExamples(lang: Language): List<String> {
        return listOf("Thank you for your time","Goodbye","bye","cya","see you")}}

//-----------------------------------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------

    class GeneralTravelInquiry : Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf(
            "Tell me about travel planning",
            "How does Atlas help with trips?",
            "General travel advice",
            "Travel suggestions",
            "Can you give me some travel tips?"
        )
        }
    }

    class DestinationInfo : Intent() {
        override fun getExamples(lang: Language): List<String> {
            return listOf(
                "Tell me about Paris",
                "Information on Tokyo",
                "Destination tips for Rome",
                "What can I see in New York?",
                "Details about London's attractions"
                // ... additional examples
            )
        }
    }
        class TravelTips : Intent() {
            override fun getExamples(lang: Language): List<String> {
                return listOf(
                    "What are some essential travel tips?",
                    "Advice for first-time travelers",
                    "How to travel on a budget?",
                    "Safety tips for traveling abroad",
                    "Best practices for international travel"
                    // ... additional examples
                )
            }
        }

        class AccommodationOptions : Intent() {
            override fun getExamples(lang: Language): List<String> {
                return listOf(
                    "Can you suggest hotels in Paris?",
                    "Where should I stay in Tokyo?",
                    "Options for accommodations in New York",
                    "Budget-friendly places to stay in Rome",
                    "Luxury hotel options in Dubai"
                    // ... additional examples
                )
            }
        }
        class LocalAttractions : Intent() {
            override fun getExamples(lang: Language): List<String> {
                return listOf(
                    "What are the top attractions in Paris?",
                    "Show me points of interest in Tokyo",
                    "Famous landmarks in New York",
                    "Must-visit places in Rome",
                    "Local attractions in London"
                    // ... additional examples
                )
            }
        }

        class TransportationOptions : Intent() {
            override fun getExamples(lang: Language): List<String> {
                return listOf(
                    "What are the public transportation options in Paris?",
                    "How can I rent a car in Tokyo?",
                    "Best way to travel around New York",
                    "Are there any bike rental services in Amsterdam?",
                    "Transportation advice for getting around Rome"
                    // ... additional examples
                )
            }
        }

class WeatherInfo : Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf(
            "What's the weather like in Paris today?",
            "Can you give me the weather forecast for Tokyo?",
            "Is it going to rain in New York this week?",
            "Current weather conditions in Rome",
            "Weather forecast for London"
            // ... additional examples
        )
    }
}
class CulturalNorms : Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf(
            "What are the cultural norms in Japan?",
            "Dress code for visiting temples in Thailand",
            "Local customs I should know about in Italy",
            "Etiquette tips for dining in France",
            "Cultural practices to be aware of in India"
            // ... additional examples
        )
    }
}
class SafetyInfo : Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf(
            "Safety tips for traveling in Brazil",
            "Emergency contacts in Germany",
            "Local laws I should be aware of in Dubai",
            "How safe is it to travel to South Africa?",
            "What should I do in an emergency in Spain?"
            // ... additional examples
        )
    }
}
class VisaRequirements : Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf(
            "Do I need a visa to visit China?",
            "What are the entry requirements for Australia?",
            "Visa process for traveling to the USA",
            "How to get a tourist visa for Russia",
            "Entry requirements for UK citizens traveling to Japan"
            // ... additional examples
        )
    }
}
class CurrencyInfo : Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf(
            "What's the currency exchange rate for the Euro?",
            "Where can I exchange money in Mexico?",
            "Currency used in Egypt",
            "Best places for currency exchange in Thailand",
            "Current exchange rates for the Japanese Yen"
            // ... additional examples
        )
    }
}


class HealthAdvisories : Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf(
            "What are the current health advisories for Brazil?",
            "Do I need any vaccinations to travel to Kenya?",
            "Are there any health risks in Thailand right now?",
            "Health safety tips for traveling during a pandemic",
            "Medical advice for travelers to India"
            // ... additional examples
        )
    }
}

class LocalEvents : Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf(
            "Are there any local festivals happening in Japan this month?",
            "What events are scheduled in Paris this summer?",
            "Can you tell me about cultural events in New York City?",
            "List of popular festivals in India",
            "Upcoming events and concerts in Berlin"
            // ... additional examples
        )
    }
}
class ShoppingInfo : Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf(
            "Where are the best shopping areas in Paris?",
            "Local markets in Marrakech",
            "Shopping malls in Dubai",
            "Best places to buy souvenirs in London",
            "Luxury shopping in Milan"
            // ... additional examples
        )
    }
}
class LanguageInfo : Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf(
            "What language is spoken in Brazil?",
            "Communication tips for non-English speaking countries",
            "Basic phrases in Spanish for travel",
            "Language guide for travelers in Japan",
            "Do most people speak English in Germany?"
            // ... additional examples
        )
    }
}
class BudgetPlanning : Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf(
            "How much should I budget for a trip to Italy?",
            "Cost-effective travel tips",
            "Average travel expenses in Thailand",
            "Budgeting for a vacation in Australia",
            "Travel costs in South Africa"
            // ... additional examples
        )
    }
}
class ItineraryPlanning : Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf(
            "Can you help plan a week-long trip to Japan?",
            "Itinerary suggestions for a European tour",
            "Planning a family vacation in the USA",
            "Custom travel itinerary for Thailand",
            "Road trip planning across Canada"
            // ... additional examples
        )
    }
}
class TravelInsuranceInfo : Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf(
            "Do I need travel insurance for my trip?",
            "Best travel insurance options",
            "Coverage details of travel insurance",
            "Travel insurance advice for international travel",
            "Insurance policies for adventure sports"
            // ... additional examples
        )
    }
}

class DiningAndCuisine : Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf(
            "Where can I find the best local food here?",
            "Recommend some traditional dishes in this area",
            "What are the popular cuisines in this city?",
            "Can you suggest a good restaurant nearby?",
            "I'm looking for vegan dining options",
            "Where's the best place to eat seafood here?",
            "Tell me about the food specialties of this place",
            "I'd like to try some authentic local dishes",
            "Where can I find a good Italian restaurant in this city?",
            "What are some must-try foods in this region?"
            // ... additional examples
        )
    }
}



class UnhandledQuery : Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf(
            "Can you help me with something else?",
            "I have a different question",
            "Not sure how to ask this",
            "Can you assist with another topic?",
            "I need information on something else"
            // ... additional examples
        )
    }
}

