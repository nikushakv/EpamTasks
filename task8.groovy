import java.util.zip.ZipEntry
import java.util.zip.ZipOutputStream

def task8() {
    def sourceFile = new File("Employee.xml")
    def zipFile = new File("Employee.zip")

    def zipOutputStream = new ZipOutputStream(new FileOutputStream(zipFile))
    def zipEntry = new ZipEntry(sourceFile.name)

    zipOutputStream.putNextEntry(zipEntry)
    zipOutputStream.write(sourceFile.bytes)

    zipOutputStream.closeEntry()
    zipOutputStream.close()
}

task8()
