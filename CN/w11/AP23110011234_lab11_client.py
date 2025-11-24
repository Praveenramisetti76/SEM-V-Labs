import socket

SERVER_HOST = "localhost"   # Change if server is on another machine
SERVER_PORT = 5000
MAX_HOPS = 30


def main():
    destination = input("Enter destination domain/IP: ")

    try:
        with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as sock:
            sock.connect((SERVER_HOST, SERVER_PORT))
            f = sock.makefile("r")

            # Send destination first (for server info)
            sock.sendall((destination + "\n").encode())

            print(f"\nTracing route to {destination} over a maximum of {MAX_HOPS} hops:\n")

            for ttl in range(1, MAX_HOPS + 1):
                # Send TTL value to server
                sock.sendall((str(ttl) + "\n").encode())

                # Read response line from server
                response = f.readline()
                if not response:
                    print("No response from server. Exiting.")
                    break

                response = response.strip()

                if response.startswith("TIME_EXCEEDED:"):
                    router_ip = response.split(":", 1)[1]
                    print(f"{ttl}\t{router_ip}\t(Time Exceeded)")
                elif response.startswith("ECHO_REPLY:"):
                    dest_ip = response.split(":", 1)[1]
                    print(f"{ttl}\t{dest_ip}\t(Destination reached)")
                    print("\nTrace complete.")
                    break
                else:
                    print(f"{ttl}\tUnknown response: {response}")

    except Exception as e:
        print(f"Error: {e}")


if __name__ == "__main__":
    main()
