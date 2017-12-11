
englishMiles = float(input())

def calculateRomanMiles(englishMiles):
    romanMiles = (englishMiles * 5280) / 4854
    return romanMiles
def calculateRomanPaces(englishMiles):
    romanPaces = englishMiles * 1000
    return romanPaces


while englishMiles != 0.0:
    romanMiles = calculateRomanMiles(englishMiles)
    romanPaces = int(round(calculateRomanPaces(romanMiles), 0))
    print("{:.2f} English miles equals {:.2f} Roman miles or ".format(englishMiles, romanMiles) + str(romanPaces) + " paces.")
    englishMiles = float(input())
