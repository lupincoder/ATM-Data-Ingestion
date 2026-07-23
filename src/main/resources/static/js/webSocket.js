const socket = new WebSocket("ws://localhost:8080/myHandler");

const messageInput = document.getElementById("message");
const sendButton = document.getElementById("sendButton");
const messages = document.getElementById("messages");

sendButton.addEventListener("click", () => {
    const message = messageInput.value.trim();
    if (message === "") {
        return;
    }
    const paragraph = document.createElement("p");
    paragraph.textContent = "You: " + message;
    messages.append(paragraph);
    socket.send(message);
    messageInput.value = "";

});

socket.onopen = () => {
    console.log("Connected!");
};

socket.onmessage = (event) => {
    const paragraph = document.createElement("p");
    paragraph.textContent = event.data;
    // console.log("Received:", event.data);
    messages.appendChild(paragraph);
};

socket.onclose = () => {
    console.log("Disconnected");
};

socket.onerror = (error) => {
    console.error(error);
};