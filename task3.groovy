import groovy.xml.XmlParser

def CountLastNames(){
    def file=new File("Employee.xml")
    def parser= new XmlParser()
    def root=parser.parse(file)
    def CsvFile=new File("countlastnames.csv")
    def Title= new StringBuilder()
    Title.append("Lastname,Count\n")
    def CountLastNames=[:]

    root.employee.each{emp->
        def name=emp.employee_info.personal_info.surname.text()
        if(CountLastNames.containsKey(name)){
            CountLastNames[name]=CountLastNames[name] + 1
        }else{
            CountLastNames[name]=1
        }



    }
    CountLastNames.each{lastname,count ->
        Title.append("$lastname,$count\n")
    }

    CsvFile.write(Title.toString())


}
CountLastNames()