import socket

# Simulated route: each element represents one hop/router
ROUTE = [
    "192.168.1.1",     # Hop 1
    "10.0.0.1",        # Hop 2
    "172.16.0.1",      # Hop 3
    "93.184.216.34"    # Destination (example-like IP)
]

HOST = ""       # Listen on all interfaces
PORT = 5000     # Port for server


def handle_client(conn, addr):
    print(f"[+] Client connected from {addr}")
    try:
        # Wrap socket in a file-like object for easy line reading
        f = conn.makefile("r")

        # First line: destination host (for info only)
        destination = f.readline().strip()
        if not destination:
            print("[-] No destination received. Closing connection.")
            return

        print(f"[Server] Client wants to trace route to: {destination}")

        # Read TTL values from client
        for line in f:
            line = line.strip()
            if not line:
                break

            try:
                ttl = int(line)
            except ValueError:
                print(f"[-] Invalid TTL received: {line}")
                continue

            print(f"[Server] Received TTL = {ttl}")

            # Simulate router behavior:
            # If TTL < route length -> TIME_EXCEEDED at router
            # If TTL == route length -> ECHO_REPLY from destination
            if ttl < len(ROUTE):
                router_ip = ROUTE[ttl - 1]  # hop index = ttl - 1
                response = f"TIME_EXCEEDED:{router_ip}"
                print(f"[Server] Sending: {response}")
                conn.sendall((response + "\n").encode())
            else:
                dest_ip = ROUTE[-1]
                response = f"ECHO_REPLY:{dest_ip}"
                print(f"[Server] Sending: {response}")
                conn.sendall((response + "\n").encode())
                break

    except Exception as e:
        print(f"[!] Error handling client {addr}: {e}")
    finally:
        conn.close()
        print(f"[-] Client {addr} disconnected.")


def main():
    print(f"[+] TraceRouteServer starting on port {PORT}...")
    with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as server_socket:
        server_socket.bind((HOST, PORT))
        server_socket.listen()
        print("[+] Server is listening...")

        while True:
            conn, addr = server_socket.accept()
            handle_client(conn, addr)


if __name__ == "__main__":
    main()
