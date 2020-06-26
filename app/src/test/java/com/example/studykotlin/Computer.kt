package com.example.studykotlin

class Computer(val disk: Int) {

    var availableSpace: Int = 0

    var usedSpace: Int
        get() {
            return disk - availableSpace
        }
        set(value) {
            availableSpace -= value
        }

    // 以下代码回导致栈溢出，因为赋值 price = value 会不停的调用 set 方法，需要使用幕后字段来赋值
//    var price: Int = 0
//        set(value) {
//            if (value < 0) {
//                price = 0
//            } else {
//                price = value
//            }
//        }

    var price: Int = 0
        set(value) {
            if (value < 0) {
                // 访问器（set 方法）可以读取或修改隐式参数 filed 的值访问隐藏在该属性背后字段的值
                field = 0
            } else {
                field = value
            }
        }

    var firstName = ""

    // 内联属性 数据只有访问器，没有幕后字段。
    inline var name: String
        get() = firstName
        set(value) {
            this.firstName = value
        }
}