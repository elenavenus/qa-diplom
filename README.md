# Инструкция к запуску автотестов

1. Склонировать репозиторий
2. Установить docker, если он не установлен
3. Установить jdk 11 или выше, если он не установлен
4. Установить переменные среды JAVA_HOME с корневой папкой jdk (например C:\Program Files\Java\jdk1.8.0_341)
5. Добавить в переменную PATH путь %JAVA_HOME%/bin (например C:\Program Files\Java\jdk1.8.0_341\bin)
6. Собрать образы всех сервисов. Для этого:
- Собрать образ sut. Для этого:
    - Перейти в папку внутри проекта \docker\sut
    - Выполнить команду docker build -t sut .
- Собрать образ gate-simulator. Для этого:
    - Перейти в папку внутри проекта \docker\gate-simulator
    - Выполнить команду docker build -t gate-simulator .
7. Запустить docker-compose для PostgreSQL в отдельной консоли. Для этого:
- Открыть отдельную консоль
- Перейти в папку внутри проекта \docker\compose\postgres
- Запустить команду docker-compose up
- Дождаться полного запуска всех контейнеров
8. Запустить тесты в gradle
- Перейти в корневую папку проекта
- Выполнить команду gradlew.bat clean test - для Windows или команду gradlew clean test - для Linux
9. Сгенерировать отчёт в Allure
- Перейти в корневую папку проекта
- Выполнить команду gradlew.bat allureReport - для Windows или команду gradlew allureReport - для Linux
10. Запустить сервис Allure для просмотра отчёта
- Перейти в корневую папку проекта
- Выполнить команду gradlew.bat allureServe - для Windows или команду gradlew allureServe - для Linux
11. Отключить docker-compose процессы из шага 7
- Перейти в консоль открытую на шаге 7
- Нажать сочетание клавиш CTRL + C
12. Запустить docker-compose для MySQL в отдельной консоли
- Открыть отдельную консоль
- Перейти в папку внутри проекта \docker\compose\mysql
- Запустить команду docker-compose up
- Дождаться полного запуска всех контейнеров
13. Запустить тесты в gradle
- Перейти в корневую папку проекта
- Выполнить команду gradlew.bat clean test - для Windows или команду gradlew clean test - для Linux
14. Сгенерировать отчёт в Allure
- Перейти в корневую папку проекта
- Выполнить команду gradlew.bat allureReport - для Windows или команду gradlew allureReport - для Linux
15. Запустить сервис Allure для просмотра отчёта
- Перейти в корневую папку проекта
- Выполнить команду gradlew.bat allureServe - для Windows или команду gradlew allureServe - для Linux
16. Отключить docker-compose процессы из шага 12
- Перейти в консоль открытую на шаге 12
- Нажать сочетание клавиш CTRL + C
