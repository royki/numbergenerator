package generator

trait RandomNumber {
    def next: (Long, Generator)
    def factor: Long
}

final case class Generator(start: Long, factor: Long) extends RandomNumber {
    private val mod: Long = 2147483647L
    override def next: (Long, Generator) = {
        val newSeed = (start * factor) % mod 
        val nextRandom = Generator(newSeed, factor)
        (newSeed, nextRandom)
    }
}

object Produce {
    val A: Long = 65
    val B: Long = 8921
    val factorA: Long = 16807
    val factorB: Long = 48271
    val process_amount: Int = 4000000

    def make(start: Long, factor: Long): Stream[Generator] = {
        def loop(s: Long): Stream[Generator] = {
          val (newSeed, nextRandom) = Generator(s, factor).next
        
          nextRandom #:: loop(newSeed)
        }

        loop(start)
    }

    def generator(s: Long, f: Long, num: Int): List[Long] = {
        make(s, f).take(num).map(x => x.start).toList
    }    
}

class MatchingPairs(genA: List[Long], genB: List[Long]) {    

    def value: List[(Long, Long)] = {    
        genA.zip(genB).filter {
            case (a, b) => (a & 0x0000FFFFL) == (b & 0x0000FFFFL)
        }
    }
    
    def size: Int = value.size
}

object Generator extends App {

    val generatorA = Produce.generator(Produce.A, Produce.factorA, Produce.process_amount)
    val generatorB = Produce.generator(Produce.B, Produce.factorB, Produce.process_amount)
    
    val generator = new MatchingPairs(generatorA, generatorB)

    val number_of_matching_pairs = generator.size
    println(s"$number_of_matching_pairs Number of Matching Pairs are found from 2 random number generators that process ${Produce.process_amount} number")
    println
    val all_matching_pairs = generator.value
    println("Matching Pairs in Decimal")
    all_matching_pairs.foreach(println)
    println
    println("Matching Pairs in Binary")
    all_matching_pairs.foreach{
        x => println(x._1.toBinaryString, x._2.toBinaryString)
    }
}

   
