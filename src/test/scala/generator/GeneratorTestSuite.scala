package generator

import org.scalatest._

class GeneratorTestSuite extends FunSuite with Matchers {
    test("1st 5 random numbers produce 1 matching pair") {
        val generatorA = Produce.generator(65, 16807, 5)
        val generatorB = Produce.generator(8921, 48271, 5)
              
        Produce.countPairs(generatorA, generatorB) shouldBe 1
    }

    test("1st 100 random numbers produce 1 matching pair") {
        val generatorA = Produce.generator(65, 16807, 100)
        val generatorB = Produce.generator(8921, 48271, 100)
              
        Produce.countPairs(generatorA, generatorB) shouldBe 1
    }

    test("1st 40000 random numbers produce 3 matching pair") {
        val generatorA = Produce.generator(65, 16807, 40000)
        val generatorB = Produce.generator(8921, 48271, 40000)
              
        Produce.countPairs(generatorA, generatorB) shouldBe 3
    }

    test("1st 400000 random numbers produce 5 matching pair") {
        val generatorA = Produce.generator(65, 16807, 400000)
        val generatorB = Produce.generator(8921, 48271, 400000)
              
        Produce.countPairs(generatorA, generatorB) shouldBe 5
    }

    test("1st 4000000 random numbers produce 50 matching pair") {
        val generatorA = Produce.generator(65, 16807, 4000000)
        val generatorB = Produce.generator(8921, 48271, 4000000)
              
        Produce.countPairs(generatorA, generatorB) shouldBe 50
    }

    ignore("40 Million") {
        test("1st 40000000 random numbers produce 588 matching pair") {
            
            val generatorA = Produce.generator(65, 16807, 40000000)
            val generatorB = Produce.generator(8921, 48271, 40000000)
                
            Produce.countPairs(generatorA, generatorB) shouldBe 588
        }
    }
}
