# AI Powered Trip Personal Assistant Robot: Atlas

## Overview
Atlas is a conversational travel assistant designed to help users plan their journeys and explore destinations. This thesis utilizes the Furhat API to create interactive and engaging conversations with users. The assistant provides information about travel destinations, tips, and allows users to express emotions through emojis.
<img width="365" alt="Screenshot 2024-01-16 at 22 20 26" src="https://github.com/rayaneB0t/AI-Powered-Trip-Personal-Assistant/assets/83134555/17e4ac5f-7694-4fbd-a868-b08509e1e358">

<img width="1386" alt="Screenshot 2024-01-16 at 22 24 31" src="https://github.com/rayaneB0t/AI-Powered-Trip-Personal-Assistant/assets/83134555/94b609f6-2f6d-4985-9155-1f6364392214">


## Features
- **Intent Descriptions**: Descriptions for various travel-related intents are provided, allowing the assistant to respond contextually.
- **Emotional Expressions**: Users can convey their emotions using emojis, and the assistant responds with corresponding Furhat gestures.
- **Gestures Library**: Gestures such as 'thinker', 'thumbsup', and 'thumbsdown' are defined to add a visual element to the conversation.

## Project Structure
- `main.kt`: The main Kotlin file containing the flow logic, gesture definitions, and emoji processing functions.
- `furhatos.app.tripassistant.flow.main`: Package containing the main conversation flow logic.
- `furhatos.gestures`: Package containing Furhat gesture definitions.

## Dependencies
- Furhat API: https://docs.furhat.io/remote-api/





## Setup
1. Clone the repository: `git clone https://github.com/your-username/atlas-travel-assistant.git`
2. Install Furhat API and configure the project to use it.
3. Run the application.

## Usage
1. Customize the `keypairs` and `nlgdata` maps in `main.kt` to tailor the responses to your specific use case.
2. Add more gestures and expressions to enhance the conversational experience.
3. Run the application and interact with Atlas to explore its capabilities.

## License
This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details.
