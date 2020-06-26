package com.example.studykotlin.dsl

import org.junit.Test

/**
 * TODO
 *
 * @author meijie05
 * @since 2020/6/26 上午9:07
 */


class Cpu {
    var core: Int = 0
    var arch: String = "32 bits"

    fun core(core: Int) {
        this.core = core
    }

    fun arch(arch: String) {
        this.arch = arch
    }


    fun show() {
        println("Cpu $core , $arch")
    }


}

fun cpu(block: (Cpu) -> Unit): Cpu {
    val cpu = Cpu()
    block(cpu)
    return cpu
}

// 参数类型为 Cpu 类的扩展类型
fun cpu2(init: Cpu.() -> Unit): Cpu {
    val cpu = Cpu()
    cpu.init()
    return cpu
}

class DslTest {

    @Test
    fun test() {
        val cpu = cpu {
            it.core(2)
            it.arch("64 bits")
        }

        cpu.show()
    }

    @Test
    fun test1() {
        val cpu = cpu2 {
            core(4)
            arch("64 bits")
        }

        cpu.show()
    }

    @Test
    fun test2() {
        val cpu = Cpu()
        with(cpu) {
            core(2)
            arch("xxx")
        }
    }

    @Test
    fun test3() {
        Cpu().apply {
            core(2)
            arch("yyy")
        }
    }
}