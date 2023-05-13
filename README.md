Sæt følgende ind i et skript, for at kunne gøre brug af pluginet i skript:
<------------------------------------------------------------------------>
import:
    com.sommer.coinsystem.coins.CoinManager

offlineplayer property coins:
    return type: integer
    get:
        return CoinManager.getCoins(expr-1) ? 0
    set:
        CoinManager.setCoins(expr-1, change value)
    add:
        CoinManager.addCoins(expr-1, change value)
    remove:
        CoinManager.removeCoins(expr-1, change value)
<------------------------------------------------------------------------>
Et eksempel på, hvordan det bruges i skript:
<------------------------------------------------------------------------>
command /tjekcoins <integer>:
    trigger:
        if player's coins > arg-1:
            send "&aDu har mere end %arg-1% coins!"
        else:
            send "&cDu har under %arg-1% coins!"
  <------------------------------------------------------------------------>
