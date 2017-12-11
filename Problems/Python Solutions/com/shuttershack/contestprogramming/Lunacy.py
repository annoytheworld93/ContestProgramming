number = float(input())

def calculateWeight(earth_weight):
    moon_weight = earth_weight * 0.167
    return moon_weight

while number != -1:
    number = number

    moon_weight = float(calculateWeight(number))
    print("{:.2f} {:.2f}".format(number, moon_weight))
    #print(str(number) + " " + str(moon_weight, 2))
    number = float(input())
