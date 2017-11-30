import aaa.AAA
import aaa.MyInterface

internal class DontCreateMe : MyInterface , AAA {
    override fun bar() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun foo() {
        super<MyInterface>.foo()
        super<AAA>.foo()
        val l = mutableListOf(1, 2, 3)
        l.swap1(0, 2)
    }
    fun MutableList<Int>.swap1(x: Int, y: Int) {
        val temp = this[x] // this 对应 list
        this[x] = this[y]
        this[y] = 2
    }
}