import groovy.xml.MarkupBuilder
import groovy.xml.MarkupBuilder
import java.time.LocalDate

def AllName(){
    def rand= new Random()
    def BoyNames= []
    def GirlNames= []
    def boysfile= new File("USA_Names_Boys.txt")
    def girlsfile = new File("USA_Names_Girls.txt")
    def today=LocalDate.now()

    def writer= new StringWriter()
    def xml= new MarkupBuilder(writer)

    def RandomSurname  = [
            "Smith",
            "Johnson",
            "Williams",
            "Brown",
            "Jones",
            "Garcia",
            "Miller",
            "Davis",
            "Rodriguez",
            "Martinez",
            "Hernandez",
            "Lopez",
            "Gonzalez",
            "Wilson",
            "Anderson",
            "Thomas",
            "Taylor",
            "Moore",
            "Jackson",
            "Martin"
    ]

    boysfile.eachLine{line,linenumber->
        if(linenumber > 1) {
            def parts = line.split(/\s+/)

            if(parts.size() >= 2){
                BoyNames.add(parts[1])
            }

        }
    }

    girlsfile.eachLine{line,linenumber ->

        if(linenumber>1){
            def parts = line.split(/\s+/)

            if (parts.size() >= 2){
                GirlNames.add(parts[1])
            }
        }
    }



    xml.root {
        (1..100).each { i ->
            def RandomDay=rand.nextInt(365)
            def RandomStartDate=today.minusDays(RandomDay)
            def isMale = rand.nextBoolean()
            def empGender = isMale ? "Male" : "Female"
            def currentNameList = isMale ? BoyNames : GirlNames
            def empName = currentNameList[ rand.nextInt(currentNameList.size()) ]
            def empSurname = RandomSurname[ rand.nextInt(RandomSurname.size()) ]
            employee {
                employee_info {
                    start_date(RandomStartDate)
                    personal_info {
                        gender(empGender)
                        firstname(empName)
                        surname(empSurname)

                    }
                }
            }


        }

    }




    new File("Employee.xml").write(writer.toString())






}

AllName()