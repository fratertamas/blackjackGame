 CardTest.java
 * egységes elnevezési konvenciók: szép, hogy test** a teszt függvények neve
 * card változót felesleges kiemelni, csak az utoló teszted használja, viszont az is új értéket állít be
 * testToCreateCardCreated - idea-ba állítsd be a sonarLint plugint, az is szól, hogy felesleges assertNotNull-t használnod, mivel a paraméterét new-val létre is hozod, így feleslegesek ezek az ellenőrzések
 * testValueOfCardGetValue -> ez a teszt csak arról szóljon, hogy csinálsz egy card objektumot, és ellenőrizd le, hogy a getValue valóban jó értékkel tér vissza. Az enum értékének az ellenőrzését (NINE.getValue()) egy külön tesztbe menjen (pl.: ValueOfCardTest.java), és itt csak az enumod függvényeit teszteld
 * testSuitOfCardGetSuit ez így tökéletes ahogy van :)
 
DeckOfCardTest.java
 * azta! Ez tetszik :D

PlayerTest.java
 * testPlayerCreated - felesleges, a 15. sorban ott van hogy a testPlayert megcsináltad :) szerintem ezt ki lehet venni, csak megtéveszt, hogy itt mit is akarsz tesztelni?!
 * testPlayerAndDealerCreated - assertNotSame - ez is felesleges, mivel objectid ( == ) alapján hasonlít, és a 26. sorban ott a new, így biztosan nem lesz ugyanaz az objektum... ezt szóban beszéljük majd át ;)
 * throws Exception nem kell
 * testPlayersGetScore - itt nemm kell a dealert tesztelni, mivel az is csak egy Player.. itt a getScore-on van a hangsúly
 * testCheckNextCard - már van egy ilyen teszted, miben tér el a testPlayerHasHand-től?
 
GameTest.java
 * ez tetszik! testMoneyAndPlayerBet konkrét összeggel tudna dolgozhatni az assertben?
 * checkPlayerBet fura, hogy visszaad egy int-et, ennek kellene egy jobb név
 * getTest-ben nincs assert, ez lehet hogy felesleges
 
osztályok / szerepek rendben vannak
git commit-ok rendben vannak

Összességében rendben van, amit ide írtam, ezek finomságok, fontos finomságok, amit az iskolában nem tanítanak.