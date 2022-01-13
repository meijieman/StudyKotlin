package com.baidu.dk

/**
 * TODO
 *
 * @author meijie05
 * @since 2021/4/16 1:10 PM
 */
/**
 * @param continient 洲
 */
data class Country(
    val name: String, val continient: String, val population: Int
)

class CountryApp {

    fun filterCountries(countries: List<Country>, continient: String, population: Int): List<Country> {
        val res = mutableListOf<Country>()
        for (c in countries) {
            if (c.continient == continient && c.population > population) {
                res.add(c);
            }
        }
        return res;
    }

    fun filterCountries(countries: List<Country>, test: (Country) -> Boolean): List<Country> {
        val res = mutableListOf<Country>()
        for (c in countries) {
            if (test(c)) {
                res.add(c)
            }
        }
        return res;
    }
}

class CountryTest {
    // xxx
    fun isBigEuropeanCountry(country: Country): Boolean {
        return country.continient == "EU" && country.population > 10000;
    }
}


fun main() {
    fun1()


}

fun fun2() {
    val app = CountryApp()
    val test = CountryTest()
    var countries = listOf(Country("zn", "", 2), Country("cn", "", 0))
    app.filterCountries(countries, test::isBigEuropeanCountry)

    // 使用匿名函数
    app.filterCountries(countries, fun(country: Country): Boolean {
        return country.continient == "EU" && country.population > 10000
    })

    app.filterCountries(countries, { country -> country.continient == "EU" && country.population > 10000 })
    app.filterCountries(countries) { country -> country.continient == "EU" && country.population > 10000 }
}

private fun fun1() {
    val list = mutableListOf<Country>()
    val cn = Country("cn", "xxx", 100)
    list.add(cn)
    list.add(Country("eu", "", 20))

    for (country in list) {
        println(country)
    }

    println("-------")

    for (c in list.drop(10)) {
        println(c)
    }

    val ct = CountryTest()
    val bigEuropeanCountry: Boolean = ct.isBigEuropeanCountry(cn)
    val fun_ = ct::isBigEuropeanCountry
    val fun_1: Boolean = fun_(cn)
}

fun call(list: List<Int>): Int {
    fun recurse(listr: List<Int>, res: Int): Int {
        return if (listr.isNotEmpty()) {
            val el = listr.first()
            recurse(listr.drop(1), res * el + el)
        } else {
            res
        }

    }
    return recurse(list, 0)
}
