package furhatos.app.tripassistant.flow.main



class DescMake(val fulldesc:String,val smalldesc:String) {
    //All options, used to prime the NLU
}

val keypairs = mapOf(
    "WhatsNew" to "WhatsNew1,WhatsNew2",
    "AccommodationOptions" to "AccommodationOptions1,AccommodationOptions2",
    "LocalAttractions" to "LocalAttractions1,LocalAttractions2",
    "SafetyInfo" to "SafetyInfo1,SafetyInfo2",
    "WeatherInfo" to "WeatherInfo1,WeatherInfo2",
    "VisaRequirements" to "VisaRequirements1,VisaRequirements2",
    "CurrencyInfo" to "CurrencyInfo1,CurrencyInfo2",
    "TransportationOptions" to "TransportationOptions1,TransportationOptions2",
    "CulturalNorms" to "CulturalNorms1,CulturalNorms2",
    "DiningAndCuisine" to "DiningAndCuisine1,DiningAndCuisine2",
    "BudgetPlanning" to "BudgetPlanning1,BudgetPlanning2",
    "LocalEvents" to "LocalEvents1,LocalEvents2",
    "HealthAdvisories" to "HealthAdvisories1,HealthAdvisories2",
    "ItineraryPlanning" to "ItineraryPlanning1,ItineraryPlanning2",
    "TravelInsuranceInfo" to "TravelInsuranceInfo1,TravelInsuranceInfo2",
    "LanguageInfo" to "LanguageInfo1,LanguageInfo2",
    "AdventureTravel" to "AdventureTravel1,AdventureTravel2",
    "CulinaryTours" to "CulinaryTours1,CulinaryTours2",
    "FamilyTravelOptions" to "FamilyTravelOptions1,FamilyTravelOptions2",
    "HistoricalSites" to "HistoricalSites1,HistoricalSites2",
    "EcoTourism" to "EcoTourism1,EcoTourism2"

)

val nlgdata = mapOf(
    "GeneralTravelInquiry" to DescMake(
        "Atlas is your go-to travel planning assistant, ready to help you explore and plan your dream journey across the globe, from bustling cities to serene nature escapes.",
        ""),
    "DestinationInfo" to DescMake(
        "Discover the hidden gems and famous landmarks of cities like Paris, Tokyo, and New York. Learn about local culture, cuisine, and must-visit places.",
        ""),
    "TravelTips" to DescMake(
        "Get expert travel tips for budgeting, packing, safety, and navigating local customs to ensure a smooth and enjoyable journey.",
        ""),
    // ... continue with other intents and their descriptions
    "DiningAndCuisine" to DescMake(
        "Explore local dining options and cuisines. Get recommendations for the best restaurants, street food, and culinary experiences unique to your destination.",
        ""),
    "AccommodationOptions" to DescMake(
        "From luxurious hotels to cozy bed and breakfasts, Atlas can suggest the best accommodation options based on your preferences and budget.",
        ""),
    "LocalAttractions" to DescMake(
        "Discover the top attractions and hidden gems in your destination, including historical landmarks, museums, parks, and more.",
        ""),
    "SafetyInfo" to DescMake(
        "Get essential safety tips, emergency contact information, and advice on local laws to ensure a secure and hassle-free trip.",
        ""),
    "WeatherInfo" to DescMake(
        "Stay updated with the latest weather forecasts for your travel destination to plan your activities and pack accordingly.",
        ""),
    "VisaRequirements" to DescMake(
        "Navigate through visa processes and entry requirements for different countries, ensuring a smooth travel experience.",
        ""),
    "CurrencyInfo" to DescMake(
        "Learn about the local currency, exchange rates, and the best places for currency exchange in your travel destination.",
        ""),
    "TransportationOptions" to DescMake(
        "Explore various transportation options including car rentals, public transportation, and scenic train journeys to enhance your travel experience.",
        ""),
    "CulturalNorms" to DescMake(
        "Understand local customs, etiquette, and dress codes to respectfully engage with different cultures during your travels.",
        ""),
    "DiningAndCuisine" to DescMake(
        "Savor the local flavors by exploring the best dining spots, from street food vendors to high-end restaurants.",
        ""),
    "BudgetPlanning" to DescMake(
        "Plan your trip effectively within your budget, finding the best deals and cost-effective options for an affordable yet exciting journey.",
        ""),
    "LocalEvents" to DescMake(
        "Discover upcoming local events, festivals, and cultural activities to fully immerse in the local scene of your travel destination.",
        ""),
    "HealthAdvisories" to DescMake(
        "Stay informed about health advisories, vaccination requirements, and medical tips for safe and healthy travel.",
        ""),
    "ItineraryPlanning" to DescMake(
        "Customize your travel itinerary with Atlas, ensuring a well-planned and memorable trip covering all your interests and preferences.",
        ""),
    "TravelInsuranceInfo" to DescMake(
        "Understand the importance of travel insurance for your trip, covering various aspects like medical emergencies, trip cancellations, and more.",
        ""),
    "LanguageInfo" to DescMake(
        "Get useful language tips, common phrases, and communication advice for non-English speaking countries to enhance your travel experience.",
        "")
)
