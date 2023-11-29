import socket 

host = '127.0.0.1'
port = 50002  # Change the port number

server_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
server_socket.bind((host, port))
server_socket.listen()

conn, addr = server_socket.accept()
print("Connected from: " + str(addr))

while True:
    data = conn.recv(1024).decode()
    print(data)
    
    response_data = "Message Received"
    conn.send(response_data.encode())
