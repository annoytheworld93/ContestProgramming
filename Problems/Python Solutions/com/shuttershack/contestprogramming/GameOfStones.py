T = int(input())
for test_case in range(T):
    G = int(input())
    pile = []
    tot_pile = 0
    string = ""
    for i in range(G):
        tot_pile += int(input())
        string += " " + input()
    pile = [int(x) for x in string.split()]
    tot_turns = 0
    for i in pile:
        tot_turns += i//2
    if tot_turns % 2 == 0:
        print("Bob")
    else:
        print("Alice")
