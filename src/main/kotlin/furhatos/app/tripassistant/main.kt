package furhatos.app.tripassistant

import furhatos.app.tripassistant.flow.Init
import furhatos.flow.kotlin.Flow
import furhatos.skills.Skill

class TripAssistantSkill : Skill(){
    override fun start() {
    Flow().run(Init)
    }
}

fun main(args: Array<String>) {
    Skill.main(args)
}
