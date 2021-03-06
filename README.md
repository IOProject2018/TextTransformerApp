# TextTransformerApp
![Build status](<https://travis-ci.com/IOProject2018/TextTransformerApp.svg?branch=develop>)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/5c58de9c63e147c8abaf35dd2f6369e3)](https://www.codacy.com/app/MIKOLAJW197/TextTransformerApp?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=IOProject2018/TextTransformerApp&amp;utm_campaign=Badge_Grade)

Rejestr Produktu https://trello.com/b/9JWJnCzx/texttransformer

# Zasady pracy z kodem
* wybieramy zadanie (przypisujemy się do niego)
* pracujemy we własnych branchu nazwanym zgodnie z aktualnie rozwijaną funkcjonalnością
* gdy skończymy pracę i uważamy że jest ok, tworzymy pull request do branchu develop
* branch develop ustawiony jest tak, że potrzebne są co najmniej dwie okejki od innych członków zespołu, oraz (w przyszłości) przejście testów w Jenkinsie, aby zmergować kod
* po otrzymaniu okejek, upewniamy się że github nie wyświetla żadnych konfliktów (a będą) i mergujemy branch
* sprawdzający - w razie jakichkolwiek wątpliwości co do jakości wrzucanego kodu, komentujcie PR z prośbą o wyjaśnienie
* usuwamy branch roboczy, odhaczamy zadanie jako zakończone

# Zasady zadań i ocen
* są zadania administracyjne (Prowadzenie), infrastrukturalne (DoD) i programistyczne (BV). Zadania programistyczne są w częściach na githubie. Wszystko jest na trello.
* każdy bierze co chce tak żeby każdy miał tyle samo czasowo do zrobienia
* na koniec sprintu każdy dostaje max punktów lub % punktów odpowiadający ilości zadań (czasowo, a nie punktowo) jakie wykonał. Tzn: każdy dostaje procent_wykonany*liczba_punktów_za_sprint/5
* proponuje że jeśli zostaną punkty po tych co nie zrobią wszystkiego, pozostałe punkty podzielić po równo między tych z 100% wykonania

#Jacoco plugin
* Budujemy aplikację, lub odpalamy same testy
```
mvn test
```
* Następuje wygenerowanie pliku binarnego```jacoco.exec                                       ```
* Generujemy raport:
```
mvn jacoco:report
```
* Otwieramy plik `.html` znajdujacy się w folderze:
``
target/site/jacoco/index.html
``