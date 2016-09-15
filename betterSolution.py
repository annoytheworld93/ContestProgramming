from __future__ import print_function
from pprint import pprint

number_of_test_cases = int(raw_input())

def number_matrix(matrix):
    for row in matrix:
        for cell in row:
            if cell == "X":
                cell = 1
            else:
                cell = 0
    return matrix


for _ in range(number_of_test_cases):
    # height of the image
    n = int(raw_input())

    # width of the image
    m = int(raw_input())

    pattern = []
    for _ in range(n):
        line = raw_input()
        pattern.append(list(line))
    # print("pattern:")
    pprint(pattern)
    print("")

    #pattern = number_matrix(pattern)
    #pprint(pattern)
    #print("")

    for i in range(m):
        for j in range(n):
            print(pattern[i][j])
            if pattern[i][j] == "X":
                on_region = True

