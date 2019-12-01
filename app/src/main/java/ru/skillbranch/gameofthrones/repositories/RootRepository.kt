package ru.skillbranch.gameofthrones.repositories

import androidx.annotation.VisibleForTesting
import ru.skillbranch.gameofthrones.data.local.entities.CharacterFull
import ru.skillbranch.gameofthrones.data.local.entities.CharacterItem
import ru.skillbranch.gameofthrones.data.local.entities.House
import ru.skillbranch.gameofthrones.data.remote.res.CharacterRes
import ru.skillbranch.gameofthrones.data.remote.res.HouseRes
import javax.inject.Inject

object RootRepository  {


    /**
     * Получение данных о всех домах
     * @param result - колбек содержащий в себе список данных о домах
     */
    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    fun getAllHouses(result : (houses : List<HouseRes>) -> Unit) {

    }

    /**
     * Получение данных о требуемых домах по их полным именам (например фильтрация всех домов)
     * @param houseNames - массив полных названий домов (смотри App)
     * @param result - колбек содержащий в себе список данных о домах
     */
    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    fun getNeedHouses(vararg houseNames: String, result : (houses : List<HouseRes>) -> Unit) {
        //TODO implement me
    }

    /**
     * Получение данных о требуемых домах по их полным именам и персонажах в каждом из домов
     * @param houseNames - массив полных названий домов (смотри App)
     * @param result - колбек содержащий в себе список данных о доме и персонажей в нем (Дом - Список Персонажей в нем)
     */
    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    fun getNeedHouseWithCharacters(vararg houseNames: String, result : (houses : List<Pair<HouseRes, List<CharacterRes>>>) -> Unit) {
        //TODO implement me
    }

    /**
     * Запись данных о домах в DB
     * @param houses - Список персонажей (модель HouseRes - модель ответа из сети)
     * необходимо произвести трансформацию данных
     * @param complete - колбек о завершении вставки записей db
     */
    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    fun insertHouses(houses : List<HouseRes>, complete: () -> Unit) {
        //TODO implement me
    }

    /**
     * Запись данных о пересонажах в DB
     * @param Characters - Список персонажей (модель CharacterRes - модель ответа из сети)
     * необходимо произвести трансформацию данных
     * @param complete - колбек о завершении вставки записей db
     */
    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    fun insertCharacters(Characters : List<CharacterRes>, complete: () -> Unit) {
        //TODO implement me
    }

    /**
     * При вызове данного метода необходимо выполнить удаление всех записей в db
     * @param complete - колбек о завершении очистки db
     */
    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    fun dropDb(complete: () -> Unit) {
        //TODO implement me
    }

    /**
     * Поиск всех персонажей по имени дома, должен вернуть список краткой информации о персонажах
     * дома - смотри модель CharacterItem
     * @param name - краткое имя дома (его первычный ключ)
     * @param result - колбек содержащий в себе список краткой информации о персонажах дома
     */
    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    fun findCharactersByHouseName(name : String, result: (Characters : List<CharacterItem>) -> Unit) {
        //TODO implement me
    }

    /**
     * Поиск персонажа по его идентификатору, должен вернуть полную информацию о персонаже
     * и его родственных отношения - смотри модель CharacterFull
     * @param id - идентификатор персонажа
     * @param result - колбек содержащий в себе полную информацию о персонаже
     */
    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    fun findCharacterFullById(id : String, result: (Character : CharacterFull) -> Unit) {
        //TODO implement me
    }

    /**
     * Метод возвращет true если в базе нет ни одной записи, иначе false
     * @param result - колбек о завершении очистки db
     */
    fun isNeedUpdate(result: (isNeed : Boolean) -> Unit){
        //TODO implement me
    }

