package furhatos.app.tripassistant.flow.main

import furhat.libraries.standard.UtilsLib
import furhatos.app.tripassistant.flow.Parent
import furhatos.app.tripassistant.flow.nlu.*
import furhatos.app.tripassistant.flow.trivia.AskQuestion // Assuming this is now about travel trivia
import furhatos.flow.kotlin.*
import furhatos.nlu.EnumEntity
import furhatos.nlu.common.DontKnow
import theparser
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.format.DateTimeFormatter

var firstEntry = true
val Assistant: State = state(Parent) {
    var response=""
    onEntry {
        if(firstEntry){
            furhat.ledStrip.solid(java.awt.Color(0, 127, 0))
            UtilsLib.randomNoRepeat(
                { furhat.say("Hi") },
                { furhat.say("hello") },
                { furhat.say("Hello there!") },
                { val time = LocalTime.now()
                    val greeting = when (time.hour) {
                        in 6..11 -> "Good morning!"
                        in 12..17 -> "Good afternoon!"
                        else -> "Good evening!"
                    }
                    furhat.say(greeting)
                })
            furhat.say("Welcome to Atlas, your trip assistant planner!")
            call(whatCanIDo(true))
            firstEntry = false
            furhat.say("Is there something specific you would like to know about travel destinations or planning?")
            furhat.ledStrip.solid(java.awt.Color(0, 127, 0))
            furhat.listen()
        }
        else {
            furhat.ledStrip.solid(java.awt.Color(0, 127, 0))
            call(whatCanIDo(false))
            random(
                { furhat.say("Are you interested in any particular travel destination or would you like some travel planning tips?") },
                { furhat.say("Can you tell me what specifically you're interested in so that I can provide the travel information you need?") }
            )
            furhat.ledStrip.solid(java.awt.Color(0, 127, 0))
            furhat.listen()
        }
    }
    onReentry {
        furhat.ledStrip.solid(java.awt.Color(127,0,0))
        call(whatCanIDo(false))
        furhat.say("Is there anything else you would like to know more about?")
        furhat.ledStrip.solid(java.awt.Color(0,127,0))
        furhat.listen()
    }

    onResponse<AtlasOfficeInfo>{
        furhat.ledStrip.solid(java.awt.Color(127,0,0))
        var intent = ((it.intent).toString()).dropLast(2)
        response=nlgdata[intent]?.fulldesc.toString()
        var replygpt= getNLGResponseFromGPT((response))
        call(theparser(replygpt))
        furhat.ledStrip.solid(java.awt.Color(0,127,0))
        furhat.listen()
    }
    onResponse<Alright> {
        furhat.ledStrip.solid(java.awt.Color(127,0,0))
        var intent = ((it.intent).toString()).dropLast(2)
        var replygpt= getNLGResponseFromGPT((response))
        call(theparser(replygpt))
        furhat.ledStrip.solid(java.awt.Color(0,127,0))
        furhat.listen()
    }
    onResponse<AboutAtlasLocation> {
        furhat.ledStrip.solid(java.awt.Color(127,0,0))
        var intent = ((it.intent).toString()).dropLast(2)
        response=nlgdata[intent]?.fulldesc.toString()
        var replygpt= getNLGResponseFromGPT((response))
        call(theparser(replygpt))
        furhat.ledStrip.solid(java.awt.Color(0,127,0))
        furhat.listen()
    }

    onResponse<AboutAtlas> {
        furhat.ledStrip.solid(java.awt.Color(127,0,0))
        var intent = ((it.intent).toString()).dropLast(2)
        response=nlgdata[intent]?.fulldesc.toString()
        var replygpt= getNLGResponseFromGPT((response))
        call(theparser(replygpt))
        furhat.ledStrip.solid(java.awt.Color(0,127,0))
        furhat.listen()
    }

    onResponse<WhatsNew> {
        furhat.ledStrip.solid(java.awt.Color(127,0,0))
        var intent = ((it.intent).toString()).dropLast(2)
        var keyIntent = keypairs[intent]?.split(",")?.random()
        response=nlgdata[keyIntent]?.fulldesc.toString()
        var replygpt= getNLGResponseFromGPT((response))
        call(theparser(replygpt))
        furhat.ledStrip.solid(java.awt.Color(0,127,0))
        furhat.listen()
    }

    onResponse<DontKnow> {
        furhat.ledStrip.solid(java.awt.Color(127,0,0))
        var replygpt= getNLGResponseFromGPT((response))
        call(theparser(replygpt))
        furhat.ledStrip.solid(java.awt.Color(0,127,0))
        furhat.listen()
    }

    onResponse<playgame> {
        furhat.ledStrip.solid(java.awt.Color(127,0,0))
        UtilsLib.randomNoRepeat(
            { furhat.say("May I offer you some trivia about trips that you may find intriguing?") },
            { furhat.say("Are you interested in any particular information regarding trips that I can share with you?") },
            { furhat.say("Would you like to learn an interesting fact about travels ?") } )
        call(AskQuestion())
    }
    onResponse<Appreciate> {
        furhat.ledStrip.solid(java.awt.Color(127,0,0))
        response=" aww thank you make murphy appreciate the user back maybe even greet the user based on the user's response"
        var replygpt= getNLGResponseFromGPT((response))
        call(theparser(replygpt))
        furhat.ledStrip.solid(java.awt.Color(0,127,0))
        furhat.listen()
    }
    onResponse<MyName> {
        furhat.ledStrip.solid(java.awt.Color(127,0,0))
        var intent = ((it.intent).toString()).dropLast(2)
        var replygpt= getNLGResponseFromGPT((response))
        call(theparser(replygpt))
        furhat.ledStrip.solid(java.awt.Color(0,127,0))
        furhat.listen()
    }
    onResponse<DateTime> {
        furhat.ledStrip.solid(java.awt.Color(127,0,0))
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")
        val current = LocalDateTime.now().format(formatter)
        val day = LocalDateTime.now().dayOfWeek
        response = "Today date and time is $current. The format is yyyy-MM-dd HH:mm, where yyyy is the year, MM is the month, dd is the day, HH is the time in hours, mm is the time in minutes. The name of the day is $day"
        var replygpt= getNLGResponseFromGPT((response))
        call(theparser(replygpt))
        furhat.ledStrip.solid(java.awt.Color(0,127,0))
        furhat.listen()
    }


    onResponse<GoodBye> {
        furhat.ledStrip.solid(java.awt.Color(127,0,0))
        var intent = ((it.intent).toString()).dropLast(2)
        response= "Customer wants to leave the conversation. Thank the visitor for talking to Murphy"
        var replygpt= getNLGResponseFromGPT((response))
        call(theparser(replygpt))
        goto(Idle)

    }
    onResponse<Weather> {
        furhat.ledStrip.solid(java.awt.Color(127,0,0))
        var intent = ((it.intent).toString()).dropLast(2)
        response= "Visitor wants to know the weather at Currie, Edinbrugh,EH144AS use Edinbrugh weather forecast, website link : https://www.meteoblue.com/en/region/weather/radar/scotland_united-kingdom_2638360 to find the temperature and weather"
        var replygpt= getNLGResponseFromGPT((response))
        call(theparser(replygpt))
        furhat.listen()

    }
    onResponse<Alright> {
        furhat.ledStrip.solid(java.awt.Color(127,0,0))
        var intent = ((it.intent).toString()).dropLast(2)
        var replygpt= getNLGResponseFromGPT((response))
        call(theparser(replygpt))
        furhat.ledStrip.solid(java.awt.Color(0,127,0))
        furhat.listen()
    }
    onResponse {
        furhat.ledStrip.solid(java.awt.Color(127,0,0))
        var replygpt= getNLGResponseFromGPT((response))
        call(theparser(replygpt))
        furhat.ledStrip.solid(java.awt.Color(0,127,0))
        furhat.listen()
    }
    onNoResponse {
        furhat.ledStrip.solid(java.awt.Color(127,0,0))
        UtilsLib.randomNoRepeat(
            {furhat.say("Would you like to learn some interesting facts about robotics or National Robotarium?")
                call(AskQuestion())},
            {furhat.say("Hey ... can i entertain you with some facts related to robotics")
                call(AskQuestion())},
            {furhat.say("Hey ... can i entertain you with some facts about to robotics")
                call(AskQuestion())},
            {},{},{},{},{},{},{},{},{},{}
        )
        furhat.ledStrip.solid(java.awt.Color(0,127,0))
        furhat.listen(10000)
    }

    onResponse<GeneralTravelInquiry> {
        furhat.ledStrip.solid(java.awt.Color(127,0,0))
        var intent = ((it.intent).toString()).dropLast(2)
        response = nlgdata[intent]?.fulldesc.toString()
        var replygpt = getNLGResponseFromGPT(response)
        call(theparser(replygpt))
        furhat.ledStrip.solid(java.awt.Color(0,127,0))
        furhat.listen()
    }

    onResponse<DestinationInfo> {
        furhat.ledStrip.solid(java.awt.Color(127,0,0))
        var intent = ((it.intent).toString()).dropLast(2)
        response = nlgdata[intent]?.fulldesc.toString()
        var replygpt = getNLGResponseFromGPT(response)
        call(theparser(replygpt))
        furhat.ledStrip.solid(java.awt.Color(0,127,0))
        furhat.listen()
    }

// Handling Travel Tips
    onResponse<TravelTips> {
        furhat.ledStrip.solid(java.awt.Color(127,0,0))
        var intent = ((it.intent).toString()).dropLast(2)
        response = nlgdata[intent]?.fulldesc.toString()
        var replygpt = getNLGResponseFromGPT(response)
        call(theparser(replygpt))
        furhat.ledStrip.solid(java.awt.Color(0,127,0))
        furhat.listen()
    }

// Handling Accommodation Options
    onResponse<AccommodationOptions> {
        furhat.ledStrip.solid(java.awt.Color(127,0,0))
        var intent = ((it.intent).toString()).dropLast(2)
        response = nlgdata[intent]?.fulldesc.toString()
        var replygpt = getNLGResponseFromGPT(response)
        call(theparser(replygpt))
        furhat.ledStrip.solid(java.awt.Color(0,127,0))
        furhat.listen()
    }

// Handling Local Attractions
    onResponse<LocalAttractions> {
        furhat.ledStrip.solid(java.awt.Color(127,0,0))
        var intent = ((it.intent).toString()).dropLast(2)
        response = nlgdata[intent]?.fulldesc.toString()
        var replygpt = getNLGResponseFromGPT(response)
        call(theparser(replygpt))
        furhat.ledStrip.solid(java.awt.Color(0,127,0))
        furhat.listen()
    }

    // Handling Transportation Options
    onResponse<TransportationOptions> {
        furhat.ledStrip.solid(java.awt.Color(127,0,0))
        var intent = ((it.intent).toString()).dropLast(2)
        response = nlgdata[intent]?.fulldesc.toString()
        var replygpt = getNLGResponseFromGPT(response)
        call(theparser(replygpt))
        furhat.ledStrip.solid(java.awt.Color(0,127,0))
        furhat.listen()
    }

// Handling Weather Information
    onResponse<WeatherInfo> {
        furhat.ledStrip.solid(java.awt.Color(127,0,0))
        var intent = ((it.intent).toString()).dropLast(2)
        response = nlgdata[intent]?.fulldesc.toString()
        var replygpt = getNLGResponseFromGPT(response)
        call(theparser(replygpt))
        furhat.ledStrip.solid(java.awt.Color(0,127,0))
        furhat.listen()
    }

// Handling Cultural Norms and Etiquette
    onResponse<CulturalNorms> {
        furhat.ledStrip.solid(java.awt.Color(127,0,0))
        var intent = ((it.intent).toString()).dropLast(2)
        response = nlgdata[intent]?.fulldesc.toString()
        var replygpt = getNLGResponseFromGPT(response)
        call(theparser(replygpt))
        furhat.ledStrip.solid(java.awt.Color(0,127,0))
        furhat.listen()
    }

// Handling Safety and Emergency Information
    onResponse<SafetyInfo> {
        furhat.ledStrip.solid(java.awt.Color(127,0,0))
        var intent = ((it.intent).toString()).dropLast(2)
        response = nlgdata[intent]?.fulldesc.toString()
        var replygpt = getNLGResponseFromGPT(response)
        call(theparser(replygpt))
        furhat.ledStrip.solid(java.awt.Color(0,127,0))
        furhat.listen()
    }

// Handling Visa Requirements
    onResponse<VisaRequirements> {
        furhat.ledStrip.solid(java.awt.Color(127,0,0))
        var intent = ((it.intent).toString()).dropLast(2)
        response = nlgdata[intent]?.fulldesc.toString()
        var replygpt = getNLGResponseFromGPT(response)
        call(theparser(replygpt))
        furhat.ledStrip.solid(java.awt.Color(0,127,0))
        furhat.listen()
    }

// Handling Currency and Exchange Rates
    onResponse<CurrencyInfo> {
        furhat.ledStrip.solid(java.awt.Color(127,0,0))
        var intent = ((it.intent).toString()).dropLast(2)
        response = nlgdata[intent]?.fulldesc.toString()
        var replygpt = getNLGResponseFromGPT(response)
        call(theparser(replygpt))
        furhat.ledStrip.solid(java.awt.Color(0,127,0))
        furhat.listen()
    }


// Handling Health Advisories
    onResponse<HealthAdvisories> {
        furhat.ledStrip.solid(java.awt.Color(127,0,0))
        var intent = ((it.intent).toString()).dropLast(2)
        response = nlgdata[intent]?.fulldesc.toString()
        var replygpt = getNLGResponseFromGPT(response)
        call(theparser(replygpt))
        furhat.ledStrip.solid(java.awt.Color(0,127,0))
        furhat.listen()
    }

// Handling Local Events
    onResponse<LocalEvents> {
        furhat.ledStrip.solid(java.awt.Color(127,0,0))
        var intent = ((it.intent).toString()).dropLast(2)
        response = nlgdata[intent]?.fulldesc.toString()
        var replygpt = getNLGResponseFromGPT(response)
        call(theparser(replygpt))
        furhat.ledStrip.solid(java.awt.Color(0,127,0))
        furhat.listen()
    }

// Handling Shopping Information
    onResponse<ShoppingInfo> {
        furhat.ledStrip.solid(java.awt.Color(127,0,0))
        var intent = ((it.intent).toString()).dropLast(2)
        response = nlgdata[intent]?.fulldesc.toString()
        var replygpt = getNLGResponseFromGPT(response)
        call(theparser(replygpt))
        furhat.ledStrip.solid(java.awt.Color(0,127,0))
        furhat.listen()
    }

// Handling Language Information
    onResponse<LanguageInfo> {
        furhat.ledStrip.solid(java.awt.Color(127,0,0))
        var intent = ((it.intent).toString()).dropLast(2)
        response = nlgdata[intent]?.fulldesc.toString()
        var replygpt = getNLGResponseFromGPT(response)
        call(theparser(replygpt))
        furhat.ledStrip.solid(java.awt.Color(0,127,0))
        furhat.listen()
    }

// Handling Budget Planning
    onResponse<BudgetPlanning> {
        furhat.ledStrip.solid(java.awt.Color(127,0,0))
        var intent = ((it.intent).toString()).dropLast(2)
        response = nlgdata[intent]?.fulldesc.toString()
        var replygpt = getNLGResponseFromGPT(response)
        call(theparser(replygpt))
        furhat.ledStrip.solid(java.awt.Color(0,127,0))
        furhat.listen()
    }

// Handling Itinerary Planning
    onResponse<ItineraryPlanning> {
        furhat.ledStrip.solid(java.awt.Color(127,0,0))
        var intent = ((it.intent).toString()).dropLast(2)
        response = nlgdata[intent]?.fulldesc.toString()
        var replygpt = getNLGResponseFromGPT(response)
        call(theparser(replygpt))
        furhat.ledStrip.solid(java.awt.Color(0,127,0))
        furhat.listen()
    }

// Handling Travel Insurance Information
    onResponse<TravelInsuranceInfo> {
        furhat.ledStrip.solid(java.awt.Color(127,0,0))
        var intent = ((it.intent).toString()).dropLast(2)
        response = nlgdata[intent]?.fulldesc.toString()
        var replygpt = getNLGResponseFromGPT(response)
        call(theparser(replygpt))
        furhat.ledStrip.solid(java.awt.Color(0,127,0))
        furhat.listen()
    }

// Handling Dining and Cuisine Information
    onResponse<DiningAndCuisine> {
        furhat.ledStrip.solid(java.awt.Color(127,0,0))
        var intent = ((it.intent).toString()).dropLast(2)
        response = nlgdata[intent]?.fulldesc.toString()
        var replygpt = getNLGResponseFromGPT(response)
        call(theparser(replygpt))
        furhat.ledStrip.solid(java.awt.Color(0,127,0))
        furhat.listen()
    }

// Fallback for Unrecognized Queries
    onResponse<UnhandledQuery> {
        furhat.ledStrip.solid(java.awt.Color(127,0,0))
        var replygpt = getNLGResponseFromGPT("I'm not sure how to help with that. Could you ask something else?")
        call(theparser(replygpt))
        furhat.ledStrip.solid(java.awt.Color(0,127,0))
        furhat.listen()
    }


}