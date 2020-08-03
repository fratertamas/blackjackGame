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

## REFACT után, level 2

CardTest.java
 * 11. sor: legyen egységes, ez szerintem mehet a 12. sorban, nem kell külön kiemelni a card változót
 * 27. sor: ez itt pl oké
 * az enumnál teszteled, hogy az enum getValue()-ja 4... itt azt kell tesztelni, hogy KING jöjjön vissza

DeckOfCardTest.java
 * még mindig tetszik, de level2-n van pár apró észrevétel
 * 10., 11. sor: osztály szintű változó legyen private
 * 78. sorban lévő teszt assert-je sántít, 84. sorba csináltam egy tesztet

PlayerTest.java
 * kukacoskodás, de itt is lehet private a player
 * 30. sor: elvileg a unit tesztek sorrendje random.... ha ezt követően fut le a 25. sorban lévő, akkor ez bukó teszthez vezet

GameTest.java
 * 18. sor: felesleges az asertNotNull, mivel a 13. sorban a before miatt minden teszt előtt lefut
 * 26. sor: érdemes megnézni, hogyan olvashatóbb: így, vagy ha a 31,32... sorban a cardX helyett new Card(XXX) szerepel (inline-osításra gondolok :))
 * 43. sor: assertTrue ;)



