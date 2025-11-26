import groovy.xml.XmlParser
import groovy.xml.XmlUtil

def task7() {
    def file = new File("Employee.xml")
    def parser = new XmlParser()
    def root = parser.parse(file)
    def normalList = new ArrayList(root.children())

    normalList.sort { a, b ->
        a.employee_info.start_date.text() <=> b.employee_info.start_date.text()
    }

    root.children().clear()

    normalList.each { emp ->
        root.append(emp)
    }

    new File("Employee_Task7.xml").write(XmlUtil.serialize(root))
}

task7()