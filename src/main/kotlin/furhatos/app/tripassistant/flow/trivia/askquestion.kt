package furhatos.app.tripassistant.flow.trivia

import furhatos.app.tripassistant.flow.Parent
import furhatos.app.tripassistant.flow.main.Assistant
import furhatos.app.tripassistant.flow.main.getNLGResponseFromGPT
import furhatos.app.tripassistant.flow.nlu.*

import furhatos.flow.kotlin.*
import furhatos.gestures.Gestures
import furhatos.nlu.common.RequestRepeat
import furhatos.nlu.common.Yes
import theparser

var onetime = true
fun AskQuestion(): State = state(parent = Parent) {


    onEntry {
        furhat.ledStrip.solid(java.awt.Color(0,127,0))
        furhat.listen(15000)
    }
    onResponse({ listOf(Yes(), Absolutely()) }){
        if (onetime == true) {
            onetime = false
            furhat.ledStrip.solid(java.awt.Color(127,0,0))
            furhat.setSpeechRecPhrases(QuestionSet.current.speechPhrases)
            // Ask the question followed by the options
            furhat.ask(QuestionSet.current.text + " " + QuestionSet.current.getOptionsString())

        } else {
            furhat.ledStrip.solid(java.awt.Color(127,0,0))
            QuestionSet.next()
            furhat.setSpeechRecPhrases(QuestionSet.current.speechPhrases)
            furhat.ask(QuestionSet.current.text + " " + QuestionSet.current.getOptionsString())
        }
    }
    // User is answering with any of the alternatives
    onResponse<AnswerOption> {
        val answer = it.intent
        // If the user answers correct, we up the user's score and congratulates the user
        if (answer.correct) {
            furhat.gesture(Gestures.Smile)
            furhat.ledStrip.solid(java.awt.Color(127,0,0))
            random(
                { furhat.say("Great! That was the ${furhat.voice.emphasis("right")}  answer") },
                { furhat.say("that was ${furhat.voice.emphasis("correct")}") }
            )

            var replygpt = getNLGResponseFromGPT(("the correct answer is  " + QuestionSet.current.makeans() + "give a brief explanation or an amusing fact about this"))
            call(theparser(replygpt))
            goto(Assistant)
            /*
            If the user answers incorrect, we give another user the chance of answering if one is present in the game.
            If we indeed ask another player, the furhat.ask() interrupts the rest of the handler.
             */
        } else {
            furhat.gesture(Gestures.BrowFrown)
            furhat.ledStrip.solid(java.awt.Color(127,0,0))
            furhat.say("Sorry, that was ${furhat.voice.emphasis("not")} correct")
            var replygpt = getNLGResponseFromGPT(("the correct answer is  " + QuestionSet.current.makeans() + "give a brief explanation or an amusing fact about this"))
            call(theparser(replygpt))
            goto(Assistant)
            /* Find another user that has not answered this question and if so, asks them.
             For the flow of the skill, we will continue asking the new user the next question through the
             shouldChangeUser = false flag.
             */

        }

    }
        onResponse<NotInterested> {
        furhat.ledStrip.solid(java.awt.Color(127,0,0))
        var replygpt= getNLGResponseFromGPT(("Seems like customer is not interested in the facts/trivia"))
        call(theparser(replygpt))
        goto(Assistant)
    }
        // The users answers that they don't know
        onResponse<DontKnow> {
            furhat.ledStrip.solid(java.awt.Color(127,0,0))
            var replygpt= getNLGResponseFromGPT(("the correct answer is  "+ QuestionSet.current.makeans() +"give a brief explanation or an amusing fact about this"))
            call(theparser(replygpt))
            goto(Assistant)
        }

        onResponse<RequestRepeat> {
            furhat.setSpeechRecPhrases(QuestionSet.current.speechPhrases)
            furhat.ledStrip.solid(java.awt.Color(127,0,0))
            // Ask the question followed by the options
            furhat.ask(QuestionSet.current.text + " " + QuestionSet.current.getOptionsString())
        }

        onResponse<RequestRepeatQuestion> {
            furhat.gesture(Gestures.BrowRaise)
            furhat.ledStrip.solid(java.awt.Color(127,0,0))
            furhat.ask(QuestionSet.current.text)
        }

        // The user wants to hear the options again
        onResponse<RequestRepeatOptions> {
            furhat.gesture(Gestures.Surprise)
            furhat.ledStrip.solid(java.awt.Color(127,0,0))
            random(
                { furhat.ask("They are ${QuestionSet.current.getOptionsString()}") },
                { furhat.ask(QuestionSet.current.getOptionsString()) }
            )
        }

        // If we don't get any response, we assume the user was too slow


        /* If we get a response that doesn't map to any alternative or any of the above handlers,
        we track how many times this has happened in a row and give them two more attempts and
        finally moving on if we still don't get it.
     */

    onResponse {
        furhat.ledStrip.solid(java.awt.Color(127,0,0))
        var replygpt= getNLGResponseFromGPT(("the correct answer is  "+ QuestionSet.current.makeans() +"give a brief explanation or an amusing fact about this"))
        call(theparser(replygpt))
        goto(Assistant)
    }
    onNoResponse {
        furhat.ledStrip.solid(java.awt.Color(0,127,0))
        furhat.listen(7000)
        goto(Assistant) }
}