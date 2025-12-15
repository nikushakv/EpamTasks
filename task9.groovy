def zipFile = new File("Employee.zip")
def zipContent = zipFile.bytes

def encodedContent = zipContent.encodeBase64().toString()

def b64File = new File("Employee.b64")
b64File.text = encodedContent

def command = "gpg --batch --yes --passphrase mypassword -c -o Employee.pgp Employee.b64"
def process = command.execute()
process.waitFor()

