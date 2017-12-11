c, h, o = map(int, input().split())

y = (2 * o - h) / 4
x = (h - 2 * c + 2 * y) / 2
z = (c - y) / 6

if x < 0 or (int(x) != x):
    print("Error")
elif y < 0 or (int(y) != y):
    print("Error")
elif z < 0 or (int(z) != z):
    print("Error")
else:
    print(int(x), int(y), int(z))