    /**
     * Разработка клиент-серверного приложения
    Game of thrones
    Необходимо разработать клиент серверное приложение Game of Thrones содержащее минимум три функциональных экрана SplashScreen - загрузочный экран,ChartersListScreen -
    экран домов и списка персонажей (ViewPager, TabLayout), CharacterScreen - Экран просмотра детальной информации о персонаже.
    +10
    SplashScreen :

    1. При старте приложения должна быть индикация загрузки минимальное время загрузки 5с или колбек о завершении запроса к API

    2. При первом старте осуществляется запрос к API и полученные результаты Сохраняются в локальную БД (Базу данных), при последующих запусках приложения данные должны считываться из БД

    3. Если в БД нет записей (первый запуск) и отсутствует соединение с сетью отображать Snackbar (Duration = Snackbar.LENGTH_INDEFINITE)
    с сообщением "Интернет недоступен - приложение не может быть запущенно. Подключитесь к интернету и перезапустите приложение"

    4. После окончания синхронизации данных (получение данных из API и запись в ДБ) или Splash анимации переключить пользователя на экран - CharactersListScreen.
    При этом при нажатии на системную клавишу Back НЕ должно происходить возвращение на SplashScreen



    CharactersListScreen :

    1. Необходимо отобразить в ViewPager и TabLayout 6 домов и список персонажей в каждом из домов в следующей последовательности (слeва направо)

    Stark, Lannister, Targaryen, Baratheon, Greyjoy, Martel, Tyrell

    2. При переключении между домами (свайпом или тапом по TabLayout) AppBar должен изменять цвет на основной цвет соответствующего дома (Цвета приложены к ресурсам урока)

    3. Реализовать поиск персонажа внутри дома по имени (SearchView)

    4. В каждом элементе списка содержится герб дома (приложены к ресурсам урока stark_icon, lannister_icon и т.д) Имя персонажа (Если имени нет указать - "Information is unknown").
    Строку содержащую титулу персонажа и его прозвища разделенные "•", если их нет указать - "Information is unknown".
    (Пример Arya Stark - Princess • Arya Horseface • Arya Underfoot • Arry • Lumpyface • Lumpyhead • Stickboy • Weasel • Nymeria • Squan • Saltb • Cat of the Canaly • Bets • The Blind Girh • The Ugly Little Girl • Mercedenl • Mercye).
    Максимальная высота строки описания персонжа maxLines=2 если описание не уместилось в конце второй строки должно быть многоточие (...) .

    5. При клике на элемент списка осуществить переход на страницу детальной информации персонажа - CharacterScreen



    CharacterScreen:

    1. Необходимо реализовать экран детальной информации персонажа где герб дома (stark_coast_of_arms, lannister_coast_of_arms, etc) персонажа реализован
    как CollapsingToolbarLayout (можно использовать MotionLayout) заголовком экрана должно быть имя персонажа

    2. Экран должен содержать следующую информацию:

    Девиз дома - Words:

    Когда рожден персонаж - Born:

    Титулы персонажа - Titles: (многострочный текст разделенный переносом строки)

    Прозвища персонажа - Aliases: (многострочный текст разделенный переносом строки)

    Отец персонажа - Father: (кнопка с именем персонажа если информации нет то скрывать кнопку вместе с лейблом Father: , иначе при клике по кнопке осуществлять переход на соответствующую карточку персонажа)

    Мать персонажа - Mother: (кнопка с именем персонажа если информации нет то скрывать кнопку вместе с лейблом Mother: , иначе при клике по кнопке осуществлять переход на соответствующую карточку персонажа)

    3. Если персонаж мертв то показать Snackbar (Duration = Snackbar.LENGTH_INDEFINITE) c информацией о дате смерти (Пример: Amory Lorch - "Died In 299 AC, at Harrenhal")

    4. При нажатии на стрелку "Назад" в AppBar или системную клавишу back возвращаться на предыдущий экран с сохранением состояния ViewPager т.е. если вы просматриваете
    персонажа из дома Targaryen то вы должны вернуться на страницу ViewPager Targaryen

    5. AppBar scrimColor - должен соответствовать основному цвету дома

    6. ic_icon_decor - должен соответствовать акцентному цвету дома

    7. цвет кнопок (Mother, Father) - должен соответствовать основному цвету дома



    Database:

    1. Для сохранения сущности дома в качестве первичного ключа использовать краткое название дома (Пример: "House Baratheon of Dragonstone" -> "Baratheon")

    2. В базу дома сохранять только дома с названиями указанными в App NEED_NAMES



    API:

    1. Точка входа указана в App BASE_URL

    2. Документация по API доступна по адресу https://www.anapioficeandfire.com/Documentation



    RootRepository:

    Получение данных о всех домах

    result - колбек содержащий в себе список данных о домах

    fun getAllHouses(result : (houses : List<HouseRes>) -> Unit)



    Получение данных о требуемых домах по их полным именам (например фильтрация всех домов)

    houseNames - массив полных названий домов (смотри App)

    result - колбек содержащий в себе список данных о домах

    fun getNeedHouses(vararg houseNames: String, result : (houses : List<HouseRes>) -> Unit)



    Получение данных о требуемых домах по их полным именам и персонажах в каждом из домов

    houseNames - массив полных названий домов (смотри App)

    result - колбек содержащий в себе список данных о доме и персонажей в нем (Дом - Список Персонажей в нем)

    fun getNeedHouseWithCharacters(vararg houseNames: String, result : (houses : List<Pair<HouseRes, List<CharacterRes>>>) -> Unit)



    Запись данных о домах в DB

    houses - Список персонажей (модель HouseRes - модель ответа из сети) необходимо произвести трансформацию данных

    complete - колбек о завершении вставки записей db

    fun insertHouses(houses : List<HouseRes>, complete: () -> Unit)



    Запись данных о пересонажах в DB

    Characters - Список персонажей (модель CharacterRes - модель ответа из сети) необходимо произвести трансформацию данных

    complete - колбек о завершении вставки записей db

    fun insertCharacters(Characters : List<CharacterRes>, complete: () -> Unit)



    При вызове данного метода необходимо выполнить удаление всех записей в db

    complete - колбек о завершении очистки db

    fun dropDb(complete: () -> Unit)



    Поиск всех персонажей по имени дома, должен вернуть список краткой информации о персонажах дома - смотри модель CharacterItem

    name - краткое имя дома (его первычный ключ)

    result - колбек содержащий в себе список краткой информации о персонажах дома

    fun findCharactersByHouseName(name : String, result: (Characters : List<CharacterItem>) -> Unit)



    Поиск персонажа по его идентификатору, должен вернуть полную информацию о персонаже и его родственных отношения - смотри модель CharacterFull

    id - идентификатор персонажа

    result - колбек содержащий в себе полную информацию о персонаже

    fun findCharacterFullById(id : String, result: (Character : CharacterFull) -> Unit)



    Метод возвращет true если в базе нет ни одной записи, иначе false

    result - колбек о завершении очистки db

    fun isNeedUpdate(result: (isNeed : Boolean) -> Unit)
     * */
}