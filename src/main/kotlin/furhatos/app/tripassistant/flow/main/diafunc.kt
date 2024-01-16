package furhatos.app.tripassistant.flow.main

import furhatos.flow.kotlin.State
import furhatos.flow.kotlin.furhat
import furhatos.flow.kotlin.state

fun whatCanIDo(firstTime: Boolean = false): State = state {
    onEntry {
        if (firstTime) {
            furhat.ledStrip.solid(java.awt.Color(0, 127, 0)) // Changed LED color to represent a more 'travel' oriented theme
            random(
                { furhat.say("My name is Atlas. I am your trip assistant planner.") },
                { furhat.say("I'm Atlas, ready to assist you with your travel plans.") }
            )
            random(
                { furhat.say("I'm happy to provide you with information about various destinations, travel tips, and current travel news.") },
                { furhat.say("I'm here to give you detailed information on destinations, travel advice, and the latest in travel trends.") },
                { furhat.say("I'm equipped to talk about diverse travel locations and the newest developments in the travel industry.") },
                { furhat.say("I'm available to discuss your travel plans, share exciting destination ideas, and chat about journey preparations.") }
            )
        } else {
            furhat.ledStrip.solid(java.awt.Color(0, 127, 0)) // Same color change for consistency
            random(
                {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {},
                {
                    furhat.say(
                        "I can tell you all about different travel destinations, " +
                                "provide updates on the latest travel trends, " +
                                "and even help with travel planning and tips."
                    )
                },
                {
                    furhat.say(
                        "I can provide you with information about " +
                                "various travel locations, offer tips for a smooth journey, " +
                                "and keep you informed about the latest in travel."
                    )
                }
            )
        }

        terminate()
    }
}
