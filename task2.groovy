import groovy.xml.XmlParser


def CountFirstNames(){
    def file = new File("Employee.xml")
    def secondfile = new File("countnames.csv")
    def builder = new StringBuilder()
    builder.append("Name,Count\n")

    def parser = new XmlParser()
    def root = parser.parse(file)

    def countnames =[:]


    root.employee.each{ emp ->
        def name = emp.employee_info.personal_info.firstname.text()

        if(countnames.containsKey(name)){
            countnames[name]=countnames[name]+1

        }else{
            countnames[name]=1
        }

    }

    countnames.each{  name,count->
        builder.append("$name,$count\n")

    }

    secondfile.write(builder.toString())








}

CountFirstNames()