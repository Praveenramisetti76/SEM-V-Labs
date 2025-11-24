import socket
import time

SERVER_IP = "127.0.0.1"   # Change to server's IP
PORT = 9999
PACKETS = 4

sock = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
sock.settimeout(1)   # 1 sec timeout like real ping

rtt_list = []
sent = PACKETS
received = 0

print(f"Pinging {SERVER_IP} with simulated ICMP packets:\n")

for i in range(1, PACKETS + 1):
    msg = f"PING {i}".encode()

    start = time.time()
    sock.sendto(msg, (SERVER_IP, PORT))

    try:
        data, addr = sock.recvfrom(1024)
        end = time.time()

        rtt = (end - start) * 1000  # convert to ms
        rtt_list.append(rtt)
        received += 1

        print(f"Reply from {SERVER_IP}: bytes={len(data)} time={rtt:.2f}ms")

    except socket.timeout:
        print("Request timed out")

# ---- Statistics ----
print("\nPing statistics:")
print(f"    Packets: Sent = {sent}, Received = {received}, Lost = {sent - received}"
      f" ({((sent - received)/sent)*100:.0f}% loss)")

if received > 0:
    print("Approximate round trip times in milli-seconds:")
    print(f"    Minimum = {min(rtt_list):.2f}ms, Maximum = {max(rtt_list):.2f}ms, "
          f"Average = {sum(rtt_list)/len(rtt_list):.2f}ms")
