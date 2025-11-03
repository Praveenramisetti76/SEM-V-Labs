import sys

def dijkstra(graph, src):
    n = len(graph)
    dist = [sys.maxsize] * n       # Store shortest distance from source
    visited = [False] * n          # Track visited nodes
    parent = [-1] * n              # Track parent node for next-hop determination

    dist[src] = 0

    for _ in range(n):
        # Select the unvisited node with the smallest distance
        u = min((dist[i], i) for i in range(n) if not visited[i])[1]
        visited[u] = True

        for v in range(n):
            if graph[u][v] != 0 and not visited[v]:  # If there's an edge
                if dist[u] + graph[u][v] < dist[v]:
                    dist[v] = dist[u] + graph[u][v]
                    parent[v] = u

    return dist, parent

def print_routing_table(dist, parent, src):
    print(f"\nRouting Table for Source Router: {src + 1}")
    print("Destination\tNext Hop\tShortest Distance")
    for dest in range(len(dist)):
        if dest == src:
            continue
        next_hop = get_next_hop(parent, src, dest)
        print(f"{dest + 1}\t\t{next_hop + 1}\t\t{dist[dest]}")

def get_next_hop(parent, src, dest):
    # Find the first hop in the path from src to dest
    if parent[dest] == -1:
        return dest
    while parent[dest] != src:
        dest = parent[dest]
    return dest

# Main Program
if __name__ == "__main__":
    n = int(input("Enter the number of routers (nodes): "))
    print("\nEnter the cost matrix (0 if no direct link):")
    graph = []
    for i in range(n):
        row = list(map(int, input(f"Row {i+1}: ").split()))
        graph.append(row)

    src = int(input("\nEnter the source router (1 to n): ")) - 1

    dist, parent = dijkstra(graph, src)
    print_routing_table(dist, parent, src)
