package generator

import org.scalatest._

class GeneratorTestSuite extends FunSuite with Matchers {
    test("1st 5 random numbers produce 1 matching pair") {
        val generatorA = Produce.generator(65, 16807, 5)
        val generatorB = Produce.generator(8921, 48271, 5)
        
        new MatchingPairs(generatorA, generatorB).size shouldBe 1
    }    
    
    test("1st 100 random numbers produce 1 matching pair") {
        val generatorA = Produce.generator(65, 16807, 100)
        val generatorB = Produce.generator(8921, 48271, 100)
        
        new MatchingPairs(generatorA, generatorB).size shouldBe 1
    }
    
    test("1 set of matching pair") {
        val generatorA = Produce.generator(65, 16807, 100)
        val generatorB = Produce.generator(8921, 48271, 100)              
        new MatchingPairs(generatorA, generatorB).value shouldBe List((245556042L,1431495498L))
    }

    test("1st 40000 random numbers produce 3 matching pairs") {
        val generatorA = Produce.generator(65, 16807, 40000)
        val generatorB = Produce.generator(8921, 48271, 40000)
              
        new MatchingPairs(generatorA, generatorB).size shouldBe 3
    }

    test("3 set of matching pairs") {
        val generatorA = Produce.generator(65, 16807, 40000)
        val generatorB = Produce.generator(8921, 48271, 40000)    

        new MatchingPairs(generatorA, generatorB).value shouldBe
                List((245556042L,1431495498L),
                    (1190547291L,729829211L),
                    (61150002L,1467421490L))
    }

    test("1st 400000 random numbers produce 5 matching pairs") {
        val generatorA = Produce.generator(65, 16807, 400000)
        val generatorB = Produce.generator(8921, 48271, 400000)
              
        new MatchingPairs(generatorA, generatorB).size shouldBe 5
    }

    test("5 set of matching pairs") {
        val generatorA = Produce.generator(65, 16807, 400000)
        val generatorB = Produce.generator(8921, 48271, 400000)   
        
        new MatchingPairs(generatorA, generatorB).value shouldBe
                List((245556042L,1431495498L),
                    (1190547291L,729829211L),
                    (61150002L,1467421490L),
                    (1597675276L,1502320396L),
                    (1719433764L,779057700L))
    }

    test("1st 4000000 random numbers produce 50 matching pairs") {
        val generatorA = Produce.generator(65, 16807, 4000000)
        val generatorB = Produce.generator(8921, 48271, 4000000)
                     
        new MatchingPairs(generatorA, generatorB).size shouldBe 50
    }

    test("50 set of matching pairs") {
        val generatorA = Produce.generator(65, 16807, 4000000)
        val generatorB = Produce.generator(8921, 48271, 4000000)              
        
        new MatchingPairs(generatorA, generatorB).value shouldBe
                List((245556042L,1431495498L),
                (1190547291L,729829211L),
                (61150002L,1467421490L),
                (1597675276L,1502320396L),
                (1719433764L,779057700L),
                (1664278139L,231399035L),
                (1959337819L,1419255643L),
                (720940047L,466332687L),
                (394587144L,741796872L),
                (1279450859L,276946667L),
                (620853143L,859142039L),
                (490380070L,821795622L),
                (880812817L,1728258833L),
                (1966877078L,1940728214L),
                (864096223L,384962527L),
                (906772155L,1903771323L),
                (1416057932L,589780044L),
                (1805317476L,258733412L),
                (421289603L,1714642563L),
                (216397239L,2138371511L),
                (1034082904L,449108568L),
                (696817386L,257660650L),
                (467730152L,2010185448L),
                (1753207336L,145609256L),
                (53298063L,1122386831L),
                (125728055L,1000633655L),
                (1650806092L,588336460L),
                (1008672214L,1131486678L),
                (1273236841L,1435766121L),
                (1180181917L,1075127709L),
                (1821689859L,32098307L),
                (1128780203L,88920491L),
                (737701488L,134573680L),
                (1838903217L,621572017L),
                (1810961625L,846337241L),
                (924803200L,442589312L),
                (1567172435L,315565907L),
                (657884172L,1517323276L),
                (1095950732L,1445585292L),
                (1639340328L,1241471272L),
                (740673710L,1070188718L),
                (472371575L,605147511L),
                (424511556L,384272452L),
                (1737154678L,387244150L),
                (2139923689L,1426236649L),
                (324612525L,488845741L),
                (244010545L,1914981937L),
                (747409766L,406098278L),
                (176738178L,838324098L),
                (486071569L,899276049L))
    }

    ignore("40 Million") {
        test("1st 40000000 random numbers produce 588 matching pairs") {
            
            val generatorA = Produce.generator(65, 16807, 40000000)
            val generatorB = Produce.generator(8921, 48271, 40000000)
                
            new MatchingPairs(generatorA, generatorB).size shouldBe 588
        }

        test("588 set of matching pairs") {
            val generatorA = Produce.generator(65, 16807, 100)
            val generatorB = Produce.generator(8921, 48271, 100)              
            
            new MatchingPairs(generatorA, generatorB).value shouldBe
                    List((245556042,1431495498),
                        (1190547291,729829211),
                        (61150002,1467421490))
        }
    }
}
