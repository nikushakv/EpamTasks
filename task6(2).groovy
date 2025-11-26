import groovy.xml.XmlParser
import groovy.xml.XmlUtil

def task6(){
    def file= new File("Employee.xml")
    def parser=new XmlParser()
    def root = parser.parse(file)

    Date date = Date.parse('yyyy-MM-dd', '2020-01-31')
    int dateInt = date.format('yyyyMMdd') as Integer

    root.employee.each{ emp ->
        def StartDate = emp.employee_info.start_date.text()

        if (StartDate) {
            Date tempDate = Date.parse('yyyy-MM-dd', StartDate)
            int StartDateInt = tempDate.format('yyyyMMdd') as Integer
            if( StartDateInt < dateInt ){
                emp.parent().remove(emp)
            }
        }
    }
    new File("Employee_Task6.xml").write(XmlUtil.serialize(root))
}

task6()