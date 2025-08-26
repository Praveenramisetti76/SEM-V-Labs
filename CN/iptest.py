import subprocess

def get_network_info():
    try:
        # Run ipconfig /all via cmd.exe
        process = subprocess.Popen(
            ["cmd.exe", "/c", "ipconfig", "/all"],
            stdout=subprocess.PIPE,
            stderr=subprocess.STDOUT,
            text=True
        )

        # Read output line by line
        for line in process.stdout:
            line = line.strip()
            if (line.startswith("Default Gateway") or
                line.startswith("DNS Servers") or
                line.startswith("DHCP Server") or
                line.startswith("IPv4 Address")):
                print(line)

        process.stdout.close()
        exit_code = process.wait()
        print(f"\nProcess exited with code: {exit_code}")

    except Exception as e:
        print("Error:", e)


if __name__ == "__main__":
    get_network_info()