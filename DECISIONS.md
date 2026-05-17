## 1
Wzorzec Strategy
Promocje zostały zaimplementowane przy użyciu wzorca Strategy.
Każda promocja jest osobną klasą implementującą interfejs Promotion.
Pozwala to na łatwe dodawanie nowych promocji bez modyfikowania istniejacego kodu,
oraz dynamiczne zmienianie zestawu promocji w trakcie działania programu

## 2
Klasa Product została zaprojektowana jako niemutowalna
Pola są final,
zmiana ceny odbywa się przez metodę withDiscountPrice, która tworzy nowy obiekt.

## 3
Do sortowania użyto interfejsu Comparator

## 4 
Kod obsługuje sytuacje brzegowe (pusty koszyk, produkt null, cena 0)

