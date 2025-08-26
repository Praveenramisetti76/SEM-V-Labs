import psutil
import socket

def list_ports():
    connections = psutil.net_connections(kind='inet')  # inet = TCP + UDP
    for conn in connections:
        laddr = f"{conn.laddr.ip}:{conn.laddr.port}" if conn.laddr else ""
        raddr = f"{conn.raddr.ip}:{conn.raddr.port}" if conn.raddr else ""
        proto = "TCP" if conn.type == socket.SOCK_STREAM else "UDP"
        pid = conn.pid

        # Get process name (application) if available
        try:
            process = psutil.Process(pid).name() if pid else "System"
        except (psutil.NoSuchProcess, psutil.AccessDenied):
            process = "Unknown"

        print(f"Protocol: {proto:<4} | Local Address: {laddr:<22} | "
              f"Remote Address: {raddr:<22} | Port: {conn.laddr.port if conn.laddr else ''} | "
              f"Application: {process}")

if __name__ == "__main__":
    list_ports()
