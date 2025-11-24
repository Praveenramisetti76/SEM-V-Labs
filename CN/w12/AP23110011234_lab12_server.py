import socket
import time

HOST = "0.0.0.0"   # Listen on all interfaces
PORT = 9999        # Any free port

sock = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
sock.bind((HOST, PORT))

print(f"Ping Server Running on port {PORT}...")

while True:
    data, addr = sock.recvfrom(1024)
    print(f"Received '{data.decode()}' from {addr}")

    # Simulate processing delay (optional)
    time.sleep(0.05)

    sock.sendto(b"PONG", addr)
