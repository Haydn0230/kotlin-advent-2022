package com.githhub.haydn0230

import com.githhub.haydn0230.day1.ExpenseReport
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

val testdata = listOf<Int>(
    1721,
    979,
    366,
    299,
    675,
    1456,
)

class ExpenseReportTest : StringSpec({
    "should multiply two numbers that equal 2020 returning 514579" {
        ExpenseReport(2020, testdata).checkTwoEntries() shouldBe 514579
    }

    "should multiply three numbers that equal 2020 returning 241861950" {
        ExpenseReport(2020, testdata).checkThreeEntries() shouldBe 241861950
    }


})
