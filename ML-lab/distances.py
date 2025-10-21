def euclidean_distance(p1, p2):
    s = 0
    for i in range(len(p1)):
        d = p1[i] - p2[i]
        s += d * d
    x = s
    guess = x / 2 if x > 1 else 1
    for _ in range(20):
        guess = (guess + x / guess) / 2
    return guess

def manhattan_distance(p1, p2):
    s = 0
    for i in range(len(p1)):
        d = p1[i] - p2[i]
        if d < 0:
            d = -d
        s += d
    return s

def minkowski_distance(p1, p2, order):
    s = 0
    for i in range(len(p1)):
        d = p1[i] - p2[i]
        if d < 0:
            d = -d
        s += d ** order
    x = s
    guess = x / 2 if x > 1 else 1
    for _ in range(20):
        guess = ((order - 1) * guess + x / (guess ** (order - 1))) / order
    return guess

def main():
    dataset = [
        [1, 2, 3],
        [4, 5, 6],
        [7, 8, 9],
        [10, 11, 12]
    ]

    for i in range(len(dataset)):
        print("Point", i, ":", dataset[i])

    i1 = int(input("Enter index of first point: "))
    i2 = int(input("Enter index of second point: "))
    p1, p2 = dataset[i1], dataset[i2]

    print("1. Euclidean Distance")
    print("2. Manhattan Distance")
    print("3. Minkowski Distance")

    choice = int(input("Enter your choice (1/2/3): "))

    if choice == 1:
        dist = euclidean_distance(p1, p2)
        print("Euclidean Distance =", dist)
    elif choice == 2:
        dist = manhattan_distance(p1, p2)
        print("Manhattan Distance =", dist)
    elif choice == 3:
        order = int(input("Enter the order: "))
        dist = minkowski_distance(p1, p2, order)
        print("Minkowski Distance (order=" + str(order) + ") =", dist)
    else:
        print("Invalid choice")

if __name__ == "__main__":
    main()