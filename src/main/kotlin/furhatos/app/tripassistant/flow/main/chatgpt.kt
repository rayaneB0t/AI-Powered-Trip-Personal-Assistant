package furhatos.app.tripassistant.flow.main

import com.theokanning.openai.service.OpenAiService
import com.theokanning.openai.completion.CompletionRequest
import furhatos.flow.kotlin.*

val serviceKey = "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"

fun getNLGResponseFromGPT(input: String, histval: Int = 10): String {
    val service = OpenAiService(serviceKey)
    val history = Furhat.dialogHistory.all.takeLast(histval).mapNotNull {
        when (it) {
            is DialogHistory.ResponseItem -> {
                "User: ${it.response.text}"
            }
            is DialogHistory.UtteranceItem -> {
                "Atlas: ${it.toText()}"
            }
            else -> null
        }
    }.joinToString(separator = "\n")

    var conversationInput = "The following is a conversation with an AI assistant named Atlas. Atlas is knowledgeable, friendly, and helpful, specializing in travel planning and advice. Atlas engages with users to offer travel suggestions and planning tips.\n"
    if (input.trim().isNotEmpty()) {
        conversationInput += "Here are some additional details for reference:\n"
        conversationInput += input
    }
    conversationInput += "\nHere are the recent interactions between Atlas and the user:\n"
    conversationInput += history
    conversationInput += "\nAtlas should now provide a concise and informative response. The response should be engaging, with appropriate travel-related suggestions or clarifications. Avoid unnecessary information and ensure the advice is practical and relevant to the user's query. Atlas: ?"

    var response = ""
    val lengthOfPrompt = conversationInput.length
    val temperature = 0.7
    val maxTokens = 100
    val topP = 0.6
    val frequencyPenalty = 0.0
    val presencePenalty = 0.3

    val completionRequest = CompletionRequest.builder()
        .model("text-davinci-003")
        .temperature(temperature)
        .topP(topP)
        .frequencyPenalty(frequencyPenalty)
        .presencePenalty(presencePenalty)
        .maxTokens(maxTokens)
        .prompt(conversationInput)
        .echo(true)
        .build()

    try {
        val completion = service.createCompletion(completionRequest).choices.first().text
        response = completion.trim()
    } catch (e: Exception) {
        println("Problem with connection to OpenAI: " + e.message)
        response = "I'm having trouble connecting to my resources at the moment. Could you please repeat your question or ask something else?"
        return response
    }

    return response.drop(lengthOfPrompt)
}
