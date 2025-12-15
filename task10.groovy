import java.security.MessageDigest

def file = new File("Employee.pgp")
def digest = MessageDigest.getInstance("SHA-1")

digest.update(file.bytes)
def output = digest.digest()

def hexString = new StringBuilder()
for (byte b : output) {
    hexString.append(String.format("%02x", b))
}

println hexString.toString()

