import sys

def distance_vector_routing(graph, src):
    n = len(graph)
    dist = [sys.maxsize] * n        # Distance table
    parent = [-1] * n               # Parent to track next hop

    dist[src] = 0

    # Relax edges n-1 times (Bellman-Ford core logic)
    for _ in range(n - 1):
        for u in range(n):
            for v in range(n):
                if graph[u][v] != 0 and dist[u] + graph[u][v] < dist[v]:
                    dist[v] = dist[u] + graph[u][v]
                    parent[v] = u

    return dist, parent

def get_next_hop(parent, src, dest):
    if parent[dest] == -1:
        return dest
    while parent[dest] != src and parent[dest] != -1:
        dest = parent[dest]
    return dest

def print_routing_table(dist, parent, src):
    print(f"\nRouting Table for Source Router: {src + 1}")
    print("Destination\tNext Hop\tShortest Distance")
    for dest in range(len(dist)):
        if dest == src:
            continue
        next_hop = get_next_hop(parent, src, dest)
        print(f"{dest + 1}\t\t{next_hop + 1}\t\t{dist[dest]}")

# Main Program
if __name__ == "__main__":
    n = int(input("Enter the number of routers (nodes): "))
    print("\nEnter the cost matrix (0 if no direct link):")
    graph = []
    for i in range(n):
        row = list(map(int, input(f"Row {i+1}: ").split()))
        graph.append(row)

    src = int(input("\nEnter the source router (1 to n): ")) - 1

    dist, parent = distance_vector_routing(graph, src)
    print_routing_table(dist, parent, src)
