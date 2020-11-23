prefixes = "JKLMNOPQ"
suffix = "ack"

for p in prefixes:
    if p in "OQ":
        print(p + "u" + suffix)
    else:
        print(p + suffix)
