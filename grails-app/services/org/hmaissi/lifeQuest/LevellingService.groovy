package org.hmaissi.lifeQuest

class LevellingService {

    def int getLevelFromXp(int xpPoints) {
        if (xpPoints > 0 && xpPoints < 83) {
            return 1
        } else if(xpPoints > 83 && xpPoints < 174) {
            return 2
        }else if(xpPoints > 83 && xpPoints < 174) {
            return 3
        }else if(xpPoints > 174 && xpPoints < 276) {
            return 4
        }else if(xpPoints > 276 && xpPoints < 388) {
            return 5
        }else if(xpPoints > 388 && xpPoints < 512) {
            return 6
        }else if(xpPoints > 512 && xpPoints < 650) {
            return 7
        }else if(xpPoints > 801 && xpPoints < 969) {
            return 8
        }else if(xpPoints > 969 && xpPoints < 1154) {
            return 9
        } else {
            return 0
        }
    }
}
