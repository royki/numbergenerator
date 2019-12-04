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

object  Produce {
    val A: Long = 65
    val B: Long = 8921
    val factorA: Long = 16807
    val factorB: Long = 48271
    val process_amount: Int = 40000000

    def make(start: Long, factor: Long): Stream[Generator] = {
        def loop(s: Long): Stream[Generator] = {
          val (newSeed, nextRandom) = Generator(s, factor).next
          nextRandom #:: loop(newSeed)
        }
        loop(start)
    }

    def generator(a: Long, f: Long, num: Int): List[Long] = {
        make(a, f).take(num).map(x => x.start).toList
    }

    def leastSignificatBits_16(a: Long, f: Long, num: Int): List[Long] = {
        generator(a, f, num).map(x => (x & 0x0000FFFFL))
    }

    def countPair(genA: List[Long], genB: List[Long]): Int = {            
        genA.zip(genB).count(x => x._1 == x._2)
    }
}

object Generator extends App {

    val generatorA = Produce.leastSignificatBits_16(Produce.A, Produce.factorA, Produce.process_amount)
    val generatorB = Produce.leastSignificatBits_16(Produce.B, Produce.factorB, Produce.process_amount)
          
    val number_of_matching_pairs = Produce.countPair(generatorA, generatorB)
    println(s"$number_of_matching_pairs Number of Matching Pairs are found from 2 random number generators that process ${Produce.process_amount} number")
}

   
