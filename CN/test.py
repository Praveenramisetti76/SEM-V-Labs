# Before running this script, you may need to install the 'netifaces' library.
# You can do this by opening your terminal or command prompt and running:
# pip install netifaces

import netifaces
import socket

def find_all_addresses():
    """
    Finds and prints all IPv4 and MAC addresses associated with the local
    machine's network interfaces.
    """
    print("Finding all IPv4 and MAC addresses...\n")

    # Get a list of all network interface names (e.g., 'eth0', 'lo', 'Wi-Fi').
    try:
        interfaces = netifaces.interfaces()
    except Exception as e:
        print(f"Error accessing network interfaces: {e}")
        print("Please ensure 'netifaces' is installed correctly.")
        return

    found_addresses = False
    for interface in interfaces:
        try:
            # Get the addresses for the current interface.
            addresses = netifaces.ifaddresses(interface)
            
            print(f"--- Interface: '{interface}' ---")

            # Check for MAC address (AF_LINK).
            if netifaces.AF_LINK in addresses:
                mac_address = addresses[netifaces.AF_LINK][0]['addr']
                print(f"  MAC Address: {mac_address.upper()}")
                found_addresses = True
            
            # Check for IPv4 address (AF_INET).
            if netifaces.AF_INET in addresses:
                ipv4_addresses = addresses[netifaces.AF_INET]
                
                # Iterate through all IPv4 addresses found for this interface.
                for address_info in ipv4_addresses:
                    ip_address = address_info['addr']
                    
                    if ip_address.startswith('127.'):
                        print(f"  Loopback Address: {ip_address}")
                    else:
                        print(f"  Local IP Address: {ip_address}")
                        found_addresses = True
            
            print("-" * (len(interface) + 16)) # Separator for readability

        except ValueError:
            # This can happen if an interface has no addresses assigned.
            continue
        except Exception as e:
            print(f"An error occurred while checking interface '{interface}': {e}")
            
    if not found_addresses:
        print("\nNo network interfaces with either MAC or IPv4 addresses were found.")
        print("This may mean you are not connected to a network.")

# Call the main function to run the program.
if __name__ == "__main__":
    find_all_addresses()
