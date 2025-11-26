import groovy.xml.XmlParser
import groovy.xml.XmlUtil


def task4() {
    def File = new File("USA_Names_Boys.txt")
    def SecondFile = new File("USA_Names_Girls.txt")
    def top50Boy = []
    def top50Girl = []

    File.eachLine { line, linenumber ->
        if (linenumber > 1 && linenumber <= 51) {
            def parts = line.split(/\s+/)
            if (parts.size() >= 2) {
                top50Boy.add(parts[1])
            }
        }
    }

    SecondFile.eachLine { line, linenumber ->
        if (linenumber > 1 && linenumber <= 51) {
            def parts = line.split(/\s+/)
            if (parts.size() >= 2) {
                top50Girl.add(parts[1])
            }
        }
    }


    def xmlFile = new File("Employee.xml")
    def parser = new XmlParser()
    def root = parser.parse(xmlFile)
    def rand = new Random()


    root.employee.each { emp ->
        def gender = emp.employee_info.personal_info.gender.text()
        def name = emp.employee_info.personal_info.firstname.text()


        if (gender == "Male") {
            if (!top50Boy.contains(name)) {
                def replacement = top50Boy[rand.nextInt(top50Boy.size())]
                emp.employee_info.personal_info.firstname[0].value = replacement

            }
        } else {
            if (!top50Girl.contains(name)) {
                def replacement = top50Girl[rand.nextInt(top50Girl.size())]
                emp.employee_info.personal_info.firstname[0].value = replacement

            }

        }


    }


    new File("Employee_Task4.xml").write(XmlUtil.serialize(root))

}

task4()

