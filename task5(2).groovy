import groovy.xml.XmlParser
import groovy.xml.XmlUtil

def task5(){
     def file = new File("Employee.xml")
     def parser = new XmlParser()
     def root= parser.parse(file)
     def IDCount = 1
    root.employee.each{emp->
        def LastName=emp.employee_info.personal_info.surname
        def fullsurname=LastName.text()

        if(fullsurname.size()>10){
            def SmallLastName=fullsurname.substring(0,10)
            LastName[0].value = SmallLastName
        }
        emp.appendNode( "ID", IDCount)
        IDCount++

    }

    new File("Employee_Task5.xml").write(XmlUtil.serialize(root))
}
task5()