#!/usr/bin/env python3
"""
Simple TCP echo client.
Usage: python3 echo_client.py [host] [port]
Default host: 127.0.0.1, port: 12345
Type lines and press Enter to send. Type 'exit' to quit.
"""
import socket
import sys

HOST = '127.0.0.1'
PORT = 12345

if len(sys.argv) >= 2:
    HOST = sys.argv[1]
if len(sys.argv) >= 3:
    PORT = int(sys.argv[2])

def main():
    with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
        s.connect((HOST, PORT))
        print(f"[i] Connected to {HOST}:{PORT}. Type lines to send. 'exit' to quit.")
        try:
            while True:
                line = input("> ")
                if line.strip().lower() == "exit":
                    print("[i] Exiting.")
                    break
                # send as bytes (utf-8). add newline if you want to preserve line structure
                s.sendall(line.encode('utf-8'))
                # receive echo (may need loop for large messages; simple here)
                data = s.recv(4096)
                if not data:
                    print("[!] Server closed connection.")
                    break
                print(f"Echoed: {data.decode('utf-8')}")
        except KeyboardInterrupt:
            print("\n[i] Interrupted, closing.")

if __name__ == "__main__":
    main()
