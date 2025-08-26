import psutil

def get_mac_addresses():
    for interface, addrs in psutil.net_if_addrs().items():
        for addr in addrs:
            if addr.family == psutil.AF_LINK:  # MAC Address
                print(f"{interface} -> {addr.address}")

def get_ports():
    connections = psutil.net_connections()
    ports = set()
    for conn in connections:
        if conn.laddr:
            ports.add(conn.laddr.port)
    for port in sorted(ports):
        print(f"Port: {port}")
if __name__ == "__main__":
    get_mac_addresses()
    get_ports()