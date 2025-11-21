#!/usr/bin/env python3
"""
Threaded TCP echo server.
Usage: python3 echo_server.py [host] [port]
Default host: 0.0.0.0, port: 12345
"""
import socket
import threading
import sys

HOST = '0.0.0.0'
PORT = 12345

if len(sys.argv) >= 2:
    HOST = sys.argv[1]
if len(sys.argv) >= 3:
    PORT = int(sys.argv[2])

def handle_client(conn, addr):
    print(f"[+] Connected: {addr}")
    try:
        with conn:
            while True:
                data = conn.recv(1024)
                if not data:
                    break
                # Echo back exactly what we received
                conn.sendall(data)
    except Exception as e:
        print(f"[!] Error with {addr}: {e}")
    finally:
        print(f"[-] Disconnected: {addr}")

def main():
    with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
        s.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1)
        s.bind((HOST, PORT))
        s.listen()
        print(f"[i] Echo server listening on {HOST}:{PORT} (Ctrl-C to stop)")
        try:
            while True:
                conn, addr = s.accept()
                t = threading.Thread(target=handle_client, args=(conn, addr), daemon=True)
                t.start()
        except KeyboardInterrupt:
            print("\n[i] Server shutting down.")

if __name__ == "__main__":
    main()
