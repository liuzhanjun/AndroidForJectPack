package com.hai.yun.mydatabinding_1.data

import dagger.Component

@Component
class Student {
    lateinit var name: String;
    var age: Int = 0;

    constructor() {

    }

    constructor(name: String) {
        this.name = name
    }

}